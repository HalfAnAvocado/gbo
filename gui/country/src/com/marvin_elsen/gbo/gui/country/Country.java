package com.marvin_elsen.gbo.gui.country;


public class Country
{
    private final String name;

    private final String capital;

    private final long people;

    private final long area;


    public Country(String name, String capital, long people, long area)
    {
        this.name = name;
        this.capital = capital;
        this.people = people;
        this.area = area;
    }


    public String getName()
    {
        return this.name;
    }


    public String getCapital()
    {
        return this.capital;
    }


    public long getPeople()
    {
        return this.people;
    }


    public long getArea()
    {
        return this.area;
    }


    public long getDensity()
    {
        return Math.round((double) this.getPeople() / this.getArea());
    }


    @Override
    public String toString()
    {
        return this.getName();
    }
}