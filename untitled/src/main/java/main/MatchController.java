package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import main.client.Action;
import main.client.Message4Server;
import main.model.*;

import java.io.ObjectInputStream;

public class MatchController {
    private Match match;
    private Action action;
    private Player me;
    private Message4Server server;
    private ObjectInputStream in;
    private boolean selectedmn;
    private boolean selectedstudent;
    private Student assistantchoosen;
    @FXML
    Pane land_view;
    @FXML
    Pane board_view;
    @FXML
    ImageView cloud0;
    @FXML
    ImageView cloud1;
    @FXML
    ImageView cloud2;
    @FXML
    ImageView assistant0;
    @FXML
    ImageView assistant1;
    @FXML
    ImageView assistant2;
    @FXML
    ImageView assistant3;
    @FXML
    ImageView assistant4;
    @FXML
    ImageView assistant5;
    @FXML
    ImageView assistant6;
    @FXML
    ImageView assistant7;
    @FXML
    ImageView assistant8;
    @FXML
    ImageView assistant9;
    @FXML
    ImageView island0;
    @FXML
    ImageView island1;
    @FXML
    ImageView island2;
    @FXML
    ImageView island3;
    @FXML
    ImageView island4;
    @FXML
    ImageView island5;
    @FXML
    ImageView island6;
    @FXML
    ImageView island7;
    @FXML
    ImageView island8;
    @FXML
    ImageView island9;
    @FXML
    ImageView island10;
    @FXML
    ImageView island11;
    @FXML
    ImageView entry00;
    @FXML
    ImageView entry01;
    @FXML
    ImageView entry02;
    @FXML
    ImageView entry03;
    @FXML
    ImageView entry04;
    @FXML
    ImageView entry05;
    @FXML
    ImageView entry06;
    @FXML
    ImageView entry07;
    @FXML
    ImageView entry08;
    @FXML
    ImageView entry10;
    @FXML
    ImageView entry11;
    @FXML
    ImageView entry12;
    @FXML
    ImageView entry13;
    @FXML
    ImageView entry14;
    @FXML
    ImageView entry15;
    @FXML
    ImageView entry16;
    @FXML
    ImageView entry17;
    @FXML
    ImageView entry18;
    @FXML
    ImageView entry20;
    @FXML
    ImageView entry21;
    @FXML
    ImageView entry22;
    @FXML
    ImageView entry23;
    @FXML
    ImageView entry24;
    @FXML
    ImageView entry25;
    @FXML
    ImageView entry26;
    @FXML
    ImageView entry27;
    @FXML
    ImageView entry28;
    @FXML
    ImageView board0;
    @FXML
    ImageView board1;
    @FXML
    ImageView board2;

