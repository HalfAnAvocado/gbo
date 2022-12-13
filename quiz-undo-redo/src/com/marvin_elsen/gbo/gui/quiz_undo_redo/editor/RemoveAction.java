package com.marvin_elsen.gbo.gui.quiz_undo_redo.editor;


import com.marvin_elsen.gbo.gui.quiz_undo_redo.main.UndoableRedoableActionBase;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.model.Model;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.model.Question;


public class RemoveAction extends UndoableRedoableActionBase
{
    private final Question questionToRemove;

    private final int questionIndex;


    public RemoveAction(Model model, int questionIndex)
    {
        super(model);
        this.questionToRemove = model.getQuestionAt(questionIndex);
        this.questionIndex = questionIndex;
    }


    @Override
    public void undo()
    {
        this.model.addQuestionAt(this.questionToRemove, this.questionIndex);
    }


    @Override
    public void redo()
    {
        this.model.removeQuestion(this.questionToRemove);
    }
}