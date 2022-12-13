package com.marvin_elsen.gbo.gui.quiz_editable.main;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;


public class MainView extends BorderPane
{
    private MainPresenter presenter;

    @FXML
    private Button continueButton;


    public MainView()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("MainView.fxml"));

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
    }


    public MainView(MainPresenter presenter)
    {
        this();

        this.setPresenter(presenter);
    }


    public void setPresenter(MainPresenter presenter)
    {
        this.presenter = presenter;
    }


    public void setContent(Pane content)
    {
        this.setCenter(content);
    }


    public void onOverviewClick()
    {
        this.presenter.showOverview();
    }


    public void onQuizContinueClick()
    {
        this.presenter.showQuiz();
    }


    public void onQuizStartClick()
    {
        this.continueButton.setDisable(false);
        this.presenter.startQuiz();
    }


    public void onEditorClick()
    {
        this.continueButton.setDisable(true);
        this.presenter.showEditor();
    }
}
