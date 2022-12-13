package com.marvin_elsen.gbo.gui.quiz_drag_and_drop;


import com.marvin_elsen.gbo.gui.quiz_drag_and_drop.game.QuizPresenter;
import com.marvin_elsen.gbo.gui.quiz_drag_and_drop.game.QuizView;
import com.marvin_elsen.gbo.gui.quiz_drag_and_drop.main.MainPresenter;
import com.marvin_elsen.gbo.gui.quiz_drag_and_drop.main.MainView;
import com.marvin_elsen.gbo.gui.quiz_drag_and_drop.model.Model;
import com.marvin_elsen.gbo.gui.quiz_drag_and_drop.overview.OverviewPresenter;
import com.marvin_elsen.gbo.gui.quiz_drag_and_drop.overview.OverviewView;
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

        return mainPresenter;
    }
}