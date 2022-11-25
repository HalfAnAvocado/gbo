package com.marvin_elsen.gbo.uebung_01.aufgabe_02;


public class List
{
    private Node head;
    private Node tail;


    public static void main(String[] args)
    {
        List list = new List();

        list.add(1);
        list.add(2);
        list.add(3);

        list.forEach(System.out::println);

        System.out.println();

        list.forEach(node -> System.out.println(node.getData() * 2));
    }


    public void add(int data)
    {
        Node node = new Node(data);

        if (this.tail != null)
        {
            this.tail.setSuccessor(node);
            this.tail = node;
        }
        else
        {
            this.head = node;
            this.tail = node;
        }
    }


    public void forEach(ForEachStrategy strategy)
    {
        Node currentNode = this.head;

        while (currentNode != null)
        {
            strategy.execute(currentNode);
            currentNode = currentNode.getSuccessor();
        }
    }
}
