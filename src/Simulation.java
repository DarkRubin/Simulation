package src;

import java.util.Scanner;

public class Simulation {

    private static final String START = "Start";

    public void moveCounter() {

    }
    public void nextTurn() {

    }
    public void startSimulation() {

    }
    public void pauseSimulation() {

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите длину поля:");
            int length = scanner.nextInt();
            if (length < 4 || length > 50 ) {
                System.out.println("Недопустимое значение, введите от 4 до 50");
                continue;
            }
            System.out.println("Введите ширину поля:");
            int width = scanner.nextInt();
            if (width < 4 || width > 50 ) {
                System.out.println("Недопустимое значение, введите от 4 до 50");
                continue;
            }

            System.out.println("Запустить симуляцию: \"start\"");
            String line = scanner.nextLine();
        }



    }
}
