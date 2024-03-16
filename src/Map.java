package src;

import src.Entity.Entity;

import java.util.HashMap;

public class Map {

    public HashMap<Coordinates, Entity> map = new HashMap<>();


    public void removeEntity(Coordinates coordinates) {
        map.remove(coordinates);
    }


    public void setEntity(Entity entity, Coordinates coordinates) {
        entity.coordinates = coordinates;
        map.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates) {
        return map.get(coordinates);
    }
}
