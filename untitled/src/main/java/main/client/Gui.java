package main.client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.model.*;

import java.io.IOException;
import java.util.List;

public class Gui implements View {
    Stage stage;

    public Gui(Stage stage) {
        this.stage=stage;
    }


    @Override
    public String getUsername() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("login_page.fxml"));
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        }catch (IOException e){
            e.printStackTrace();
        }
        stage.show();
        return null;
    }

    @Override
    public Wizards getWizard(List<Wizards> wizards) {
        return null;
    }

    @Override
    public Cloud getCloud(List<Cloud> clouds) {
        return null;
    }

    @Override
    public AssistantCard getAssistantCard(List<AssistantCard> cards) {
        return null;
    }

    @Override
    public int getNumStep(Player pl) {
        return 0;
    }

    @Override
    public void getWinner(Player pl) {

    }

    @Override
    public String getDestination(Match match) {
        return null;
    }

    @Override
    public void printMatch(Match match) {

    }

    @Override
    public void printTurn(Player pl, String phase) {

    }

    @Override
    public void lastRound() {

    }

    @Override
    public int getNumPlayer() {
        return 0;
    }

    @Override
    public Student getStudent(Player pl) {
        return null;
    }

    @Override
    public void getTitolo() {

    }

    @Override
    public void wakeUp(String state) {

    }

    @Override
    public void setMe(Player me) {

    }

    @Override
    public void setMatch(Match match) {

    }

    @Override
    public void setCards(List<AssistantCard> cards) {

    }

    @Override
    public void setWilly(List<Wizards> willy) {

    }

    @Override
    public void setClouds(List<Cloud> clouds) {

    }

    @Override
    public String chooseMatch(List<String> join, List<String> resume) {
        return null;
    }

    @Override
    public void setNack() {

    }

    @Override
    public String chooseLogin() {
        return null;
    }

    @Override
    public void run() {

    }
}
