package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import main.client.Action;
import main.client.Message4Server;
import main.model.*;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Map;

public class MatchController{
    private static Match match;
    private static Action action;
    private static Player me;
    private static Message4Server server;
    private static ObjectInputStream in;
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
    @FXML
    HBox green0;
    @FXML
    HBox green1;
    @FXML
    HBox green2;
    @FXML
    HBox red0;
    @FXML
    HBox red1;
    @FXML
    HBox red2;
    @FXML
    HBox yellow0;
    @FXML
    HBox yellow1;
    @FXML
    HBox yellow2;
    @FXML
    HBox pink0;
    @FXML
    HBox pink1;
    @FXML
    HBox pink2;
    @FXML
    HBox blue0;
    @FXML
    HBox blue1;
    @FXML
    HBox blue2;
    @FXML
    Label name0;
    @FXML
    Label name1;
    @FXML
    Label name2;
    @FXML
    ImageView profred0;
    @FXML
    ImageView profred1;
    @FXML
    ImageView profred2;
    @FXML
    ImageView profgreen0;
    @FXML
    ImageView profgreen1;
    @FXML
    ImageView profgreen2;
    @FXML
    ImageView profyellow0;
    @FXML
    ImageView profyellow1;
    @FXML
    ImageView profyellow2;
    @FXML
    ImageView profblue0;
    @FXML
    ImageView profblue1;
    @FXML
    ImageView profblue2;
    @FXML
    ImageView profpink0;
    @FXML
    ImageView profpink1;
    @FXML
    ImageView profpink2;
    @FXML
    ImageView tower00;
    @FXML
    ImageView tower01;
    @FXML
    ImageView tower02;
    @FXML
    ImageView tower03;
    @FXML
    ImageView tower04;
    @FXML
    ImageView tower05;
    @FXML
    ImageView tower06;
    @FXML
    ImageView tower07;
    @FXML
    ImageView tower10;
    @FXML
    ImageView tower11;
    @FXML
    ImageView tower12;
    @FXML
    ImageView tower13;
    @FXML
    ImageView tower14;
    @FXML
    ImageView tower15;
    @FXML
    ImageView tower16;
    @FXML
    ImageView tower17;
    @FXML
    ImageView tower20;
    @FXML
    ImageView tower21;
    @FXML
    ImageView tower22;
    @FXML
    ImageView tower23;
    @FXML
    ImageView tower24;
    @FXML
    ImageView tower25;
    @FXML
    ImageView tower26;
    @FXML
    ImageView tower27;
    @FXML
    ImageView white0;
    @FXML
    ImageView white1;
    @FXML
    ImageView white2;
    @FXML
    ImageView white3;
    @FXML
    ImageView white4;
    @FXML
    ImageView white5;
    @FXML
    ImageView white6;
    @FXML
    ImageView white7;
    @FXML
    ImageView white8;
    @FXML
    ImageView white9;
    @FXML
    ImageView white10;
    @FXML
    ImageView white11;
    @FXML
    ImageView black0;
    @FXML
    ImageView black1;
    @FXML
    ImageView black2;
    @FXML
    ImageView black3;
    @FXML
    ImageView black4;
    @FXML
    ImageView black5;
    @FXML
    ImageView black6;
    @FXML
    ImageView black7;
    @FXML
    ImageView black8;
    @FXML
    ImageView black9;
    @FXML
    ImageView black10;
    @FXML
    ImageView black11;
    @FXML
    ImageView grey0;
    @FXML
    ImageView grey1;
    @FXML
    ImageView grey2;
    @FXML
    ImageView grey3;
    @FXML
    ImageView grey4;
    @FXML
    ImageView grey5;
    @FXML
    ImageView grey6;
    @FXML
    ImageView grey7;
    @FXML
    ImageView grey8;
    @FXML
    ImageView grey9;
    @FXML
    ImageView grey10;
    @FXML
    ImageView grey11;
    @FXML
    ImageView mn0;
    @FXML
    ImageView mn1;
    @FXML
    ImageView mn2;
    @FXML
    ImageView mn3;
    @FXML
    ImageView mn4;
    @FXML
    ImageView mn5;
    @FXML
    ImageView mn6;
    @FXML
    ImageView mn7;
    @FXML
    ImageView mn8;
    @FXML
    ImageView mn9;
    @FXML
    ImageView mn10;
    @FXML
    ImageView mn11;
    @FXML
    Label red_0;
    @FXML
    Label red_1;
    @FXML
    Label red_2;
    @FXML
    Label red_3;
    @FXML
    Label red_4;
    @FXML
    Label red_5;
    @FXML
    Label red_6;
    @FXML
    Label red_7;
    @FXML
    Label red_8;
    @FXML
    Label red_9;
    @FXML
    Label red_10;
    @FXML
    Label red_11;
    @FXML
    Label blue_0;
    @FXML
    Label blue_1;
    @FXML
    Label blue_2;
    @FXML
    Label blue_3;
    @FXML
    Label blue_4;
    @FXML
    Label blue_5;
    @FXML
    Label blue_6;
    @FXML
    Label blue_7;
    @FXML
    Label blue_8;
    @FXML
    Label blue_9;
    @FXML
    Label blue_10;
    @FXML
    Label blue_11;
    @FXML
    Label green_0;
    @FXML
    Label green_1;
    @FXML
    Label green_2;
    @FXML
    Label green_3;
    @FXML
    Label green_4;
    @FXML
    Label green_5;
    @FXML
    Label green_6;
    @FXML
    Label green_7;
    @FXML
    Label green_8;
    @FXML
    Label green_9;
    @FXML
    Label green_10;
    @FXML
    Label green_11;
    @FXML
    Label pink_0;
    @FXML
    Label pink_1;
    @FXML
    Label pink_2;
    @FXML
    Label pink_3;
    @FXML
    Label pink_4;
    @FXML
    Label pink_5;
    @FXML
    Label pink_6;
    @FXML
    Label pink_7;
    @FXML
    Label pink_8;
    @FXML
    Label pink_9;
    @FXML
    Label pink_10;
    @FXML
    Label pink_11;
    @FXML
    Label yellow_0;
    @FXML
    Label yellow_1;
    @FXML
    Label yellow_2;
    @FXML
    Label yellow_3;
    @FXML
    Label yellow_4;
    @FXML
    Label yellow_5;
    @FXML
    Label yellow_6;
    @FXML
    Label yellow_7;
    @FXML
    Label yellow_8;
    @FXML
    Label yellow_9;
    @FXML
    Label yellow_10;
    @FXML
    Label yellow_11;
    @FXML
    AnchorPane land0;
    @FXML
    AnchorPane land1;
    @FXML
    AnchorPane land2;
    @FXML
    AnchorPane land3;
    @FXML
    AnchorPane land4;
    @FXML
    AnchorPane land5;
    @FXML
    AnchorPane land6;
    @FXML
    AnchorPane land7;
    @FXML
    AnchorPane land8;
    @FXML
    AnchorPane land9;
    @FXML
    AnchorPane land10;
    @FXML
    AnchorPane land11;
    @FXML
    Label size0;
    @FXML
    Label size1;
    @FXML
    Label size2;
    @FXML
    Label size3;
    @FXML
    Label size4;
    @FXML
    Label size5;
    @FXML
    Label size6;
    @FXML
    Label size7;
    @FXML
    Label size8;
    @FXML
    Label size9;
    @FXML
    Label size10;
    @FXML
    Label size11;

