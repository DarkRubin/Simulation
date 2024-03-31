package src;

import java.util.ArrayList;
import java.util.Objects;

import static src.Simulation.*;

public class Coordinates {
    public Integer length;
    public Integer width;

    public Coordinates(Integer length, Integer width) {
        this.length = length;
        this.width = width;
    }

    public Coordinates[] getBelowCoordinates(boolean onlyEmpty) {
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
        if (belowCells.isEmpty()) {
            return null;
        }
        return belowCells.toArray(new Coordinates[0]);
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
