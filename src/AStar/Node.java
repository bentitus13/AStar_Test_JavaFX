package AStar;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Node {
    private String id;
    private double x;
    private double y;
    private ArrayList<Edge> edges = new ArrayList<Edge>();

    public double getY() {
        return y;
    }

    public double getX() {

        return x;
    }

    public String getID() {
        return id;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setID(String id) {
        this.id = id;
    }

//    public Node(int x, int y, Edge[] edges) {
//        this.x = x;
//        this.y = y;
//        for (int i = 0; i < edges.length; i++) {
//            this.edges.add(edges[i]);
//        }
//    }

    public Node(double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public void addEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    public String toString() {
        return this.id;
    }

    public boolean equals(Node comp) {
        if (this.x == comp.getX()) {
            if (this.y == comp.getY()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Node> AStar(Node destNode) {
        // Total cost from start node
        int gScore;

        // temporary variable for comparing gScores
        int tempGScore;

        // Total cost to end node
        int fScore;

        // temporary variable for comparing fScores
        int tempFScore;

        // Path of nodes to return
        ArrayList<Node> path = new ArrayList<Node>();
        path.add(this); //Add start node to path

        // Nodes to explore in the future
        ArrayList<Node> openSet = new ArrayList<Node>();
        openSet.add(this);

        // Nodes that have been explored
        ArrayList<Node> closedSet = new ArrayList<Node>();

        // Check the current node
        if (this.equals(destNode)) {
            System.out.println("We good");
        } else {
            System.out.println("Destination not equal to start...looking to neighbors");
            System.out.println(edges.toString());
        }

        // Check if the destination is one of the neighbors
        for (Iterator<Edge> i = edges.iterator(); i.hasNext();) {
            Edge e = i.next();
            System.out.print(e.toString());
            if (e.getNode1().equals(destNode)) {
                System.out.println("We good");
                path.add(e.getNode1());
            }
            if (e.getNode2().equals(destNode)) {
                System.out.println("We good");
                path.add(e.getNode2());
            }
        }
        System.out.println("Path found!");
        return path;
    }

}
