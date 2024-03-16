package src.Creature;

import src.Coordinates;
import src.Entity.Entity;
import src.Entity.Grass;
import src.Map;

public abstract class Creature extends Entity {

    public Creature(Coordinates coordinates) {
        super(coordinates);
    }

    protected abstract void makeMove(Map map, Coordinates coordinates);




    protected Coordinates checkBelowCells(Coordinates coordinates, boolean isHerbivore, Map map) {
        int length = coordinates.length;
        int width = coordinates.width;
        Coordinates[] search = new Coordinates[8];
        int index = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    search[index++] = new Coordinates(length + i, width + j);
                }
            }
        }
        if (isHerbivore) {
            return searchGrassBelow(search, map);
        }else {
            return searchHerbivoreBelow(search, map);
        }
    }
    private Coordinates searchGrassBelow(Coordinates[] search, Map map) {
        for (Coordinates value : search) {
            if (map.getEntity(value) != null && map.getEntity(value) instanceof Grass) {
                return value;
            }
        }
        return null;
    }

    private Coordinates searchHerbivoreBelow(Coordinates[] search, Map map) {
        for (Coordinates value : search) {
            if (map.getEntity(value) != null && map.getEntity(value) instanceof Herbivore) {
                return value;
            }
        }
        return null;
    }



}
