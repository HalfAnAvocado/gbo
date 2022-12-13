package com.marvin_elsen.gbo.gui.counter;


public class Decrementer
{
    private int value;


    public Decrementer(int value)
    {
        super();
        this.value = value;
    }


    public int getValue()
    {
        return this.value;
    }


    public void decrement()
    {
        this.value--;
    }
}
