package src.Creature;

import src.Coordinates;
import src.Entity.Entity;
import src.Entity.Grass;

import static src.Simulation.map;

public abstract class Creature extends Entity {

    public Creature(Coordinates coordinates) {
        super(coordinates);
    }

    protected abstract void makeMove(Coordinates coordinates);


    protected Coordinates foundWay(Coordinates coordinates) {
        return null;
    }

    protected Coordinates checkBelowCells(Coordinates coordinates, boolean isHerbivore) {
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
            return searchGrassBelow(search);
        }else {
            return searchHerbivoreBelow(search);
        }
    }
    private Coordinates searchGrassBelow(Coordinates[] search) {
        for (Coordinates value : search) {
            if (map.getEntity(value) instanceof Grass) {
                return value;
            }
        }
        return null;
    }

    private Coordinates searchHerbivoreBelow(Coordinates[] search) {
        for (Coordinates value : search) {
            if (map.getEntity(value) != null &&
                    map.getEntity(value) instanceof Herbivore) {
                return value;
            }
        }
        return null;
    }

    private void searchGrassOnMap(Coordinates coordinates) {
        int length = coordinates.length;
        int width = coordinates.width;
        Coordinates[] search = new Coordinates[8];
        for (int k = 1; k < 50; k++) {
            for (int i = -k; i < k; i++) {
                for (int j = -k; j < k; j++) {
                    if (i != 0 || j != 0) {
                        Coordinates result =
                                new Coordinates(length + i, width + j);
                    }
                }
                k++;
            }
        }

        System.out.println();
    }
}
