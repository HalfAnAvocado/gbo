package com.marvin_elsen.gbo.uebung_02.aufgabe_06;


@FunctionalInterface
public interface ChangeListener
{
    void changed(VerySimpleIntegerProperty property, Integer oldValue, Integer newValue);
}