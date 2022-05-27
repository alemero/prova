package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.client.Message4Server;
import main.client.View;

import java.io.IOException;
import java.io.ObjectInputStream;

public class MainController {
    Boolean newPlayer=false;
    static View gui;

    Message4Server server;
    ObjectInputStream in;
    @FXML
    Button button;
    @FXML
    Button login;
    @FXML
    Button new_account;
    @FXML
    Button send_username;
    @FXML
    TextField username;
    @FXML
    Label result_username;

    public Message4Server getServer() {
        return server;
    }

    public void setServer(Message4Server server) {
        this.server = server;
    }

    public static View getGui() {
        return gui;
    }

    public static void setGui(View gu) {
        gui = gu;
    }


    public void soluzione(ActionEvent actionEvent) {
    }

    public void login_new(ActionEvent actionEvent) {
        newPlayer=true;
        gui.getUsername();
    }

    public void login_login(ActionEvent actionEvent) {
        gui.getUsername();
    }


    public void username(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        String us=username.getCharacters().toString();
        if(newPlayer){
            server.sendRegistration(us);
        }else{
            server.sendLogin(us);
        }
        String response=(String)in.readObject();
        if(response.equals("LoginFailed")){
            result_username.setText("Username errato.. Riprova");
        }else{

        }
    }


}
