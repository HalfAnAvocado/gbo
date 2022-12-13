package com.marvin_elsen.gbo.uebung_04.aufgabe_04;


import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;


public class GridPaneExampleExtended extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage)
    {
        GridPane root = new GridPane();

        root.setHgap(10);
        root.setVgap(10);

        Insets ins = new Insets(10);
        root.setPadding(ins);

        for (int i = 1; i <= 5; i++)
        {
            for (int j = 1; j <= 5; j++)
            {
                if (i < 3 || j < 3)
                {
                    Button b = new Button("Button " + i + "/" + j);
                    root.add(b, i - 1, j - 1);
                }
            }
        }

        Button b = new Button("Button 6/*");
        // b.setMaxHeight(Double.MAX_VALUE);
        root.add(b, 5, 0, 1, 4);

        b = new Button("Button */6");
        // b.setMaxWidth(Double.MAX_VALUE);
        root.add(b, 0, 5, 3, 1);

        b = new Button("Button 3/3");
        // b.setMaxHeight(Double.MAX_VALUE);
        // b.setMaxWidth(Double.MAX_VALUE);
        root.add(b, 2, 2, 3, 3);

        root.setGridLinesVisible(true);

        ColumnConstraints columnConstraints1 = new ColumnConstraints();
        columnConstraints1.setFillWidth(true);
        columnConstraints1.setHgrow(Priority.ALWAYS);
        columnConstraints1.setHalignment(HPos.RIGHT);

        ColumnConstraints columnConstraints2 = new ColumnConstraints();
        columnConstraints2.setFillWidth(true);
        columnConstraints2.setHgrow(Priority.ALWAYS);
        columnConstraints2.setHalignment(HPos.CENTER);

        ColumnConstraints columnConstraints3 = new ColumnConstraints();
        columnConstraints3.setFillWidth(true);
        columnConstraints3.setHgrow(Priority.ALWAYS);
        columnConstraints3.setHalignment(HPos.LEFT);

        root.getColumnConstraints().addAll(columnConstraints1, columnConstraints2, columnConstraints3, columnConstraints3, columnConstraints2, columnConstraints1);

        RowConstraints rowContraints1 = new RowConstraints();
        rowContraints1.setFillHeight(true);
        rowContraints1.setVgrow(Priority.ALWAYS);
        rowContraints1.setValignment(VPos.BOTTOM);

        RowConstraints rowContraints2 = new RowConstraints();
        rowContraints2.setFillHeight(true);
        rowContraints2.setVgrow(Priority.ALWAYS);
        rowContraints2.setValignment(VPos.TOP);

        RowConstraints rowContraints3 = new RowConstraints();
        rowContraints3.setFillHeight(true);
        rowContraints3.setVgrow(Priority.ALWAYS);
        rowContraints3.setValignment(VPos.CENTER);

        root.getRowConstraints().addAll(rowContraints3, rowContraints2, rowContraints1, rowContraints2, rowContraints3, rowContraints1);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("GridPane-Beispiel");
        primaryStage.show();
    }
}
