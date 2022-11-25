package com.marvin_elsen.gbo.gui.quiz.model;


public class Question
{
    private final String question;

    private final String[] possibleAnswers;

    private final int indexOfCorrectAnswer;

    private int timesAnswered;

    private int timesCorrectlyAnswered;


    public Question(String question, String[] possibleAnswers, int indexOfCorrectAnswer)
    {
        if (indexOfCorrectAnswer < 0 || indexOfCorrectAnswer >= possibleAnswers.length)
        {
            throw new IllegalArgumentException();
        }

        this.question = question;
        this.possibleAnswers = possibleAnswers;

        this.indexOfCorrectAnswer = indexOfCorrectAnswer;
    }


    public String getQuestion()
    {
        return this.question;
    }


    public String[] getPossibleAnswers()
    {
        return this.possibleAnswers;
    }


    public String getPossibleAnswerAt(int index)
    {
        return this.possibleAnswers[index];
    }


    public int getTimesAnswered()
    {
        return this.timesAnswered;
    }


    public void setTimesAnswered(int timesAnswered)
    {
        this.timesAnswered = timesAnswered;
    }


    public int getTimesCorrectlyAnswered()
    {
        return this.timesCorrectlyAnswered;
    }


    public void setTimesCorrectlyAnswered(int timesCorrectlyAnswered)
    {
        this.timesCorrectlyAnswered = timesCorrectlyAnswered;
    }


    public int getIndexOfCorrectAnswer()
    {
        return this.indexOfCorrectAnswer;
    }


    public void incrementTimesAnswered()
    {
        this.timesAnswered++;
    }


    public void incrementTimesCorrectlyAnswered()
    {
        this.timesCorrectlyAnswered++;
    }


    @Override
    public String toString()
    {
        return String.format("%s (Antworten: %d, davon richtig: %d)", this.getQuestion(), this.getTimesAnswered(), this.getTimesCorrectlyAnswered());
    }
}