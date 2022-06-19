package main.client;

import main.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Action {
    Match match;

    public Action(Match match) {
        this.match = match;
    }

    public void cardAndMoveMN(AssistantCard assistant,int step) throws IllegalArgumentException{
        if (assistant.getMNSteps()<step || step<0) throw new IllegalArgumentException();
        match.moveMotherNature(step);
    }

    public void checkAllProfessors(){
        for (Type_Student e: Type_Student.values()) {
            match.checkProfessor(e);
        }
    }



    public void uniteLands()  {
        try{
            if(match.getLands().indexOf(match.getMotherNature().getPosition())!=match.getLands().size()-1) {
                if (match.getMotherNature().getPosition().getTowerColor() ==
                        match.getLands().get((match.getLands().indexOf(match.getMotherNature().getPosition()) + 1) % match.getLands().size()).getTowerColor()) {
                    match.uniteLandAfter(match.getLands().indexOf(match.getMotherNature().getPosition()));
                }
            }else if (match.getLands().get(0).getTowerColor()==match.getLands().get(match.getLands().size()-1).getTowerColor()){
                match.uniteLandAfter(match.getLands().indexOf(match.getMotherNature().getPosition()));
            }
        }catch (Exception e){
            System.out.println("isola dopo senza torre");
        }
        try{
            if(match.getLands().indexOf(match.getMotherNature().getPosition())!=0){
                if(match.getMotherNature().getPosition().getTowerColor()==
                        match.getLands().get(match.getLands().indexOf(match.getMotherNature().getPosition())-1).getTowerColor()){
                    match.uniteLandBefore(match.getLands().indexOf(match.getMotherNature().getPosition()));
                }
            }else if(match.getLands().get(0).getTowerColor()==match.getLands().get(match.getLands().size()-1).getTowerColor()){
                match.uniteLandBefore(match.getLands().indexOf(match.getMotherNature().getPosition()));
            }
        }catch(Exception e){
            System.out.println("isola prima senza torre");
        }
    }

    public void chooseCloud(Player player, Cloud cloud){
        player.getBoard().importStudents(cloud.getStudents());
        cloud.choose();
    }


    public void moveFromIngressToLand(Player player,Student student,Land land){
        land.addStudent(player.getBoard().removeStudent(student));
    }

    public void moveFromIngressToBoard(Player player,Student student) throws Exception{
            player.getBoard().placeStudent(player.getBoard().removeStudent(student));
    }
}
