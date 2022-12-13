package com.marvin_elsen.gbo.gui.quiz_drag_and_drop.overview;


import com.marvin_elsen.gbo.gui.quiz_drag_and_drop.model.Question;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

import java.io.IOException;


public class OverviewView extends VBox
{
    private OverviewPresenter presenter;

    @FXML
    private TableView<Question> overviewTable;

    @FXML
    private TableColumn<Question, String> questionCol;

    @FXML
    private TableColumn<Question, Number> totalAnswerCol;

    @FXML
    private TableColumn<Question, Number> correctAnswerCol;


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
        if (this.overviewTable.getItems().isEmpty())
        {
            this.overviewTable.setItems(questions);
            this.questionCol.setCellValueFactory(c -> c.getValue().questionProperty());
            this.totalAnswerCol.setCellValueFactory(c -> c.getValue().timesAnsweredProperty());
            this.correctAnswerCol.setCellValueFactory(c -> c.getValue().timesCorrectlyAnsweredProperty());
        }
    }


    public void updateQuestions()
    {
        this.overviewTable.refresh();
    }
}
