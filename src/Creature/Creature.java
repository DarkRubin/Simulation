package src.Creature;

import src.Actions.SearchWay;
import src.Coordinates;
import src.Entity.Entity;
import src.Entity.Grass;


import java.util.List;

import static src.Simulation.*;

public abstract class Creature extends Entity {

    private final boolean IS_HERBIVORE;
    public Creature(Coordinates coordinates, boolean IS_HERBIVORE) {
        super(coordinates);
        this.IS_HERBIVORE = IS_HERBIVORE;
    }

    protected void foundAndGo(Coordinates coordinates, int MOVE_RANGE) {
        SearchWay searchWay = new SearchWay(IS_HERBIVORE, coordinates);
        List<Coordinates> way = searchWay.foundWay();
        if (way != null && way.size() > 1) {
            way.removeLast();
            goForFood(MOVE_RANGE, way, coordinates);
        }
    }

    private void goForFood(int MOVE_RANGE, List<Coordinates> way, Coordinates coordinates) {
        int index = 0;
        for (Coordinates cell : way.reversed()) {
            if (index <= MOVE_RANGE) {
                map.moveEntity(coordinates, cell);
                this.coordinates = cell;
                coordinates = cell;
                index++;
            } else break;
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
