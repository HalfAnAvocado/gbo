package com.marvin_elsen.gbo.gui.country;


import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Locale;


public class Controller
{
    @FXML
    private ComboBox<Country> countrySelector;

    @FXML
    private CheckBox exactValues;

    @FXML
    private Label countryName;

    @FXML
    private Label capital;

    @FXML
    private Label population;

    @FXML
    private Label area;

    @FXML
    private Label density;

    @FXML
    private TextField countryField;

    @FXML
    private TextField capitalField;

    @FXML
    private TextField populationField;

    @FXML
    private TextField areaField;


    static String format(boolean isExactValuesSelected, long value)
    {
        if (!isExactValuesSelected)
        {
            if (value >= 1_000_000)
            {
                value = Math.round(value / 1_000_000d);

                return String.format(Locale.GERMAN, "%,d Mill.", value);
            }
            else if (value > 1_000)
            {
                value = Math.round(value / 1_000d) * 1_000;
            }
        }

        return String.format(Locale.GERMAN, "%,d", value);
    }


    private boolean isDigitString(String text)
    {
        for (char character : text.toCharArray())
        {
            if (!Character.isDigit(character))
            {
                return false;
            }
        }

        return true;
    }


    private void updateInformationLabels(String countryNameText, String capitalText, String populationText, String areaText, String densityText)
    {
        this.countryName.setText(countryNameText);
        this.capital.setText(capitalText);
        this.population.setText(populationText);
        this.area.setText(areaText);
        this.density.setText(densityText);
    }


    private void updateInformationLabels()
    {
        Country selectedCountry = this.countrySelector.getSelectionModel().getSelectedItem();

        this.updateInformationLabels(selectedCountry.getName(), selectedCountry.getCapital(), Controller.format(this.exactValues.isSelected(), selectedCountry.getPeople()), Controller.format(this.exactValues.isSelected(), selectedCountry.getArea()), Controller.format(this.exactValues.isSelected(), selectedCountry.getDensity()));
    }


    @FXML
    private void onExactValuesClick()
    {
        if (!this.countrySelector.getItems().isEmpty())
        {
            this.updateInformationLabels();
        }
    }


    @FXML
    private void onCountrySelectorClick()
    {
        if (!this.countrySelector.getItems().isEmpty())
        {
            this.updateInformationLabels();
        }
        else
        {
            this.updateInformationLabels("", "", "", "", "");
        }
    }


    @FXML
    private void onAddClick()
    {
        String newCountryName = this.countryField.getText();
        String newCapital = this.capitalField.getText();
        String newPopulation = this.populationField.getText();
        String newArea = this.areaField.getText();

        // Besser wäre Überprüfung in der Country Klasse, sonst muss der Check
        // an mehreren Stellen gemacht werden
        if (!(newCountryName.isEmpty() || newCapital.isEmpty() || newPopulation.isEmpty() || newArea.isEmpty() || !this.isDigitString(newPopulation) || !this.isDigitString(newArea)))
        {
            this.countrySelector.getItems().add(new Country(newCountryName, newCapital, Long.parseLong(newPopulation), Long.parseLong(newArea)));

            if (this.countrySelector.getItems().size() == 1)
            {
                this.countrySelector.getSelectionModel().select(0);
            }
        }

        this.countryField.clear();
        this.capitalField.clear();
        this.populationField.clear();
        this.areaField.clear();
    }


    @FXML
    private void onDeleteClick()
    {
        if (!this.countrySelector.getItems().isEmpty())
        {
            int selectedCountryIndex = this.countrySelector.getSelectionModel().getSelectedIndex();

            if (selectedCountryIndex == 0)
            {
                if (this.countrySelector.getItems().size() > 1)
                {
                    this.countrySelector.getSelectionModel().select(1);
                }
            }

            this.countrySelector.getItems().remove(selectedCountryIndex);
        }
    }
}
