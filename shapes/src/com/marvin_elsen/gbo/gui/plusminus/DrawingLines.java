package com.marvin_elsen.gbo.gui.plusminus;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class DrawingLines extends Application
{
    private Pane root;

    private ColorPicker colorPicker;

    private Button deleteButton;

    private ChoiceBox<Integer> strokeWidthChoiceBox;

    private double x, y;


    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage)
    {
        this.root = new Pane();
        this.root.setOnMousePressed(e -> this.mousePressed(e.getX(), e.getY()));
        this.root.setOnMouseDragged(e -> this.mouseDragged(e.getX(), e.getY()));

        HBox toolBox = new HBox();

        this.strokeWidthChoiceBox = new ChoiceBox<>();

        for (int i = 5; i < 20; i += 1)
        {
            this.strokeWidthChoiceBox.getItems().add(i);
        }
        this.strokeWidthChoiceBox.getSelectionModel().select(0);

        this.colorPicker = new ColorPicker();

        this.deleteButton = new Button("Löschen");
        this.deleteButton.setOnAction(e -> this.root.getChildren().remove(1, this.root.getChildren().size()));

        toolBox.getChildren().addAll(this.strokeWidthChoiceBox, this.colorPicker, this.deleteButton);
        toolBox.setSpacing(10);
        toolBox.setPadding(new Insets(10));

        this.root.getChildren().add(toolBox);

        primaryStage.setTitle("Freihandzeichnen");
        primaryStage.setScene(new Scene(this.root, 330, 300));
        primaryStage.show();
    }


    private void mousePressed(double newX, double newY)
    {
        this.x = newX;
        this.y = newY;
        this.mouseDragged(this.x, this.y);
    }


    private void mouseDragged(double newX, double newY)
    {
        Line line = new Line(this.x, this.y, newX, newY);
        line.setStroke(this.colorPicker.getValue());
        line.setStrokeWidth(this.strokeWidthChoiceBox.getValue());

        this.root.getChildren().add(line);
        this.x = newX;
        this.y = newY;
    }
}
