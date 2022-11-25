package com.marvin_elsen.gbo.gui.quiz.game;


import com.marvin_elsen.gbo.gui.quiz.model.Model;
import com.marvin_elsen.gbo.gui.quiz.model.Question;


public class QuizPresenter
{
    private QuizView view;

    private Model model;

    // Auswahl der nächsten Frage sollte im Model sein
    private int currentQuestionIndex;


    public QuizPresenter()
    {
        this.currentQuestionIndex = 0;
    }


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
        Question currentQuestion = this.model.getQuestionAt(this.currentQuestionIndex);
        int indexOfCorrectAnswer = currentQuestion.getIndexOfCorrectAnswer();

        // Sollte im Model sein
        if (selectedAnswerIndex == indexOfCorrectAnswer)
        {
            currentQuestion.incrementTimesCorrectlyAnswered();
        }

        currentQuestion.incrementTimesAnswered();
    }


    public void showNextQuestion()
    {
        // Auswahl der nächsten Frage sollte im Model sein
        this.currentQuestionIndex++;

        if (this.currentQuestionIndex < this.model.getQuestionsCount())
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
        // Auswahl der nächsten Frage sollte im Model sein
        Question currentQuestion = this.model.getQuestionAt(this.currentQuestionIndex);
        String questionName = currentQuestion.getQuestion();
        String[] questionAnswers = currentQuestion.getPossibleAnswers();

        this.view.showQuestion(questionName, questionAnswers);
    }


    public void resetQuiz()
    {
        this.currentQuestionIndex = 0;

        this.showCurrentQuestion();
    }
}