package com.marvin_elsen.gbo.uebung_04.aufgabe_02;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
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
        VBox root = new VBox(10);

        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");
        Button button5 = new Button("Button 5");

        button1.setMaxWidth(Double.MAX_VALUE);

        button2.setMaxHeight(Double.MAX_VALUE);
        VBox.setVgrow(button2, Priority.ALWAYS);

        button4.setMaxWidth(Double.MAX_VALUE);
        button4.setMaxHeight(Double.MAX_VALUE);
        VBox.setVgrow(button4, Priority.ALWAYS);

        root.setAlignment(Pos.BOTTOM_RIGHT);
        root.setPadding(new Insets(10));
        root.setFillWidth(true);

        root.getChildren().addAll(button1, button2, button3, button4, button5);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.setTitle("VBox-Beispiel");
        primaryStage.show();
    }
}
