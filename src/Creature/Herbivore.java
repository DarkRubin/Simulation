package src.Creature;

import src.Coordinates;

import src.Entity.Grass;


import java.util.ArrayList;
import java.util.List;

import static src.Creature.Predator.POWER;
import static src.Entity.Grass.grassOnMap;
import static src.Simulation.map;

public class Herbivore extends Creature {

    private static final int MOVE_RANGE = 4;
    private int healthPoint = 10;
    public static List<Coordinates> herbivoresOnMap = new ArrayList<>();
    private static final Class<Grass> TARGET = Grass.class;


    public Herbivore(Coordinates coordinates) {
        super(coordinates);
        herbivoresOnMap.add(coordinates);
    }

    @Override
    protected void creatureEat(Coordinates coordinates) {
        map.removeEntity(coordinates);
        grassOnMap.remove(coordinates);
        healthPoint += 5;
    }

    @Override
    protected boolean isFood(Coordinates coordinates) {
        return map.getEntity(coordinates) instanceof Grass;
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
        super.makeMove(coordinates, MOVE_RANGE, TARGET);
    }

}
