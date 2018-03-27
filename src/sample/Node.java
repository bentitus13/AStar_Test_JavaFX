package sample;

import java.util.ArrayList;
import java.util.HashSet;

public class Node {
    private int x;
    private int y;
    private HashSet<Edge> edges = new HashSet<Edge>();

    Node(int x, int y, Edge[] edges) {
        this.x = x;
        this.y = y;
        for (int i = 0; i < edges.length; i++) {
            this.edges.add(edges[i]);
        }
    }

    public ArrayList<Node> aStar(Node destination) {
        ArrayList<Node> Path = new ArrayList<Node>();
        Path.add(this);
        return Path;
    }

}
