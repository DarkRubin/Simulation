package src.Creature;

import src.Coordinates;


import java.util.ArrayList;

import static src.Entity.Grass.grassOnMap;
import static src.Simulation.map;

public class Herbivore extends Creature {

    public Coordinates coordinates;
    private static final int MOVE_RANGE = 4;
    private int healthPoint = 10;
    public static ArrayList<Coordinates> herbivoresOnMap = new ArrayList<>();


    public Herbivore(Coordinates coordinates) {
        super(coordinates, true);
        this.coordinates = coordinates;
        herbivoresOnMap.add(coordinates);
    }

    public void takeHurt(int power) {
        healthPoint -= power;
        if (healthPoint <= 0) {
            map.removeEntity(coordinates);
            herbivoresOnMap.remove(coordinates);
        }
    }

    public void makeMove(Coordinates coordinates) {
        if (HerbivoreEat(coordinates) || grassOnMap.isEmpty()) return;
        foundAndGo(coordinates, MOVE_RANGE);
    }

    public boolean HerbivoreEat(Coordinates coordinates) {
        Coordinates belowCell = checkCellsForFood(coordinates);
        if (belowCell != null) {
            map.removeEntity(belowCell);
            grassOnMap.remove(belowCell);
            healthPoint += 5;
            return true;
        } else return false;
    }
}
