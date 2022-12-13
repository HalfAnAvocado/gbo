package com.marvin_elsen.gbo.gui.quiz_undo_redo.main;


import com.marvin_elsen.gbo.gui.quiz_undo_redo.model.Model;


public abstract class UndoableRedoableActionBase implements UndoableRedoableAction
{
    protected Model model;


    public UndoableRedoableActionBase(Model model)
    {
        this.model = model;
    }
}