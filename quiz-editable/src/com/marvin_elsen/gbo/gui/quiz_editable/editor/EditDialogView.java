package com.marvin_elsen.gbo.gui.quiz_editable.editor;


import com.marvin_elsen.gbo.gui.quiz_editable.model.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;


public class EditDialogView extends VBox
{
    private EditDialogPresenter presenter;

    private final ToggleGroup toggleGroup;

    @FXML
    private TextArea dialogQuestion;

    @FXML
    private Button applyButton;

    @FXML
    private VBox answersVbox;


    public EditDialogView()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("EditDialogView.fxml"));

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

        this.toggleGroup = new ToggleGroup();
    }


    public EditDialogView(EditDialogPresenter presenter)
    {
        this();

        this.setPresenter(presenter);
    }


    public void setPresenter(EditDialogPresenter presenter)
    {
        this.presenter = presenter;
    }


    public void removeAnswerHandle(ActionEvent event)
    {
        Button button = (Button) event.getSource();
        HBox hbox = (HBox) button.getParent();
        RadioButton radioButton = (RadioButton) hbox.getChildren().get(0);

        this.answersVbox.getChildren().remove(hbox);
        this.toggleGroup.getToggles().remove(radioButton);
    }


    public HBox createAnswerHbox(String answerText)
    {
        RadioButton radioButton = new RadioButton();
        this.toggleGroup.getToggles().add(radioButton);

        TextField textField = new TextField(answerText);
        Button button = new Button("Löschen");
        button.setOnAction(e -> this.removeAnswerHandle(e));

        HBox hbox = new HBox(radioButton, textField, button);
        hbox.setSpacing(10);

        return hbox;
    }


    public void init(Question question)
    {
        String questionName = question.getQuestion();
        String[] answers = question.getPossibleAnswers();
        int correctAnswerIndex = question.getIndexOfCorrectAnswer();

        this.dialogQuestion.setText(questionName);

        for (int i = 0; i < answers.length; i++)
        {
            HBox answerHbox = this.createAnswerHbox(answers[i]);
            RadioButton radioButton = (RadioButton) answerHbox.getChildren().get(0);

            if (i == correctAnswerIndex)
            {
                this.toggleGroup.selectToggle(radioButton);
            }

            this.answersVbox.getChildren().add(answerHbox);
        }

        this.applyButton.setText("\u00c4ndern");
    }


    public void init()
    {
        this.applyButton.setText("Hinzuf\u00fcgen");
    }


    public void addAnswer()
    {
        HBox hbox = this.createAnswerHbox("");

        this.answersVbox.getChildren().add(hbox);
    }


    public void onApplyClick()
    {
        String questionName = this.dialogQuestion.getText();
        Toggle selectedToggle = this.toggleGroup.getSelectedToggle();
        int correctAnswersIndex = this.toggleGroup.getToggles().indexOf(selectedToggle);

        int answerCount = this.answersVbox.getChildren().size();

        String[] answers = new String[answerCount];

        for (int i = 0; i < answerCount; i++)
        {
            HBox answerHbox = (HBox) this.answersVbox.getChildren().get(i);
            String answerName = ((TextField) answerHbox.getChildren().get(1)).getText();
            answers[i] = answerName;
        }

        this.presenter.editQuestion(questionName, answers, correctAnswersIndex);
    }


    public void onCancelClick()
    {
        this.close();
    }


    public void resetInput()
    {
        this.dialogQuestion.clear();
        this.answersVbox.getChildren().clear();
    }


    public void close()
    {
        this.resetInput();
        this.getScene().getWindow().hide();
    }
}
