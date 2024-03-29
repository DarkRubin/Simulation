package src;

import src.Actions.*;

import java.util.Scanner;

import static java.lang.Thread.sleep;


public class Simulation {
    private static final String START_TEXT = "Введите количество ходов для симуляции,\"SPACE\" чтобы остановить, \"0\" - выйти";
    public static int maxLength;
    public static int maxWidth;

    public static Map map = new Map();
    private final TurnActions turnActions = new TurnActions();
    private final Scanner scanner = new Scanner(System.in);


    public Simulation() {
        new CreateSimulation();
        startSimulation();
    }

    public void startSimulation() {

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



//    public void pauseSimulation() {
//        System.out.println("Симуляция остановлена нажмите \"SPACE\" чтобы возобновить");
//        while (true) {
//            if (scanner.nextLine().equals(" "))
//                return;
//        }
//    }
}
