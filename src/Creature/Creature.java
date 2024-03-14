package src.Creature;

import src.Coordinates;
import src.Entity.Entity;

public abstract class Creature extends Entity {

    public Creature(Coordinates coordinates) {
        super(coordinates);
    }

    public abstract void makeMove();
}
