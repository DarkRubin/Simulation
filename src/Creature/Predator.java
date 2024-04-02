package src.Creature;

import src.Coordinates;

import java.util.ArrayList;

import static src.Creature.Herbivore.herbivoresOnMap;

public class Predator extends Creature {

    static final int POWER = 5;
    private static final int MOVE_RANGE = 5;
    private final boolean IS_HERBIVORE;

    public Coordinates coordinates;
    public static ArrayList<Coordinates> predatorsOnMap = new ArrayList<>();

    public Predator(Coordinates coordinates) {
        super(coordinates);
        IS_HERBIVORE = false;
        this.coordinates = coordinates;
        predatorsOnMap.add(coordinates);
    }

    public void makeMove(Coordinates coordinates) {
        if (!herbivoresOnMap.isEmpty())
            super.makeMove(coordinates, MOVE_RANGE, IS_HERBIVORE);
    }
}
