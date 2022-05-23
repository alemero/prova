package main.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import main.client.Gui;
import main.client.View;

public class ViewController {
    Boolean newPlayer=false;
    static View gui;

    public static View getGui() {
        return gui;
    }

    public static void setGui(View gu) {
        gui = gu;
    }

    @FXML
    Button new_account;

    @FXML
    Button login;

    public void login_new(ActionEvent actionEvent) {
        newPlayer=true;
        gui.getUsername();
    }

    public void login_login(ActionEvent actionEvent) {
        gui.getUsername();
    }
}
