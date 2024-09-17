package src.Creature;

import src.Coordinates;

import java.util.ArrayList;
import java.util.List;

import static src.Creature.Herbivore.herbivoresOnMap;
import static src.Simulation.map;

public class Predator extends Creature {

    static final int POWER = 5;
    private static final int MOVE_RANGE = 5;

    public static List<Coordinates> predatorsOnMap = new ArrayList<>();
    private static final Class<Herbivore> TARGET = Herbivore.class;

    public Predator(Coordinates coordinates) {
        super(coordinates);
        predatorsOnMap.add(coordinates);
    }

    @Override
    protected void creatureEat(Coordinates coordinates) {
        Herbivore herbivore = (Herbivore) map.getEntity(coordinates);
        herbivore.takeHurt(coordinates);
    }

    @Override
    protected boolean isFood(Coordinates coordinates) {
        return map.getEntity(coordinates) instanceof Herbivore;
    }

    public void makeMove(Coordinates coordinates) {
        if (!herbivoresOnMap.isEmpty())
            super.makeMove(coordinates, MOVE_RANGE, TARGET);
    }
}
