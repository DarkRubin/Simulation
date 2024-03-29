package src.Creature;

import src.Coordinates;


import java.util.ArrayList;

import static src.Entity.Grass.countGrass;
import static src.Simulation.map;

public class Herbivore extends Creature {

    public Coordinates coordinates;
    private static final int MOVE_RANGE = 4;
    private int healthPoint = 10;
    public static ArrayList<Coordinates> herbivoreOnMap = new ArrayList<>();


    public Herbivore(Coordinates coordinates) {
        super(coordinates, true);
        this.coordinates = coordinates;
        herbivoreOnMap.add(coordinates);
    }

    public void takeHurt(int power) {
        healthPoint -= power;
        if (healthPoint == 0) {
            map.removeEntity(coordinates);
            herbivoreOnMap.remove(coordinates);
        }
    }

    public void makeMove(Coordinates coordinates) {
        if (!HerbivoreEat(coordinates))
            goForFood(coordinates, MOVE_RANGE);
    }

    public boolean HerbivoreEat(Coordinates coordinates) {
        Coordinates belowCell = checkCellsForFood(coordinates);
        if (belowCell != null) {
            map.removeEntity(belowCell);
            countGrass--;
            healthPoint += 5;
            return true;
        } else return false;
    }
}
