package src;

import src.Actions.*;

import java.util.Scanner;

import static java.lang.Thread.sleep;


public class Simulation {
    private static final String START_TEXT = "Введите количество ходов для симуляции, \"Q\" - выйти";
    public static int maxLength;
    public static int maxWidth;
    public static Map map = new Map();
    public boolean isPause = false;
    private final TurnActions turnActions = new TurnActions();


    public Simulation() {
        new CreateSimulation();
        startSimulation();
    }

    public void startSimulation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(START_TEXT);
        String line = scanner.nextLine();
        while (!line.equalsIgnoreCase("q")) {
            int count = Integer.parseInt(line);
            for (int i = 0; i < count; i++) {
                turnActions.nextTurn();
                try {
                    sleep(700);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(START_TEXT);
            line = scanner.nextLine();
        }

    }


    public void pauseOrResumeSimulation() {
        isPause = !isPause;
    }
}
