package src.Creature;

import src.Coordinates;
import src.Entity.Entity;
import src.Entity.Grass;

import java.util.ArrayList;

import static src.Creature.Herbivore.herbivoreOnMap;
import static src.Entity.Grass.grassOnMap;
import static src.Simulation.*;

public abstract class Creature extends Entity {

    protected boolean IS_HERBIVORE;
    private ArrayList<Coordinates> foodOnMap;
    private ArrayList<Coordinates> way;
    public Creature(Coordinates coordinates) {
        super(coordinates);

    }

    protected abstract void makeMove(Coordinates coordinates);

    protected ArrayList<Coordinates> foundWay(ArrayList<Coordinates> visited, Coordinates coordinates) {
        foodOnMap = IS_HERBIVORE ? grassOnMap : herbivoreOnMap;
        ArrayList<Coordinates> possibleWay = new ArrayList<>();
        Coordinates distance = shortestDistance(coordinates);
        while (checkBelowCells(coordinates) == null) {
            for (Coordinates cell : getNotVisitedCoordinates(coordinates, visited)) {
                visited.add(cell);
                if (shortestDistance(cell).moduleCoordinate() < distance.moduleCoordinate()) {
                    foundWay(visited, cell);
                    possibleWay.add(cell);
                }
                if (getNotVisitedCoordinates(coordinates, visited).length <= 1)
                    return null;
            }

        }

        way = possibleWay;
        return way;
    }

    protected Coordinates checkBelowCells(Coordinates coordinates) {
        Coordinates[] search = coordinates.getBelowCoordinates(false);
        if (IS_HERBIVORE) {
            for (Coordinates value : search) {
                if (map.getEntity(value) instanceof Grass) {
                    return value;
                }
            }
        }else {
            for (Coordinates value : search) {
                if (map.getEntity(value) instanceof Herbivore) {
                    return value;
                }
            }
        }
        return null;
    }

    private int getTarget() {
        int i = -1;
        Coordinates distance = null;
        while (foodOnMap.size() > ++i && distance != shortestDistance(coordinates)) {
            distance = coordinates.getDistance(foodOnMap.get(i));
        }
        return i;
    }

    private Coordinates shortestDistance(Coordinates coordinates) {
        Coordinates shortestWay = new Coordinates(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Coordinates value : foodOnMap) {
            Coordinates distance = coordinates.getDistance(value);
            if (distance.length + distance.width < shortestWay.length + shortestWay.width) {
                shortestWay = distance;
            }
        }
        return shortestWay;
    }

    private Coordinates[] getNotVisitedCoordinates(Coordinates coordinates,ArrayList<Coordinates> visited) {
        ArrayList<Coordinates> notVisited = new ArrayList<>();
        Coordinates[] belowCoordinates = coordinates.getBelowCoordinates(true);
        for (Coordinates belowCoordinate : belowCoordinates) {
            if (!visited.contains(belowCoordinate)) {
                notVisited.add(belowCoordinate);
            }
        }
        return notVisited.toArray(new Coordinates[0]);
    }
}
