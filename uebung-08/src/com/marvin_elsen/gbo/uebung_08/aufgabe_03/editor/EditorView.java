package com.marvin_elsen.gbo.uebung_08.aufgabe_03.editor;


import com.marvin_elsen.gbo.uebung_08.aufgabe_03.model.Question;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Optional;


public class EditorView extends VBox
{
    private final Alert noSelectionAlert;
    private final Alert deleteAlert;
    private EditorPresenter presenter;
    @FXML
    private ListView<Question> editorList;
    private Stage editStage;


    public EditorView()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("EditorView.fxml"));

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

        this.noSelectionAlert = new Alert(AlertType.INFORMATION);
        this.noSelectionAlert.setHeaderText("");
        this.noSelectionAlert.setContentText("Es muss eine Frage ausgew\u00e4hlt werden!");

        this.deleteAlert = new Alert(AlertType.CONFIRMATION);
        this.deleteAlert.setHeaderText("");
        this.deleteAlert.setContentText("Soll diese Frage wirklich gel\u00f6scht werden?");
    }


    public EditorView(EditorPresenter presenter)
    {
        this();

        this.setPresenter(presenter);
    }


    public void setPresenter(EditorPresenter presenter)
    {
        this.presenter = presenter;
    }


    public void onAddQuestionClick()
    {
        this.presenter.addQuestion();
    }


    public void onEditQuestionClick()
    {
        if (this.isQuestionSelected())
        {
            int selectedQuestionIndex = this.editorList.getSelectionModel().getSelectedIndex();

            this.presenter.editQuestion(selectedQuestionIndex);
        }
    }


    public void showEdit()
    {
        this.editStage.showAndWait();
        this.editorList.refresh();
    }


    public void onDeleteQuestionClick()
    {
        if (this.isQuestionSelected())
        {
            Optional<ButtonType> choice = this.deleteAlert.showAndWait();

            if (choice.isPresent() && choice.get() == ButtonType.OK)
            {
                int selectedQuestionIndex = this.editorList.getSelectionModel().getSelectedIndex();

                this.presenter.removeQuestion(selectedQuestionIndex);
            }
        }
    }


    public void showQuestions(ObservableList<Question> questions)
    {
        if (this.editorList.getItems().isEmpty())
        {
            this.editorList.setItems(questions);
        }
    }


    public boolean isQuestionSelected()
    {
        Question selectedQuestion = this.editorList.getSelectionModel().getSelectedItem();
        boolean isQuestionSelected = selectedQuestion != null;

        if (!isQuestionSelected)
        {
            this.noSelectionAlert.show();
        }

        return isQuestionSelected;
    }


    public void initEdit(Pane root)
    {
        if (this.editStage == null)
        {
            Scene scene = new Scene(root);

            this.editStage = new Stage(StageStyle.UTILITY);
            this.editStage.initModality(Modality.WINDOW_MODAL);
            this.editStage.initOwner(this.getParent().getScene().getWindow());
            this.editStage.setScene(scene);
            this.editStage.setTitle("Dialog");
        }
    }
}
