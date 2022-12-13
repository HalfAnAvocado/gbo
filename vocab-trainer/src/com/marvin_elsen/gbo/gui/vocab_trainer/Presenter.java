package com.marvin_elsen.gbo.gui.vocab_trainer;


public class Presenter
{
    private View view;

    private Model model;


    public void setView(View view)
    {
        this.view = view;

        this.view.showGermanVocable(this.model.getGermanVocable(0));
    }


    public void setModel(Model model)
    {
        this.model = model;
    }


    public void checkVocable(String germanVocable, String englishVocable)
    {
        if (this.model.isCorrect(germanVocable, englishVocable))
        {
            this.view.showTranslationCorrect();
        }
        else
        {
            this.view.showTranslationError();
        }
    }


    public void germanVocableSelected(int index)
    {
        index = index % this.model.getVocableCount();

        this.view.showGermanVocable(this.model.getGermanVocable(index));
        this.view.resetInput();
    }
}
