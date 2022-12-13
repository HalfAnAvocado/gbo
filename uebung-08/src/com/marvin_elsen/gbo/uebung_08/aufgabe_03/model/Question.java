package com.marvin_elsen.gbo.uebung_08.aufgabe_03.model;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Question
{
    private final SimpleStringProperty question;
    private final SimpleIntegerProperty indexOfCorrectAnswer;
    private final SimpleIntegerProperty timesAnswered;
    private final SimpleIntegerProperty timesCorrectlyAnswered;
    private String[] possibleAnswers;


    public Question(String question, String[] possibleAnswers, int indexOfCorrectAnswer)
    {
        if (indexOfCorrectAnswer < 0 || indexOfCorrectAnswer >= possibleAnswers.length)
        {
            throw new IllegalArgumentException();
        }

        this.question = new SimpleStringProperty(question);
        this.possibleAnswers = possibleAnswers;

        this.indexOfCorrectAnswer = new SimpleIntegerProperty(indexOfCorrectAnswer);

        this.timesAnswered = new SimpleIntegerProperty(0);
        this.timesCorrectlyAnswered = new SimpleIntegerProperty(0);
    }


    public String getQuestion()
    {
        return this.question.getValue();
    }


    public SimpleStringProperty questionProperty()
    {
        return this.question;
    }


    public String[] getPossibleAnswers()
    {
        return this.possibleAnswers;
    }


    public void setPossibleAnswers(String[] answers)
    {
        this.possibleAnswers = answers;
    }


    public String getPossibleAnswerAt(int index)
    {
        return this.possibleAnswers[index];
    }


    public int getTimesAnswered()
    {
        return this.timesAnswered.getValue();
    }


    public void setTimesAnswered(int timesAnswered)
    {
        this.timesAnswered.setValue(timesAnswered);
    }


    public SimpleIntegerProperty timesAnsweredProperty()
    {
        return this.timesAnswered;
    }


    public int getTimesCorrectlyAnswered()
    {
        return this.timesCorrectlyAnswered.getValue();
    }


    public void setTimesCorrectlyAnswered(int timesCorrectlyAnswered)
    {
        this.timesCorrectlyAnswered.setValue(timesCorrectlyAnswered);
    }


    public SimpleIntegerProperty timesCorrectlyAnsweredProperty()
    {
        return this.timesCorrectlyAnswered;
    }


    public int getIndexOfCorrectAnswer()
    {
        return this.indexOfCorrectAnswer.getValue();
    }


    public SimpleIntegerProperty indexOfCorrectAnswerProperty()
    {
        return this.indexOfCorrectAnswer;
    }


    public void incrementTimesAnswered()
    {
        this.timesAnswered.set(this.timesAnswered.get() + 1);
    }


    public void incrementTimesCorrectlyAnswered()
    {
        this.timesCorrectlyAnswered.set(this.timesCorrectlyAnswered.get() + 1);
    }


    @Override
    public String toString()
    {
        return String.format("%s", this.getQuestion());
    }
}