package src.Creature;

import src.Coordinates;


import java.util.ArrayList;

import static src.Creature.Predator.POWER;
import static src.Entity.Grass.grassOnMap;
import static src.Simulation.map;

public class Herbivore extends Creature {

    public Coordinates coordinates;
    private static final int MOVE_RANGE = 4;
    private int healthPoint = 10;
    private final boolean IS_HERBIVORE;
    public static ArrayList<Coordinates> herbivoresOnMap = new ArrayList<>();


    public Herbivore(Coordinates coordinates) {
        super(coordinates);
        IS_HERBIVORE = true;
        this.coordinates = coordinates;
        herbivoresOnMap.add(coordinates);
    }

    protected void takeHurt(Coordinates coordinates) {
        healthPoint -= POWER;
        if (healthPoint <= 0) {
            map.removeEntity(coordinates);
            map.removeEntity(this.coordinates);
            herbivoresOnMap.remove(coordinates);
            herbivoresOnMap.remove(this.coordinates);
        }
    }

    public void makeMove(Coordinates coordinates) {
        if (grassOnMap.isEmpty()) return;
        if (super.makeMove(coordinates, MOVE_RANGE, IS_HERBIVORE)) {
            healthPoint += 5;
        }
    }

}
