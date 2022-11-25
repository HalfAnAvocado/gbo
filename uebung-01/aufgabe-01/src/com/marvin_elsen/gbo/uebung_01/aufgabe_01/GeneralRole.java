package com.marvin_elsen.gbo.uebung_01.aufgabe_01;


public class GeneralRole implements Role
{
    private final String message;


    public GeneralRole(String message)
    {
        super();
        this.message = message;
    }


    @Override
    public void play()
    {
        System.out.println(this.message);
    }
}
