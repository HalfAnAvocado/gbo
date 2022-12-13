package com.marvin_elsen.gbo.gui.plusminus;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class PlusMinus extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        GridPane root = FXMLLoader.load(this.getClass().getResource("PlusMinus.fxml"));

        Scene scene = new Scene(root, 300, 300);

        primaryStage.setScene(scene);
        primaryStage.setTitle("PlusMinus");
        primaryStage.show();
    }
}