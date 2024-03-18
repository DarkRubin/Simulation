package src;

import src.Actions.*;

import java.util.Scanner;

import static java.lang.Thread.sleep;
import static src.Creature.Herbivore.countHerbivore;
import static src.Entity.Grass.countGrass;


public class Simulation {
    public static int maxLength;
    public static int maxWidth;
    public static Map map = new Map();
    public static boolean isPause = false;
    private final MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();
    private final MakeMoveAll makeMoveAll = new MakeMoveAll();
    private final SpawnMoreObjects spawnMoreObjects = new SpawnMoreObjects();
    public Simulation() {
        new CreateSimulation();
        startSimulation();
    }

    public void startSimulation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество ходов для симуляции, \"Q\" - выйти");
        String line = scanner.nextLine();
        while (!line.equalsIgnoreCase("q")) {
            int count = Integer.parseInt(line);
            for (int i = 0; i < count; i++) {
                nextTurn();
                try {
                    sleep(700);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Введите количество ходов для симуляции, \"Q\" - выйти");
            line = scanner.nextLine();
        }

    }


    public void pauseOrResumeSimulation() {
        isPause = !isPause;
    }
    public void nextTurn() {
        if (countGrass < 2) {
            spawnMoreObjects.spawnGrass();
        }
        if (countHerbivore < 2) {
            spawnMoreObjects.spawnHerbivore();
        }

        makeMoveAll.nextTurn();
        mapConsoleRenderer.render();
    }
}
