package com.marvin_elsen.gbo.gui.quiz_editable;


import com.marvin_elsen.gbo.gui.quiz_editable.editor.EditDialogPresenter;
import com.marvin_elsen.gbo.gui.quiz_editable.editor.EditDialogView;
import com.marvin_elsen.gbo.gui.quiz_editable.editor.EditorPresenter;
import com.marvin_elsen.gbo.gui.quiz_editable.editor.EditorView;
import com.marvin_elsen.gbo.gui.quiz_editable.game.QuizPresenter;
import com.marvin_elsen.gbo.gui.quiz_editable.game.QuizView;
import com.marvin_elsen.gbo.gui.quiz_editable.main.MainPresenter;
import com.marvin_elsen.gbo.gui.quiz_editable.main.MainView;
import com.marvin_elsen.gbo.gui.quiz_editable.model.Model;
import com.marvin_elsen.gbo.gui.quiz_editable.overview.OverviewPresenter;
import com.marvin_elsen.gbo.gui.quiz_editable.overview.OverviewView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        String questionsFilePath = this.getParameters().getUnnamed().get(0);

        MainPresenter mainPresenter = this.initializeApplication(questionsFilePath);
        mainPresenter.startQuiz();

        Scene scene = new Scene(mainPresenter.getView());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Quiz");
        primaryStage.show();
    }


    private MainPresenter initializeApplication(String questionsFilePath) throws IOException
    {
        Model model = ModelInitializer.initModel(questionsFilePath);

        MainPresenter mainPresenter = new MainPresenter();
        MainView mainView = new MainView(mainPresenter);
        mainPresenter.setView(mainView);

        OverviewPresenter overviewPresenter = new OverviewPresenter();
        OverviewView overviewView = new OverviewView(overviewPresenter);
        overviewPresenter.setModel(model);
        overviewPresenter.setView(overviewView);
        mainPresenter.setOverviewPresenter(overviewPresenter);

        QuizPresenter quizPresenter = new QuizPresenter();
        QuizView quizView = new QuizView(quizPresenter);
        quizPresenter.setModel(model);
        quizPresenter.setView(quizView);
        mainPresenter.setQuizPresenter(quizPresenter);

        EditDialogPresenter editDialogPresenter = new EditDialogPresenter();
        EditDialogView editDialogView = new EditDialogView(editDialogPresenter);
        editDialogPresenter.setModel(model);
        editDialogPresenter.setView(editDialogView);

        EditorPresenter editorPresenter = new EditorPresenter();
        EditorView editorView = new EditorView(editorPresenter);
        editorPresenter.setModel(model);
        editorPresenter.setView(editorView);
        editorPresenter.setEditDialogPresenter(editDialogPresenter);
        mainPresenter.setEditorPresenter(editorPresenter);

        return mainPresenter;
    }
}