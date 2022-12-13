package com.marvin_elsen.gbo.uebung_01.aufgabe_02;


public class Node
{
    private int data;
    private Node successor;


    public Node(int data)
    {
        this.data = data;
    }


    public int getData()
    {
        return this.data;
    }


    public void setData(int data)
    {
        this.data = data;
    }


    public Node getSuccessor()
    {
        return this.successor;
    }


    public void setSuccessor(Node successor)
    {
        this.successor = successor;
    }


    @Override
    public String toString()
    {
        return Integer.toString(this.data);
    }
}
