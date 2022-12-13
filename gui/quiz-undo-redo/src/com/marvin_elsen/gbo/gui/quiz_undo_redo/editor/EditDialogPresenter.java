package com.marvin_elsen.gbo.gui.quiz_undo_redo.editor;


import com.marvin_elsen.gbo.gui.quiz_undo_redo.main.UndoableRedoableAction;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.model.Model;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.model.Question;


public class EditDialogPresenter
{
    private EditDialogView view;

    private Question questionBeingEdited;

    private EditorPresenter editorPresenter;

    private Model model;


    public EditDialogView getView()
    {
        return this.view;
    }


    public void setView(EditDialogView view)
    {
        this.view = view;
    }


    public void setEditorPresenter(EditorPresenter presenter)
    {
        this.editorPresenter = presenter;
    }


    public void setModel(Model model)
    {
        this.model = model;
    }


    public void initView(Question question)
    {
        this.questionBeingEdited = question;
        this.view.init(question);
    }


    public void initView()
    {
        this.questionBeingEdited = null;
        this.view.init();
    }


    public void editQuestion(String questionName, String[] answers, int correctAnswerIndex)
    {
        if (this.questionBeingEdited != null)
        {
            UndoableRedoableAction action = new EditAction(this.model, this.editorPresenter.getView(), this.questionBeingEdited, questionName, answers, correctAnswerIndex);
            this.editorPresenter.addAction(action);
            action.redo();
        }
        else
        {
            UndoableRedoableAction action = new AddAction(this.model, new Question(questionName, answers, correctAnswerIndex));
            this.editorPresenter.addAction(action);
            action.redo();
        }

        this.view.close();
    }
}