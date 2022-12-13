package com.marvin_elsen.gbo.gui.graphics;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        SinusModel model = new SinusModel(10000);

        SinusPresenter presenter = new SinusPresenter(model);

        SinusView view = new SinusView(presenter);
        presenter.setView(view);

        view.initializeView();

        Scene scene = new Scene(view, 800, 800);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Sinus");
        primaryStage.show();
    }
}