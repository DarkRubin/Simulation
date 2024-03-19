package src;

import java.util.Objects;

public class Coordinates {
    public Integer length;
    public Integer width;

    public Coordinates(Integer length, Integer width) {
        this.length = length;
        this.width = width;
    }

    public Coordinates changeCoordinates(int addLength, int addWidth) {
        if (length + addLength > -1 || width + addWidth > -1) {
            return new Coordinates(length + addLength, width + addWidth);
        }
        return null;
    }

    public Coordinates[] getBelowCoordinates(Coordinates coordinates) {
        Coordinates[] belowCells = new Coordinates[8];
        int index = -1;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    if (coordinates.changeCoordinates(i, j) != null)
                        belowCells[++index] = coordinates.changeCoordinates(i, j);
                }
            }
        }
        return belowCells;
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
