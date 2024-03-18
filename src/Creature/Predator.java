package src.Creature;

import src.Coordinates;

import static src.Simulation.map;

public class Predator extends Creature {

    private static final int POWER = 5;
    public Predator(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public void makeMove(Coordinates coordinates) {
        Coordinates belowCells = checkBelowCells(coordinates, false);
        if (belowCells != null) {
            Herbivore herbivore = (Herbivore) map.getEntity(belowCells);
            herbivore.takeHurt(POWER);
        }
    }
}
