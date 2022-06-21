package main.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.MainController;
import main.model.*;


import java.io.IOException;
import java.util.List;

public class Gui extends Application implements View {
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
    public void setServer(Message4Server server) {

    }

    @Override
    public Wizards getWizard(List<Wizards> wizards) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("chooseWizard.fxml"));
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("titolo.fxml"));
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("selection_game.fxml"));
        Scene scene=null;
        try {
            scene=fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.show();
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
    public Land chooseLand(List<Land> lands) {
        return null;
    }

    @Override
    public Student chooseStudent(List<Student> student) {
        return null;
    }

    @Override
    public Type_Student chooseColorStudent() {
        return null;
    }

    @Override
    public void playerConnected(String username) {

    }

    @Override
    public void playerDisconnected(String username) {

    }

    @Override
    public void playerDisconnectedAll() {

    }

    @Override
    public void finishedAC(Player p) {

    }

    @Override
    public CharacterCard chooseChCard(CharacterCard[] cards) {
        return null;
    }

    @Override
    public void setCharacters(CharacterCard[] characters) {

    }

    @Override
    public void run() {

    }


    @Override
    public void start(Stage stage) throws IOException {
        View gui=new Gui(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("prima_app.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Eriantys");
        MainController.setGui(gui);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        MainController a=new MainController();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
