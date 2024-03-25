package src;

import java.util.Objects;

public class Coordinates {
    public Integer length;
    public Integer width;

    public Coordinates(Integer length, Integer width) {
        this.length = length;
        this.width = width;
    }

    public Coordinates[] getBelowCoordinates(boolean onlyEmpty) {
        Coordinates[] belowCells = new Coordinates[8];
        int index = -1;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    int newLength = length + j;
                    int newWidth = width + i;
                    belowCells[++index] = new Coordinates(newLength, newWidth);
                }
            }
        }
        return belowCells;
    }

    public int moduleCoordinate() {
        return length + width;
    }

    public Coordinates getDistance(Coordinates endCoordinates) {
        int distanceLength = Math.abs(length - endCoordinates.length);
        int distanceWidth = Math.abs(width - endCoordinates.width);
        return new Coordinates(distanceLength, distanceWidth);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(length, that.length) && Objects.equals(width, that.width);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width);
    }
}
