package src.Actions;

import src.Coordinates;
import src.Creature.Herbivore;
import src.Creature.Predator;
import src.Entity.Entity;

import static src.Simulation.*;

public class MakeMoveAll extends Actions {

    private int move;
    public void nextTurn() {

        for (int width = 1; width <= maxWidth; width++) {
            for (int length = 1; length <= maxLength; length++) {
                Coordinates coordinates = new Coordinates(length, width);
                Entity entity = map.getEntity(coordinates);
                if (entity instanceof Herbivore) {
                    ((Herbivore) entity).makeMove(coordinates);
                }
                if (entity instanceof Predator) {
                    ((Predator) entity).makeMove(coordinates);
                }
            }
        }
        move++;
        System.out.println(move);
    }
}
