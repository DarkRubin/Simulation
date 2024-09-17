package src.Creature;

import src.Actions.SearchWay;
import src.Coordinates;
import src.Entity.Entity;


import java.util.List;

import static src.Simulation.*;

public abstract class Creature extends Entity {
    private final Coordinates notFound = new Coordinates(-1, -1);

    public Creature(Coordinates coordinates) {
        super(coordinates);
    }

    protected abstract void creatureEat(Coordinates coordinates);
    protected abstract boolean isFood(Coordinates coordinates);

    protected void searchAndGo(Coordinates coordinates, int moveRange, Class<?> target) {
        SearchWay searchWay = new SearchWay(coordinates);
        List<Coordinates> way = searchWay.foundWay(target);
        if (way.size() > 1) {
            way.removeLast();
            goForFood(moveRange, way, coordinates);
        }
    }

    private void goForFood(int moveRange, List<Coordinates> way, Coordinates coordinates) {
        int index = 0;
        for (Coordinates cell : way.reversed()) {
            if (index <= moveRange) {
                map.moveEntity(coordinates, cell);
                this.coordinates = cell;
                coordinates = cell;
                index++;
            } else break;
        }
    }

    protected void makeMove(Coordinates coordinates, int moveRange, Class<?> target) {
        Coordinates food = checkBelowCellsForFood(coordinates);
        if (food.equals(notFound)) {
            searchAndGo(coordinates, moveRange, target);
        } else creatureEat(food);
    }

    protected Coordinates checkBelowCellsForFood(Coordinates coordinates) {
        Coordinates[] search = SearchWay.getBelowCoordinates(coordinates);
        for (Coordinates value : search) {
            if (isFood(value))
                return value;
        }
        return notFound;
    }
}
