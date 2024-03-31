package src.Actions;

import src.Coordinates;
import src.Creature.Herbivore;
import src.Entity.Grass;

import java.util.*;

import static src.Simulation.map;

public class SearchWay {
    private final boolean IS_HERBIVORE;
    private final Coordinates coordinates;

    public SearchWay(boolean IS_HERBIVORE, Coordinates coordinates) {
        this.IS_HERBIVORE = IS_HERBIVORE;
        this.coordinates = coordinates;
    }

    public ArrayList<Coordinates> foundWay() {
        ArrayList<Coordinates> way = new ArrayList<>();
        way.add(new Coordinates(-99, -99));
        while (!coordinates.equals(way.getLast())) {
            build(way);
            if (way.size() == 1) {
                return null;
            }
        }
        way.removeFirst();
        return way;
    }

    public void build(ArrayList<Coordinates> way) {
        LinkedHashSet<Coordinates> queue = new LinkedHashSet<>();
        ArrayList<Coordinates> visited = new ArrayList<>();
        queue.add(coordinates);
        while (!queue.isEmpty()) {
            Coordinates cell = queue.removeLast();
            visited.add(cell);
            for (Coordinates belowCell : cell.getBelowCoordinates(false)) {
                if (visited.contains(belowCell)) continue;
                if (isFood(belowCell) || way.getLast().equals(belowCell)) {
                    way.add(cell);
                    queue.clear();
                    break;
                }

                if (map.getEntity(belowCell) == null)
                    queue.add(belowCell);
            }
        }

    }

    private boolean isFood (Coordinates coordinates) {
        if (IS_HERBIVORE && map.getEntity(coordinates) instanceof Grass)
            return true;
        else
            return !IS_HERBIVORE && map.getEntity(coordinates) instanceof Herbivore;
    }

}
