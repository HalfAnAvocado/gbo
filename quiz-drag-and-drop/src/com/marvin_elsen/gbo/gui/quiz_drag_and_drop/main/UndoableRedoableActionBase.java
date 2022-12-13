package com.marvin_elsen.gbo.gui.quiz_drag_and_drop.main;


import com.marvin_elsen.gbo.gui.quiz_drag_and_drop.model.Model;


public abstract class UndoableRedoableActionBase implements UndoableRedoableAction
{
    protected Model model;


    public UndoableRedoableActionBase(Model model)
    {
        this.model = model;
    }
}