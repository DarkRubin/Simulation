package src.Creature;

import src.Coordinates;
import src.Entity.Entity;
import src.Entity.Grass;
import src.Graph;
import src.GraphNode;

import java.util.ArrayList;

import static src.Simulation.*;

public abstract class Creature extends Entity {

    public Creature(Coordinates coordinates) {
        super(coordinates);
    }

    protected abstract void makeMove(Coordinates coordinates);

    protected Coordinates foundWay(Coordinates coordinates) {

        return null;
    }

    protected Coordinates checkBelowCells(Coordinates coordinates, boolean isHerbivore) {
        Coordinates[] search = coordinates.getBelowCoordinates(coordinates);
        if (isHerbivore) {
            for (Coordinates value : search) {
                if (map.getEntity(value) instanceof Grass) {
                    return value;
                }
            }
        }else {
            for (Coordinates value : search) {
                if (map.getEntity(value) instanceof Herbivore) {
                    return value;
                }
            }
        }
        return null;
    }


    protected ArrayList<Coordinates> searchGrassOnMap() {
        ArrayList<Coordinates> grassOnMap = new ArrayList<>();
        for (int width = 1; width <= maxWidth; width++) {
            for (int length = 1; length <= maxLength; length++) {
                Coordinates newCoordinates = new Coordinates(length, width);
                Entity entity = map.getEntity(newCoordinates);
                if (entity instanceof Grass) {
                    grassOnMap.add(newCoordinates);
                }
            }
        }
        return grassOnMap;
    }
    private Coordinates[] foundEmptyCell(Coordinates coordinates) {
        Coordinates[] emptyCells = new Coordinates[8];
        int index = 0;
        Coordinates[] belowCoordinates = coordinates.getBelowCoordinates(coordinates);
        for (Coordinates coordinatesIterate : belowCoordinates) {
            if (map.getEntity(coordinatesIterate) == null) {
                emptyCells[index++] = coordinatesIterate;
            }
        }
        return emptyCells;
    }

    private Graph buildGraph(Coordinates coordinates, boolean isHerbivore) {
        Graph graph = new Graph();
        GraphNode startNode = new GraphNode(coordinates);
        graph.addNode(startNode);
        while (checkBelowCells(coordinates, isHerbivore) != null) {
            for (Coordinates thisCell : foundEmptyCell(coordinates)) {
                GraphNode graphNode = new GraphNode(thisCell);
                graph.addNode(graphNode);
                graph.addEdge(startNode, graphNode);
            }
            for (int i = 0; i < foundEmptyCell(coordinates).length; i++) {
                coordinates = foundEmptyCell(coordinates)[i];
            }

        }


        return graph;
    }
}
