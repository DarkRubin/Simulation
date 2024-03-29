package src.Creature;

import src.Actions.MapConsoleRenderer;
import src.Actions.WaySearch;
import src.Coordinates;
import src.Entity.Entity;
import src.Entity.Grass;


import java.util.ArrayList;

import static src.Creature.Herbivore.herbivoreOnMap;
import static src.Entity.Grass.grassOnMap;
import static src.Simulation.*;

public abstract class Creature extends Entity {

    private final boolean IS_HERBIVORE;
    public Creature(Coordinates coordinates, boolean IS_HERBIVORE) {
        super(coordinates);
        this.IS_HERBIVORE = IS_HERBIVORE;
    }

    protected void goForFood(Coordinates coordinates, int MOVE_RANGE) {
        ArrayList<Coordinates> foodOnMap = IS_HERBIVORE ? grassOnMap : herbivoreOnMap;
        int index = 0;
        MapConsoleRenderer renderer = new MapConsoleRenderer();
        WaySearch waySearch = new WaySearch(foodOnMap);
        ArrayList<Coordinates> way = waySearch.foundWay(coordinates);
        if (way != null && way.size() > 1) {
            way.removeFirst();
            for (Coordinates cell : way.reversed()) {
                if (index <= MOVE_RANGE) {
                    map.moveEntity(coordinates, cell, map);
                    renderer.render();
                    index++;
                }
            }
        }
    }

    protected Coordinates checkCellsForFood(Coordinates coordinates) {
        if (coordinates == null) return null;

        Coordinates[] search = coordinates.getBelowCoordinates(false);
        if (IS_HERBIVORE) {
            for (Coordinates value : search) {
                if (map.getEntity(value) instanceof Grass) {
                    return value;
                }
            }
        } else {
            for (Coordinates value : search) {
                if (map.getEntity(value) instanceof Herbivore) {
                    return value;
                }
            }
        }
        return null;
    }
}
