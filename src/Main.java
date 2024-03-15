package src;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Введите длину поля:");
//        length = scanner.nextInt();
//        if (length < 4 || length > 50) {
//            System.out.println("Недопустимое значение, введите от 4 до 50");
//
//        }
//        System.out.println("Введите ширину поля:");
//        int width = scanner.nextInt();
//        if (width < 4 || width > 50) {
//            System.out.println("Недопустимое значение, введите от 4 до 50");
//        }
//        MAX_WIDTH = width;
//
//        System.out.println("Запустить симуляцию: \"start\"");
//        String line = scanner.nextLine();
//        if (line.equalsIgnoreCase(START)) {
//            Map map = new Map();
//            MapConsoleRenderer renderer = new MapConsoleRenderer();
//            renderer.render(map, MAX_LENGTH, MAX_WIDTH);
//        }
//        System.out.println("dddd");
        Simulation simulation = new Simulation();
        simulation.createSimulation();


    }
}

