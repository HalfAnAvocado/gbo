package com.marvin_elsen.gbo.gui.quiz.overview;


import com.marvin_elsen.gbo.gui.quiz.model.Model;
import com.marvin_elsen.gbo.gui.quiz.model.Question;


public class OverviewPresenter
{
    private OverviewView view;

    private Model model;


    public OverviewView getView()
    {
        return this.view;
    }


    public void setView(OverviewView view)
    {
        this.view = view;
    }


    public void setModel(Model model)
    {
        this.model = model;
    }


    public void showQuestions()
    {
        this.view.showQuestions(this.model.getQuestions());
        this.view.updateQuestions();
    }


    public void deleteHistory()
    {
        // Sollte im Model sein
        for (Question question : this.model.getQuestions())
        {
            question.setTimesAnswered(0);
            question.setTimesCorrectlyAnswered(0);
        }

        this.view.updateQuestions();
    }
}
