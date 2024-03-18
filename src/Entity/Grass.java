package src.Entity;

import src.Coordinates;

public class Grass extends Entity {
    public static int countGrass;
    public Grass(Coordinates coordinates) {
        super(coordinates);
        countGrass++;
    }
}
