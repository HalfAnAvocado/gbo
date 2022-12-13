package com.marvin_elsen.gbo.uebung_04.aufgabe_05;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.script.ScriptException;


public class CalculatorController
{
    private final Computation computation;
    @FXML
    private TextField display;


    public CalculatorController()
    {
        super();
        this.computation = new Computation();
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
        try
        {
            String expression = this.display.getText();

            Number result = (Number) this.computation.evaluate(expression);
            this.display.appendText("=" + result);
        }
        catch (ScriptException exception)
        {
            this.display.appendText("=>FEHLER");
        }
    }


    @FXML
    private void onClick(ActionEvent event)
    {
        Button buttonClicked = (Button) event.getSource();
        String buttonCaption = buttonClicked.getText();

        this.display.appendText(buttonCaption);
    }
}
