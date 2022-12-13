package com.marvin_elsen.gbo.uebung_08.aufgabe_03.editor;


import com.marvin_elsen.gbo.uebung_08.aufgabe_03.model.Model;
import com.marvin_elsen.gbo.uebung_08.aufgabe_03.model.Question;


public class EditorPresenter
{
    private EditorView view;

    private EditDialogPresenter editDialogPresenter;

    private Model model;


    public EditorView getView()
    {
        return this.view;
    }


    public void setView(EditorView view)
    {
        this.view = view;
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
        this.model.removeQuestion(questionIndex);
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
}