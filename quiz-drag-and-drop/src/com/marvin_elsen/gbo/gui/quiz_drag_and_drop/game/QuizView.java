package com.marvin_elsen.gbo.gui.quiz_drag_and_drop.game;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.IOException;


public class QuizView extends VBox
{
    private QuizPresenter presenter;

    @FXML
    private Label question;

    @FXML
    private GridPane correctAnswersGridPane;

    @FXML
    private GridPane possibleAnswersGridPane;

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

        ColumnConstraints constraints = new ColumnConstraints();
        constraints.setFillWidth(true);
        constraints.setHalignment(HPos.CENTER);
        this.possibleAnswersGridPane.getColumnConstraints().add(constraints);

        constraints = new ColumnConstraints();
        constraints.setFillWidth(true);
        constraints.setHalignment(HPos.CENTER);
        this.correctAnswersGridPane.getColumnConstraints().add(constraints);

        constraints = new ColumnConstraints();
        constraints.setFillWidth(true);
        constraints.setHgrow(Priority.ALWAYS);
        constraints.setHalignment(HPos.LEFT);
        this.correctAnswersGridPane.getColumnConstraints().add(constraints);
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


    public void onDragDetected(MouseEvent event)
    {
        Label source = (Label) event.getSource();
        Dragboard dragBoard = source.startDragAndDrop(TransferMode.MOVE);

        ClipboardContent content = new ClipboardContent();
        content.putString(source.getText());
        dragBoard.setContent(content);
    }


    public void onDragDone(DragEvent event)
    {
        Label source = (Label) event.getSource();

        if (event.isAccepted())
        {
            source.setText("");
        }
    }


    public void onMouseEntered(MouseEvent event)
    {
        Label source = (Label) event.getSource();

        if (!source.getText().isEmpty())
        {
            this.setCursor(Cursor.HAND);
        }
    }


    public void onMouseExited(MouseEvent event)
    {
        this.setCursor(Cursor.DEFAULT);
    }


    public void onDragOver(DragEvent event)
    {
        if (event.getGestureSource() != event.getSource() && event.getDragboard().hasString())
        {
            event.acceptTransferModes(TransferMode.MOVE);
        }
    }


    public void onDragDropped(DragEvent event)
    {
        Label target = (Label) event.getSource();
        boolean success = false;
        if (event.getGestureSource() != event.getSource() && event.getDragboard().hasString())
        {
            target.setText(event.getDragboard().getString());
            success = true;
        }
        event.setDropCompleted(success);
    }


    public void onDragEntered(DragEvent event)
    {
        Label target = (Label) event.getSource();
        target.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, new Insets(0))));
    }


    public void onDragExited(DragEvent event)
    {

        Label target = (Label) event.getSource();
        target.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, new Insets(0))));
    }


    public void showQuestion(String questionName, String[] answers)
    {
        this.resetView();

        String labelText = questionName;
        this.question.setText(labelText);

        int answerIndex = 0;
        for (String answer : answers)
        {
            Label label = new Label(answer);
            label.setUserData(answerIndex);
            label.setPadding(new Insets(5));

            label.setOnMouseEntered(e -> this.onMouseEntered(e));
            label.setOnMouseExited(e -> this.onMouseExited(e));
            label.setOnDragDetected(e -> this.onDragDetected(e));
            label.setOnDragDone(e -> this.onDragDone(e));
            label.setOnDragOver(e -> this.onDragOver(e));
            label.setOnDragEntered(e -> this.onDragEntered(e));
            label.setOnDragExited(e -> this.onDragExited(e));
            label.setOnDragDropped(e -> this.onDragDropped(e));

            this.possibleAnswersGridPane.add(label, answerIndex, 0);

            label = new Label(Integer.toString((answerIndex + 1)) + ".");
            label.setPadding(new Insets(5));
            this.correctAnswersGridPane.add(label, 0, answerIndex);

            label = new Label();
            label.setPadding(new Insets(5));
            label.setMaxWidth(Double.MAX_VALUE);
            label.setOnMouseEntered(e -> this.onMouseEntered(e));
            label.setOnMouseExited(e -> this.onMouseExited(e));
            label.setOnDragDetected(e -> this.onDragDetected(e));
            label.setOnDragDone(e -> this.onDragDone(e));
            label.setOnDragOver(e -> this.onDragOver(e));
            label.setOnDragEntered(e -> this.onDragEntered(e));
            label.setOnDragExited(e -> this.onDragExited(e));
            label.setOnDragDropped(e -> this.onDragDropped(e));

            this.correctAnswersGridPane.add(label, 1, answerIndex);

            answerIndex++;
        }
    }


    public void showEndScreen()
    {
        this.correctAnswersGridPane.getChildren().clear();
        this.possibleAnswersGridPane.getChildren().clear();

        this.question.setText("Ende des Quiz");

        this.nextQuestionButton.setDisable(true);
    }


    @FXML
    private void nextQuestionButtonOnClick()
    {
        // if (this.answersToggleGroup.getSelectedToggle() != null)
        // {
        // RadioButton selectedAnswerRadioButton = (RadioButton)
        // this.answersToggleGroup.getSelectedToggle();
        // int selectedAnswerIndex = (Integer)
        // selectedAnswerRadioButton.getUserData();
        //
        // this.presenter.evaluateCurrentQuestion(selectedAnswerIndex);
        // }

        this.presenter.showNextQuestion();
    }


    public void resetView()
    {
        this.possibleAnswersGridPane.getChildren().clear();
        this.correctAnswersGridPane.getChildren().clear();
        this.nextQuestionButton.setDisable(false);
    }
}