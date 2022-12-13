package com.marvin_elsen.gbo.gui.quiz.model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Model
{
    private final ObservableList<Question> questions;


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
}
