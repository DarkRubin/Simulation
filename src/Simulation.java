package src;

import src.Creature.Herbivore;
import src.Creature.Predator;
import src.Entity.Entity;
import src.Entity.Grass;
import src.Entity.Rock;
import src.Entity.Tree;

import java.util.Random;

public class Simulation {
    public static final int MAX_LENGTH = 8;
    public static final int MAX_WIDTH = 8;

    private Map map = new Map();
    private MapConsoleRenderer renderer = new MapConsoleRenderer();
    private static boolean isPause = false;
    private int move;
    private boolean isCreated = false;


    private void nextTurn() {
        for (int width = 1; width <= MAX_WIDTH; width++) {
            for (int length = 1; length <= MAX_LENGTH; length++) {
                Coordinates coordinates = new Coordinates(length, width);
                Entity entity = map.getEntity(coordinates);
                if (entity instanceof Herbivore) {
                    ((Herbivore) entity).makeMove(map, coordinates);
                }
                if (entity instanceof Predator) {
                    ((Predator) entity).makeMove(map, coordinates);
                }
             }
        }
        move++;
    }

    private int randomInt() {
        Random random = new Random();
        return random.nextInt(1,20);
    }

    private Entity summonEntity(Coordinates coordinates, int random) {
        return switch (random) {
            case 1 -> new Tree(coordinates);
            case 2,3 -> new Grass(coordinates);
            case 4 -> new Rock(coordinates);
            case 5 -> new Predator(coordinates);
            case 6,7 -> new Herbivore(coordinates);
            default -> throw new IllegalArgumentException() ;
        };
    }

    private void createSimulation() {
        for (int width = 1; width <= MAX_WIDTH; width++) {
            for (int length = 1; length <= MAX_LENGTH; length++) {
                Coordinates coordinates = new Coordinates(length,width);
                int random = randomInt();
                if (random > 7) continue;
                Entity entity = summonEntity(coordinates, random);
                map.setEntity(entity, coordinates);
            }
        }
        renderer.render(map);
        isCreated = true;
    }

    public void startSimulation() {

        if (!isCreated) {
            createSimulation();
        }
        nextTurn();
        System.out.println(move);
        renderer.render(map);

    }

    private void spawnNewGrass() {

    }

    public void pauseSimulation() {
        isPause = true;
    }
    public void resumeSimulation() {
        isPause = false;
    }
}
