package com.marvin_elsen.gbo.uebung_07.aufgabe_01;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }


    public void start(Stage primaryStage)
    {
        Presenter p = new Presenter();
        View v = new View(p);
        v.initView();
        Model m = new Model();
        p.setView(v);
        p.setModel(m);

        Scene scene = new Scene(v.getUI());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.show();
    }
}
