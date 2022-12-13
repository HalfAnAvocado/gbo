package com.marvin_elsen.gbo.uebung_11.aufgabe_03;


import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;


class Delta
{
    double x;

    double y;
}


public class Anchor extends Circle
{
    private SimpleDoubleProperty polyPointXProperty;

    private SimpleDoubleProperty polyPointYProperty;

    private Delta dragDelta = new Delta();


    public Anchor(SimpleDoubleProperty polyPointXProperty, SimpleDoubleProperty polyPointYProperty)
    {
        super(polyPointXProperty.get(), polyPointYProperty.get(), 7);

        this.setFill(Color.rgb(255, 0, 0, 0.5));
        this.setStroke(Color.CRIMSON);
        this.setStrokeWidth(2);
        this.setStrokeType(StrokeType.OUTSIDE);

        this.polyPointXProperty = polyPointXProperty;
        this.polyPointYProperty = polyPointYProperty;

        polyPointXProperty.bind(this.centerXProperty());
        polyPointYProperty.bind(this.centerYProperty());

        this.setOnMouseEntered(e -> this.mouseEnter(e));
        this.setOnMouseExited(e -> this.mouseExit(e));
        this.setOnMousePressed(e -> this.startDrag(e));
        this.setOnMouseDragged(e -> this.continueDrag(e));
        this.setOnMouseReleased(e -> this.endDrag(e));
    }


    private void mouseEnter(MouseEvent event)
    {
        if (!event.isPrimaryButtonDown())
        {
            this.getScene().setCursor(Cursor.HAND);
        }
    }


    private void mouseExit(MouseEvent event)
    {
        if (!event.isPrimaryButtonDown())
        {
            this.getScene().setCursor(Cursor.DEFAULT);
        }
    }


    private void startDrag(MouseEvent event)
    {
        this.dragDelta.x = this.getCenterX() - event.getX();
        this.dragDelta.y = this.getCenterY() - event.getY();

        this.getScene().setCursor(Cursor.MOVE);
    }


    private void continueDrag(MouseEvent event)
    {
        this.setCenterX(event.getX() + this.dragDelta.x);
        this.setCenterY(event.getY() + this.dragDelta.y);
    }


    private void endDrag(MouseEvent event)
    {
        this.getScene().setCursor(Cursor.DEFAULT);
    }
}
