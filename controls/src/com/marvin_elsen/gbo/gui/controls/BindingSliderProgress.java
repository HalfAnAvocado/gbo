package com.marvin_elsen.gbo.gui.controls;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class BindingSliderProgress extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Slider slider = new Slider(-2, 2, 0);
        ProgressBar progressBar = new ProgressBar();
        ProgressIndicator progressIndicator = new ProgressIndicator();

        progressBar.progressProperty().bind(slider.valueProperty());
        progressIndicator.progressProperty().bind(slider.valueProperty());

        VBox root = new VBox(slider, progressBar, progressIndicator);
        root.setPadding(new Insets(5));

        Scene scene = new Scene(root, 300, 100);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Slider mit Listener");
        primaryStage.show();
    }
}