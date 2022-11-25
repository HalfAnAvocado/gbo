package com.marvin_elsen.gbo.uebung_01.aufgabe_01;


import java.util.ArrayList;


public class Actor
{
    private final ArrayList<Role> roles;


    public Actor()
    {
        this.roles = new ArrayList<>();
    }


    public static void main(String[] args)
    {
        Actor actor = new Actor();

        System.out.println("1. Actionaufruf");
        actor.action();

        System.out.println("2. Actionaufruf");
        actor.addRole(new HelloRole());
        actor.action();

        System.out.println("3. Actionaufruf");
        actor.addRole(new ByeRole());
        actor.action();

        System.out.println("4. Actionaufruf");
        actor.addRole(new GeneralRole("Irgendein Text"));
        actor.action();

        System.out.println("5. Actionaufruf");
        actor.clearRoles();
        actor.action();
    }


    public void addRole(Role role)
    {
        this.roles.add(role);
    }


    public void clearRoles()
    {
        this.roles.clear();
    }


    public void action()
    {
        if (!this.roles.isEmpty())
        {
            this.roles.forEach(Role::play);
        }
    }
}
