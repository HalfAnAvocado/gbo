package com.marvin_elsen.gbo.gui.vocab_trainer;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class View
{
    private Presenter presenter;

    private int nextClicks;

    @FXML
    private TextField translation;

    @FXML
    private Label status;

    @FXML
    private Label vocable;

    @FXML
    private Button check;

    @FXML
    private Button next;


    public void setPresenter(Presenter presenter)
    {
        this.presenter = presenter;
    }


    @FXML
    private void onTranslationAction()
    {
        String englishVocable = this.translation.getText().trim();
        String germanVocable = this.vocable.getText().trim();

        this.presenter.checkVocable(germanVocable, englishVocable);
    }


    @FXML
    private void onNextClick()
    {
        this.nextClicks++;
        this.presenter.germanVocableSelected(this.nextClicks);
    }


    public void resetInput()
    {
        this.translation.setText("");
        this.status.setText("");
    }


    public void showTranslationError()
    {
        this.status.setText("Die Lösung war falsch. Sie können es nochmals versuchen.");
    }


    public void showTranslationCorrect()
    {
        this.status.setText("Die Lösung war richtig.");
    }


    public void showGermanVocable(String germanVocable)
    {
        this.vocable.setText(germanVocable);
    }
}
