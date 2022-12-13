package com.marvin_elsen.gbo.gui.quiz_editable.model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Model
{
    private final ObservableList<Question> questions;

    private int currentQuestionIndex;


    public Model()
    {
        this.questions = FXCollections.observableArrayList();
    }


    public void addQuestion(Question question)
    {
        this.questions.add(question);
    }


    public ObservableList<Question> getQuestions()
    {
        return this.questions;
    }


    public Question getQuestionAt(int index)
    {
        return this.questions.get(index);
    }


    public int getQuestionsCount()
    {
        return this.questions.size();
    }


    public void evaluateCurrentQuestion(int selectedAnswerIndex)
    {
        Question currentQuestion = this.getQuestionAt(this.currentQuestionIndex);
        int indexOfCorrectAnswer = currentQuestion.getIndexOfCorrectAnswer();

        if (selectedAnswerIndex == indexOfCorrectAnswer)
        {
            currentQuestion.incrementTimesCorrectlyAnswered();
        }

        currentQuestion.incrementTimesAnswered();
    }


    public boolean hasNextQuestion()
    {
        this.currentQuestionIndex++;
        return this.currentQuestionIndex < this.getQuestionsCount();
    }


    public Question getCurrentQuestion()
    {
        return this.getQuestionAt(this.currentQuestionIndex);
    }


    public void resetCurrentQuestion()
    {
        this.currentQuestionIndex = 0;
    }


    public void resetQuestions()
    {
        for (Question question : this.getQuestions())
        {
            question.setTimesAnswered(0);
            question.setTimesCorrectlyAnswered(0);
        }
    }


    public void removeQuestion(int questionIndex)
    {
        this.questions.remove(questionIndex);
    }
}
