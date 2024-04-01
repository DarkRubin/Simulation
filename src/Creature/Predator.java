package src.Creature;

import src.Coordinates;

import java.util.ArrayList;

import static src.Creature.Herbivore.herbivoresOnMap;
import static src.Simulation.map;

public class Predator extends Creature {

    private static final int POWER = 5;
    private static final int MOVE_RANGE = 5;

    public Coordinates coordinates;
    public static ArrayList<Coordinates> predatorsOnMap = new ArrayList<>();

    public Predator(Coordinates coordinates) {
        super(coordinates, false);
        this.coordinates = coordinates;
        predatorsOnMap.add(coordinates);
    }

    public void makeMove(Coordinates coordinates) {
        if (PredatorEat(coordinates) || herbivoresOnMap.isEmpty()) return;
        foundAndGo(coordinates, MOVE_RANGE);
    }

    public boolean PredatorEat(Coordinates coordinates) {
        Coordinates belowCells = checkCellsForFood(coordinates);
         if (map.getEntity(belowCells) instanceof Herbivore herbivore ) {
            herbivore.takeHurt(POWER, belowCells);
            return true;
        } else return false;
    }
}
