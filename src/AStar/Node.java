package AStar;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Node {
    private String id;
    private double x;
    private double y;
    private ArrayList<Edge> edges = new ArrayList<Edge>();
    private Node parent;

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {

        this.parent = parent;
    }

    public double getY() {
        return y;
    }

    public double getX() {

        return x;
    }

    public String getID() {
        return id;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
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

    private boolean hasParent() {
        if (parent != null) {
            return true;
        } else {
            return false;
        }
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

    public Edge getEdge(Node n) {
//        System.out.println("this node in getEdge: " + this.toString());
//        System.out.println("dest node in getEdge: " + n.toString());
        Edge edge = null;
        for (Iterator<Edge> i = this.getEdges().iterator(); i.hasNext(); ) {
            Edge e = i.next();
//            System.out.println("Edge in getEdge: " + e.toString());
//            System.out.println("node1 in getEdge: " + e.getNode1().toString());
//            System.out.println("node2 in getEdge: " + e.getNode2().toString());
            if (e.getNode1().equals(n)) {
//                System.out.println("gucci");
                edge = e;
            }
            if (e.getNode2().equals(n)) {
//                System.out.println("gucci");
                edge = e;
            }
        }
        return edge;
    }

    @Override
    public String toString() {
        return this.id;
    }

    private boolean equals(Node comp) {
        if (this.x == comp.getX()) {
            if (this.y == comp.getY()) {
                return true;
            }
        }
        return false;
    }

    private Double distanceBetweenNodes(Node node) {
        return Math.hypot(this.x-node.getX(), (this.y-node.getY()));
    }

    private ArrayList<Node> getPath(Node n) {
        ArrayList<Node> tempPath = new ArrayList<Node>();
//        System.out.println("Node given: " + n.toString());
        while (n.hasParent()) {
//            System.out.println("Parent: " + n.getParent());
            tempPath.add(n);
            n = n.getParent();
        }
        tempPath.add(n);
//        System.out.println("tempPath: " + tempPath);
        ArrayList<Node> path = (ArrayList<Node>)tempPath.clone();

//        System.out.println("tempPath.size(): " + tempPath.size());
//        System.out.println("path: " + path);
//        System.out.println("path.size(): " + path.size());
        for (int i = 0; i < tempPath.size() / 2; i++) {
            path.set(tempPath.size() - i - 1, tempPath.get(i));
            path.set(i, tempPath.get(tempPath.size() - i - 1));
        }
        return path;
    }

    public ArrayList<Node> AStar(Node destNode) {
        // Total cost from start node
        HashMap<String, Double> gScore = new HashMap<String, Double>();

        // Total cost to end node
        HashMap<String, Double> fScore = new HashMap<String, Double>();

        // Path of nodes to return
        ArrayList<Node> path = new ArrayList<Node>();
        path.add(this); //Add start node to path

        // Nodes to explore in the future
        // Really should be a key/value priority queue sorted by fScore
        HashSet<Node> openSet = new HashSet<Node>();
        openSet.add(this);

        // Add gScore for current node
        gScore.put(this.id, 0.0);

        // add fScore for current node
        fScore.put(this.id, this.distanceBetweenNodes(destNode));

        // Nodes that have been explored
        HashSet<Node> closedSet = new HashSet<Node>();
        closedSet.add(this);

        // Check the current node
//        if (this.equals(destNode)) {
//            System.out.println("We good");
//        } else {
//            System.out.println("Destination not equal to start...looking to neighbors");
//            System.out.println(edges.toString());
//        }

        this.parent = null;

        // Unexplored node with shortest distance to goal
        // Initialize to first item in openSet
        // (if only 1 item then it is the shortest to goal)
        Node currentNode = this;

        // Start searching
        while (!openSet.isEmpty()) {
//            System.out.println("Starting iteration on new Node <--------------------------------------------------------------");
            // Temporary fScore value for comparing to current fScore
            // Since we want the lowest fScore, make the default super large
            double tempFScore = Double.POSITIVE_INFINITY;

//            System.out.println("getting next iterator for openset");

//            System.out.println("finding new node to explore");
            // Get item in openSet that has smallest
            for (Node tempNode : openSet) {
//                System.out.println("iterating through openSet");
//                System.out.println("currently iterating through: " + n.toString());
                if (fScore.get(tempNode.getID()) < tempFScore) {
//                    System.out.println("Found possible node to explore: " + fScore.get(n.getID()) + " less than: " + tempFScore);
                    tempFScore = fScore.get(tempNode.getID());
                    currentNode = tempNode;
                }
            }
//            System.out.println("openSet: " + openSet);
            openSet.remove(currentNode);
            closedSet.add(currentNode);
//            System.out.println("closedSet: " + closedSet);

//            System.out.println("Found new node to explore: " + currentNode.toString());

            // Check if we found the goal
            if (currentNode.equals(destNode)) {
//                System.out.println("We good");
                path = getPath(currentNode);
                return path;
            }

            // Add neighbors to openSet
            for (Edge e: currentNode.getEdges()) {
                // Temporary variable for comparing gScores
                Double tempGScore = 0.0;

//                System.out.println("Adding new neighbor! <---------------------------------");

                // Set neighbor to the node in edge that is not current node
                Node neighbor;
                if (e.getNode1().equals(currentNode)) {
                    neighbor = e.getNode2();
                } else {
                    neighbor = e.getNode1();
                }
                if (!closedSet.contains(neighbor)) {
//                    System.out.println("Edge: " + e.toString());
//                    System.out.println("Neighbor: " + neighbor.toString());
//
//                    System.out.println("Current node gScore: " + gScore.get(currentNode.getID()));
//
//                    System.out.println("Distance between current node and neighbor: " + currentNode.distanceBetweenNodes(neighbor));

                    // Add neighbor gScore value to gScore
                    tempGScore = gScore.get(currentNode.getID()) + e.getWeight();// currentNode.distanceBetweenNodes(neighbor);

                    if (!gScore.containsKey(neighbor.getID())) {
//                        System.out.println("setting parent");

                        // Set parent for recreating the path later
                        neighbor.setParent(currentNode);

//                        System.out.println("Parent: " + neighbor.getParent());
//
//                        System.out.println("putting tempGScore");

                        // Set the gScore for neighbor to tempGScore
                        gScore.put(neighbor.getID(), tempGScore);

                        // Calculate tempFScore for readability
                        tempFScore = gScore.get(neighbor.getID()) + destNode.distanceBetweenNodes(neighbor);
//                        System.out.println("tempFScore: " + tempFScore);
//
//                        System.out.println("Setting fScore");
                        // Set fScore for neighbor to tempFScore
                        fScore.put(neighbor.getID(), tempFScore);
                    }
//                    System.out.println("adding neighbor");

                    // Add neighbor nodes with weights to the openSet
                    openSet.add(neighbor);
                }
            }
//            System.out.println("fScore: " + fScore);
//            System.out.println("gScore: " + gScore);
        }

        System.out.println("Path not found!");
        return null;
    }

}
