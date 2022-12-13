package com.marvin_elsen.gbo.uebung_05.aufgabe_01;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application
{
    private int count = 0;


    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Hyperlink hyperLink = new Hyperlink("Dies ist ein ziemlich langer Hyperlink mit ziemlich viel Text");
        Label label = new Label("Hallo Welt zum 0.");

        hyperLink.setOnAction(event ->
        {
            Main.this.count += 1;
            label.setText("Hallo Welt zum " + Main.this.count + ".");
        });

        CheckBox checkBoxVisited = new CheckBox("Hyperlink besucht");
        CheckBox checkBoxUnderline = new CheckBox("Unterstrichen");
        CheckBox checkBoxWrapText = new CheckBox("Zeilenumbruch");

        hyperLink.visitedProperty().bind(checkBoxVisited.selectedProperty());
        hyperLink.underlineProperty().bind(checkBoxUnderline.selectedProperty());
        hyperLink.wrapTextProperty().bind(checkBoxWrapText.selectedProperty());

        VBox root = new VBox(hyperLink, label, checkBoxVisited, checkBoxUnderline, checkBoxWrapText);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Hyperlink");
        primaryStage.show();
    }
}
