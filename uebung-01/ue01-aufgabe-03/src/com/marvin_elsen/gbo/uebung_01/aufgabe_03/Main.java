package com.marvin_elsen.gbo.uebung_01.aufgabe_03;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage)
    {
        try
        {
            GridPane root = FXMLLoader.load(this.getClass().getResource("Main.fxml"));
            Scene scene = new Scene(root, 300, 100);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Hello World");
            primaryStage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
