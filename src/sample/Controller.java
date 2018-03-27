package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

//import java.awt.*;

public class Controller {
    private boolean firstSelect = true;
    private boolean secondSelect = false;
    private Node startNode;
    private Node endNode;

    @FXML
    private Canvas testCanvas;
    private Button goButton;
    private Label label;

    @FXML
    private Circle node01;

    @FXML
    private Circle node02;

    @FXML
    private Circle node03;

    @FXML
    private Circle node04;

    @FXML
    private Circle node05;

    @FXML
    private Circle node06;

    @FXML
    private Circle node07;

    @FXML
    private Circle node08;

    @FXML
    private Circle node09;

    @FXML
    private Circle node10;

    @FXML
    private Line edge0102;

    @FXML
    private Line edge0104;

    @FXML
    private Line edge0203;

    @FXML
    private Line edge0304;

    @FXML
    private Line edge0305;

    @FXML
    private Line edge00309;

    @FXML
    private Line edge0409;

    @FXML
    private Line edge0506;

    @FXML
    private Line edge0508;

    @FXML
    private Line edge0607;

    @FXML
    private Line edge0610;

    @FXML
    private Line edge0708;

    @FXML
    private Line edge0809;

    @FXML
    private Line edge0910;

    @FXML
    public void setNode01() {
        if (firstSelect) {
            firstSelect = false;
            node01.setFill(Color.rgb(35, 205, 0, .99));
            startNode = new Node(((int) node01.getCenterX()), (int) node01.getCenterY());
        } else if (secondSelect) {
            secondSelect = false;
            node01.setFill(Color.rgb(205, 35, 0, 0.99));
        }
    }

    @FXML
    public void setNode02() {
        if (firstSelect) {
            firstSelect = false;
            node02.setFill(Color.rgb(35, 205, 0, .99));
        } else if (secondSelect) {
            secondSelect = false;
            node02.setFill(Color.rgb(205, 35, 0, 0.99));
        }
    }

    @FXML
    public void setNode03() {
        if (firstSelect) {
            firstSelect = false;
            node03.setFill(Color.rgb(35, 205, 0, .99));
        } else if (secondSelect) {
            secondSelect = false;
            node03.setFill(Color.rgb(205, 35, 0, 0.99));
        }
    }

    @FXML
    public void setNode04() {
        if (firstSelect) {
            firstSelect = false;
            node04.setFill(Color.rgb(35, 205, 0, .99));
        } else if (secondSelect) {
            secondSelect = false;
            node04.setFill(Color.rgb(205, 35, 0, 0.99));
        }
    }

    @FXML
    public void setNode05() {
        if (firstSelect) {
            firstSelect = false;
            node05.setFill(Color.rgb(35, 205, 0, .99));
        } else if (secondSelect) {
            secondSelect = false;
            node05.setFill(Color.rgb(205, 35, 0, 0.99));
        }
    }

    @FXML
    public void setNode06() {
        if (firstSelect) {
            firstSelect = false;
            node06.setFill(Color.rgb(35, 205, 0, .99));
        } else if (secondSelect) {
            secondSelect = false;
            node06.setFill(Color.rgb(205, 35, 0, 0.99));
        }
    }

    @FXML
    public void setNode07() {
        if (firstSelect) {
            firstSelect = false;
            node07.setFill(Color.rgb(35, 205, 0, .99));
        } else if (secondSelect) {
            secondSelect = false;
            node07.setFill(Color.rgb(205, 35, 0, 0.99));
        }
    }

    @FXML
    public void setNode08() {
        if (firstSelect) {
            firstSelect = false;
            node08.setFill(Color.rgb(35, 205, 0, .99));
        } else if (secondSelect) {
            secondSelect = false;
            node08.setFill(Color.rgb(205, 35, 0, 0.99));
        }
    }

    @FXML
    public void setNode09() {
        if (firstSelect) {
            firstSelect = false;
            node09.setFill(Color.rgb(35, 205, 0, .99));
        } else if (secondSelect) {
            secondSelect = false;
            node09.setFill(Color.rgb(205, 35, 0, 0.99));
        }
    }

    @FXML
    public void setNode10() {
        if (firstSelect) {
            firstSelect = false;
            node10.setFill(Color.rgb(35, 205, 0, .99));
        } else if (secondSelect) {
            secondSelect = false;
            node10.setFill(Color.rgb(205, 35, 0, 0.99));
        }
    }

    @FXML
    public void goButtonPressed() {
        firstSelect = true;
    }
}
