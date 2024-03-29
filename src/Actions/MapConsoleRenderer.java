package src.Actions;

import src.Coordinates;
import src.Entity.Entity;

import static src.Simulation.*;

public class MapConsoleRenderer extends Action {
    private static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";
    private static final String ANSI_RESET = "\u001B[0m";
    public void render() {
        for (int width = 1; width <= maxWidth; width++) {
            StringBuilder line = new StringBuilder(ANSI_WHITE_SQUARE_BACKGROUND);
            for (int length = 1; length <= maxLength; length++) {
                Coordinates coordinates = new Coordinates(length,width);
                String cell = selectSpriteForCell(map.getEntity(coordinates));
                line.append(cell);
            }
            line.append(ANSI_RESET);
            System.out.println(line);
        }
        System.out.println();
    }
    private String selectSpriteForCell(Entity entity) {
        if (entity == null) {
            return " ⬜";
        }
        return switch (entity.getClass().getSimpleName()) {
            case "Grass" -> " 🌿";
            case "Rock" -> " ⛰️";
            case "Tree" -> " 🌲";
            case "Herbivore" -> " 🐑";
            case "Predator" -> " 🐺";
            default -> throw new ClassCastException("Entity error");
        };
    }


    @Override
    public void doInThisMove() {
        render();
    }
}
