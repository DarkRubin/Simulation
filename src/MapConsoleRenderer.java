package src;

import src.Entity.Entity;

public class MapConsoleRenderer {
    public void render(Map map) {
        for (int width = 8; width >= 1; width--) {
            String line = "";
            for (int length = 0; length < 8; length++) {

            }
        }
    }

    private String selectSpriteForEntity(Entity entity) {
        switch (entity.getClass().getSimpleName()) {
            case "Grass":
                return "\uD83D\uDFE9";
            case "Rock":
            case "Tree":
            case "Herbivore":
            case "Predator":
                return "\uD83D\uDFE9";
        }
        return null;
    }




}
