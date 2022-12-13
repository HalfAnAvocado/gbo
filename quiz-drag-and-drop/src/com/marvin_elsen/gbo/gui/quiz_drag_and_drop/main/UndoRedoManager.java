package com.marvin_elsen.gbo.gui.quiz_drag_and_drop.main;


import java.util.ArrayList;
import java.util.List;


public class UndoRedoManager
{
    private final List<UndoableRedoableAction> actions = new ArrayList<>();

    private int currentPosition = 0;


    public void addAction(UndoableRedoableAction action)
    {
        for (int i = this.actions.size() - 1; i >= this.currentPosition; i--)
        {
            this.actions.remove(i);
        }

        this.actions.add(action);
        this.currentPosition++;
    }


    public void undo()
    {
        if (this.currentPosition > 0)
        {
            this.currentPosition--;
            this.actions.get(this.currentPosition).undo();
        }
    }


    public void redo()
    {
        if (this.currentPosition < this.actions.size())
        {
            this.actions.get(this.currentPosition).redo();
            this.currentPosition++;
        }
    }


    public boolean canUndo()
    {
        return this.actions.size() > 0 && this.currentPosition > 0;
    }


    public boolean canRedo()
    {
        return this.actions.size() > 0 && this.currentPosition < this.actions.size();
    }
}