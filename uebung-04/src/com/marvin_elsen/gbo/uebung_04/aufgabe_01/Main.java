package com.marvin_elsen.gbo.uebung_04.aufgabe_01;


import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application
{

    private ArrayList<Button> buttons;


    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Pane root = new Pane();
        this.buttons = new ArrayList<Button>();

        for (int i = 1; i <= 10; i++)
        {
            Button b = new Button("Button " + i);

            this.buttons.add(b);

            root.getChildren().add(b);
        }

        Scene scene = new Scene(root, 300, 300);

        Button lastButton = this.buttons.get(this.buttons.size() - 1);
        Button firstButton = this.buttons.get(0);

        DoubleProperty firstButtonX = firstButton.layoutXProperty();
        DoubleProperty lastButtonX = lastButton.layoutXProperty();

        DoubleProperty firstButtonY = firstButton.layoutYProperty();
        DoubleProperty lastButtonY = lastButton.layoutYProperty();

        int buttonCount = this.buttons.size();
        for (int i = 1; i < buttonCount - 1; i++) // Iteriere durch alle Buttons
        // zwischen Start- und
        // Endbutton
        {
            double fraction = (double) i / (buttonCount - 1); // i = 1 => 1/9
            // (Startbutton
            // ist
            // 0/9); i = 8 =>
            // 8/9
            // (Endbutton ist
            // 9/9)

            // x = (x1 + fraction*(x2-x1))
            DoubleBinding bindingX = firstButtonX.add(lastButtonX.subtract(firstButtonX).multiply(fraction));
            // y = (y1 + fraction*(y2-y1))
            DoubleBinding bindingY = firstButtonY.add(lastButtonY.subtract(firstButtonY).multiply(fraction));

            this.buttons.get(i).layoutXProperty().bind(bindingX);
            this.buttons.get(i).layoutYProperty().bind(bindingY);
        }

        root.widthProperty().addListener(cl -> lastButton.setLayoutX(root.getWidth() - lastButton.getWidth()));
        root.heightProperty().addListener(cl -> lastButton.setLayoutY(root.getHeight() - lastButton.getHeight()));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Pane-Beispiel");
        primaryStage.show();
    }
}
