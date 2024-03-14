package src;

import src.Entity.Entity;

import java.util.HashMap;

public class Map {

    public HashMap<Coordinates, Entity> map = new HashMap<>();


    private String getPieceSprite(Coordinates coordinates) {
        return null;
    }


    public void setEntity(Entity entity, Coordinates coordinates) {
        entity.coordinates = coordinates;
        map.put(coordinates, entity);
    }
}

//    public Entity getEntity(Coordinates coordinates) {
//        return entity.get(coordinates);
//    }
//}
