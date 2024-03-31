package src.Entity;

import src.Coordinates;

import java.util.ArrayList;

public class Grass extends Entity {
    public static ArrayList<Coordinates> grassOnMap = new ArrayList<>();

    public Grass(Coordinates coordinates) {
        super(coordinates);
        grassOnMap.add(coordinates);
    }
}
