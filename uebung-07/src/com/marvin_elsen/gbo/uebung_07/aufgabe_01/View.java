package com.marvin_elsen.gbo.uebung_07.aufgabe_01;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.time.LocalDateTime;


public class View
{
    private Presenter presenter;

    private GridPane pane;

    private TextField loginName;

    private TextArea log;

    private PasswordField password;

    private Label status;


    public View(Presenter presenter)
    {
        this.presenter = presenter;
    }


    public void initView()
    {
        this.pane = new GridPane();
        Insets insets = new Insets(5);
        this.pane.setPadding(insets);
        this.pane.setHgap(2);
        this.pane.setVgap(5);

        this.pane.add(new Label("Login-Kennung:"), 0, 0);

        this.loginName = new TextField();
        this.pane.add(this.loginName, 1, 0);

        this.pane.add(new Label("Passwort:"), 0, 1);

        this.password = new PasswordField();
        this.pane.add(this.password, 1, 1);

        Button b = new Button("Login");
        this.pane.add(b, 0, 2, 2, 1);

        this.status = new Label();
        this.pane.add(this.status, 0, 3, 2, 1);

        this.log = new TextArea();
        this.log.setEditable(false);
        this.pane.add(this.log, 0, 4, 3, 1);

        Button clear = new Button("Liste löschen");
        clear.setOnAction(e -> this.onClearClick());
        this.pane.add(clear, 0, 5);

        EventHandler<ActionEvent> h = e -> this.handle();
        this.loginName.setOnAction(h);
        this.password.setOnAction(h);
        b.setOnAction(h);
    }


    private void handle()
    {
        String name = this.loginName.getText();
        String pw = this.password.getText();
        name = name.trim();
        pw = pw.trim();
        this.presenter.login(name, pw);
    }


    private void onClearClick()
    {
        this.resetInput();
        this.log.clear();
    }


    public Pane getUI()
    {
        return this.pane;
    }


    public void resetInput()
    {
        this.loginName.setText("");
        this.password.setText("");
    }


    public void clearFormatting()
    {
        this.status.setUnderline(false);
        this.status.setTextFill(Color.BLACK);
    }


    public void showOkayMessage()
    {
        this.clearFormatting();
        this.status.setText("Login erfolgreich.");
    }


    public void showInputError()
    {
        this.clearFormatting();
        this.status.setText("Keine Login-Kennung angegeben.");
    }


    public void showLoginError()
    {
        this.clearFormatting();
        this.status.setText("Login-Kennung bzw. Passwort falsch.");
    }


    public void logSuccessfulLogin()
    {
        this.clearFormatting();
        this.log.appendText(String.format("%s: %s hat sich erfolgreich angemeldet.\n", LocalDateTime.now(), this.loginName.getText()));
    }


    public void logUnsuccessfulLogin()
    {
        this.clearFormatting();
        this.log.appendText(String.format("%s: %s hat erfolglos versucht sich anzumelden.\n", LocalDateTime.now(), this.loginName.getText()));
    }


    public void showTooManyTriesError()
    {
        this.status.setText(String.format("Warnung: Wiederholter Fehlversuch für %s", this.loginName.getText()));
        this.status.setUnderline(true);
        this.status.setTextFill(Color.RED);
    }
}
