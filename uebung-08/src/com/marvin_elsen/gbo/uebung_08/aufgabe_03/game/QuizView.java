package com.marvin_elsen.gbo.uebung_08.aufgabe_03.game;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

import java.io.IOException;


public class QuizView extends VBox
{
    private final ToggleGroup answersToggleGroup;
    private QuizPresenter presenter;
    @FXML
    private Label question;
    @FXML
    private VBox answersVbox;
    @FXML
    private Button nextQuestionButton;


    public QuizView()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("QuizView.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try
        {
            fxmlLoader.load();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        this.answersToggleGroup = new ToggleGroup();
    }


    public QuizView(QuizPresenter presenter)
    {
        this();

        this.setPresenter(presenter);
    }


    public void setPresenter(QuizPresenter presenter)
    {
        this.presenter = presenter;
    }


    public void showQuestion(String questionName, String[] answers)
    {
        this.resetView();

        String labelText = questionName;
        this.question.setText(labelText);

        int answerIndex = 0;
        for (String answer : answers)
        {
            RadioButton radioButton = new RadioButton(answer);
            radioButton.setUserData(answerIndex);

            this.answersVbox.getChildren().add(radioButton);
            this.answersToggleGroup.getToggles().add(radioButton);

            answerIndex++;
        }
    }


    public void showEndScreen()
    {
        this.answersVbox.getChildren().clear();

        this.question.setText("Ende des Quiz");

        this.nextQuestionButton.setDisable(true);
    }


    @FXML
    private void nextQuestionButtonOnClick()
    {
        if (this.answersToggleGroup.getSelectedToggle() != null)
        {
            RadioButton selectedAnswerRadioButton = (RadioButton) this.answersToggleGroup.getSelectedToggle();
            int selectedAnswerIndex = (Integer) selectedAnswerRadioButton.getUserData();

            this.presenter.evaluateCurrentQuestion(selectedAnswerIndex);
        }

        this.presenter.showNextQuestion();
    }


    public void resetView()
    {
        this.answersVbox.getChildren().clear();
        this.answersToggleGroup.getToggles().clear();
        this.nextQuestionButton.setDisable(false);
    }
}