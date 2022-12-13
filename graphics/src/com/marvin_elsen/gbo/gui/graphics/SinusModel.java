package com.marvin_elsen.gbo.gui.graphics;


import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class SinusModel
{
    private final ObservableList<SimpleDoubleProperty> points;

    private final SimpleDoubleProperty frequency;

    private final SimpleDoubleProperty amplitude;

    private final SimpleDoubleProperty phase;


    public SinusModel(int pointsAmount)
    {
        if (pointsAmount % 2 != 0)
        {
            throw new IllegalArgumentException("Punkteanzahl muss durch zwei teilbar sein!");
        }

        this.points = FXCollections.observableArrayList();

        for (int i = 0; i < pointsAmount; i++)
        {
            this.points.add(new SimpleDoubleProperty(0));
        }

        this.frequency = new SimpleDoubleProperty(1);
        this.amplitude = new SimpleDoubleProperty(1);
        this.phase = new SimpleDoubleProperty(0);

        this.frequencyProperty().addListener((o, oldValue, newValue) -> this.calculatePoints(this.getAmplitude(), (double) newValue, this.getPhase()));
        this.amplitudeProperty().addListener((o, oldValue, newValue) -> this.calculatePoints((double) newValue, this.getFrequency(), this.getPhase()));
        this.phaseProperty().addListener((o, oldValue, newValue) -> this.calculatePoints(this.getAmplitude(), this.getFrequency(), (double) newValue));

        this.calculatePoints(this.getAmplitude(), this.getFrequency(), this.getPhase());
    }


    public SimpleDoubleProperty frequencyProperty()
    {
        return this.frequency;
    }


    public SimpleDoubleProperty amplitudeProperty()
    {
        return this.amplitude;
    }


    public SimpleDoubleProperty phaseProperty()
    {
        return this.phase;
    }


    public double getFrequency()
    {
        return this.frequency.get();
    }


    public void setFrequency(double frequency)
    {
        this.frequency.set(frequency);
    }


    public double getAmplitude()
    {
        return this.amplitude.get();
    }


    public void setAmplitude(double amplitude)
    {
        this.amplitude.set(amplitude);
    }


    public double getPhase()
    {
        return this.phase.get();
    }


    public void setPhase(double phase)
    {
        this.phase.set(phase);
    }


    public ObservableList<SimpleDoubleProperty> getPoints()
    {
        return this.points;
    }


    private void calculatePoints(double newAmplitude, double newFrequency, double newPhase)
    {
        double scaleFactor = 1 / 100d;

        for (int i = 0; i < this.points.size() - 1; i += 2)
        {
            double x = i < this.points.size() / 2 ? -i : i - this.points.size() / 2;
            x = x * scaleFactor;
            double y = newAmplitude * Math.sin(newFrequency * x + newPhase);

            this.points.get(i).set(x);
            this.points.get(i + 1).set(y);
        }
    }
}