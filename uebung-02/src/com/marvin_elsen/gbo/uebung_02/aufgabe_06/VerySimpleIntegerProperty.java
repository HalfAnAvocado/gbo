package com.marvin_elsen.gbo.uebung_02.aufgabe_06;


import java.util.ArrayList;


public class VerySimpleIntegerProperty
{
    private Integer value;

    private final ArrayList<ChangeListener> listeners;


    public VerySimpleIntegerProperty(int initValue)
    {
        super();
        this.value = initValue;
        this.listeners = new ArrayList<>();
    }


    public VerySimpleIntegerProperty()
    {
        this(0);
    }


    public static void main(String[] args)
    {
        VerySimpleIntegerProperty property = new VerySimpleIntegerProperty();

        property.addListener((p, newValue, oldValue) -> System.out.println("oldValue: " + oldValue + " newValue: " + newValue));
        property.set(5);
        property.addListener((p, newValue, oldValue) -> System.out.println("oldValue + newValue = " + (newValue + oldValue)));
        property.set(5);
        property.set(6);
        System.out.println(property.get());
    }


    public void set(Integer newValue)
    {
        if (this.value.intValue() != newValue.intValue())
        {
            Integer oldValue = this.value;
            this.value = newValue;
            this.listeners.forEach(cl -> cl.changed(this, oldValue, this.value));
        }
    }


    public Integer get()
    {
        return this.value;
    }


    public void addListener(ChangeListener listener)
    {
        this.listeners.add(listener);
    }


    public void removeListener(ChangeListener listener)
    {
        this.listeners.remove(listener);
    }
}