    public void moveto(MouseEvent mouseEvent) {
        int idland=-1;
        switch (((ImageView)mouseEvent.getSource()).getId()){
            case "island0":
                idland=0;
                break;
            case "island1":
                idland=1;
                break;
            case "island2":
                idland=2;
                break;
            case "island3":
                idland=3;
                break;
            case "island4":
                idland=4;
                break;
            case "island5":
                idland=5;
                break;
            case "island6":
                idland=6;
                break;
            case "island7":
                idland=7;
                break;
            case "island8":
                idland=8;
                break;
            case "island9":
                idland=9;
                break;
            case "island10":
                idland=10;
                break;
            case "island11":
                idland=11;
                break;
            case "board0":
                if(me==match.getPlayer()[0])
                    idland=12;
                break;
            case "board1":
                if(me==match.getPlayer()[1])
                    idland=12;
                break;
            case "board2":
                if(me==match.getPlayer()[2])
                    idland=12;
                break;
        }
        if(idland>=0){
            if(selectedmn){
               int indexmn=match.getLands().indexOf(match.getMotherNature().getPosition());
               int indexlandselected=-1;
                for (Land l: match.getLands()) {
                    if(l.getID()==idland)
                        indexlandselected=match.getLands().indexOf(l);
                }
                int step=0;
                if(indexlandselected>=0) {
                    if (indexmn < indexlandselected) {
                        step = indexlandselected - indexmn;
                    } else if (indexmn > indexlandselected) {
                        step = match.getLands().size() - 1 - indexmn;
                        step++;
                        step = step + indexlandselected;
                    }
                    if (step > 0 && step <= me.getPlayedCard().getMNSteps()) {
                        server.sendStepsMN(step);
                    }
                }
                selectedmn=false;
            }else if(selectedstudent){
                server.sendMovedStudent(assistantchoosen,idland);
                if(idland==12){
                    try {
                        action.moveFromIngressToBoard(me,assistantchoosen);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{
                    for (Land l: match.getLands()) {
                        if(l.getID()==idland)
                            action.moveFromIngressToLand(me,assistantchoosen,l);
                    }
                }
            }
        }
    }


    public void choose_cloud(MouseEvent mouseEvent) {
        switch (((ImageView)mouseEvent.getSource()).getId()){
            case "cloud0":
                action.chooseCloud(me,match.getCloud()[0]);
                server.sendChoiceCloud(match.getCloud()[0]);
                break;
            case "cloud1":
                action.chooseCloud(me,match.getCloud()[1]);
                server.sendChoiceCloud(match.getCloud()[1]);
                break;
            case "cloud2":
                action.chooseCloud(me,match.getCloud()[2]);
                server.sendChoiceCloud(match.getCloud()[2]);
                break;
        }
    }

    public void show_boards(ActionEvent actionEvent) {
        land_view.setVisible(false);
        board_view.setVisible(true);
    }

    public void use_assistant(MouseEvent mouseEvent) {
        switch (((ImageView)mouseEvent.getSource()).getId()){
            case "assistant0":
                for (AssistantCard a: me.getDeck()) {
                    if(a.getValue()==1){
                        server.sendChosenCard(a);
                        me.draw(a);
                        assistant1.setVisible(false);
                    }
                }
                break;
            case "assistant1":
                for (AssistantCard a: me.getDeck()) {
                   if(a.getValue()==2){
                       server.sendChosenCard(a);
                       me.draw(a);
                       assistant1.setVisible(false);
                   }
                }
                break;
            case "assistant2":
                for (AssistantCard a: me.getDeck()) {
                    if(a.getValue()==3){
                        server.sendChosenCard(a);
                        me.draw(a);
                        assistant1.setVisible(false);
                    }
                }
                break;
            case "assistant3":
                for (AssistantCard a: me.getDeck()) {
                    if(a.getValue()==4){
                        server.sendChosenCard(a);
                        me.draw(a);
                        assistant1.setVisible(false);
                    }
                }
                break;
            case "assistant4":
                for (AssistantCard a: me.getDeck()) {
                    if(a.getValue()==5){
                        server.sendChosenCard(a);
                        me.draw(a);
                        assistant1.setVisible(false);
                    }
                }
                break;
            case "assistant5":
                for (AssistantCard a: me.getDeck()) {
                    if(a.getValue()==6){
                        server.sendChosenCard(a);
                        me.draw(a);
                        assistant1.setVisible(false);
                    }
                }
                break;
            case "assistant6":
                for (AssistantCard a: me.getDeck()) {
                    if(a.getValue()==7){
                        server.sendChosenCard(a);
                        me.draw(a);
                        assistant1.setVisible(false);
                    }
                }
                break;
            case "assistant7":
                for (AssistantCard a: me.getDeck()) {
                    if(a.getValue()==8){
                        server.sendChosenCard(a);
                        me.draw(a);
                        assistant1.setVisible(false);
                    }
                }
                break;
            case "assistant8":
                for (AssistantCard a: me.getDeck()) {
                    if(a.getValue()==9){
                        server.sendChosenCard(a);
                        me.draw(a);
                        assistant1.setVisible(false);
                    }
                }
                break;
            case "assistant9":
                for (AssistantCard a: me.getDeck()) {
                    if(a.getValue()==10){
                        server.sendChosenCard(a);
                        me.draw(a);
                        assistant1.setVisible(false);
                    }
                }
                break;
        }
    }

    public void go_to_island(ActionEvent actionEvent) {
        board_view.setVisible(false);
        land_view.setVisible(true);
    }

    public void selectmn(MouseEvent mouseEvent) {
        selectedmn=true;
        selectedstudent=false;
    }

    private void selected(int pla,int stu){
        if(me==match.getPlayer()[pla]){
            selectedstudent=true;
            selectedmn=false;
            assistantchoosen=me.getBoard().getEntrance().get(stu);
        }
    }



    public void selectfromentry(MouseEvent mouseEvent) {
        switch (((ImageView)mouseEvent.getSource()).getId()){
            case "entry00":
                selected(0,0);
                break;
            case "entry01":
                selected(0,1);
                break;
            case "entry02":
                selected(0,2);
                break;
            case "entry03":
                selected(0,3);
                break;
            case "entry04":
                selected(0,4);
                break;
            case "entry05":
                selected(0,5);
                break;
            case "entry06":
                selected(0,6);
                break;
            case "entry07":
                selected(0,7);
                break;
            case "entry08":
                selected(0,8);
                break;
            case "entry09":
                selected(0,9);
                break;
            case "entry10":
                selected(1,0);
                break;
            case "entry11":
                selected(1,1);
                break;
            case "entry12":
                selected(1,2);
                break;
            case "entry13":
                selected(1,3);
                break;
            case "entry14":
                selected(1,4);
                break;
            case "entry15":
                selected(1,5);
                break;
            case "entry16":
                selected(1,6);
                break;
            case "entry17":
                selected(1,7);
                break;
            case "entry18":
                selected(1,8);
                break;
            case "entry19":
                selected(1,9);
                break;
            case "entry20":
                selected(2,0);
                break;
            case "entry21":
                selected(2,1);
                break;
            case "entry22":
                selected(2,2);
                break;
            case "entry23":
                selected(2,3);
                break;
            case "entry24":
                selected(2,4);
                break;
            case "entry25":
                selected(2,5);
                break;
            case "entry26":
                selected(2,6);
                break;
            case "entry27":
                selected(2,7);
                break;
            case "entry28":
                selected(2,8);
                break;
            case "entry29":
                selected(2,9);
                break;
        }

    }
}
