package com.marvin_elsen.gbo.gui.vocab_trainer;


import java.util.HashMap;


public class Model
{
    private final HashMap<String, String> vocableHashMap;


    public Model()
    {
        this.vocableHashMap = new HashMap<>();
        this.vocableHashMap.put("Katze", "cat");
        this.vocableHashMap.put("Tisch", "table");
    }


    public boolean isCorrect(String germanVocable, String englishVocable)
    {
        return englishVocable.equals(this.vocableHashMap.get(germanVocable));
    }


    public String getGermanVocable(int index)
    {
        return (String) this.vocableHashMap.keySet().toArray()[index];
    }


    public int getVocableCount()
    {
        return this.vocableHashMap.size();
    }
}