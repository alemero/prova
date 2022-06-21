package main.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * it contains 3 or 4 students (it depends on the number of players)
 */
public class Cloud implements Serializable {

    private ArrayList<Student> students;
    private final Bag bag;
    private boolean hasBeenChosen;
    private final int nop;

    /**
     *
     * @param bag link of the bag of the game
     * @param number_of_players necessary in order to know the number of Students to get
     * @throws Exception if the number of players is none between 2 and 3
     */
    public Cloud (Bag bag, int number_of_players) throws Exception{
        if(number_of_players==2 || number_of_players==4){
            students = new ArrayList<>(3);
            nop=3;
        }
        else if(number_of_players==3){
            students = new ArrayList<>(4);
            nop=4;
        }
        else
            throw new Exception("Wrong number of players");
        this.bag = bag;
        hasBeenChosen=false;
    }

    /**
     * refills the cloud automatically
     */
    public void importStudents() throws Exception{
        for (int i = 0; i < nop; i++) {
            students.add(bag.getRandomStudent());
        }
    }

    /**
     * deletes all the students on this cloud
     */
    public void clearStudents() {
        students.clear();
    }

    /**
     *
     * @return ArrayList that contains the students of the cloud
     */
    public ArrayList<Student> getStudents() {
        return (ArrayList<Student>) students.clone();
    }

    /**
     * changes to true the state "hasBeenChosen"
     */
    public void choose(){
        hasBeenChosen = true;
    }

    /**
     *
     * @return boolean valor: true if it has been chosen
     */
    public boolean hasBeenChosen(){
        return hasBeenChosen;
    }

    /**
     * turns the state "hasBeenChosen" to false
     */
    public void reset(){
        hasBeenChosen = false;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cloud cloud = (Cloud) o;

        return students.equals(cloud.students);
    }

    public Cloud clone () {
        Cloud cloud;
        int players;

        if (nop == 3)
            players = 2;
        else
            players = 3;

        try {
            cloud = new Cloud(bag, players);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ArrayList<Student>s= (ArrayList<Student>) students.clone();
        cloud.setStudents(s);
        return cloud;
    }

}
