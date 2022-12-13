package com.marvin_elsen.gbo.gui.graphics;


import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;


public class SinusView extends VBox
{
    private final SinusPresenter presenter;

    private Label equationLabel;

    private Pane canvasPane;

    private Slider amplitudeSlider;

    private Slider frequencySlider;

    private Slider phaseSlider;

    private Slider zoomSlider;

    private Path sinePath;


    public SinusView(SinusPresenter presenter)
    {
        this.presenter = presenter;
    }


    private HBox createSliderHBox(Label label, Slider slider)
    {
        HBox hbox = new HBox(label, slider);
        hbox.setMaxWidth(Double.MAX_VALUE);
        hbox.setSpacing(10);

        HBox.setHgrow(slider, Priority.ALWAYS);

        return hbox;
    }


    public void initializeView()
    {
        this.sinePath = new Path();

        this.sinePath.setStrokeWidth(3);
        this.sinePath.setStroke(Color.CRIMSON);

        this.equationLabel = new Label();
        this.equationLabel.setFont(new Font(24));

        this.updateEquationLabelText(1, 1, 0);

        this.canvasPane = new Pane();
        this.canvasPane.setPrefHeight(300);
        this.canvasPane.setPrefWidth(300);
        this.canvasPane.setMaxHeight(Double.MAX_VALUE);
        this.canvasPane.setMaxWidth(Double.MAX_VALUE);

        Rectangle clippingRect = new Rectangle();
        clippingRect.widthProperty().bind(this.canvasPane.widthProperty());
        clippingRect.heightProperty().bind(this.canvasPane.heightProperty());

        // clippingRect.setFill(Color.RED);
        // this.canvasPane.getChildren().add(clippingRect);

        this.canvasPane.setClip(clippingRect);

        Line verticalLine = new Line();
        verticalLine.startXProperty().bind(this.canvasPane.widthProperty().divide(2));
        verticalLine.setStartY(0);
        verticalLine.endXProperty().bind(this.canvasPane.widthProperty().divide(2));
        verticalLine.endYProperty().bind(this.canvasPane.heightProperty());

        Line horizontalLine = new Line();
        horizontalLine.setStartX(0);
        horizontalLine.startYProperty().bind(this.canvasPane.heightProperty().divide(2));
        horizontalLine.endXProperty().bind(this.canvasPane.widthProperty());
        horizontalLine.endYProperty().bind(this.canvasPane.heightProperty().divide(2));

        this.canvasPane.getChildren().addAll(verticalLine, horizontalLine);

        VBox.setVgrow(this.canvasPane, Priority.SOMETIMES);

        Label amplitudeLabel = new Label("Amplitude: ");
        amplitudeLabel.setFont(new Font(24));

        this.amplitudeSlider = new Slider(-6, 6, 1);
        this.amplitudeSlider.setId("amplitude");
        this.amplitudeSlider.setShowTickMarks(true);
        this.amplitudeSlider.setShowTickLabels(true);
        this.amplitudeSlider.setMajorTickUnit(2);
        this.amplitudeSlider.setMinorTickCount(1);
        this.amplitudeSlider.setMaxWidth(Double.MAX_VALUE);

        Label frequencyLabel = new Label("Frequenz: ");
        frequencyLabel.setFont(new Font(24));

        this.frequencySlider = new Slider(0, 40, 1);
        this.frequencySlider.setId("frequency");
        this.frequencySlider.setShowTickMarks(true);
        this.frequencySlider.setShowTickLabels(true);
        this.frequencySlider.setMajorTickUnit(10);
        this.frequencySlider.setMinorTickCount(5);
        this.frequencySlider.setMaxWidth(Double.MAX_VALUE);

        Label phaseLabel = new Label("Phase: ");
        phaseLabel.setFont(new Font(24));

        this.phaseSlider = new Slider(-10, 10, 0);
        this.phaseSlider.setId("phase");
        this.phaseSlider.setShowTickMarks(true);
        this.phaseSlider.setShowTickLabels(true);
        this.phaseSlider.setMajorTickUnit(5);
        this.phaseSlider.setMinorTickCount(1);
        this.phaseSlider.setMaxWidth(Double.MAX_VALUE);

        Label zoomLabel = new Label("Zoom: ");
        zoomLabel.setFont(new Font(24));

        this.zoomSlider = new Slider(10, 210, 100);
        this.zoomSlider.setId("zoom");
        this.zoomSlider.setShowTickMarks(true);
        this.zoomSlider.setShowTickLabels(true);
        this.zoomSlider.setMajorTickUnit(100);
        this.zoomSlider.setMinorTickCount(50);
        this.zoomSlider.setMaxWidth(Double.MAX_VALUE);

        this.getChildren().addAll(this.equationLabel, this.canvasPane, this.createSliderHBox(amplitudeLabel, this.amplitudeSlider), this.createSliderHBox(frequencyLabel, this.frequencySlider), this.createSliderHBox(phaseLabel, this.phaseSlider), this.createSliderHBox(zoomLabel, this.zoomSlider));
        this.setFillWidth(true);
        this.setSpacing(10);
        this.setPadding(new Insets(10));

        this.presenter.requestBindings();
        this.presenter.requestPoints();
    }


