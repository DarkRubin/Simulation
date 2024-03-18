package src.Actions;

import src.Coordinates;
import src.Creature.Herbivore;
import src.Creature.Predator;
import src.Entity.Entity;
import src.Entity.Grass;
import src.Entity.Rock;
import src.Entity.Tree;


import java.util.Random;
import java.util.Scanner;

import static src.Simulation.*;

public class CreateSimulation extends Actions {

    private void chooseMapSize() {
        Scanner scanner = new Scanner(System.in);
        int length;
        int width;
        while (true) {
            System.out.println("Введите длину поля:");
            length = scanner.nextInt();
            if (length < 4 || length > 50) {
                System.out.println("Недопустимое значение, введите от 4 до 50");
                continue;
            }
            System.out.println("Введите ширину поля:");
            width = scanner.nextInt();
            if (width >= 4 && width <= 50) {
                break;
            } else {
                System.out.println("Недопустимое значение, введите от 4 до 50");
            }
        }
        maxLength = length;
        maxWidth = width;
    }



    private Entity summonEntity(Coordinates coordinates) {
        int random = new Random().nextInt(11);
        return switch (random) {
            case 1 -> new Tree(coordinates);
            case 2,3 -> new Grass(coordinates);
            case 4 -> new Rock(coordinates);
            case 5 -> new Predator(coordinates);
            case 6,7 -> new Herbivore(coordinates);
            default -> null;
        };
    }

    public CreateSimulation() {
        chooseMapSize();
        for (int width = 1; width <= maxWidth; width++) {
            for (int length = 1; length <= maxLength; length++) {
                Coordinates coordinates = new Coordinates(length,width);
                Entity entity = summonEntity(coordinates);
                if (entity == null) continue;
                map.setEntity(entity, coordinates);
            }
        }
    }



}
