package com.marvin_elsen.gbo.uebung_02.aufgabe_07;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class Computation
{
    private final ScriptEngine engine;


    public Computation()
    {
        ScriptEngineManager manager = new ScriptEngineManager();
        engine = manager.getEngineByName("JavaScript");
    }


    public Object evaluate(String expression) throws ScriptException
    {
        return engine.eval(expression);
    }
}