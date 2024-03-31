package src;

import src.Creature.Herbivore;
import src.Entity.Entity;

import java.util.HashMap;
import static src.Creature.Herbivore.herbivoresOnMap;
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

    public void moveEntity(Coordinates coordinates, Coordinates newCoordinates) {
        Entity entity = map.get(coordinates);
        if (entity == null) throw new RuntimeException();
        if (entity instanceof Herbivore) {
            herbivoresOnMap.remove(coordinates);
            herbivoresOnMap.add(newCoordinates);
        } else {
            predatorsOnMap.remove(coordinates);
            predatorsOnMap.add(newCoordinates);
        }
        map.remove(coordinates);
        map.put(newCoordinates, entity);

    }

    public Entity getEntity(Coordinates coordinates) {
        return map.get(coordinates);
    }
}
