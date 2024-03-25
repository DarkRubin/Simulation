package src.Creature;

import src.Actions.MapConsoleRenderer;
import src.Coordinates;


import java.util.ArrayList;

import static src.Entity.Grass.countGrass;
import static src.Simulation.map;

public class Herbivore extends Creature {
    private final MapConsoleRenderer renderer = new MapConsoleRenderer();

    public Coordinates coordinates;
    private static final int MOVE_RANGE = 4;
    private static int healthPoint = 10;
    public static ArrayList<Coordinates> herbivoreOnMap = new ArrayList<>();


    public Herbivore(Coordinates coordinates) {
        super(coordinates);
        herbivoreOnMap.add(coordinates);
        IS_HERBIVORE = true;
    }

    public void takeHurt(int power) {
        healthPoint -= power;
        if (healthPoint == 0) {
            map.removeEntity(coordinates);
            herbivoreOnMap.remove(coordinates);
        }
    }
    @Override
    public void makeMove(Coordinates coordinates) {
        ArrayList<Coordinates> visited = new ArrayList<>();
        Coordinates belowCells = checkBelowCells(coordinates);
        if (belowCells != null) {
            map.removeEntity(belowCells);
            countGrass--;
            healthPoint += 5;
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
