package src;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    Coordinates coordinates;
    public List<GraphNode> neighbors;

    public GraphNode(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.neighbors = new ArrayList<>();
    }
}
