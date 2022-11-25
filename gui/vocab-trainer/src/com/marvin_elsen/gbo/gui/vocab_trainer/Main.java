package com.marvin_elsen.gbo.gui.vocab_trainer;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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
        Presenter presenter = new Presenter();
        View view = new View();

        Pane root;

        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("VocabTrainerView.fxml"));
            root = fxmlLoader.load();
            view = fxmlLoader.getController();
            view.setPresenter(presenter);
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
            return;
        }

        Model model = new Model();
        presenter.setModel(model);
        presenter.setView(view);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Vokabel-Training");
        primaryStage.show();
    }
}