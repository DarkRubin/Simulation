package src.Actions;

import src.Coordinates;
import src.Creature.Herbivore;
import src.Creature.Predator;
import src.Entity.Grass;

import java.util.Random;

import static src.Creature.Herbivore.herbivoresOnMap;
import static src.Creature.Predator.predatorsOnMap;
import static src.Entity.Grass.grassOnMap;
import static src.Simulation.*;

public class SpawnMoreObjects extends Action {

    @Override
    public void doInThisMove() {
        if (grassOnMap.size() < 2) {
            spawnGrass();
        }
        if (herbivoresOnMap.size() < 2) {
            spawnHerbivores();
        }
        if (predatorsOnMap.size() < 2) {
            spawnPredators();
        }
    }



    private void spawnGrass() {
        int countGrassToSpawn = maxLength * maxWidth / 8;
        boolean val;
        while (0 < countGrassToSpawn) {
            for (int width = 1; width <= maxWidth; width++) {
                for (int length = 1; length <= maxLength; length++) {
                    Coordinates coordinates = new Coordinates(length, width);
                    val = new Random().nextInt(0,10) == 1;
                    if (map.getEntity(coordinates) == null && val) {
                        map.setEntity(new Grass(coordinates), coordinates);
                        countGrassToSpawn--;
                        break;
                    }
                }
            }

        }

    }

    private void spawnHerbivores() {
        int countHerbivoreToSpawn = maxLength * maxWidth / 10;
        while (0 < countHerbivoreToSpawn) {
            for (int width = 1; width <= maxWidth; width++) {
                for (int length = 1; length <= maxLength; length++) {
                    boolean val = new Random().nextInt(10) == 0;
                    Coordinates coordinates = new Coordinates(length, width);
                    if (map.getEntity(coordinates) == null && val) {
                        map.setEntity(new Herbivore(coordinates), coordinates);
                        countHerbivoreToSpawn--;
                        break;
                    }
                }
            }

        }
    }

    private void spawnPredators() {
        int countPredatorsToSpawn = maxLength * maxWidth / 13;
        while (0 < countPredatorsToSpawn) {
            for (int width = 1; width <= maxWidth; width++) {
                for (int length = 1; length <= maxLength; length++) {
                    Coordinates coordinates = new Coordinates(length, width);
                    boolean val = new Random().nextInt(10) == 0;
                    if (map.getEntity(coordinates) == null && val) {
                        map.setEntity(new Predator(coordinates), coordinates);
                        countPredatorsToSpawn--;
                        break;
                    }
                }
            }

        }
    }


}
