package src;

import java.util.ArrayList;
import java.util.List;

public class Graph {


    List<GraphNode> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(GraphNode node) {
        nodes.add(node);
    }

    public void addEdge(GraphNode node1, GraphNode node2) {
        if (!node1.neighbors.contains(node2))
            node1.neighbors.add(node2);
        if (!node2.neighbors.contains(node1))
            node2.neighbors.add(node1);
    }
}

