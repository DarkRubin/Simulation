package src.Creature;

import src.Actions.SearchWay;
import src.Coordinates;
import src.Entity.Entity;
import src.Entity.Grass;


import java.util.List;

import static src.Entity.Grass.grassOnMap;
import static src.Simulation.*;

public abstract class Creature extends Entity {

    public Creature(Coordinates coordinates) {
        super(coordinates);
    }

    protected void foundAndGo(Coordinates coordinates, int MOVE_RANGE, boolean IS_HERBIVORE) {
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

    protected boolean creatureEat(Coordinates coordinates, boolean IS_HERBIVORE) {
        Coordinates belowCell = checkCellsForFood(coordinates, IS_HERBIVORE);
        if (IS_HERBIVORE && map.getEntity(belowCell) instanceof Grass) {
            map.removeEntity(belowCell);
            grassOnMap.remove(belowCell);
            return true;
        } else if (!IS_HERBIVORE && map.getEntity(belowCell) instanceof Herbivore herbivore) {
            herbivore.takeHurt(belowCell);
            return true;
        }
        return false;
    }

    protected boolean makeMove(Coordinates coordinates, int MOVE_RANGE, boolean IS_HERBIVORE) {
        if (creatureEat(coordinates, IS_HERBIVORE)) return true;
        foundAndGo(coordinates, MOVE_RANGE, IS_HERBIVORE);
        return false;
    }

    protected Coordinates checkCellsForFood(Coordinates coordinates, boolean IS_HERBIVORE) {
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
