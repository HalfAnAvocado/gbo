package com.marvin_elsen.gbo.gui.graphics;


public class SinusPresenter
{
    private final SinusModel model;

    private SinusView view;


    public SinusPresenter(SinusModel model)
    {
        this.model = model;
    }


    public void setView(SinusView view)
    {
        this.view = view;
    }


    public void requestBindings()
    {
        this.view.setupBindings(this.model.amplitudeProperty(), this.model.frequencyProperty(), this.model.phaseProperty());
    }


    public void requestPoints()
    {
        this.view.setupPoints(this.model.getPoints());
    }
}