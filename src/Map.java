package src;

import src.Creature.Herbivore;
import src.Entity.Entity;

import java.util.HashMap;
import static src.Creature.Herbivore.herbivoreOnMap;
import static src.Creature.Predator.predatorsOnMap;

public class Map {

    public HashMap<Coordinates, Entity> map = new HashMap<>();


    public void removeEntity(Coordinates coordinates) {
        map.remove(coordinates);
    }


    public void setEntity(Entity entity, Coordinates coordinates) {
        entity.coordinates = coordinates;
        map.put(coordinates, entity);
    }

    public void moveEntity(Coordinates coordinates, Coordinates newCoordinates, Map map) {
        Entity entity = map.getEntity(coordinates);
        if (entity instanceof Herbivore) {
            herbivoreOnMap.remove(coordinates);
            herbivoreOnMap.add(newCoordinates);
        } else {
            predatorsOnMap.remove(coordinates);
            predatorsOnMap.add(newCoordinates);
        }
        map.removeEntity(coordinates);
        map.setEntity(entity, newCoordinates);

    }

    public Entity getEntity(Coordinates coordinates) {
        return map.get(coordinates);
    }
}
