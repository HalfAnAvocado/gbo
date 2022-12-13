package com.marvin_elsen.gbo.uebung_03.aufgabe_03;


import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.SimpleDoubleProperty;


public class Asset1
{
    private static final double FACTOR = 1.1;

    private final DoubleProperty accountBalanceEuro;

    private final ReadOnlyDoubleWrapper accountBalanceDollar;

    private final NumberBinding euroToDollar;


    public Asset1(double initialValue)
    {
        this.accountBalanceEuro = new SimpleDoubleProperty(initialValue);
        this.accountBalanceDollar = new ReadOnlyDoubleWrapper(initialValue * FACTOR);

        this.euroToDollar = this.accountBalanceEuro.multiply(FACTOR);
        this.accountBalanceDollar.bind(this.euroToDollar);
    }


    public static void main(String[] args)
    {
        Asset1 asset = new Asset1(5);

        System.out.println("Euro: " + asset.getAccountBalanceEuro() + " Dollar: " + asset.getAccountBalanceDollar());

        asset.setAccountBalanceEuro(10);

        System.out.println("Euro: " + asset.getAccountBalanceEuro() + " Dollar: " + asset.getAccountBalanceDollar());

        asset.accountBalanceEuroProperty().set(20);

        System.out.println("Euro: " + asset.getAccountBalanceEuro() + " Dollar: " + asset.getAccountBalanceDollar());
    }


    public double getAccountBalanceEuro()
    {
        return this.accountBalanceEuro.get();
    }


    public void setAccountBalanceEuro(double newValue)
    {
        this.accountBalanceEuro.set(newValue);
    }


    public DoubleProperty accountBalanceEuroProperty()
    {
        return this.accountBalanceEuro;
    }


    public double getAccountBalanceDollar()
    {
        return this.accountBalanceDollar.get();
    }


    public ReadOnlyDoubleProperty accountBalanceDollarProperty()
    {
        return this.accountBalanceDollar.getReadOnlyProperty();
    }
}
