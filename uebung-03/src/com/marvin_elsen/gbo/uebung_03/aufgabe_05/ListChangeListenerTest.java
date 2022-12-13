package com.marvin_elsen.gbo.uebung_03.aufgabe_05;


import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;


public class ListChangeListenerTest
{
    public static void main(String[] args)
    {
        ObservableList<String> observableList = FXCollections.observableArrayList();

        observableList.addListener(new ListChangeListener<String>()
        {
            @Override
            public void onChanged(ListChangeListener.Change<? extends String> change)
            {
                System.out.println("-------------onChange called-------------");
                while (change.next())
                {
                    if (change.wasPermutated())
                    {
                        System.out.println("-------------wasPermutated()-------------");
                    }
                    else if (change.wasUpdated())
                    {
                        System.out.println("-------------wasUpdated()-------------");
                    }
                    else if (change.wasReplaced())
                    {
                        System.out.println("-------------wasReplaced()-------------");
                    }
                    else if (change.wasRemoved())
                    {
                        System.out.println("-------------wasRemoved()-------------");
                        System.out.println("Removed size: " + change.getRemovedSize());

                        for (String n : change.getRemoved())
                        {
                            System.out.println("getRemoved: " + n);
                        }
                    }
                    else if (change.wasAdded())
                    {
                        System.out.println("-------------wasAdded()-------------");
                        System.out.println("Added size: " + change.getAddedSize());

                        for (String n : change.getAddedSubList())
                        {
                            System.out.println("getAddedSubList: " + n);
                        }
                    }

                    System.out.println("Interval from: " + change.getFrom());
                    System.out.println("Interval to: " + change.getTo());

                    for (String n : change.getList())
                    {
                        System.out.println("getList: " + n);
                    }
                }
            }
        });

        observableList.add("8899");
        observableList.add("1337");
        observableList.addAll("25", "50", "60");

        observableList.remove(3);
        observableList.remove("8899");
        observableList.removeAll("25", "60", "1337");

        observableList.addAll("25", "50", "60");

        System.out.println("-------------sort-------------");
        FXCollections.sort(observableList);

        System.out.println("-------------reverse-------------");
        FXCollections.reverse(observableList);

        // observableList.sort();
        // observableList.reserve();
    }
}
