package com.marvin_elsen.gbo.gui.plusminus;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class PlusMinusController
{
    private int count;

    @FXML
    private Button plus;

    @FXML
    private Button minus;

    @FXML
    private Label counterL;


    @FXML
    private void buttonMinusClick()
    {
        this.count--;
        this.counterL.setText(Integer.toString(this.count));
    }


    @FXML
    private void buttonPlusClick()
    {
        this.count++;
        this.counterL.setText(Integer.toString(this.count));
    }
}