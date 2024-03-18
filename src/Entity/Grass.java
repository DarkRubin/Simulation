package src.Entity;

import src.Coordinates;
import src.Entity.Entity;

public class Grass extends Entity {
    public static int countGrass;
    public Grass(Coordinates coordinates) {
        super(coordinates);
        countGrass++;
    }
}
