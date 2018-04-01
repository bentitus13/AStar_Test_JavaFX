package sample;

import AStar.Edge;
import AStar.Node;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application {
    Controller controller = new Controller();

    @Override
    public void start(Stage primaryStage) throws Exception{
        controller.setEdgeLists();
        controller.setHashSets();

        Group group = new Group();

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        group.getChildren().addAll(root);

        // Add edges to UI
        controller.drawEdges();
        HashMap<String, Line> lineList = controller.edgeDispSet;
        for (Line line : lineList.values()) {
            group.getChildren().add(line);
        }

        // Add nodes to UI
        controller.drawNodes();
        HashMap<String, Circle> circleList = controller.nodeDispSet;
        for (Circle c : circleList.values()) {
            group.getChildren().add(c);
        }

        primaryStage.setTitle("Pathfinding Test");
        primaryStage.setScene(new Scene(group, 600, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
