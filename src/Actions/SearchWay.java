package src.Actions;

import src.Coordinates;

import java.util.*;

import static src.Simulation.map;

public class SearchWay {
    private final Coordinates coordinates;
    private Class<?> TARGET;

    public SearchWay(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ArrayList<Coordinates> foundWay(Class<?> TARGET) {
        this.TARGET = TARGET;
        ArrayList<Coordinates> way = new ArrayList<>();
        way.add(new Coordinates(-99, -99));
        while (!coordinates.equals(way.getLast())) {
            build(way);
            if (way.size() == 1) {
                return way;
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
            Coordinates cell = queue.removeFirst();
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

    private boolean isFood(Coordinates coordinates) {
        if (map.getEntity(coordinates) == null) return false;
        return map.getEntity(coordinates).getClass().getSimpleName().equals(TARGET.getSimpleName());
    }

}
