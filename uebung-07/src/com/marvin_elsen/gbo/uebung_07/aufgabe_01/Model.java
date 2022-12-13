package com.marvin_elsen.gbo.uebung_07.aufgabe_01;


import java.util.HashMap;


public class Model
{
    private final int maxtries = 3;
    private HashMap<String, String> userList;
    private HashMap<String, Integer> userLoginTries;


    public Model()
    {
        this.userList = new HashMap<>();
        this.userList.put("hänsel", "password1");
        this.userList.put("gretel", "password2");
        this.userList.put("aschenputtel", "password3");
        this.userList.put("wolf", "password4");
        this.userList.put("7zwerge", "password5");
        this.userList.put("hansimglück", "password6");

        this.userLoginTries = new HashMap<>();
    }


    public boolean isOkay(String loginName, String password)
    {
        return password.equals(this.userList.get(loginName));
    }


    public void incrementLoginTries(String user)
    {
        if (!this.userLoginTries.containsKey(user))
        {
            this.userLoginTries.put(user, 1);
        }
        else
        {
            int oldTries = this.userLoginTries.get(user);
            this.userLoginTries.put(user, ++oldTries);
        }
    }


    public void resetLoginTries(String user)
    {
        this.userLoginTries.put(user, 0);
    }


    public boolean hasMaxLoginTriesBeenReached(String user)
    {
        return this.userLoginTries.get(user) >= this.maxtries;
    }
}