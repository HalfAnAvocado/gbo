package com.marvin_elsen.gbo.gui.quiz_editable.editor;


import com.marvin_elsen.gbo.gui.quiz_editable.model.Model;
import com.marvin_elsen.gbo.gui.quiz_editable.model.Question;


public class EditDialogPresenter
{
    private EditDialogView view;

    private Question questionBeingEdited;

    private Model model;


    public EditDialogView getView()
    {
        return this.view;
    }


    public void setView(EditDialogView view)
    {
        this.view = view;
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
            this.questionBeingEdited.questionProperty().set(questionName);
            this.questionBeingEdited.setPossibleAnswers(answers);
            this.questionBeingEdited.indexOfCorrectAnswerProperty().set(correctAnswerIndex);
        }
        else
        {
            this.model.addQuestion(new Question(questionName, answers, correctAnswerIndex));
        }

        this.view.close();
    }
}
