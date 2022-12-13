package com.marvin_elsen.gbo.uebung_02.aufgabe_07;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.script.ScriptException;


public class Calculator extends Application
{
    private Computation computation;
    @FXML
    private TextField display;


    public Calculator()
    {
        super();
        this.computation = new Computation();
    }


    public static void main(String[] args)
    {
        Application.launch(args);
    }


    @FXML
    private void onClearClick()
    {
        this.display.clear();
    }


    @FXML
    private void onDeleteClick()
    {
        String currentText = this.display.getText();

        if (!currentText.isEmpty())
        {
            int currentLength = currentText.length();

            String newText = currentText.substring(0, currentLength - 1);

            this.display.setText(newText);
        }
    }


    @FXML
    private void onEqualClick()
    {
        String expression = this.display.getText();

        try
        {
            Number result = (Number) this.computation.evaluate(expression);
            this.display.setText(expression + "=" + result);
        }
        catch (ScriptException exception)
        {
            this.display.setText(expression + "=>FEHLER");
        }
    }


    @FXML
    private void onClick(ActionEvent event)
    {
        Button buttonClicked = (Button) event.getSource();
        String buttonCaption = buttonClicked.getText();

        String currentText = this.display.getText();

        this.display.setText(currentText + buttonCaption);
    }


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.computation = new Computation();
        Pane root = FXMLLoader.load(this.getClass().getResource("com/marvin_elsen/gbo/uebung_02/aufgabe_07/Calculator.fxml"));

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Taschenrechner");
        primaryStage.show();
    }
}
