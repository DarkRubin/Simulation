package src.Creature;

import src.Coordinates;
import src.Entity.Grass;


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

    protected void takeHurt(int power, Coordinates coordinates) {
        healthPoint -= power;
        if (healthPoint <= 0) {
            map.removeEntity(coordinates);
            map.removeEntity(this.coordinates);
            herbivoresOnMap.remove(coordinates);
            herbivoresOnMap.remove(this.coordinates);
        }
    }

    public void makeMove(Coordinates coordinates) {
        if (HerbivoreEat(coordinates) || grassOnMap.isEmpty()) return;
        foundAndGo(coordinates, MOVE_RANGE);
    }

    private boolean HerbivoreEat(Coordinates coordinates) {
        Coordinates belowCell = checkCellsForFood(coordinates);
        if (map.getEntity(belowCell) instanceof Grass) {
            map.removeEntity(belowCell);
            grassOnMap.remove(belowCell);
            healthPoint += 5;
            return true;
        } else return false;
    }
}
