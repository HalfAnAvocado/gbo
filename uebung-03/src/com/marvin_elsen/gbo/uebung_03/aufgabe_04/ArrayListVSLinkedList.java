package com.marvin_elsen.gbo.uebung_03.aufgabe_04;


import java.util.ArrayList;
import java.util.LinkedList;


public class ArrayListVSLinkedList
{
    private static long start;

    private static final ArrayList<Integer> arrayList = new ArrayList<>();

    private static final LinkedList<Integer> linkedList = new LinkedList<>();


    private static void startTimer()
    {
        start = System.currentTimeMillis();
    }


    private static long stopTimer()
    {
        return System.currentTimeMillis() - start;
    }


    private static void einfuegenAmAnfangArrayList(long samples)
    {
        startTimer();
        for (int sample = 0; sample < samples; sample++)
        {
            arrayList.add(0, sample);
        }
        System.out.println("ArrayList: " + stopTimer() + "ms");
    }


    private static void einfuegenAmAnfangLinkedList(long samples)
    {
        startTimer();
        for (int sample = 0; sample < samples; sample++)
        {
            linkedList.add(0, sample);
        }
        System.out.println("LinkedList: " + stopTimer() + "ms");
    }


    private static void einfuegenAmEndeArrayList(long samples)
    {
        startTimer();
        for (int sample = 0; sample < samples; sample++)
        {
            arrayList.add(sample);
        }
        System.out.println("ArrayList: " + stopTimer() + "ms");
    }


    private static void einfuegenAmEndeLinkedList(long samples)
    {
        startTimer();
        for (int sample = 0; sample < samples; sample++)
        {
            linkedList.add(sample);
        }
        System.out.println("LinkedList: " + stopTimer() + "ms");
    }


    private static void loeschenAmEndeArrayList(long samples)
    {
        startTimer();
        for (int sample = 0; sample < samples; sample++)
        {
            arrayList.remove(arrayList.size() - 1);
        }
        System.out.println("ArrayList: " + stopTimer() + "ms");
    }


    private static void loeschenAmEndeLinkedList(long samples)
    {
        startTimer();
        for (int sample = 0; sample < samples; sample++)
        {
            linkedList.removeLast();
        }
        System.out.println("LinkedList: " + stopTimer() + "ms");
    }


    private static void loeschenAmAnfangArrayList(long samples)
    {
        startTimer();
        for (int sample = 0; sample < samples; sample++)
        {
            arrayList.remove(0);
        }
        System.out.println("ArrayList: " + stopTimer() + "ms");
    }


    private static void loeschenAmAnfangLinkedList(long samples)
    {
        startTimer();
        for (int sample = 0; sample < samples; sample++)
        {
            linkedList.removeFirst();
        }
        System.out.println("LinkedList: " + stopTimer() + "ms");
    }


    private static void zugriffErsteElementArrayList(long samples)
    {
        startTimer();
        for (int sample = 0; sample < samples; sample++)
        {
            arrayList.get(0);
        }
        System.out.println("ArrayList: " + stopTimer() + "ms");
    }


    private static void zugriffErsteElementLinkedList(long samples)
    {
        startTimer();
        for (int sample = 0; sample < samples; sample++)
        {
            linkedList.getFirst();
        }
        System.out.println("LinkedList: " + stopTimer() + "ms");
    }


    private static void zugriffMittlereElementArrayList(long samples)
    {
        startTimer();
        for (int sample = 0; sample < samples; sample++)
        {
            arrayList.get(arrayList.size() / 2);
        }
        System.out.println("ArrayList: " + stopTimer() + "ms");
    }


    private static void zugriffMittlereElementLinkedList(long samples)
    {
        startTimer();
        for (int sample = 0; sample < samples; sample++)
        {
            linkedList.get(linkedList.size() / 2);
        }
        System.out.println("LinkedList: " + stopTimer() + "ms");
    }


    private static void zugriffLetzeElementArrayList(long samples)
    {
        startTimer();
        for (int sample = 0; sample < samples; sample++)
        {
            arrayList.get(arrayList.size() - 1);
        }
        System.out.println("ArrayList: " + stopTimer() + "ms");
    }


    private static void zugriffLetzteElementLinkedList(long samples)
    {
        startTimer();
        for (int sample = 0; sample < samples; sample++)
        {
            linkedList.getLast();
        }
        System.out.println("LinkedList: " + stopTimer() + "ms");
    }


    public static void main(String[] args)
    {
        long samples = 200_000;
        long samples2 = samples;

        System.out.println("-------Einfügen am Anfang der Liste-------");
        einfuegenAmAnfangArrayList(samples);
        einfuegenAmAnfangLinkedList(samples);

        System.out.println("-------Zugriff auf das erste Element der Liste-------");
        zugriffErsteElementArrayList(samples);
        zugriffErsteElementLinkedList(samples);

        System.out.println("-------Zugriff auf das mittlere Element der Liste-------");
        zugriffMittlereElementArrayList(samples2);
        zugriffMittlereElementLinkedList(samples2);

        System.out.println("-------Zugriff auf das letzte Element der Liste-------");
        zugriffLetzeElementArrayList(samples);
        zugriffLetzteElementLinkedList(samples);

        System.out.println("-------Löschen am Anfang der Liste-------");
        loeschenAmAnfangArrayList(samples / 2);
        loeschenAmAnfangLinkedList(samples / 2);

        System.out.println("-------Löschen am Ende der Liste-------");
        loeschenAmEndeArrayList(samples / 2);
        loeschenAmEndeLinkedList(samples / 2);

        System.out.println("-------Einfügen am Ende der Liste-------");
        einfuegenAmEndeArrayList(samples);
        einfuegenAmEndeLinkedList(samples);
    }
}
