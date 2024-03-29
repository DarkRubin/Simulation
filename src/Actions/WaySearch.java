package src.Actions;

import src.Coordinates;

import java.util.*;

public class WaySearch {

    private final int INF = Integer.MAX_VALUE;
    private final ArrayList<Coordinates> foodOnMap;
    private ArrayList<Coordinates> neighbors;
    private ArrayList<Coordinates> emptyCells;
    private ArrayList<Coordinates> visited;
    private Queue<Coordinates>

    public WaySearch(ArrayList<Coordinates> foodOnMap) {
        this.foodOnMap = foodOnMap;
    }

    public ArrayList<Coordinates> foundWay(Coordinates coordinates) {
        ArrayList<Coordinates> way;

        if () {

        }
        return way;
    }

    private void buildGraph(Coordinates coordinates) {

        for (Coordinates belowCoordinate : coordinates.getBelowCoordinates(true)) {
            if (visited.contains(belowCoordinate)) continue;
            else
        }

    }

}
