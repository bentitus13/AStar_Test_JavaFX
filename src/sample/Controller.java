package sample;

import AStar.Edge;
import AStar.Node;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

//import java.awt.*;

public class Controller {
    private boolean firstSelect = true;
    private boolean secondSelect = true;
    private static Node startNode;
    private static Node endNode;

    @FXML
    private Canvas testCanvas;

    @FXML
    private Button goButton;

    @FXML
    private Label label;

    @FXML
    private AnchorPane anchorPane;

    private static Node Node01 = new Node(50.0,50.0);
    private static Node Node02 = new Node(100.0, 50.0);
    private static Node Node03 = new Node(150.0, 100.0);
    private static Node Node04 = new Node(50.0, 250.0);
    private static Node Node05 = new Node(250.0, 150.0);
    private static Node Node06 = new Node(500.0, 100.0);
    private static Node Node07 = new Node(400.0, 200.0);
    private static Node Node08 = new Node(350.0, 300.0);
    private static Node Node09 = new Node(300.0, 450.0);
    private static Node Node10 = new Node(450.0, 400.0);
    private static Edge Edge0102 = new Edge(Node01, Node02);
    private static Edge Edge0104 = new Edge(Node01, Node04);
    private static Edge Edge0203 = new Edge(Node02, Node03);
    private static Edge Edge0304 = new Edge(Node03, Node04);
    private static Edge Edge0305 = new Edge(Node03, Node05);
    private static Edge Edge0309 = new Edge(Node03, Node09);
    private static Edge Edge0409 = new Edge(Node04, Node09);
    private static Edge Edge0506 = new Edge(Node05, Node06);
    private static Edge Edge0508 = new Edge(Node05, Node08);
    private static Edge Edge0607 = new Edge(Node06, Node07);
    private static Edge Edge0610 = new Edge(Node06, Node10);
    private static Edge Edge0708 = new Edge(Node07, Node08);
    private static Edge Edge0809 = new Edge(Node08, Node09);
    private static Edge Edge0910 = new Edge(Node09, Node10);

    static ArrayList<Edge> edgelist01 = new ArrayList<Edge>();
    static ArrayList<Edge> edgelist02 = new ArrayList<Edge>();
    static ArrayList<Edge> edgelist03 = new ArrayList<Edge>();
    static ArrayList<Edge> edgelist04 = new ArrayList<Edge>();
    static ArrayList<Edge> edgelist05 = new ArrayList<Edge>();
    static ArrayList<Edge> edgelist06 = new ArrayList<Edge>();
    static ArrayList<Edge> edgelist07 = new ArrayList<Edge>();
    static ArrayList<Edge> edgelist08 = new ArrayList<Edge>();
    static ArrayList<Edge> edgelist09 = new ArrayList<Edge>();
    static ArrayList<Edge> edgelist10 = new ArrayList<Edge>();

    static ArrayList<Node> nodelist = new ArrayList<Node>();

    static HashMap<String, Node> nodeSet = new HashMap<String, Node>();
    static HashMap<String, Edge> edgeSet = new HashMap<String, Edge>();

    static HashMap<String, Circle> nodeDispSet = new HashMap<String, Circle>();
    static HashMap<String, Line> edgeDispSet = new HashMap<String, Line>();

