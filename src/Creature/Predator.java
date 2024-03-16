package src.Creature;

import src.Coordinates;
import src.Entity.Entity;
import src.Map;

public class Predator extends Creature {

    private static final int POWER = 5;
    public Predator(Coordinates coordinates) {
        super(coordinates);
    }
//    private static final Entity FOOD = new Herbivore(null);

    @Override
    public void makeMove(Map map, Coordinates coordinates) {
        Coordinates belowCells = checkBelowCells(coordinates, false, map);
        if (belowCells != null) {
            Herbivore herbivore = (Herbivore) map.getEntity(belowCells);
            herbivore.takeHurt(map, POWER);
        }
    }
}
