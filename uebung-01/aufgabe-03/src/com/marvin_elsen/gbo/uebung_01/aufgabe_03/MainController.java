package com.marvin_elsen.gbo.uebung_01.aufgabe_03;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class MainController
{
    private int counter;

    @FXML
    private Label label;


    public void buttonClicked(ActionEvent actionEvent)
    {
        this.counter++;
        this.label.setText("Hallo Welt zum " + this.counter + ".");
    }
}