package com.marvin_elsen.gbo.gui.quiz_undo_redo;


import com.marvin_elsen.gbo.gui.quiz_undo_redo.editor.EditDialogPresenter;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.editor.EditDialogView;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.editor.EditorPresenter;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.editor.EditorView;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.game.QuizPresenter;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.game.QuizView;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.main.MainPresenter;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.main.MainView;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.model.Model;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.overview.OverviewPresenter;
import com.marvin_elsen.gbo.gui.quiz_undo_redo.overview.OverviewView;
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
        editorPresenter.setMainPresenter(mainPresenter);
        mainPresenter.setEditorPresenter(editorPresenter);
        editDialogPresenter.setEditorPresenter(editorPresenter);

        return mainPresenter;
    }
}