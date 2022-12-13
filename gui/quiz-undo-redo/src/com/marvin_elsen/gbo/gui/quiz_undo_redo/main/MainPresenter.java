package com.marvin_elsen.gbo.gui.quiz_undo_redo.main;


import com.marvin_elsen.gbo.gui.quiz_undo_redo.editor.EditorPresenter;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.game.QuizPresenter;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.overview.OverviewPresenter;


public class MainPresenter
{
    private MainView view;

    private OverviewPresenter overviewPresenter;

    private QuizPresenter quizPresenter;

    private EditorPresenter editorPresenter;


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


    public void setEditorPresenter(EditorPresenter editorPresenter)
    {
        this.editorPresenter = editorPresenter;
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


    public void showEditor()
    {
        this.editorPresenter.showQuestions();
        this.view.setContent(this.editorPresenter.getView());
        this.editorPresenter.initEdit();
    }


    public void undo()
    {
        this.editorPresenter.undo();
    }


    public void redo()
    {
        this.editorPresenter.redo();
    }


    public void setUndo(boolean canUndo)
    {
        this.view.setUndo(canUndo);
    }


    public void setRedo(boolean canRedo)
    {
        this.view.setRedo(canRedo);
    }
}