    public void setupBindings(SimpleDoubleProperty amplitudeProperty, SimpleDoubleProperty frequencyProperty, SimpleDoubleProperty phaseProperty)
    {
        amplitudeProperty.bind(this.amplitudeSlider.valueProperty());
        frequencyProperty.bind(this.frequencySlider.valueProperty());
        phaseProperty.bind(this.phaseSlider.valueProperty());

        amplitudeProperty.addListener((o, oldValue, newValue) -> this.updateEquationLabelText((double) newValue, frequencyProperty.get(), phaseProperty.get()));
        frequencyProperty.addListener((o, oldValue, newValue) -> this.updateEquationLabelText(amplitudeProperty.get(), (double) newValue, phaseProperty.get()));
        phaseProperty.addListener((o, oldValue, newValue) -> this.updateEquationLabelText(amplitudeProperty.get(), frequencyProperty.get(), (double) newValue));
    }


    public void setupPoints(ObservableList<SimpleDoubleProperty> points)
    {
        int pointsMiddle = points.size() / 2;

        NumberBinding canvasPaneWidthCenter = this.canvasPane.widthProperty().divide(2);
        NumberBinding canvasPaneHeightCenter = this.canvasPane.heightProperty().divide(2);

        SimpleDoubleProperty currentPointX = points.get(pointsMiddle);
        SimpleDoubleProperty currentPointY = points.get(pointsMiddle + 1);

        MoveTo center = new MoveTo();
        center.xProperty().bind(canvasPaneWidthCenter.add(currentPointX));
        center.yProperty().bind(canvasPaneHeightCenter.add(currentPointY));

        DoubleProperty zoom = this.zoomSlider.valueProperty();

        // Von 0,0 nach positiv
        this.sinePath.getElements().add(center);
        for (int i = pointsMiddle; i < points.size() - 1; i += 2)
        {
            currentPointX = points.get(i);
            currentPointY = points.get(i + 1);

            LineTo lineTo = new LineTo();
            lineTo.xProperty().bind(canvasPaneWidthCenter.add(currentPointX.multiply(zoom)));
            lineTo.yProperty().bind(canvasPaneHeightCenter.add(currentPointY.multiply(zoom)));

            Circle circle = new Circle(5, Color.CRIMSON);
            circle.centerXProperty().bind(lineTo.xProperty());
            circle.centerYProperty().bind(lineTo.yProperty());

            this.sinePath.getElements().add(lineTo);
            // this.canvasPane.getChildren().add(circle);
        }

        // Von 0,0 nach negativ
        this.sinePath.getElements().add(center);
        for (int i = 0; i < pointsMiddle - 1; i += 2)
        {
            currentPointX = points.get(i);
            currentPointY = points.get(i + 1);

            LineTo lineTo = new LineTo();
            lineTo.xProperty().bind(canvasPaneWidthCenter.add(currentPointX.multiply(zoom)));
            lineTo.yProperty().bind(canvasPaneHeightCenter.add(currentPointY.multiply(zoom)));

            Circle circle = new Circle(5, Color.CRIMSON);
            circle.centerXProperty().bind(lineTo.xProperty());
            circle.centerYProperty().bind(lineTo.yProperty());

            this.sinePath.getElements().addAll(lineTo);
            // this.canvasPane.getChildren().add(circle);
        }

        this.canvasPane.getChildren().add(this.sinePath);
    }


    public void updateEquationLabelText(double amplitude, double frequency, double phase)
    {
        String text = String.format("%.2f * sin(%.2f * x + %.2f)", amplitude, frequency, phase);
        this.equationLabel.setText(text);
    }
}