package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.client.Message4Server;
import main.client.View;
import main.model.Match;
import main.model.Wizards;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class MainController{

    Boolean newPlayer=false;
    static View gui;

    Message4Server server;
    ObjectInputStream in;
    Match match;
    @FXML
    Pane login_page;
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
    @FXML
    ChoiceBox<String> selectionGames;
    @FXML
    Button new_match;
    @FXML
    Pane first;
    @FXML
    Pane second;
    @FXML
    Pane third;
    @FXML
    Button wizard1;
    @FXML
    Button wizard2;
    @FXML
    Button wizard3;
    @FXML
    Button wizard4;
    @FXML
    ChoiceBox playernum;
    @FXML
    CheckBox expert;
    @FXML
    Button typematch;
    @FXML
    ImageView image;

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

    @FXML
    public void username(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        String us=username.getCharacters().toString();
        if(newPlayer){
            server.sendRegistration(us);
        }else{
            server.sendLogin(us);
        }
        String response= (String)in.readObject();
        if(response.equals("LoginFailed")){
            result_username.setText("Username errato.. Riprova");
        }else{
            ArrayList<String> join=new ArrayList<>();
            join=(ArrayList<String>) in.readObject();
            ArrayList<String> resume=new ArrayList<>();
            resume=(ArrayList<String>) in.readObject();
            join.addAll(resume);
            selectionGames.getItems().addAll(join);
            login_page.setVisible(false);
            first.setVisible(true);
        }
    }

    @FXML
    public void newGame(ActionEvent actionEvent) {
        first.setVisible(false);
        third.setVisible(true);
        playernum.getItems().add("2");
        playernum.getItems().add("3");
    }
    @FXML
    public void gameSelected(ActionEvent actionEvent) {
        server.sendChoosingGame(selectionGames.getValue());
        String response;
        try {
            response = (String) in.readObject();
            if (response.equals("Creation")) {
                match = (Match) in.readObject();
            }
            gui.printMatch(match);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void close(ActionEvent actionEvent) {
    }
    @FXML
    public void chooseWizard(ActionEvent actionEvent){
        switch (((Button)actionEvent.getSource()).getId()){
            case("wizard1"):
                server.sendChoice(Wizards.WIZARD1);
                break;
            case ("wizard2"):
                server.sendChoice(Wizards.WIZARD2);
                break;
            case ("wizard3"):
                server.sendChoice(Wizards.WIZARD3);
                break;
            case ("wizard4"):
                server.sendChoice(Wizards.WIZARD4);
                break;
        }
    }

    public void choosetypematch(ActionEvent actionEvent) {
        server.sendNumPlayers(Integer.parseInt((String) playernum.getValue()));
        server.sendExpertMatch(expert.isSelected());
        String response = null;
        first.setVisible(false);
        third.setVisible(false);
        second.setVisible(true);
        try {
            response = (String) in.readObject();
            List<Wizards> willy = new ArrayList<>();
            if (response.equals("Wizard")) {
                willy = (ArrayList<Wizards>) in.readObject();
                if (!willy.contains(Wizards.WIZARD1)) {
                    wizard1.setVisible(false);
                } else {
                    wizard1.setVisible(true);
                }
                if (!willy.contains(Wizards.WIZARD2)) {
                    wizard2.setVisible(false);
                }else {
                    wizard2.setVisible(true);
                }
                if (!willy.contains(Wizards.WIZARD3)) {
                    wizard3.setVisible(false);
                } else {
                    wizard3.setVisible(true);
                }
                if (!willy.contains(Wizards.WIZARD4)) {
                    wizard4.setVisible(false);
                } else {
                    wizard4.setVisible(true);
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
