package com.marvin_elsen.gbo.gui.quiz_undo_redo.editor;


import com.marvin_elsen.gbo.gui.quiz_undo_redo.main.UndoableRedoableActionBase;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.model.Model;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.model.Question;


public class EditAction extends UndoableRedoableActionBase
{
    private final String oldName;
    private final String newName;

    private final String[] oldPossibleAnswers;
    private final String[] newPossibleAnswers;

    private final int oldCorrectAnswerIndex;
    private final int newCorrectAnswerIndex;

    private final Question question;

    private final EditorView editorView;


    public EditAction(Model model, EditorView view, Question question, String questionName, String[] answers, int correctAnswerIndex)
    {
        super(model);

        this.question = question;

        this.oldName = question.questionProperty().get();
        this.newName = questionName;
        question.questionProperty().set(questionName);

        this.oldPossibleAnswers = question.getPossibleAnswers();
        this.newPossibleAnswers = answers;
        question.setPossibleAnswers(answers);

        this.oldCorrectAnswerIndex = question.getIndexOfCorrectAnswer();
        this.newCorrectAnswerIndex = correctAnswerIndex;
        question.indexOfCorrectAnswerProperty().set(correctAnswerIndex);

        this.editorView = view;
    }


    @Override
    public void undo()
    {
        this.question.questionProperty().set(this.oldName);
        this.question.setPossibleAnswers(this.oldPossibleAnswers);
        this.question.indexOfCorrectAnswerProperty().set(this.oldCorrectAnswerIndex);

        this.editorView.refresh();
    }


    @Override
    public void redo()
    {
        this.question.questionProperty().set(this.newName);
        this.question.setPossibleAnswers(this.newPossibleAnswers);
        this.question.indexOfCorrectAnswerProperty().set(this.newCorrectAnswerIndex);

        this.editorView.refresh();
    }
}