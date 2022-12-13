package com.marvin_elsen.gbo.uebung_03.aufgabe_01;


import javafx.beans.property.SimpleIntegerProperty;


public class Main
{
    private static void aufgabeA() // Geht
    {
        System.out.println("\nAufgabe a)");

        SimpleIntegerProperty property1 = new SimpleIntegerProperty(1);
        SimpleIntegerProperty property2 = new SimpleIntegerProperty(2);
        SimpleIntegerProperty property3 = new SimpleIntegerProperty(3);
        SimpleIntegerProperty property4 = new SimpleIntegerProperty(4);

        property1.bind(property2);
        property2.bind(property3);
        property3.bind(property4);

        System.out.println("Property1: " + property1);
        System.out.println("Property2: " + property2);
        System.out.println("Property3: " + property3);
        System.out.println("Property4: " + property4 + "\n");

        // property1.set(11);
        // property2.set(22);
        // property3.set(33);
        property4.set(44);

        System.out.println("Property1: " + property1.get());
        System.out.println("Property2: " + property2.get());
        System.out.println("Property3: " + property3.get());
        System.out.println("Property4: " + property4.get());
    }


    public static void aufgabeB() // Geht nichts
    {
        System.out.println("\nAufgabe b)");

        SimpleIntegerProperty property1 = new SimpleIntegerProperty(1);
        SimpleIntegerProperty property2 = new SimpleIntegerProperty(2);
        SimpleIntegerProperty property3 = new SimpleIntegerProperty(3);

        property1.bind(property2);
        System.out.println("Property1: " + property1.get());
        property2.bind(property3); // Binding wird überschrieben
        System.out.println("Property1: " + property1.get());
    }


    public static void aufgabeC() // Geht
    {
        System.out.println("\nAufgabe c)");

        SimpleIntegerProperty property1 = new SimpleIntegerProperty(1);
        SimpleIntegerProperty property2 = new SimpleIntegerProperty(2);
        SimpleIntegerProperty property3 = new SimpleIntegerProperty(3);

        property1.bind(property3);
        property2.bind(property3);

        property3.set(33);
        System.out.println("Property1: " + property1.get());
        System.out.println("Property2: " + property2.get());
    }


    public static void aufgabeD()
    {
        System.out.println("\nAufgabe d)");

        SimpleIntegerProperty property1 = new SimpleIntegerProperty(1);
        SimpleIntegerProperty property2 = new SimpleIntegerProperty(2);
        SimpleIntegerProperty property3 = new SimpleIntegerProperty(3);
        SimpleIntegerProperty property4 = new SimpleIntegerProperty(4);

        // property1.bind(property2);
        // property2.bind(property3);
        // property3.bind(property4);
        // property4.bind(property1); // Stackoverflow böse
    }


    private static void aufgabeE() // Geht
    {
        System.out.println("\nAufgabe e)");

        SimpleIntegerProperty property1 = new SimpleIntegerProperty(1);
        SimpleIntegerProperty property2 = new SimpleIntegerProperty(2);
        SimpleIntegerProperty property3 = new SimpleIntegerProperty(3);
        SimpleIntegerProperty property4 = new SimpleIntegerProperty(4);

        property1.bindBidirectional(property2);
        property2.bindBidirectional(property3);
        property3.bindBidirectional(property4);

        System.out.println("Property1: " + property1);
        System.out.println("Property2: " + property2);
        System.out.println("Property3: " + property3);
        System.out.println("Property4: " + property4 + "\n");

        property1.set(11);

        System.out.println("Property1: " + property1.get());
        System.out.println("Property2: " + property2.get());
        System.out.println("Property3: " + property3.get());
        System.out.println("Property4: " + property4.get() + "\n");

        property2.set(22);

        System.out.println("Property1: " + property1.get());
        System.out.println("Property2: " + property2.get());
        System.out.println("Property3: " + property3.get());
        System.out.println("Property4: " + property4.get() + "\n");

        property3.set(33);

        System.out.println("Property1: " + property1.get());
        System.out.println("Property2: " + property2.get());
        System.out.println("Property3: " + property3.get());
        System.out.println("Property4: " + property4.get() + "\n");

        property4.set(44);

        System.out.println("Property1: " + property1.get());
        System.out.println("Property2: " + property2.get());
        System.out.println("Property3: " + property3.get());
        System.out.println("Property4: " + property4.get() + "\n");
    }


    public static void aufgabeF()
    {
        System.out.println("\nAufgabe f)");

        SimpleIntegerProperty property1 = new SimpleIntegerProperty(1);
        SimpleIntegerProperty property2 = new SimpleIntegerProperty(2);
        SimpleIntegerProperty property3 = new SimpleIntegerProperty(3);
        SimpleIntegerProperty property4 = new SimpleIntegerProperty(4);

        property1.bindBidirectional(property2);
        property2.bindBidirectional(property3);
        property3.bindBidirectional(property4);
        property4.bindBidirectional(property1);

        property1.set(11);

        System.out.println("Property1: " + property1.get());
        System.out.println("Property2: " + property2.get());
        System.out.println("Property3: " + property3.get());
        System.out.println("Property4: " + property4.get() + "\n");

        property4.set(44);

        System.out.println("Property1: " + property1.get());
        System.out.println("Property2: " + property2.get());
        System.out.println("Property3: " + property3.get());
        System.out.println("Property4: " + property4.get() + "\n");
    }


    public static void main(String[] args)
    {
        aufgabeA();
        aufgabeB();
        aufgabeC();
        aufgabeD();
        aufgabeE();
        aufgabeF();
    }
}
