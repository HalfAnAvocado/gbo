package com.marvin_elsen.gbo.gui.plusminus;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.stage.Stage;


public class Bezier extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage)
    {
        Pane root = new Pane();
        this.drawBezier(root);

        primaryStage.setTitle("Bezier-Kurve");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }


    public void doPointMovement(MouseEvent event)
    {
        Circle point = (Circle) event.getSource();

        point.setCenterX(event.getX());
        point.setCenterY(event.getY());
    }


    private void drawBezier(Pane root)
    {
        Circle startPoint = new Circle(50, 50, 5, Color.RED);
        Circle endPoint = new Circle(300, 50, 5, Color.RED);
        Circle controlPoint1 = new Circle(100, 200, 5, Color.RED);
        Circle controlPoint2 = new Circle(250, 200, 5, Color.RED);

        startPoint.setOnMouseDragged(e -> this.doPointMovement(e));
        endPoint.setOnMouseDragged(e -> this.doPointMovement(e));
        controlPoint1.setOnMouseDragged(e -> this.doPointMovement(e));
        controlPoint2.setOnMouseDragged(e -> this.doPointMovement(e));

        CubicCurve bezier = new CubicCurve(startPoint.getCenterX(), startPoint.getCenterY(), controlPoint1.getCenterX(), controlPoint1.getCenterY(), controlPoint2.getCenterX(), controlPoint2.getCenterY(), endPoint.getCenterX(), endPoint.getCenterY());
        bezier.setStroke(Color.BLACK);
        bezier.setFill(null);
        bezier.setStrokeWidth(3);

        bezier.controlX1Property().bind(controlPoint1.centerXProperty());
        bezier.controlY1Property().bind(controlPoint1.centerYProperty());
        bezier.controlX2Property().bind(controlPoint2.centerXProperty());
        bezier.controlY2Property().bind(controlPoint2.centerYProperty());
        bezier.startXProperty().bind(startPoint.centerXProperty());
        bezier.startYProperty().bind(startPoint.centerYProperty());
        bezier.endXProperty().bind(endPoint.centerXProperty());
        bezier.endYProperty().bind(endPoint.centerYProperty());

        root.getChildren().add(bezier);

        root.getChildren().add(startPoint);
        root.getChildren().add(controlPoint1);
        root.getChildren().add(controlPoint2);
        root.getChildren().add(endPoint);
    }
}
