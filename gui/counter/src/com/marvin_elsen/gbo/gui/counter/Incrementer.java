package com.marvin_elsen.gbo.gui.counter;


public class Incrementer
{
    private int value;


    public Incrementer(int value)
    {
        super();
        this.value = value;
    }


    public int getValue()
    {
        return value;
    }


    public void increment()
    {
        value++;
    }
}
