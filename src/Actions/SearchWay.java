package src.Actions;

import src.Coordinates;

import java.util.*;

import static src.Simulation.*;

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
            for (Coordinates belowCell : getBelowCoordinates(cell,false)) {
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

    public static Coordinates[] getBelowCoordinates(Coordinates coordinates, boolean onlyEmpty) {
        int length = coordinates.length;
        int width = coordinates.width;
        ArrayList<Coordinates> belowCells = new ArrayList<>();
        int newLength;
        int newWidth;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    if (length + j > 0 && length + j <= maxLength) {
                        newLength = length + j;
                    } else continue;
                    if (width + i > 0 && width + i <= maxWidth) {
                        newWidth = width + i;
                    } else continue;
                    if (!onlyEmpty) {
                        belowCells.add(new Coordinates(newLength, newWidth));
                    }else if (map.getEntity(new Coordinates(newLength, newWidth)) == null) {
                        belowCells.add(new Coordinates(newLength, newWidth));
                    }
                }
            }
        }
        return belowCells.toArray(new Coordinates[0]);
    }

    private boolean isFood(Coordinates coordinates) {
        if (map.getEntity(coordinates) == null) return false;
        return map.getEntity(coordinates).getClass().getSimpleName().equals(TARGET.getSimpleName());
    }

}
