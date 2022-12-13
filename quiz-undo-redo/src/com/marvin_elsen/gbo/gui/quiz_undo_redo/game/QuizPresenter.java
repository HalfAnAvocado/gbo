package com.marvin_elsen.gbo.gui.quiz_undo_redo.game;


import com.marvin_elsen.gbo.gui.quiz_undo_redo.model.Model;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.model.Question;


public class QuizPresenter
{
    private QuizView view;

    private Model model;


    public QuizView getView()
    {
        return this.view;
    }


    public void setView(QuizView view)
    {
        this.view = view;
    }


    public void setModel(Model model)
    {
        this.model = model;
    }


    public void evaluateCurrentQuestion(int selectedAnswerIndex)
    {
        this.model.evaluateCurrentQuestion(selectedAnswerIndex);
    }


    public void showNextQuestion()
    {
        if (this.model.hasNextQuestion())
        {
            this.showCurrentQuestion();
        }
        else
        {
            this.view.showEndScreen();
        }
    }


    public void showCurrentQuestion()
    {
        Question currentQuestion = this.model.getCurrentQuestion();
        String questionName = currentQuestion.getQuestion();
        String[] questionAnswers = currentQuestion.getPossibleAnswers();

        this.view.showQuestion(questionName, questionAnswers);
    }


    public void resetQuiz()
    {
        this.model.resetCurrentQuestion();

        this.showCurrentQuestion();
    }
}