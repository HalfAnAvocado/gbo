package com.marvin_elsen.gbo.gui.quiz.overview;


import com.marvin_elsen.gbo.gui.quiz.model.Question;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.io.IOException;


public class OverviewView extends VBox
{
    private OverviewPresenter presenter;

    @FXML
    private ListView<Question> overviewList;


    public OverviewView()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("OverviewView.fxml"));

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


    public OverviewView(OverviewPresenter presenter)
    {
        this();

        this.setPresenter(presenter);
    }


    public void setPresenter(OverviewPresenter presenter)
    {
        this.presenter = presenter;
    }


    @FXML
    private void onDeleteHistoryClick()
    {
        this.presenter.deleteHistory();
    }


    public void showQuestions(ObservableList<Question> questions)
    {
        this.overviewList.setItems(questions);
    }


    public void updateQuestions()
    {
        this.overviewList.refresh();
    }
}
