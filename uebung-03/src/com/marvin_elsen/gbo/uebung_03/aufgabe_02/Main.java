package com.marvin_elsen.gbo.uebung_03.aufgabe_02;


import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class Main
{
    public static void main(String[] args)
    {
        SimpleIntegerProperty a = new SimpleIntegerProperty(2);
        SimpleIntegerProperty b = new SimpleIntegerProperty(4);

        NumberBinding squareAddition = a.multiply(a).add(b.multiply(b));

        ChangeListener<Number> changeListener = new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                System.out.println("a²+b²=" + squareAddition.getValue());
            }
        };

        a.addListener(changeListener);
        b.addListener(changeListener);
        // squareAddition.addListener(changeListener); // Geht nicht, da sonst
        // nicht zwischen 5 und -5 unterschieden würde

        a.set(5);
        a.set(-5);

        b.set(5);
        b.set(-5);
        b.set(-5);
    }
}
