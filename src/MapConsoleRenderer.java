package src;

import src.Entity.Entity;
import src.Simulation;

import static src.Simulation.MAX_LENGTH;
import static src.Simulation.MAX_WIDTH;

public class MapConsoleRenderer {




    public static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_RESET = "\u001B[0m";
    public void render(Map map) {

        for (int width = 1; width <= MAX_WIDTH; width++) {
            String line = ANSI_WHITE_SQUARE_BACKGROUND;
            for (int length = 1; length <= MAX_LENGTH; length++) {
                Coordinates coordinates = new Coordinates(length,width);
                String cell = selectSpriteForCell(map.getEntity(coordinates));
                line += cell;
            }
            line += ANSI_RESET;
            System.out.println(line);
        }

    }
    private String selectSpriteForCell(Entity entity) {
        if (entity == null) {
            return "   ";
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





}
