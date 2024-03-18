package src.Actions;

import src.Coordinates;

import src.Creature.Herbivore;
import src.Entity.Grass;

import java.util.Random;

import static src.Simulation.*;
import static src.Simulation.map;

public class SpawnMoreObjects extends Actions {

    private final int mapSize = maxLength * maxWidth;
    public void spawnGrass() {
        int countGrassToSpawn = mapSize / 10;
        boolean val = new Random().nextInt(0,9) == 1;
        while (0 < countGrassToSpawn) {
            for (int width = 1; width <= maxWidth; width++) {
                for (int length = 1; length <= maxLength; length++) {
                    Coordinates coordinates = new Coordinates(length, width);
                    if (map.getEntity(coordinates) == null && val) {
                        Grass grass = new Grass(coordinates);
                        map.setEntity(grass, coordinates);
                        countGrassToSpawn--;

                    }
                }
            }

        }

    }

    public void spawnHerbivore() {
        int countHerbivoreToSpawn = mapSize / 10;
        boolean val = new Random().nextInt(10) == 0;
        while (0 < countHerbivoreToSpawn) {
            for (int width = 1; width <= maxWidth; width++) {
                for (int length = 1; length <= maxLength; length++) {
                    Coordinates coordinates = new Coordinates(length, width);
                    if (map.getEntity(coordinates) == null && val) {
                        Herbivore herbivore = new Herbivore(coordinates);
                        map.setEntity(herbivore, coordinates);
                        countHerbivoreToSpawn--;

                    }
                }
            }

        }

    }


}
