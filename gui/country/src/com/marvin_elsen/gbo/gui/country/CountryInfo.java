package com.marvin_elsen.gbo.gui.country;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class CountryInfo extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Pane root = FXMLLoader.load(this.getClass().getResource("Main.fxml"));

        Scene scene = new Scene(root);

        ComboBox<Country> countrySelector = (ComboBox) root.lookup("#countrySelector");
        CheckBox exactValues = (CheckBox) root.lookup("#exactValues");

        Label countryName = (Label) root.lookup("#countryName");
        Label capital = (Label) root.lookup("#capital");
        Label population = (Label) root.lookup("#population");
        Label area = (Label) root.lookup("#area");
        Label density = (Label) root.lookup("#density");

        countrySelector.getItems().add(new Country("Belgien", "Brüssel", 10_839_905, 30_528));
        countrySelector.getItems().add(new Country("Luxemburg", "Luxemburg", 511_840, 2_586));
        countrySelector.getItems().add(new Country("Kanada", "Ottawa", 34_278_406, 9_984_670));
        countrySelector.getItems().add(new Country("Deutschland", "Berlin", 82175684, 357385));

        // Controller hat Initializer Methode, um so etwas zu tun
        if (countrySelector.getItems().size() > 0)
        {
            countrySelector.getSelectionModel().select(0);
            Country country = countrySelector.getSelectionModel().getSelectedItem();

            countryName.setText(country.getName());
            capital.setText(country.getCapital());
            population.setText(Controller.format(exactValues.isSelected(), country.getPeople()));
            area.setText(Controller.format(exactValues.isSelected(), country.getArea()));
            density.setText(Long.toString(country.getDensity()));
        }

        primaryStage.setScene(scene);
        primaryStage.setTitle("L\u00e4nder-Informationen");
        primaryStage.show();
    }
}