    EventHandler<MouseEvent> clickHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            for (String string : nodeDispSet.keySet()) {
                if (nodeDispSet.get(string) == event.getSource()) {
                    Node node = nodeSet.get(string);
                    if (firstSelect) {
                        nodeDispSet.get(node.getID()).setFill(Color.rgb(35, 205, 0, .99));
                        startNode = node;
                        firstSelect = false;
                    } else if (secondSelect) {
                        nodeDispSet.get(node.getID()).setFill(Color.rgb(205, 35, 0, 0.99));
                        endNode = node;
                        secondSelect = false;
                    }
                }
            }
            event.consume();
        }
    };

    public void drawNodes() {
        for (Node node : nodelist) {
            Circle circle = new Circle(5.0);
            circle.setCenterX(node.getX());
            circle.setCenterY(node.getY());
            circle.setFill(Color.DODGERBLUE);
            circle.setStroke(Color.BLACK);
            circle.setStrokeType(StrokeType.INSIDE);
            circle.setOnMouseClicked(clickHandler);

            String label = node.getID();
            nodeDispSet.put(label, circle);
        }
    }

    public void drawEdges() {
        for (Edge edge : edgeSet.values()) {
            Line line = new Line();
            line.setStartX(edge.getNode1().getX());
            line.setStartY(edge.getNode1().getY());
            line.setEndX(edge.getNode2().getX());
            line.setEndY(edge.getNode2().getY());
            line.setStrokeWidth(1.0);
            line.setStrokeType(StrokeType.CENTERED);

            String label = edge.getID();
            edgeDispSet.put(label, line);
        }
    }

    public void setEdgeLists() {

        edgelist01.add(Edge0102);
        edgelist01.add(Edge0104);
        edgelist02.add(Edge0102);
        edgelist02.add(Edge0203);
        edgelist03.add(Edge0203);
        edgelist03.add(Edge0304);
        edgelist03.add(Edge0305);
        edgelist03.add(Edge0309);
        edgelist04.add(Edge0304);
        edgelist04.add(Edge0409);
        edgelist04.add(Edge0104);
        edgelist05.add(Edge0305);
        edgelist05.add(Edge0506);
        edgelist05.add(Edge0508);
        edgelist06.add(Edge0506);
        edgelist06.add(Edge0607);
        edgelist06.add(Edge0610);
        edgelist07.add(Edge0607);
        edgelist07.add(Edge0708);
        edgelist08.add(Edge0508);
        edgelist08.add(Edge0708);
        edgelist08.add(Edge0809);
        edgelist09.add(Edge0309);
        edgelist09.add(Edge0409);
        edgelist09.add(Edge0809);
        edgelist09.add(Edge0910);
        edgelist10.add(Edge0610);
        edgelist10.add(Edge0910);

        Node01.addEdges(edgelist01);
        Node02.addEdges(edgelist02);
        Node03.addEdges(edgelist03);
        Node04.addEdges(edgelist04);
        Node05.addEdges(edgelist05);
        Node06.addEdges(edgelist06);
        Node07.addEdges(edgelist07);
        Node08.addEdges(edgelist08);
        Node09.addEdges(edgelist09);
        Node10.addEdges(edgelist10);

        Node01.setID("Node 1");
        Node02.setID("Node 2");
        Node03.setID("Node 3");
        Node04.setID("Node 4");
        Node05.setID("Node 5");
        Node06.setID("Node 6");
        Node07.setID("Node 7");
        Node08.setID("Node 8");
        Node09.setID("Node 9");
        Node10.setID("Node 10");

        Edge0102.setID("Edge 1-2");
        Edge0104.setID("Edge 1-4");
        Edge0203.setID("Edge 2-3");
        Edge0304.setID("Edge 3-4");
        Edge0305.setID("Edge 3-5");
        Edge0309.setID("Edge 3-9");
        Edge0409.setID("Edge 4-9");
        Edge0506.setID("Edge 5-6");
        Edge0508.setID("Edge 5-8");
        Edge0607.setID("Edge 6-7");
        Edge0610.setID("Edge 6-10");
        Edge0708.setID("Edge 7-8");
        Edge0809.setID("Edge 8-9");
        Edge0910.setID("Edge 9-10");

        nodelist.add(Node01);
        nodelist.add(Node02);
        nodelist.add(Node03);
        nodelist.add(Node04);
        nodelist.add(Node05);
        nodelist.add(Node06);
        nodelist.add(Node07);
        nodelist.add(Node08);
        nodelist.add(Node09);
        nodelist.add(Node10);
    }

    public void setHashSets() {
        nodeSet.put(Node01.getID(), Node01);
        nodeSet.put(Node02.getID(), Node02);
        nodeSet.put(Node03.getID(), Node03);
        nodeSet.put(Node04.getID(), Node04);
        nodeSet.put(Node05.getID(), Node05);
        nodeSet.put(Node06.getID(), Node06);
        nodeSet.put(Node07.getID(), Node07);
        nodeSet.put(Node08.getID(), Node08);
        nodeSet.put(Node09.getID(), Node09);
        nodeSet.put(Node10.getID(), Node10);

        edgeSet.put(Edge0102.getID(), Edge0102);
        edgeSet.put(Edge0104.getID(), Edge0104);
        edgeSet.put(Edge0203.getID(), Edge0203);
        edgeSet.put(Edge0304.getID(), Edge0304);
        edgeSet.put(Edge0305.getID(), Edge0305);
        edgeSet.put(Edge0309.getID(), Edge0309);
        edgeSet.put(Edge0409.getID(), Edge0409);
        edgeSet.put(Edge0506.getID(), Edge0506);
        edgeSet.put(Edge0508.getID(), Edge0508);
        edgeSet.put(Edge0607.getID(), Edge0607);
        edgeSet.put(Edge0610.getID(), Edge0610);
        edgeSet.put(Edge0708.getID(), Edge0708);
        edgeSet.put(Edge0809.getID(), Edge0809);
        edgeSet.put(Edge0910.getID(), Edge0910);
    }

    @FXML
    public void goButtonPressed() {
        ArrayList<Node> path = startNode.AStar(endNode);
        Node currentNode = null, pastNode = null;
        Circle waypoint;
        Line line;
        for (Node n : path) {
            pastNode = currentNode;
            currentNode = n;
            waypoint = nodeDispSet.get(currentNode.getID());
            waypoint.setFill(Color.rgb(250, 150, 0));
            for (Edge e : currentNode.getEdges()) {
                if (pastNode != null) {
                    if (e.contains(pastNode)) {
                        line = edgeDispSet.get(e.getID());
                        line.setStroke(Color.rgb(250, 150, 0));
                        line.setStrokeWidth(2.0);
                    }
                }
            }
        }
        System.out.println("All done!");
    }
}
