package src.Creature;

import src.Coordinates;
import src.Entity.Entity;
import src.Entity.Grass;
import src.Map;

public class Herbivore extends Creature {

    private int healthPoint = 10;
    public Herbivore(Coordinates coordinates) {
        super(coordinates);
    }

    public void takeHurt(Map map, int power) {
        healthPoint -= power;
        if (healthPoint == 0) {
            map.removeEntity(coordinates);
        }
    }
    @Override
    public void makeMove(Map map, Coordinates coordinates) {
        Coordinates belowCells = checkBelowCells(coordinates, true, map);
        if (belowCells != null) {
            map.removeEntity(belowCells);
            healthPoint += 5;
        }

    }


}
