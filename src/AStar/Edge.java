package AStar;

import javafx.util.Pair;

public class Edge {
    private String id;
    private Node node1;
    private Node node2;
    private double weight;

    public String toString() {
        return id;
    }

    public String getID() {

        return id;
    }

    public Node getNode1() {
        return node1;
    }

    public Node getNode2() {
        return node2;
    }

    public double getWeight() {
        return weight;
    }

    public void setID(String id) {
        this.id = id;
    }

    public boolean contains(Node n) {
        if (this.node1.equals(n)) {
            return true;
        }
        if (this.node2.equals(n)) {
            return true;
        }
        return false;
    }

    public Edge(Node node1, Node node2) {
        this.id = id;


        this.node1 = node1;
        this.node2 = node2;
        weight = Math.hypot((node1.getX() - node2.getX()),(node1.getY() - node2.getY()));
    }
}
