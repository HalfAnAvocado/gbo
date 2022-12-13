package com.marvin_elsen.gbo.uebung_03.aufgabe_03;


import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.SimpleDoubleProperty;


public class Asset2
{
    private static final double FACTOR = 1.1;

    private double accountBalanceEuroPrimitive;

    private double accountBalanceDollarPrimitive;

    private DoubleProperty accountBalanceEuro;

    private ReadOnlyDoubleWrapper accountBalanceDollar;

    private NumberBinding euroToDollar;


    public Asset2(double initialValue)
    {
        this.accountBalanceEuroPrimitive = initialValue;
        this.accountBalanceDollarPrimitive = initialValue * FACTOR;
    }


    public static void main(String[] args)
    {
        Asset2 asset = new Asset2(5);

        System.out.println("Euro: " + asset.getAccountBalanceEuro() + " Dollar: " + asset.getAccountBalanceDollar());

        asset.setAccountBalanceEuro(10);

        System.out.println("Euro: " + asset.getAccountBalanceEuro() + " Dollar: " + asset.getAccountBalanceDollar());

        asset.accountBalanceEuroProperty().set(20);

        System.out.println("Euro: " + asset.getAccountBalanceEuro() + " Dollar: " + asset.getAccountBalanceDollar());
    }


    public double getAccountBalanceEuro()
    {
        if (this.accountBalanceEuro == null)
        {
            return this.accountBalanceEuroPrimitive;
        }
        else
        {
            return this.accountBalanceEuro.get();
        }
    }


    public void setAccountBalanceEuro(double newValue)
    {
        if (this.accountBalanceEuro == null)
        {
            this.accountBalanceEuroPrimitive = newValue;
            this.accountBalanceDollarPrimitive = newValue * FACTOR;
        }
        else
        {
            this.accountBalanceEuro.set(newValue);
        }
    }


    public DoubleProperty accountBalanceEuroProperty()
    {
        if (this.accountBalanceEuro == null)
        {
            this.accountBalanceEuro = new SimpleDoubleProperty(this.accountBalanceEuroPrimitive);
            this.accountBalanceDollar = new ReadOnlyDoubleWrapper(this.accountBalanceDollarPrimitive);

            this.euroToDollar = this.accountBalanceEuro.multiply(FACTOR);
            this.accountBalanceDollar.bind(this.euroToDollar);
        }

        return this.accountBalanceEuro;
    }


    public double getAccountBalanceDollar()
    {
        if (this.accountBalanceDollar == null)
        {
            return this.accountBalanceDollarPrimitive;
        }
        else
        {
            return this.accountBalanceDollar.get();
        }
    }


    public ReadOnlyDoubleProperty accountBalanceDollarProperty()
    {
        if (this.accountBalanceDollar == null)
        {
            this.accountBalanceEuro = new SimpleDoubleProperty(this.accountBalanceEuroPrimitive);
            this.accountBalanceDollar = new ReadOnlyDoubleWrapper(this.accountBalanceDollarPrimitive);

            this.euroToDollar = this.accountBalanceEuro.multiply(FACTOR);
            this.accountBalanceDollar.bind(this.euroToDollar);
        }

        return this.accountBalanceDollar.getReadOnlyProperty();
    }
}
