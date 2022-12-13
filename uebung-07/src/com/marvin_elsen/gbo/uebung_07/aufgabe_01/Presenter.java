package com.marvin_elsen.gbo.uebung_07.aufgabe_01;


public class Presenter
{
    private View view;

    private Model model;


    public Presenter()
    {
    }


    public void setView(View view)
    {
        this.view = view;
    }


    public void setModel(Model model)
    {
        this.model = model;
    }


    public void login(String loginName, String password)
    {
        if (loginName.isEmpty())
        {
            this.view.showInputError();
        }
        else if (this.model.isOkay(loginName, password))
        {
            this.view.showOkayMessage();
            this.view.logSuccessfulLogin();
            this.view.resetInput();
            this.model.resetLoginTries(loginName);
        }
        else
        {
            this.view.showLoginError();
            this.view.logUnsuccessfulLogin();
            this.model.incrementLoginTries(loginName);

            if (this.model.hasMaxLoginTriesBeenReached(loginName))
            {
                this.view.showTooManyTriesError();
            }
        }
    }
}