package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.client.Action;
import main.client.Gui;
import main.client.View;
import main.model.Colors;
import main.model.Match;
import main.model.Player;
import main.model.Wizards;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Player p=new Player("ale", Colors.BLACK,8, Wizards.WIZARD1,false);
        Player p1=new Player("antonio", Colors.WHITE,8, Wizards.WIZARD2,false);
        Player p2=new Player("luigi", Colors.GREY,8, Wizards.WIZARD2,false);
        Match m=new Match(p,p1,p2);
        MatchController.setMatch(m);
        MatchController.setMe(p);
        MatchController.setAction(new Action(m));
        View gui=new Gui(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("prova.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Eriantys");
        MainController.setGui(gui);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }   

    public static void main(String[] args) {
        launch(args);
    }
}
