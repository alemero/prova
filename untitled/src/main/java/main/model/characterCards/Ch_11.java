package main.model.characterCards;

import main.client.View;
import main.model.Bag;
import main.model.CharacterCard;
import main.model.Player;
import main.model.Student;

import java.util.ArrayList;

public class Ch_11 implements CharacterCard {

    private final short price;
    private boolean activated;
    private final String powerUp;
    private  ArrayList<Student> students;
    private Bag bag;
    View view;
    Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Ch_11(Bag bag, View view){
        this.view=view;
        price=2;
        activated=false;
        powerUp="Take 1 Student from this card and place it in your Dining Room. " +
                "Then, draw a new Student from the Bag and place it on this card.";
        students = new ArrayList<>(4);
        this.bag = bag;

        for (int i=0; i<4; i++){
            try {
                students.add(bag.getRandomStudent());
            }
            catch (Exception e){};
        }
    }

    @Override
    public void activatePowerUp() {
        Student student=view.chooseStudent(students);
        player.getBoard().ch_11_effect(student);
        try {
            students.add(bag.getRandomStudent());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(!activated){
            activated=true;
        }
    }

    @Override
    public short getPrice() {
        if(activated){
            return (short)(price+1);
        }
        else{
            return price;
        }
    }

    @Override
    public boolean hasBeenActivated() {
        return activated;
    }

    @Override
    public String getPowerUp() {
        return powerUp;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
