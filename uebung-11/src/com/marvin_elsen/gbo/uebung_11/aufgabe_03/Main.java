package com.marvin_elsen.gbo.uebung_11.aufgabe_03;


import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;


public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);

        this.drawPolygon(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Gefülltes Polygon");
        primaryStage.show();
    }


    private void drawPolygon(Pane pane)
    {
        final int pointCount = 20;

        Polygon polygon = new Polygon();
        polygon.setFill(Color.LIGHTBLUE);
        polygon.setStroke(Color.BLACK);
        polygon.setStrokeWidth(3);

        pane.getChildren().add(polygon);

        for (int y = 0; y < 2; y++)
        {
            for (int x = 0; x < pointCount / 2; x++)
            {
                double xPos = 0;
                double yPos = y * 100 + 50;

                if (y == 0)
                {
                    xPos = x * 100 + 50;
                }
                else
                {
                    xPos = (pointCount / 2 - 1) * 100 + 50 - x * 100;
                }

                polygon.getPoints().add(xPos);
                polygon.getPoints().add(yPos);
            }
        }

        this.drawAnchors(polygon, pane);
    }


    public void drawAnchors(Polygon polygon, Pane pane)
    {
        ObservableList<Double> points = polygon.getPoints();

        for (int i = 0; i < polygon.getPoints().size() - 1; i += 2)
        {
            final int indexX = i;

            SimpleDoubleProperty polyPointXProperty = new SimpleDoubleProperty(points.get(i));
            SimpleDoubleProperty polyPointYProperty = new SimpleDoubleProperty(points.get(i + 1));

            polyPointXProperty.addListener((o, ov, nv) -> points.set(indexX, (Double) nv));
            polyPointYProperty.addListener((o, ov, nv) -> points.set(indexX + 1, (Double) nv));

            Anchor anchor = new Anchor(polyPointXProperty, polyPointYProperty);
            pane.getChildren().add(anchor);
        }
    }
}