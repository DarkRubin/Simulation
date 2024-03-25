package src.Creature;

import src.Actions.MapConsoleRenderer;
import src.Coordinates;

import java.util.ArrayList;

import static src.Simulation.map;

public class Predator extends Creature {

    private final MapConsoleRenderer renderer = new MapConsoleRenderer();
    private static final int POWER = 5;
    private static final int MOVE_RANGE = 5;
    public static ArrayList<Coordinates> predatorsOnMap = new ArrayList<>();

    public Predator(Coordinates coordinates) {
        super(coordinates);
        IS_HERBIVORE = false;
    }

    @Override
    public void makeMove(Coordinates coordinates) {
        ArrayList<Coordinates> visited = new ArrayList<>();
        Coordinates belowCells = checkBelowCells(coordinates);
        if (belowCells != null) {
            Herbivore herbivore = (Herbivore) map.getEntity(belowCells);
            herbivore.takeHurt(POWER);
        } else {
            ArrayList<Coordinates> way = foundWay(visited, coordinates);
            if (way != null) {
                for (int i = 0; i < MOVE_RANGE; i++) {
                    this.coordinates = way.get(i);
                    renderer.render();
                }
            }
        }
    }
}
