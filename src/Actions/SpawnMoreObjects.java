package src.Actions;

import src.Coordinates;
import src.Creature.Herbivore;
import src.Entity.Grass;

import java.util.Random;

import static src.Creature.Herbivore.herbivoreOnMap;
import static src.Entity.Grass.grassOnMap;
import static src.Simulation.*;

public class SpawnMoreObjects extends Action {

    @Override
    public void doInThisMove() {
        if (grassOnMap.size() < 2) {
            spawnGrass();
        }
        if (herbivoreOnMap.size() < 2) {
            spawnHerbivore();
        }
    }

    public static void spawnGrass() {
        int countGrassToSpawn = maxLength * maxWidth / 8;
        boolean val;
        while (0 < countGrassToSpawn) {
            for (int width = 1; width <= maxWidth; width++) {
                for (int length = 1; length <= maxLength; length++) {
                    Coordinates coordinates = new Coordinates(length, width);
                    val = new Random().nextInt(0,13) == 1;
                    if (map.getEntity(coordinates) == null && val) {
                        Grass grass = new Grass(coordinates);
                        map.setEntity(grass, coordinates);
                        countGrassToSpawn--;
                        break;
                    }
                }
            }

        }

    }

    public static void spawnHerbivore() {
        int countHerbivoreToSpawn = maxLength * maxWidth / 10;
        boolean val = new Random().nextInt(10) == 0;
        while (0 < countHerbivoreToSpawn) {
            for (int width = 1; width <= maxWidth; width++) {
                for (int length = 1; length <= maxLength; length++) {
                    Coordinates coordinates = new Coordinates(length, width);
                    if (map.getEntity(coordinates) == null && val) {
                        Herbivore herbivore = new Herbivore(coordinates);
                        map.setEntity(herbivore, coordinates);
                        countHerbivoreToSpawn--;
                        break;
                    }
                }
            }

        }

    }


}