    public void initialize(){
        white0.setVisible(false);
        white1.setVisible(false);
        white2.setVisible(false);
        white3.setVisible(false);
        white4.setVisible(false);
        white5.setVisible(false);
        white6.setVisible(false);
        white7.setVisible(false);
        white8.setVisible(false);
        white9.setVisible(false);
        white10.setVisible(false);
        white11.setVisible(false);
        black0.setVisible(false);
        black1.setVisible(false);
        black2.setVisible(false);
        black3.setVisible(false);
        black4.setVisible(false);
        black5.setVisible(false);
        black6.setVisible(false);
        black7.setVisible(false);
        black8.setVisible(false);
        black9.setVisible(false);
        black10.setVisible(false);
        black11.setVisible(false);
        grey0.setVisible(false);
        grey1.setVisible(false);
        grey2.setVisible(false);
        grey3.setVisible(false);
        grey4.setVisible(false);
        grey5.setVisible(false);
        grey6.setVisible(false);
        grey7.setVisible(false);
        grey8.setVisible(false);
        grey9.setVisible(false);
        grey10.setVisible(false);
        grey11.setVisible(false);
        mn1.setVisible(false);
        mn2.setVisible(false);
        mn3.setVisible(false);
        mn4.setVisible(false);
        mn5.setVisible(false);
        mn6.setVisible(false);
        mn7.setVisible(false);
        mn8.setVisible(false);
        mn9.setVisible(false);
        mn10.setVisible(false);
        mn11.setVisible(false);
        ArrayList<Type_Student> temp=new ArrayList<>();
        temp.add(Type_Student.DRAGON);
        red_1.setText(":"+match.getLands().get(1).getInfluence(temp));
        red_2.setText(":"+match.getLands().get(2).getInfluence(temp));
        red_3.setText(":"+match.getLands().get(3).getInfluence(temp));
        red_4.setText(":"+match.getLands().get(4).getInfluence(temp));
        red_5.setText(":"+match.getLands().get(5).getInfluence(temp));
        red_7.setText(":"+match.getLands().get(7).getInfluence(temp));
        red_8.setText(":"+match.getLands().get(8).getInfluence(temp));
        red_9.setText(":"+match.getLands().get(9).getInfluence(temp));
        red_10.setText(":"+match.getLands().get(10).getInfluence(temp));
        red_11.setText(":"+match.getLands().get(11).getInfluence(temp));
        temp.remove(0);
        temp.add(Type_Student.UNICORN);
        blue_1.setText(":"+match.getLands().get(1).getInfluence(temp));
        blue_2.setText(":"+match.getLands().get(2).getInfluence(temp));
        blue_3.setText(":"+match.getLands().get(3).getInfluence(temp));
        blue_4.setText(":"+match.getLands().get(4).getInfluence(temp));
        blue_5.setText(":"+match.getLands().get(5).getInfluence(temp));
        blue_7.setText(":"+match.getLands().get(7).getInfluence(temp));
        blue_8.setText(":"+match.getLands().get(8).getInfluence(temp));
        blue_9.setText(":"+match.getLands().get(9).getInfluence(temp));
        blue_10.setText(":"+match.getLands().get(10).getInfluence(temp));
        blue_11.setText(":"+match.getLands().get(11).getInfluence(temp));
        temp.remove(0);
        temp.add(Type_Student.FROG);
        green_1.setText(":"+match.getLands().get(1).getInfluence(temp));
        green_2.setText(":"+match.getLands().get(2).getInfluence(temp));
        green_3.setText(":"+match.getLands().get(3).getInfluence(temp));
        green_4.setText(":"+match.getLands().get(4).getInfluence(temp));
        green_5.setText(":"+match.getLands().get(5).getInfluence(temp));
        green_7.setText(":"+match.getLands().get(7).getInfluence(temp));
        green_8.setText(":"+match.getLands().get(8).getInfluence(temp));
        green_9.setText(":"+match.getLands().get(9).getInfluence(temp));
        green_10.setText(":"+match.getLands().get(10).getInfluence(temp));
        green_11.setText(":"+match.getLands().get(11).getInfluence(temp));
        temp.remove(0);
        temp.add(Type_Student.FAIRIE);
        pink_1.setText(":"+match.getLands().get(1).getInfluence(temp));
        pink_2.setText(":"+match.getLands().get(2).getInfluence(temp));
        pink_3.setText(":"+match.getLands().get(3).getInfluence(temp));
        pink_4.setText(":"+match.getLands().get(4).getInfluence(temp));
        pink_5.setText(":"+match.getLands().get(5).getInfluence(temp));
        pink_7.setText(":"+match.getLands().get(7).getInfluence(temp));
        pink_8.setText(":"+match.getLands().get(8).getInfluence(temp));
        pink_9.setText(":"+match.getLands().get(9).getInfluence(temp));
        pink_10.setText(":"+match.getLands().get(10).getInfluence(temp));
        pink_11.setText(":"+match.getLands().get(11).getInfluence(temp));
        temp.remove(0);
        temp.add(Type_Student.GNOME);
        yellow_1.setText(":"+match.getLands().get(1).getInfluence(temp));
        yellow_2.setText(":"+match.getLands().get(2).getInfluence(temp));
        yellow_3.setText(":"+match.getLands().get(3).getInfluence(temp));
        yellow_4.setText(":"+match.getLands().get(4).getInfluence(temp));
        yellow_5.setText(":"+match.getLands().get(5).getInfluence(temp));
        yellow_7.setText(":"+match.getLands().get(7).getInfluence(temp));
        yellow_8.setText(":"+match.getLands().get(8).getInfluence(temp));
        yellow_9.setText(":"+match.getLands().get(9).getInfluence(temp));
        yellow_10.setText(":"+match.getLands().get(10).getInfluence(temp));
        yellow_11.setText(":"+match.getLands().get(11).getInfluence(temp));
    }

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
        selectedstudent=false;
        selectedmn=false;
    }


    public void choose_cloud(MouseEvent mouseEvent) {
        switch (((ImageView) mouseEvent.getSource()).getId()) {
            case "cloud0" -> {
                action.chooseCloud(me, match.getCloud()[0]);
                server.sendChoiceCloud(match.getCloud()[0]);
            }
            case "cloud1" -> {
                action.chooseCloud(me, match.getCloud()[1]);
                server.sendChoiceCloud(match.getCloud()[1]);
            }
            case "cloud2" -> {
                action.chooseCloud(me, match.getCloud()[2]);
                server.sendChoiceCloud(match.getCloud()[2]);
            }
        }
    }

    private void show_towers(int i){
        Player pl=match.getPlayer()[i];
        Image colored_tower=null;
        switch (pl.getColor()){
            case GREY -> colored_tower=new Image("file:wooden_pieces/wooden_pieces/grey_tower.png");
            case BLACK -> colored_tower=new Image("file:src/main/resources/wooden_pieces/wooden_pieces/black_tower.png");
            case WHITE -> colored_tower=new Image("file:wooden_pieces/wooden_pieces/white_tower.png");
        }

        switch (i) {
            case 0 -> {
                tower00.setImage(colored_tower);
                tower00.setVisible(pl.getBoard().getTowersNum() >= 1);
                tower01.setImage(colored_tower);
                tower01.setVisible(pl.getBoard().getTowersNum() >= 2);
                tower02.setImage(colored_tower);
                tower02.setVisible(pl.getBoard().getTowersNum() >= 3);
                tower03.setImage(colored_tower);
                tower03.setVisible(pl.getBoard().getTowersNum() >= 4);
                tower04.setImage(colored_tower);
                tower04.setVisible(pl.getBoard().getTowersNum() >= 5);
                tower05.setImage(colored_tower);
                tower05.setVisible(pl.getBoard().getTowersNum() >= 6);
                tower06.setImage(colored_tower);
                tower06.setVisible(pl.getBoard().getTowersNum() >= 7);
                tower07.setImage(colored_tower);
                tower07.setVisible(pl.getBoard().getTowersNum() >= 8);
            }
            case 1 -> {
                tower10.setImage(colored_tower);
                tower10.setVisible(pl.getBoard().getTowersNum() >= 1);
                tower11.setImage(colored_tower);
                tower11.setVisible(pl.getBoard().getTowersNum() >= 2);
                tower12.setImage(colored_tower);
                tower12.setVisible(pl.getBoard().getTowersNum() >= 3);
                tower13.setImage(colored_tower);
                tower13.setVisible(pl.getBoard().getTowersNum() >= 4);
                tower14.setImage(colored_tower);
                tower14.setVisible(pl.getBoard().getTowersNum() >= 5);
                tower15.setImage(colored_tower);
                tower15.setVisible(pl.getBoard().getTowersNum() >= 6);
                tower16.setImage(colored_tower);
                tower16.setVisible(pl.getBoard().getTowersNum() >= 7);
                tower17.setImage(colored_tower);
                tower17.setVisible(pl.getBoard().getTowersNum() >= 8);
            }
            case 2 -> {
                tower20.setImage(colored_tower);
                tower20.setVisible(pl.getBoard().getTowersNum() >= 1);
                tower21.setImage(colored_tower);
                tower21.setVisible(pl.getBoard().getTowersNum() >= 2);
                tower22.setImage(colored_tower);
                tower22.setVisible(pl.getBoard().getTowersNum() >= 3);
                tower23.setImage(colored_tower);
                tower23.setVisible(pl.getBoard().getTowersNum() >= 4);
                tower24.setImage(colored_tower);
                tower24.setVisible(pl.getBoard().getTowersNum() >= 5);
                tower25.setImage(colored_tower);
                tower25.setVisible(pl.getBoard().getTowersNum() >= 6);
                tower26.setImage(colored_tower);
                tower26.setVisible(pl.getBoard().getTowersNum() >= 7);
                tower27.setImage(colored_tower);
                tower27.setVisible(pl.getBoard().getTowersNum() >= 8);
            }
        }
    }

    private void show(int i){
        Player pl=match.getPlayer()[i];
        Map<Type_Student,Player> professors=match.getProfessors();
        int num_red=pl.getBoard().getStudentsOfType(Type_Student.DRAGON);
        int num_blue=pl.getBoard().getStudentsOfType(Type_Student.UNICORN);
        int num_yellow=pl.getBoard().getStudentsOfType(Type_Student.GNOME);
        int num_green=pl.getBoard().getStudentsOfType(Type_Student.FROG);
        int num_pink=pl.getBoard().getStudentsOfType(Type_Student.FAIRIE);
        switch (i) {
            case 0 -> {
                name0.setText(match.getPlayer()[0].getUserName());
                for (Node e : red0.getChildren()) {
                    if (num_red > 0) {
                        e.setVisible(true);
                        num_red--;
                    } else {
                        e.setVisible(false);
                    }
                }
                for (Node e : green0.getChildren()) {
                    if (num_green > 0) {
                        e.setVisible(true);
                        num_green--;
                    } else {
                        e.setVisible(false);
                    }
                }
                for (Node e : yellow0.getChildren()) {
                    if (num_yellow > 0) {
                        e.setVisible(true);
                        num_yellow--;
                    } else {
                        e.setVisible(false);
                    }
                }
                for (Node e : blue0.getChildren()) {
                    if (num_blue > 0) {
                        e.setVisible(true);
                        num_blue--;
                    } else {
                        e.setVisible(false);
                    }
                }
                for (Node e : pink0.getChildren()) {
                    if (num_pink > 0) {
                        e.setVisible(true);
                        num_pink--;
                    } else {
                        e.setVisible(false);
                    }
                }
                profred0.setVisible(professors.containsKey(Type_Student.DRAGON) && professors.get(Type_Student.DRAGON) == pl);
                profblue0.setVisible(professors.containsKey(Type_Student.UNICORN) && professors.get(Type_Student.UNICORN) == pl);
                profgreen0.setVisible(professors.containsKey(Type_Student.FROG) && professors.get(Type_Student.FROG) == pl);
                profyellow0.setVisible(professors.containsKey(Type_Student.GNOME) && professors.get(Type_Student.GNOME) == pl);
                profpink0.setVisible(professors.containsKey(Type_Student.FAIRIE) && professors.get(Type_Student.FAIRIE) == pl);
            }
            case 1 -> {
                name1.setText(match.getPlayer()[1].getUserName());
                for (Node e : red1.getChildren()) {
                    if (num_red > 0) {
                        e.setVisible(true);
                        num_red--;
                    } else {
                        e.setVisible(false);
                    }
                }
                for (Node e : green1.getChildren()) {
                    if (num_green > 0) {
                        e.setVisible(true);
                        num_green--;
                    } else {
                        e.setVisible(false);
                    }
                }
                for (Node e : yellow1.getChildren()) {
                    if (num_yellow > 0) {
                        e.setVisible(true);
                        num_yellow--;
                    } else {
                        e.setVisible(false);
                    }
                }
                for (Node e : blue1.getChildren()) {
                    if (num_blue > 0) {
                        e.setVisible(true);
                        num_blue--;
                    } else {
                        e.setVisible(false);
                    }
                }
                for (Node e : pink1.getChildren()) {
                    if (num_pink > 0) {
                        e.setVisible(true);
                        num_pink--;
                    } else {
                        e.setVisible(false);
                    }
                }
                profred1.setVisible(professors.containsKey(Type_Student.DRAGON) && professors.get(Type_Student.DRAGON) == pl);
                profblue1.setVisible(professors.containsKey(Type_Student.UNICORN) && professors.get(Type_Student.UNICORN) == pl);
                profgreen1.setVisible(professors.containsKey(Type_Student.FROG) && professors.get(Type_Student.FROG) == pl);
                profyellow1.setVisible(professors.containsKey(Type_Student.GNOME) && professors.get(Type_Student.GNOME) == pl);
                profpink1.setVisible(professors.containsKey(Type_Student.FAIRIE) && professors.get(Type_Student.FAIRIE) == pl);
            }
            case 2 -> {
                name2.setText(match.getPlayer()[2].getUserName());
                for (Node e : red2.getChildren()) {
                    if (num_red > 0) {
                        e.setVisible(true);
                        num_red--;
                    } else {
                        e.setVisible(false);
                    }
                }
                for (Node e : green2.getChildren()) {
                    if (num_green > 0) {
                        e.setVisible(true);
                        num_green--;
                    } else {
                        e.setVisible(false);
                    }
                }
                for (Node e : yellow2.getChildren()) {
                    if (num_yellow > 0) {
                        e.setVisible(true);
                        num_yellow--;
                    } else {
                        e.setVisible(false);
                    }
                }
                for (Node e : blue2.getChildren()) {
                    if (num_blue > 0) {
                        e.setVisible(true);
                        num_blue--;
                    } else {
                        e.setVisible(false);
                    }
                }
                for (Node e : pink2.getChildren()) {
                    if (num_pink > 0) {
                        e.setVisible(true);
                        num_pink--;
                    } else {
                        e.setVisible(false);
                    }
                }
                profred2.setVisible(professors.containsKey(Type_Student.DRAGON) && professors.get(Type_Student.DRAGON) == pl);
                profblue2.setVisible(professors.containsKey(Type_Student.UNICORN) && professors.get(Type_Student.UNICORN) == pl);
                profgreen2.setVisible(professors.containsKey(Type_Student.FROG) && professors.get(Type_Student.FROG) == pl);
                profyellow2.setVisible(professors.containsKey(Type_Student.GNOME) && professors.get(Type_Student.GNOME) == pl);
                profpink2.setVisible(professors.containsKey(Type_Student.FAIRIE) && professors.get(Type_Student.FAIRIE) == pl);
            }
        }
    }

    public void show_boards(ActionEvent actionEvent) {
        land_view.setVisible(false);
        board_view.setVisible(true);
        for (int i = 0; i < match.getPlayer().length; i++) {
            show(i);
            show_towers(i);
        }
        for (AssistantCard a: me.getDeck()) {
            if(a.getValue()==1) {
                assistant0.setVisible(true);
                break;
            }
        }
        for (AssistantCard a: me.getDeck()) {
            if(a.getValue()==2) {
                assistant1.setVisible(true);
                break;
            }
        }
        for (AssistantCard a: me.getDeck()) {
            if(a.getValue()==3) {
                assistant2.setVisible(true);
                break;
            }
        }
        for (AssistantCard a: me.getDeck()) {
            if(a.getValue()==4) {
                assistant3.setVisible(true);
                break;
            }
        }
        for (AssistantCard a: me.getDeck()) {
            if(a.getValue()==5) {
                assistant4.setVisible(true);
                break;
            }
        }
        for (AssistantCard a: me.getDeck()) {
            if(a.getValue()==6) {
                assistant5.setVisible(true);
                break;
            }
        }
        for (AssistantCard a: me.getDeck()) {
            if(a.getValue()==7) {
                assistant6.setVisible(true);
                break;
            }
        }
        for (AssistantCard a: me.getDeck()) {
            if(a.getValue()==8) {
                assistant7.setVisible(true);
                break;
            }
        }
        for (AssistantCard a: me.getDeck()) {
            if(a.getValue()==9) {
                assistant8.setVisible(true);
                break;
            }
        }
        for (AssistantCard a: me.getDeck()) {
            if (a.getValue() == 10) {
                assistant9.setVisible(true);
                break;
            }
        }
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

    private void print_island(int i,Land l){
        ArrayList<Type_Student> dragon=new ArrayList<>();
        dragon.add(Type_Student.DRAGON);
        ArrayList<Type_Student> gnome=new ArrayList<>();
        gnome.add(Type_Student.GNOME);
        ArrayList<Type_Student> fairie=new ArrayList<>();
        fairie.add(Type_Student.FAIRIE);
        ArrayList<Type_Student> frog=new ArrayList<>();
        frog.add(Type_Student.FROG);
        ArrayList<Type_Student> unicorn=new ArrayList<>();
        unicorn.add(Type_Student.UNICORN);
        switch (i) {
            case 0 -> {
                red_0.setText(":" + l.getInfluence(dragon));
                blue_0.setText(":" + l.getInfluence(unicorn));
                yellow_0.setText(":" + l.getInfluence(gnome));
                pink_0.setText(":" + l.getInfluence(fairie));
                green_0.setText(":" + l.getInfluence(frog));
                mn0.setVisible(match.getMotherNature().getPosition() == l);
                Integer temp = l.size();
                size0.setText(temp.toString());
                try {
                    switch (l.getTowerColor()) {
                        case WHITE -> {
                            white0.setVisible(true);
                            black0.setVisible(false);
                            grey0.setVisible(false);
                        }
                        case BLACK -> {
                            white0.setVisible(false);
                            black0.setVisible(true);
                            grey0.setVisible(false);
                        }
                        case GREY -> {
                            white0.setVisible(false);
                            black0.setVisible(false);
                            grey0.setVisible(true);
                        }
                    }
                } catch (Exception e) {
                    white0.setVisible(false);
                    black0.setVisible(false);
                    grey0.setVisible(false);
                }
            }
            case 1 -> {
                red_1.setText(":" + l.getInfluence(dragon));
                blue_1.setText(":" + l.getInfluence(unicorn));
                yellow_1.setText(":" + l.getInfluence(gnome));
                pink_1.setText(":" + l.getInfluence(fairie));
                green_1.setText(":" + l.getInfluence(frog));
                mn1.setVisible(match.getMotherNature().getPosition() == l);
                Integer temp = l.size();
                size1.setText(temp.toString());
                try {
                    switch (l.getTowerColor()) {
                        case WHITE -> {
                            white1.setVisible(true);
                            black1.setVisible(false);
                            grey1.setVisible(false);
                        }
                        case BLACK -> {
                            white1.setVisible(false);
                            black1.setVisible(true);
                            grey1.setVisible(false);
                        }
                        case GREY -> {
                            white1.setVisible(false);
                            black1.setVisible(false);
                            grey1.setVisible(true);
                        }
                    }
                } catch (Exception e) {
                    white1.setVisible(false);
                    black1.setVisible(false);
                    grey1.setVisible(false);
                }
            }
            case 2 -> {
                red_2.setText(":" + l.getInfluence(dragon));
                blue_2.setText(":" + l.getInfluence(unicorn));
                yellow_2.setText(":" + l.getInfluence(gnome));
                pink_2.setText(":" + l.getInfluence(fairie));
                green_2.setText(":" + l.getInfluence(frog));
                mn2.setVisible(match.getMotherNature().getPosition() == l);
                Integer temp = l.size();
                size2.setText(temp.toString());
                try {
                    switch (l.getTowerColor()) {
                        case WHITE -> {
                            white2.setVisible(true);
                            black2.setVisible(false);
                            grey2.setVisible(false);
                        }
                        case BLACK -> {
                            white2.setVisible(false);
                            black2.setVisible(true);
                            grey2.setVisible(false);
                        }
                        case GREY -> {
                            white2.setVisible(false);
                            black2.setVisible(false);
                            grey2.setVisible(true);
                        }
                    }
                } catch (Exception e) {
                    white2.setVisible(false);
                    black2.setVisible(false);
                    grey2.setVisible(false);
                }
            }
            case 3 -> {
                red_3.setText(":" + l.getInfluence(dragon));
                blue_3.setText(":" + l.getInfluence(unicorn));
                yellow_3.setText(":" + l.getInfluence(gnome));
                pink_3.setText(":" + l.getInfluence(fairie));
                green_3.setText(":" + l.getInfluence(frog));
                mn3.setVisible(match.getMotherNature().getPosition() == l);
                Integer temp = l.size();
                size3.setText(temp.toString());
                try {
                    switch (l.getTowerColor()) {
                        case WHITE -> {
                            white3.setVisible(true);
                            black3.setVisible(false);
                            grey3.setVisible(false);
                        }
                        case BLACK -> {
                            white3.setVisible(false);
                            black3.setVisible(true);
                            grey3.setVisible(false);
                        }
                        case GREY -> {
                            white3.setVisible(false);
                            black3.setVisible(false);
                            grey3.setVisible(true);
                        }
                    }
                } catch (Exception e) {
                    white3.setVisible(false);
                    black3.setVisible(false);
                    grey3.setVisible(false);
                }
            }
            case 4 -> {
                red_4.setText(":" + l.getInfluence(dragon));
                blue_4.setText(":" + l.getInfluence(unicorn));
                yellow_4.setText(":" + l.getInfluence(gnome));
                pink_4.setText(":" + l.getInfluence(fairie));
                green_4.setText(":" + l.getInfluence(frog));
                mn4.setVisible(match.getMotherNature().getPosition() == l);
                Integer temp = l.size();
                size4.setText(temp.toString());
                try {
                    switch (l.getTowerColor()) {
                        case WHITE -> {
                            white4.setVisible(true);
                            black4.setVisible(false);
                            grey4.setVisible(false);
                        }
                        case BLACK -> {
                            white4.setVisible(false);
                            black4.setVisible(true);
                            grey4.setVisible(false);
                        }
                        case GREY -> {
                            white4.setVisible(false);
                            black4.setVisible(false);
                            grey4.setVisible(true);
                        }
                    }
                } catch (Exception e) {
                    white4.setVisible(false);
                    black4.setVisible(false);
                    grey4.setVisible(false);
                }
            }
            case 5 -> {
                red_5.setText(":" + l.getInfluence(dragon));
                blue_5.setText(":" + l.getInfluence(unicorn));
                yellow_5.setText(":" + l.getInfluence(gnome));
                pink_5.setText(":" + l.getInfluence(fairie));
                green_5.setText(":" + l.getInfluence(frog));
                mn5.setVisible(match.getMotherNature().getPosition() == l);
                Integer temp = l.size();
                size5.setText(temp.toString());
                try {
                    switch (l.getTowerColor()) {
                        case WHITE -> {
                            white5.setVisible(true);
                            black5.setVisible(false);
                            grey5.setVisible(false);
                        }
                        case BLACK -> {
                            white5.setVisible(false);
                            black5.setVisible(true);
                            grey5.setVisible(false);
                        }
                        case GREY -> {
                            white5.setVisible(false);
                            black5.setVisible(false);
                            grey5.setVisible(true);
                        }
                    }
                } catch (Exception e) {
                    white5.setVisible(false);
                    black5.setVisible(false);
                    grey5.setVisible(false);
                }
            }
            case 6 -> {
                red_6.setText(":" + l.getInfluence(dragon));
                blue_6.setText(":" + l.getInfluence(unicorn));
                yellow_6.setText(":" + l.getInfluence(gnome));
                pink_6.setText(":" + l.getInfluence(fairie));
                green_6.setText(":" + l.getInfluence(frog));
                mn6.setVisible(match.getMotherNature().getPosition() == l);
                Integer temp = l.size();
                size6.setText(temp.toString());
                try {
                    switch (l.getTowerColor()) {
                        case WHITE -> {
                            white6.setVisible(true);
                            black6.setVisible(false);
                            grey6.setVisible(false);
                        }
                        case BLACK -> {
                            white6.setVisible(false);
                            black6.setVisible(true);
                            grey6.setVisible(false);
                        }
                        case GREY -> {
                            white6.setVisible(false);
                            black6.setVisible(false);
                            grey6.setVisible(true);
                        }
                    }
                } catch (Exception e) {
                    white6.setVisible(false);
                    black6.setVisible(false);
                    grey6.setVisible(false);
                }
            }
            case 7 -> {
                red_7.setText(":" + l.getInfluence(dragon));
                blue_7.setText(":" + l.getInfluence(unicorn));
                yellow_7.setText(":" + l.getInfluence(gnome));
                pink_7.setText(":" + l.getInfluence(fairie));
                green_7.setText(":" + l.getInfluence(frog));
                mn7.setVisible(match.getMotherNature().getPosition() == l);
                Integer temp = l.size();
                size7.setText(temp.toString());
                try {
                    switch (l.getTowerColor()) {
                        case WHITE -> {
                            white7.setVisible(true);
                            black7.setVisible(false);
                            grey7.setVisible(false);
                        }
                        case BLACK -> {
                            white7.setVisible(false);
                            black7.setVisible(true);
                            grey7.setVisible(false);
                        }
                        case GREY -> {
                            white7.setVisible(false);
                            black7.setVisible(false);
                            grey7.setVisible(true);
                        }
                    }
                } catch (Exception e) {
                    white7.setVisible(false);
                    black7.setVisible(false);
                    grey7.setVisible(false);
                }
            }
            case 8 -> {
                red_8.setText(":" + l.getInfluence(dragon));
                blue_8.setText(":" + l.getInfluence(unicorn));
                yellow_8.setText(":" + l.getInfluence(gnome));
                pink_8.setText(":" + l.getInfluence(fairie));
                green_8.setText(":" + l.getInfluence(frog));
                mn8.setVisible(match.getMotherNature().getPosition() == l);
                Integer temp = l.size();
                size8.setText(temp.toString());
                try {
                    switch (l.getTowerColor()) {
                        case WHITE -> {
                            white8.setVisible(true);
                            black8.setVisible(false);
                            grey8.setVisible(false);
                        }
                        case BLACK -> {
                            white8.setVisible(false);
                            black8.setVisible(true);
                            grey8.setVisible(false);
                        }
                        case GREY -> {
                            white8.setVisible(false);
                            black8.setVisible(false);
                            grey8.setVisible(true);
                        }
                    }
                } catch (Exception e) {
                    white8.setVisible(false);
                    black8.setVisible(false);
                    grey8.setVisible(false);
                }
            }
            case 9 -> {
                red_9.setText(":" + l.getInfluence(dragon));
                blue_9.setText(":" + l.getInfluence(unicorn));
                yellow_9.setText(":" + l.getInfluence(gnome));
                pink_9.setText(":" + l.getInfluence(fairie));
                green_9.setText(":" + l.getInfluence(frog));
                mn9.setVisible(match.getMotherNature().getPosition() == l);
                Integer temp = l.size();
                size9.setText(temp.toString());
                try {
                    switch (l.getTowerColor()) {
                        case WHITE -> {
                            white9.setVisible(true);
                            black9.setVisible(false);
                            grey9.setVisible(false);
                        }
                        case BLACK -> {
                            white9.setVisible(false);
                            black9.setVisible(true);
                            grey9.setVisible(false);
                        }
                        case GREY -> {
                            white9.setVisible(false);
                            black9.setVisible(false);
                            grey9.setVisible(true);
                        }
                    }
                } catch (Exception e) {
                    white9.setVisible(false);
                    black9.setVisible(false);
                    grey9.setVisible(false);
                }
            }
            case 10 -> {
                red_10.setText(":" + l.getInfluence(dragon));
                blue_10.setText(":" + l.getInfluence(unicorn));
                yellow_10.setText(":" + l.getInfluence(gnome));
                pink_10.setText(":" + l.getInfluence(fairie));
                green_10.setText(":" + l.getInfluence(frog));
                mn10.setVisible(match.getMotherNature().getPosition() == l);
                Integer temp = l.size();
                size10.setText(temp.toString());
                try {
                    switch (l.getTowerColor()) {
                        case WHITE -> {
                            white10.setVisible(true);
                            black10.setVisible(false);
                            grey10.setVisible(false);
                        }
                        case BLACK -> {
                            white10.setVisible(false);
                            black10.setVisible(true);
                            grey10.setVisible(false);
                        }
                        case GREY -> {
                            white10.setVisible(false);
                            black10.setVisible(false);
                            grey10.setVisible(true);
                        }
                    }
                } catch (Exception e) {
                    white10.setVisible(false);
                    black10.setVisible(false);
                    grey10.setVisible(false);
                }
            }
            case 11 -> {
                red_11.setText(":" + l.getInfluence(dragon));
                blue_11.setText(":" + l.getInfluence(unicorn));
                yellow_11.setText(":" + l.getInfluence(gnome));
                pink_11.setText(":" + l.getInfluence(fairie));
                green_11.setText(":" + l.getInfluence(frog));
                mn11.setVisible(match.getMotherNature().getPosition() == l);
                Integer temp = l.size();
                size11.setText(temp.toString());
                try {
                    switch (l.getTowerColor()) {
                        case WHITE -> {
                            white11.setVisible(true);
                            black11.setVisible(false);
                            grey11.setVisible(false);
                        }
                        case BLACK -> {
                            white11.setVisible(false);
                            black11.setVisible(true);
                            grey11.setVisible(false);
                        }
                        case GREY -> {
                            white11.setVisible(false);
                            black11.setVisible(false);
                            grey11.setVisible(true);
                        }
                    }
                } catch (Exception e) {
                    white11.setVisible(false);
                    black11.setVisible(false);
                    grey11.setVisible(false);
                }
            }
        }
    }

    private void show_islands(int i){
        boolean found=false;
        for (Land l:match.getLands()) {
            if(l.getID()==i){
                found=true;
                print_island(i,l);
            }
        }
        if(!found){
            switch (i) {
                case 0 -> land0.setVisible(false);
                case 1 -> land1.setVisible(false);
                case 2 -> land2.setVisible(false);
                case 3 -> land3.setVisible(false);
                case 4 -> land4.setVisible(false);
                case 5 -> land5.setVisible(false);
                case 6 -> land6.setVisible(false);
                case 7 -> land7.setVisible(false);
                case 8 -> land8.setVisible(false);
                case 9 -> land9.setVisible(false);
                case 10 -> land10.setVisible(false);
                case 11 -> land11.setVisible(false);
            }
        }
    }

    public void go_to_island(ActionEvent actionEvent) {
        board_view.setVisible(false);
        land_view.setVisible(true);
        for (int i = 0; i < 12; i++) {
            show_islands(i);
        }
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
        switch (((ImageView) mouseEvent.getSource()).getId()) {
            case "entry00" -> selected(0, 0);
            case "entry01" -> selected(0, 1);
            case "entry02" -> selected(0, 2);
            case "entry03" -> selected(0, 3);
            case "entry04" -> selected(0, 4);
            case "entry05" -> selected(0, 5);
            case "entry06" -> selected(0, 6);
            case "entry07" -> selected(0, 7);
            case "entry08" -> selected(0, 8);
            case "entry09" -> selected(0, 9);
            case "entry10" -> selected(1, 0);
            case "entry11" -> selected(1, 1);
            case "entry12" -> selected(1, 2);
            case "entry13" -> selected(1, 3);
            case "entry14" -> selected(1, 4);
            case "entry15" -> selected(1, 5);
            case "entry16" -> selected(1, 6);
            case "entry17" -> selected(1, 7);
            case "entry18" -> selected(1, 8);
            case "entry19" -> selected(1, 9);
            case "entry20" -> selected(2, 0);
            case "entry21" -> selected(2, 1);
            case "entry22" -> selected(2, 2);
            case "entry23" -> selected(2, 3);
            case "entry24" -> selected(2, 4);
            case "entry25" -> selected(2, 5);
            case "entry26" -> selected(2, 6);
            case "entry27" -> selected(2, 7);
            case "entry28" -> selected(2, 8);
            case "entry29" -> selected(2, 9);
        }

    }

    public static void setMatch(Match m) {match = m;}

    public static void setAction(Action a) {action = a;}

    public static void setMe(Player m) {me = m;}

    public static void setServer(Message4Server s) {server = s;}

    public static void setIn(ObjectInputStream i) {in = i;}


}
