package main.client;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Gui extends Application{

    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        Group root= new Group();
        Scene scene=new Scene(root);//ha come argument a noot node
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
