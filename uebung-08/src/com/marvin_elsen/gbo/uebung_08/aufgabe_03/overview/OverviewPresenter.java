package com.marvin_elsen.gbo.uebung_08.aufgabe_03.overview;


import com.marvin_elsen.gbo.uebung_08.aufgabe_03.model.Model;


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
        this.model.resetQuestions();

        this.view.updateQuestions();
    }
}
