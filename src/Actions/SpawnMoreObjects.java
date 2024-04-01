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

    private static final int CHANCE_SPAWN_GRASS = 12;
    private static final int CHANCE_SPAWN_HERBIVORE = 14;
    private static final int CHANCE_SPAWN_PREDATOR = 16;
    private final MapConsoleRenderer renderer = new MapConsoleRenderer();
    @Override
    public void doInThisMove() {
        isNeedSpawnGrass();
        if (herbivoresOnMap.size() < 2) {
            spawnHerbivores();
        }
        if (predatorsOnMap.size() < 2) {
            spawnPredators();
        }
    }

    private void isNeedSpawnGrass() {
        if (grassOnMap.size() < 2) {
            spawnGrass();
            return;
        }
        int trueCountGrass = 0;
        for (int width = 1; width <= maxWidth; width++) {
            for (int length = 1; length <= maxLength; length++) {
                Coordinates coordinates = new Coordinates(length, width);
                if (map.getEntity(coordinates) instanceof Grass) {
                    trueCountGrass++;
                }else grassOnMap.remove(coordinates);
            }
        }
        if (trueCountGrass < 2) {
            spawnGrass();
        }

    }


    private Coordinates[] spawner(int countToSpawn) {
        Coordinates[] freeCells = new Coordinates[countToSpawn];
        while (0 < countToSpawn) {
            int length = new Random().nextInt(1, maxLength);
            int width = new Random().nextInt(1, maxWidth);
            Coordinates coordinates = new Coordinates(length, width);
            if (map.getEntity(coordinates) == null) {
                freeCells[countToSpawn-1] = coordinates;
                countToSpawn--;
            }
        }
        return freeCells;
    }

    private void spawnGrass() {
        Coordinates[] spawner = spawner(maxLength * maxWidth / CHANCE_SPAWN_GRASS);
        for (Coordinates cell : spawner) {
            map.setEntity(new Grass(cell), cell);
        }
        renderer.render();
    }

    private void spawnHerbivores() {
        for (Coordinates cell : spawner(maxLength * maxWidth / CHANCE_SPAWN_HERBIVORE)) {
            map.setEntity(new Herbivore(cell), cell);
        }
        renderer.render();
    }

    private void spawnPredators() {
        for (Coordinates cell : spawner(maxLength * maxWidth / CHANCE_SPAWN_PREDATOR)) {
            map.setEntity(new Predator(cell), cell);
        }
        renderer.render();
    }
}
