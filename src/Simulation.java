package src;

import src.Creature.Herbivore;
import src.Creature.Predator;
import src.Entity.Entity;
import src.Entity.Grass;
import src.Entity.Rock;
import src.Entity.Tree;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Simulation {

    private static boolean isPause = false;

    public static final int MAX_LENGTH = 8;

    public static final int MAX_WIDTH = 8;

    private static final int MAP_SIZE = MAX_LENGTH * MAX_WIDTH;

    public static final String START = "Start";
    private int move;

    private void moveCounter() {

    }

    private void nextTurn() {

    }

    private int randomInt() {
        Random random = new Random();
        return random.nextInt(1,10);
    }

    private Entity summonEntity(Coordinates coordinates, int random) {
        return switch (random) {
            case 1 -> new Predator(coordinates);
            case 2 -> new Grass(coordinates);
            case 3 -> new Rock(coordinates);
            case 4 -> new Tree(coordinates);
            case 5 -> new Herbivore(coordinates);
            default -> throw new IllegalArgumentException() ;
        };
    }

    public void createSimulation() {
        Map map = new Map();
        MapConsoleRenderer renderer = new MapConsoleRenderer();
        for (int width = 1; width <= MAX_WIDTH; width++) {
            for (int length = 1; length <= MAX_LENGTH; length++) {
                Coordinates coordinates = new Coordinates(length,width);
                int random = randomInt();
                if (random > 5) {
                    continue;
                }
                map.setEntity(Objects.requireNonNull(summonEntity(coordinates, random)), coordinates);


            }
        }
        renderer.render(map, MAX_LENGTH, MAX_WIDTH);

    }

    private void startSimulation() {

    }

    public void pauseSimulation() {
        isPause = true;
    }
    public void resumeSimulation() {
        isPause = false;
    }
}
