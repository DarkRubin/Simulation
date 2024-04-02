package src;

import src.Actions.*;

import java.util.Scanner;

import static java.lang.Thread.sleep;


public class Simulation {
    private static final String START_TEXT = "Введите количество ходов для симуляции, \"0\" - выйти";
    public static int maxLength;
    public static int maxWidth;

    public static Map map = new Map();
    private final TurnActions turnActions = new TurnActions();
    private final Scanner scanner = new Scanner(System.in);



    public void startSimulation() {
        CreateSimulation creator = new CreateSimulation();
        creator.createSimulation();
        System.out.println(START_TEXT);
        int count = scanner.nextInt();
        while (count != 0) {
            for (int i = 0; i < count; i++) {
                turnActions.nextTurn();
                try {
                    sleep(700);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(START_TEXT);
            count = scanner.nextInt();
        }
    }

}
