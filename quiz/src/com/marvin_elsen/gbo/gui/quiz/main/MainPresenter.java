package com.marvin_elsen.gbo.gui.quiz.main;


import com.marvin_elsen.gbo.gui.quiz.game.QuizPresenter;
import com.marvin_elsen.gbo.gui.quiz.overview.OverviewPresenter;


public class MainPresenter
{
    private MainView view;

    private OverviewPresenter overviewPresenter;

    private QuizPresenter quizPresenter;


    public MainView getView()
    {
        return this.view;
    }


    public void setView(MainView view)
    {
        this.view = view;
    }


    public void setOverviewPresenter(OverviewPresenter overviewPresenter)
    {
        this.overviewPresenter = overviewPresenter;
    }


    public void setQuizPresenter(QuizPresenter quizPresenter)
    {
        this.quizPresenter = quizPresenter;
    }


    public void showOverview()
    {
        this.overviewPresenter.showQuestions();
        this.view.setContent(this.overviewPresenter.getView());
    }


    public void showQuiz()
    {
        this.view.setContent(this.quizPresenter.getView());
    }


    public void startQuiz()
    {
        this.quizPresenter.resetQuiz();
        this.showQuiz();
    }
}
