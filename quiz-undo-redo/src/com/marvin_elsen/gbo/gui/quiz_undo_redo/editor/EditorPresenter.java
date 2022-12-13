package com.marvin_elsen.gbo.gui.quiz_undo_redo.editor;


import com.marvin_elsen.gbo.gui.quiz_undo_redo.main.MainPresenter;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.main.UndoRedoManager;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.main.UndoableRedoableAction;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.model.Model;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.model.Question;


public class EditorPresenter
{
    private EditorView view;

    private EditDialogPresenter editDialogPresenter;

    private MainPresenter mainPresenter;

    private Model model;

    private final UndoRedoManager undoRedoManager;


    public EditorPresenter()
    {
        this.undoRedoManager = new UndoRedoManager();
    }


    public EditorView getView()
    {
        return this.view;
    }


    public void setView(EditorView view)
    {
        this.view = view;
    }


    public void setMainPresenter(MainPresenter presenter)
    {
        this.mainPresenter = presenter;
    }


    public void setModel(Model model)
    {
        this.model = model;
    }


    public void setEditDialogPresenter(EditDialogPresenter editDialogPresenter)
    {
        this.editDialogPresenter = editDialogPresenter;
    }


    public void showQuestions()
    {
        this.view.showQuestions(this.model.getQuestions());
    }


    public void removeQuestion(int questionIndex)
    {
        UndoableRedoableAction action = new RemoveAction(this.model, questionIndex);
        this.addAction(action);
        action.redo();
    }


    public void editQuestion(int questionIndex)
    {
        Question question = this.model.getQuestionAt(questionIndex);

        this.editDialogPresenter.initView(question);
        this.view.showEdit();
    }


    public void addQuestion()
    {
        this.editDialogPresenter.initView();
        this.view.showEdit();
    }


    public void initEdit()
    {
        this.view.initEdit(this.editDialogPresenter.getView());
    }


    public void undo()
    {
        this.undoRedoManager.undo();

        this.mainPresenter.setUndo(this.undoRedoManager.canUndo());
        this.mainPresenter.setRedo(this.undoRedoManager.canRedo());
    }


    public void addAction(UndoableRedoableAction action)
    {
        this.undoRedoManager.addAction(action);

        this.mainPresenter.setUndo(this.undoRedoManager.canUndo());
        this.mainPresenter.setRedo(this.undoRedoManager.canRedo());
    }


    public void redo()
    {
        this.undoRedoManager.redo();

        this.mainPresenter.setUndo(this.undoRedoManager.canUndo());
        this.mainPresenter.setRedo(this.undoRedoManager.canRedo());
    }
}