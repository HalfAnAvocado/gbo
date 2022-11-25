package com.marvin_elsen.gbo.gui.controls;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SliderListener extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Slider slider = new Slider();
        slider.setSnapToTicks(true);
        slider.setMajorTickUnit(1.0);
        slider.setMinorTickCount(0);
        slider.setBlockIncrement(1.0);

        Label label = new Label("Slider wurde noch nicht bewegt.");

        VBox root = new VBox(slider, label);
        root.setPadding(new Insets(5));

        slider.valueProperty().addListener((o, oldValue, newValue) -> label.setText("Änderung des Sliders um " + ((double) newValue - (double) oldValue)));

        Scene scene = new Scene(root, 300, 100);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Slider mit Listener");
        primaryStage.show();
    }
}
