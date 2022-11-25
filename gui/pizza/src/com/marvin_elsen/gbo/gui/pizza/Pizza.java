package com.marvin_elsen.gbo.gui.pizza;


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Pizza extends Application
{
    private Configuration configuration;

    private final FlowPane flowPaneToppings;

    private final FlowPane flowPaneSizes;

    private final ToggleGroup toggleGroupSizes;

    private final TextArea textAreaOrderText;

    private final Button buttonOrder;


    public Pizza()
    {
        this.flowPaneToppings = new FlowPane();
        this.flowPaneSizes = new FlowPane();
        this.toggleGroupSizes = new ToggleGroup();
        this.textAreaOrderText = new TextArea();
        this.buttonOrder = new Button("Bestellen!");
    }


    public static void main(String[] args)
    {
        launch(args);
    }


    private void initializeToppingCheckBoxes(Pane toppingsPane, Configuration configurationToUse)
    {
        String[] toppingNames = configurationToUse.getToppingNames();
        int numberOfDefaultToppings = configurationToUse.getNumberOfDefaultToppings();

        for (int i = 0; i < toppingNames.length; i++)
        {
            String toppingName = toppingNames[i];
            CheckBox checkBox = new CheckBox(toppingName);

            if (i < numberOfDefaultToppings)
            {
                checkBox.setSelected(true);
                checkBox.setDisable(true);
            }

            toppingsPane.getChildren().add(checkBox);
        }
    }


    private void initializeFlowPaneToppings(int paddingValue)
    {
        this.flowPaneToppings.setOrientation(Orientation.VERTICAL);
        this.flowPaneToppings.setMaxHeight(100);
        this.flowPaneToppings.setPadding(new Insets(paddingValue));
        this.flowPaneToppings.setHgap(paddingValue);
        this.flowPaneToppings.setVgap(paddingValue);
        this.flowPaneToppings.setAlignment(Pos.CENTER);
    }


    private void initializeFlowPaneSizes(int paddingValue)
    {
        this.flowPaneSizes.setPadding(new Insets(paddingValue));
        this.flowPaneSizes.setHgap(paddingValue);
        this.flowPaneSizes.setVgap(paddingValue);
        this.flowPaneSizes.setAlignment(Pos.CENTER);
    }


    private void initializeSizesRadioButtons(Pane sizesPane, Configuration configurationToUse)
    {
        String[] sizesNames = configurationToUse.getSizeNames();

        for (int i = 0; i < sizesNames.length; i++)
        {
            String sizeName = sizesNames[i];

            RadioButton radioButton = new RadioButton(sizeName);
            radioButton.setUserData(i); // Index für sizePrices
            radioButton.setToggleGroup(this.toggleGroupSizes);

            if (i == 0)
            {
                radioButton.setSelected(true);
            }

            sizesPane.getChildren().add(radioButton);
        }
    }


    private void initializeTextAreaOrderText()
    {
        this.textAreaOrderText.setId("bestelltext");
        this.textAreaOrderText.setEditable(false);
    }


    private String generateOrderText(Configuration configurationToUse)
    {
        RadioButton selectedSizeRadioButton = (RadioButton) Pizza.this.toggleGroupSizes.getSelectedToggle();
        int selectedSizeIndex = (Integer) selectedSizeRadioButton.getUserData();

        int[] sizePrices = configurationToUse.getSizePrices();
        int[] toppingPrices = configurationToUse.getToppingPrices();

        int selectedSizePrice = sizePrices[selectedSizeIndex];

        double price = selectedSizePrice;
        StringBuilder toppings = new StringBuilder();

        ObservableList<Node> flowPaneToppingsChildren = Pizza.this.flowPaneToppings.getChildren();
        for (int i = 0; i < flowPaneToppingsChildren.size(); i++)
        {
            CheckBox checkBox = (CheckBox) flowPaneToppingsChildren.get(i);

            if (checkBox.isSelected())
            {
                price += toppingPrices[i];
                toppings.append(checkBox.getText() + ", ");
            }
        }
        // Letztes ", " entfernen
        toppings.delete(toppings.length() - 2, toppings.length() - 1);

        price = price / 100.d; // Zu Euro

        return String.format("Sie haben eine Pizza bestellt.\nZutaten: %s\nDie Größe ist: %s\nDer Preis beträgt: %.2f€\nVielen Dank.", toppings, selectedSizeRadioButton.getText(), price);
    }


    private void initializeButtonOrder(Configuration configurationToUse)
    {
        this.buttonOrder.setOnAction(event -> Pizza.this.textAreaOrderText.setText(Pizza.this.generateOrderText(configurationToUse)));
    }


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.configuration = ParameterConverter.createConfiguration(this.getParameters().getNamed());

        int paddingValue = 5;

        this.initializeFlowPaneToppings(paddingValue);
        this.initializeToppingCheckBoxes(this.flowPaneToppings, this.configuration);

        this.initializeFlowPaneSizes(paddingValue);
        this.initializeSizesRadioButtons(this.flowPaneSizes, this.configuration);

        this.initializeButtonOrder(this.configuration);

        this.initializeTextAreaOrderText();

        VBox root = new VBox(this.flowPaneToppings, this.flowPaneSizes, this.buttonOrder, this.textAreaOrderText);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 300, 360);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Pizza");
        primaryStage.show();
    }
}
