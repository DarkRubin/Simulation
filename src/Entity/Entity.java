package src.Entity;

import src.Coordinates;

public abstract class Entity {
    public Coordinates coordinates;



    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
