package com.marvin_elsen.gbo.uebung_04.aufgabe_03;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
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
        Button buttonCenter = new Button("Center");
        Button buttonTop = new Button("Top");
        Button buttonRight = new Button("Right");
        Button buttonBottom = new Button("Bottom");
        Button buttonLeft = new Button("Left");

        BorderPane root = new BorderPane(buttonCenter, buttonTop, buttonRight, buttonBottom, buttonLeft);
        root.setPadding(new Insets(10));

        buttonTop.setMaxWidth(Double.MAX_VALUE);
        buttonBottom.setMaxWidth(Double.MAX_VALUE);

        buttonLeft.setMaxHeight(Double.MAX_VALUE);
        buttonRight.setMaxHeight(Double.MAX_VALUE);

        buttonCenter.setMaxWidth(Double.MAX_VALUE);
        buttonCenter.setMaxHeight(Double.MAX_VALUE);

        Scene scene = new Scene(root, 300, 300);

        primaryStage.setScene(scene);
        primaryStage.setTitle("BorderPane-Beispiel");
        primaryStage.show();
    }
}
