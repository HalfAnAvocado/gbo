package com.marvin_elsen.gbo.gui.pizza;


public class Configuration
{
    private final String[] sizeNames;

    private final int[] sizePrices; // In cent. sizePrices[i] ist Preis von
    // sizeNames[i]

    private final String[] toppingNames;

    private final int[] toppingPrices; // In cent. toppingPrices[i] ist Preis von
    // toppingNames[i]

    private final int numberOfDefaultToppings;


    public Configuration(String[] sizeNames, int[] sizePrices, String[] toppingNames, int[] toppingPrices, int numberOfDefaultToppings)
    {
        super();

        if ((sizeNames.length != sizePrices.length) || (toppingNames.length != toppingPrices.length) || (numberOfDefaultToppings > toppingNames.length))
        {
            throw new IllegalArgumentException();
        }

        this.sizeNames = sizeNames;
        this.sizePrices = sizePrices;
        this.toppingNames = toppingNames;
        this.toppingPrices = toppingPrices;
        this.numberOfDefaultToppings = numberOfDefaultToppings;
    }


    public String[] getSizeNames()
    {
        return this.sizeNames;
    }


    public int[] getSizePrices()
    {
        return this.sizePrices;
    }


    public String[] getToppingNames()
    {
        return this.toppingNames;
    }


    public int[] getToppingPrices()
    {
        return this.toppingPrices;
    }


    public int getNumberOfDefaultToppings()
    {
        return this.numberOfDefaultToppings;
    }
}
