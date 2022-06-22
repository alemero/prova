package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.client.*;
import main.model.*;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Player p=new Player("ale", Colors.BLACK,8, Wizards.WIZARD1,false);
        Player p1=new Player("antonio", Colors.WHITE,8, Wizards.WIZARD2,false);
        Player p2=new Player("luigi", Colors.GREY,8, Wizards.WIZARD3,false);
        Expert_Match m=new Expert_Match(p,p1,p2);
        m.setCard();
        try {
            m.getCloud()[0].importStudents();
            m.getCloud()[1].importStudents();
            m.getCloud()[2].importStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Player player:m.getPlayer()) {
            ArrayList<Student> a=new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                try {
                    a.add(m.getBag().getRandomStudent());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                player.getBoard().setEntrance(a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        MatchController.setme(p);
        MatchController.setmatch(m);
        MatchController.setAction(new Action(m));
        View gui=new Gui(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("prova.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Eriantys");
        MainController.setGui(gui);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

        Thread thread=new Thread((MatchController)fxmlLoader.getController());
        thread.setDaemon(true);
        thread.start();
        /*Thread th=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        this.wait(11000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                ArrayList<Tower> temp=new ArrayList<>();
                temp.add(p.getBoard().getTowers().get(1));
                try {
                    MatchController.getMatch().getLands().get(1).changeTower(temp);
                    MatchController.getMatch().getLands().get(0).changeTower(temp);
                    MatchController.getMatch().uniteLandBefore(1);
                    MatchController.getMatch().moveMotherNature(3);
                    MatchController.getMatch().moveMotherNature(5);
                    MatchController.getMatch().moveMotherNature(5);
                    p.draw(p.getDeck().get(0));
                    p.getBoard().removeTower();
                    for (Type_Student e:Type_Student.values()) {
                        m.checkProfessor(e);
                    }
                    synchronized (fxmlLoader.getController()) {
                        fxmlLoader.getController().notifyAll();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        th.start();*/
    }   

    public static void main(String[] args) {
        launch(args);
    }
}
