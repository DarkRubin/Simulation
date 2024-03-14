package src;

import java.util.Objects;

public class Coordinates {
    public final Integer length;
    public final Integer width;

    public Coordinates(Integer length, Integer width) {
        this.length = length;
        this.width = width;
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
