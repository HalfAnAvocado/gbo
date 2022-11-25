package com.marvin_elsen.gbo.gui.controls;


import javafx.application.Application;
import javafx.beans.binding.NumberBinding;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class BindingSliderSlider extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Slider slider1 = new Slider(0, 100, 0);
        Slider slider2 = new Slider(0, 100, 0);
        Slider slider3 = new Slider(0, 100, 0);
        Slider slider4 = new Slider(0, 300, 0);

        NumberBinding binding = slider1.valueProperty().add(slider2.valueProperty()).add(slider3.valueProperty());

        slider4.valueProperty().bind(binding);

        VBox root = new VBox(slider1, slider2, slider3, slider4);
        root.setPadding(new Insets(5));

        Scene scene = new Scene(root, 300, 100);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Slider mit Listener");
        primaryStage.show();
    }
}
