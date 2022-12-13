package com.marvin_elsen.gbo.gui.quiz_undo_redo.editor;


import com.marvin_elsen.gbo.gui.quiz_undo_redo.main.UndoableRedoableActionBase;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.model.Model;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.model.Question;


public class AddAction extends UndoableRedoableActionBase
{
    private final Question questionToAdd;


    public AddAction(Model model, Question question)
    {
        super(model);
        this.questionToAdd = question;
    }


    @Override
    public void undo()
    {
        this.model.removeQuestion(this.questionToAdd);
    }


    @Override
    public void redo()
    {
        this.model.addQuestion(this.questionToAdd);
    }
}