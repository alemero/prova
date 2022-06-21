package main.model;

import java.io.Serializable;
import java.util.*;

public class Match implements Serializable {
    Player[] player;
    Cloud[] cloud;
    Bag bag;
    MotherNature motherNature;
    Map<Type_Student,Player> professors;
    ArrayList<Land> lands;

    /**
     * create an instance of the match with two players
     * @param player first player who play
     * @param player1 second player who play
     */
    public Match(Player player,Player player1) {
        this.player=new Player[2];
        this.player[0] = player;
        this.player[1] = player1;
        bag=new Bag();
        cloud=new Cloud[2];
        try {
            cloud[0]=new Cloud(bag,2);
            cloud[1]=new Cloud(bag,2);
        }catch(Exception e){
            e.printStackTrace();
        }
        professors=new HashMap<>();
        lands=new ArrayList<>();
        for(short i=0;i<12;i++) {
            lands.add(new Island(i));
        }
        List<Student> a=new ArrayList<>();
        for (Type_Student e:Type_Student.values()) {
            a.add(new Student(e));
            a.add(new Student(e));
        }
        Random x=new Random();
        int r;
        for(int j=0;j<12;j++){
            if(j!=0 && j!=6){
                r= x.nextInt(2000);
                lands.get(j).addStudent(a.remove(r%a.size()));
            }
        }
        motherNature =new MotherNature(lands.get(0));
    }

    /**
     * create an instance of match of three players
     * @param player first player of the match
     * @param player1 second player of the match
     * @param player2 third player of the match
     */
    public Match(Player player,Player player1,Player player2) {
        this.player=new Player[3];
        this.player[0] = player;
        this.player[1] = player1;
        this.player[2] = player2;
        cloud=new Cloud[3];
        bag=new Bag();
        try {
            cloud[0] = new Cloud(bag,3);
            cloud[1] = new Cloud(bag,3);
            cloud[2] = new Cloud(bag,3);
        }catch (Exception e){
            e.printStackTrace();
        }
        professors=new HashMap<>();
        lands=new ArrayList<>();
        for(short i=0;i<12;i++)
            lands.add(new Island(i));
        List<Student> a=new ArrayList<>();
        for (Type_Student e:Type_Student.values()) {
            a.add(new Student(e));
            a.add(new Student(e));
        }
        Random x=new Random();
        int r;
        for(int j=0;j<12;j++){
            if(j!=0 && j!=6){
                r= x.nextInt(2000);
                lands.get(j).addStudent(a.remove(r%a.size()));
            }
        }
        motherNature =new MotherNature(lands.get(0));
    }

    public int getPlayersNum() {
        return player.length;
    }

    /**
     *
     * @return the cloud of the match
     */
    public synchronized Cloud[] getCloud() {
        return cloud.clone();
    }

    /**
     * set the cloud on the match
     * @param cloud cloud to set in the match
     */
    public synchronized void setCloud(Cloud[] cloud) {
        this.cloud = cloud;
    }

    /**
     *
     * @return the map with the professors and the player who has the professor
     */
    public Map<Type_Student, Player> getProfessors() {
        return professors;
    }

    /**
     *
     * @return the players of the match
     */
    public Player[] getPlayer() {
        return player;
    }

    /**
     *
     * @return the mother nature of the match
     */
    public MotherNature getMotherNature() {
        return motherNature;
    }

    /**
     *
     * @return the bag of the match
     */
    public Bag getBag() {
        return bag;
    }

    /**
     *
     * @return the lands of the match
     */
    public ArrayList<Land> getLands() {
        return (ArrayList<Land>) this.lands.clone();
    }

    /**
     * move mother nature to the land after the number of step
     * @param step number of step that mother nature has to do
     */
    public void moveMotherNature(int step){
        int pos=lands.indexOf(motherNature.getPosition());
        pos=(step+pos)%lands.size();
        motherNature.setPosition(lands.get(pos));
    }

    /**
     * unite the land with the land after
     * @param i index of the first to unite with after
     * @throws IllegalArgumentException  if i is i<0 or i>lands.size() or the colors of the towers are different
     */
    public void uniteLandAfter(int i) throws Exception
    {
        if(i<0 || i>=lands.size()) throw new IllegalArgumentException();
        if (i<lands.size()-1){
            if(!(lands.get(i).getTower().getColor()==lands.get(i+1).getTower().getColor()))throw new IllegalArgumentException();
            Land a;
            Land unito;
            a=lands.remove(i+1);
            unito=lands.remove(i);
            lands.add(i,unito.uniteIslands(a));
            motherNature.setPosition(lands.get(i));
        }else{
            if(!(lands.get(0).getTower().getColor()==lands.get(i).getTower().getColor()))throw new IllegalArgumentException();
            Land a;
            Land unito;
            a=lands.remove(i);
            unito=lands.remove(0);
            lands.add(0,a.uniteIslands(unito));
            motherNature.setPosition(lands.get(0));
        }
    }

    /**
     * unite the land with the one before
     * @param i is the index of the land to unite to the one before
     * @throws IllegalArgumentException if the islands have different colors of tower or i<0 or i>lands.size()-1
     */
    public void uniteLandBefore(int i) throws Exception
    {
        if(i<0 || i>lands.size()-1) throw new IllegalArgumentException();
        Land a;
        if(i>=1) {
            if(!(lands.get(i).getTower().getColor()==lands.get(i-1).getTower().getColor()))throw new IllegalArgumentException();
            a=lands.remove(i);
            lands.add(i,a.uniteIslands(lands.get(i-1)));
            lands.remove(i-1);
            motherNature.setPosition(lands.get(i-1));
        }else{
            if(!(lands.get(0).getTower().getColor()==lands.get(lands.size()-1).getTower().getColor()))throw new IllegalArgumentException();
            a=lands.remove(lands.size()-1);
            lands.add(1,lands.get(0).uniteIslands(a));
            lands.remove(0);
            motherNature.setPosition(lands.get(0));
        }
    }

    /**
     * unite the island in the center with the land before and after
     * @param i is the position of the island that is in the center
     * @throws Exception if the position of the land is i<1 or i>lands.size()-1 or if the towers of the island have different colors
     */
    public void uniteLandBeforeAndAfter(int i) throws Exception
    {
        if(i<1 || i>=lands.size()-1) throw new IllegalArgumentException();
        if(!(lands.get(i).getTower().getColor()==lands.get(i-1).getTower().getColor() &&
                lands.get(i).getTower().getColor()==lands.get(i+1).getTower().getColor()))throw new IllegalArgumentException();
        uniteLandAfter(i);
        uniteLandBefore(i);
    }

    /**
     * change the professor of type e
     * @param e type of the student
     * @return the player who have the professor of type e
     */
    public Player checkProfessor(Type_Student e) {
        int a=0;
        int i;
        for (i = 0; i < player.length; i++)
            if(player[i].getBoard().getStudentsOfType(e)>player[a].getBoard().getStudentsOfType(e)) {
                a = i;
            }
        if(player[a].getBoard().getStudentsOfType(e)>0) {
            if (professors.containsKey(e) && player[a].getBoard().getStudentsOfType(e) > professors.get(e).getBoard().getStudentsOfType(e)) {
                professors.replace(e, player[a]);
                return player[a];
            } else if (!professors.containsKey(e)) {
                professors.put(e, player[a]);
                return player[a];
            } else return professors.get(e);
        }
        else return null;
    }

    public Player getWinner() {
        int minIndex, min, temp, countProf1, countProf2;
        minIndex = 0;
        min = player[0].getBoard().getTowersNum();
        countProf1 = 0;

        for (int i=1; i<player.length; i++){
            temp = player[i].getBoard().getTowersNum();

            if (temp < min) {
                minIndex = i;
                min = temp;
                countProf1 = 0;
            } else if (temp == min) {
                countProf2 = 0;
                for (Type_Student professor : Type_Student.values()) {
                    if (professors.get(professor).equals(player[min]) && countProf1==0) {
                        countProf1++;
                    } else if (professors.get(professor).equals(player[i])) {
                        countProf2++;
                    }
                }
                if (countProf2 > countProf1) {
                    minIndex = i;
                    countProf1 = countProf2;
                }
            }
        }

        return player[minIndex];
    }


    public void setProfessors(Map<Type_Student, Player> professors) {
        this.professors = professors;
    }

    public void setLands(ArrayList<Land> lands) {
        this.lands = lands;
    }

    @Override
    public String toString() {
        StringBuilder a= new StringBuilder();

        for (Player p : player)
            a.append(p.toString());
        a.append("\n").append(getSky()).append("\nProfessori: \n");
        for (Player p : player) {
            a.append(p.getColor()).append("\t").append(p.getUserName()).append("\u001B[0m").append(":  ");
            for (Type_Student professor : professors.keySet()) {
                if (professors.get(professor).getUserName().equals(p.getUserName()))
                    a.append(professor.toString()).append("(₱)  ");
            }
            a.append("\u001B[0m\n");
        }
        a.append("\n");

        return a.toString();
    }

    public String getSky () {
        return "                                   " +
                printMN(0) + "           " + printMN(1) +
                "           " + printMN(2) + "\n" +
                "                                ___________     ___________     ___________\n" +
                "                               /" + printNoEntry(0) + "\\   /" + printNoEntry(1) + "\\   /" +
                printNoEntry(2) + "\\\n" +
                "                              /" + countStudents(0, 1) + "\\ /" + countStudents(1, 1) +
                "\\ /" + countStudents(2, 1) + "\\\n" +
                "                    " + printMN(11) + "     |" + countStudents(0, 2) + "| |" +
                countStudents(1, 2) + "| |" + countStudents(2, 2) + "|     " + printMN(3) +
                "\n" + "                 ___________  |" + printTowerRow(0, 2) + "| |" + printTowerRow(1, 2) +
                "| |" + printTowerRow(2, 2) + "|  ___________\n" +
                "                /" + printNoEntry(11) + "\\ \\" + countStudents(0, 3) + "/ \\" +
                countStudents(1, 3) + "/ \\" + countStudents(2, 3) + "/ /" +
                printNoEntry(3) + "\\\n" +
                "               /" + countStudents(11, 1) + "\\ \\___________/   \\___________/   \\___________/ /" +
                countStudents(3, 1) + "\\\n" + "     " + printMN(10) + "     |" +
                countStudents(11, 2) + "|                                               |" + countStudents(3, 2) +
                "|     " + printMN(4) + "\n" +
                "  ___________  |" + printTowerRow(11, 2) + "|                                               |" +
                printTowerRow(11, 2) + "|  ___________\n" +
                " /" + printNoEntry(9) + "\\ \\" + countStudents(11, 3) + "/   " + printChosenCloud(0) +
                "    " + printChosenCloud(2) + "    " + printChosenCloud(1) + "   \\" + countStudents(3, 3) +
                "/ /" + printNoEntry(4) + "\\\n" +
                "/" + countStudents(10, 1) + "\\ \\___________/    " + printCloudRow(0, 1) + "    " +
                printCloudRow(2, 1) +
                "    " + printCloudRow(1, 1) + "    \\___________/ /" + countStudents(4, 1) + "\\\n" +
                "|" + countStudents(10, 2) + "|                  " + printCloudRow(0, 2) + "    " +
                printCloudRow(2, 2) + "    " + printCloudRow(1, 2) + "                  |" +
                countStudents(4, 2) + "|\n" + "|" + printTowerRow(10, 2) + "|  ___________     " +
                printCloudRow(0, 3) + "    " + printCloudRow(2, 3) + "    " + printCloudRow(1, 3) +
                "     ___________  |" + printTowerRow(4, 2) + "|\n" + "\\" + countStudents(10, 3) +
                "/ /" + printNoEntry(8) + "\\    " + printCloudRow(0, 4) + "    " +
                printCloudRow(2, 4) + "    " + printCloudRow(1, 4) + "    /" + printNoEntry(5) +
                "\\ \\" + countStudents(4, 3) + "/\n" + " \\___________/ /" + countStudents(9, 1) +
                "\\   " + printCloudRow(0, 5) + "    " + printCloudRow(2, 5) + "    " +
                printCloudRow(1, 5) + "   /" + countStudents(5, 1) + "\\ \\___________/\n" +
                "               |" + countStudents(9, 2) + "|                                               |" +
                countStudents(5, 2) + "|\n" + "               |" + printTowerRow(9, 2) +
                "|  ___________     ___________     ___________  |" + printTowerRow(10, 2) + "|\n" +
                "               \\" + countStudents(9, 3) + "/ /" + printNoEntry(8) + "\\   /" +
                printNoEntry(7) + "\\   /" + printNoEntry(6) + "\\ \\" + countStudents(5, 3) +
                "/\n" + "                \\___________/ /" + countStudents(8, 1) + "\\ /" +
                countStudents(7, 1) + "\\ /" + countStudents(6, 1) + "\\ \\___________/\n" +
                "                     " + printMN(9) + "    |" + countStudents(8, 2) + "| |" +
                countStudents(7, 2) + "| |" + countStudents(6, 2) + "|     " +
                printMN(5) + "\n" + "                              |" + printTowerRow(8, 2) + "| |" +
                printTowerRow(9, 2) + "| |" + printTowerRow(9, 2) + "|\n" +
                "                              \\" + countStudents(8, 3) + "/ \\" + countStudents(7, 3) +
                "/ \\" + countStudents(6, 3) + "/\n" +
                "                               \\___________/   \\___________/   \\___________/\n" +
                "                                   " + printMN(8) + "           " + printMN(7) +
                "           " + printMN(6);
    }

    private String printCloudRow (int cloud, int row) {
        ArrayList<Student> students;

        if (cloud < this.cloud.length) {
            students = this.cloud[cloud].getStudents();

            switch (row) {
                case 1 -> {
                    return "  ## ## #  ";
                }
                case 2 -> {
                    if (students.isEmpty())
                        return " #       # ";
                    else
                        return " #  "+students.get(0).toString()+"\u001B[0m  # ";
                }
                case 3 -> {
                    if (students.isEmpty())
                        return "#         #";
                    else
                        return "# "+students.get(1)+" "+students.get(2)+"\u001B[0m #";
                }
                case 4 -> {
                    if (player.length == 2)
                        return "  ## ## #  ";
                    else if (students.isEmpty())
                        return " #       # ";
                    else
                        return " #  "+students.get(3).toString()+"\u001B[0m  #";
                }
                case 5 -> {
                    if (player.length == 3)
                        return "  ## ## #  ";
                    else
                        return "           ";
                }
                default -> {
                    return "           ";
                }
            }
        }
        else
            return "           ";
    }

    private String printChosenCloud (int cloud) {
        if (cloud < this.cloud.length)
            if (this.cloud[cloud].hasBeenChosen())
                return "   presa   ";

        return "           ";
    }

    private String printNoEntry (int island) {
        if (findIsland(island).isThereNoEntry())
            return "\u001b[31m  DIVIETO  \u001b[0m";
        else
            return "           ";
    }

    private String countStudents (int island, int row) {
        Island i = findIsland(island);
        int counter1 = 0, counter2 = 0;
        ArrayList<Student> students = i.getStudents();
        String result;

        switch (row) {
            case 1 -> {
                for (Student s : students) {
                    if (s.type() == Type_Student.DRAGON)
                        counter1++;
                }
                result = Type_Student.DRAGON+"    (X)"+counter1;

                if (counter1 < 10)
                    result += " ";
                result += "    ";
            }
            case 2 -> {
                for (Student s : students) {
                    if (s.type()==Type_Student.FROG)
                        counter1++;
                    if (s.type()==Type_Student.GNOME)
                        counter2++;
                }
                result = Type_Student.FROG+"(X)"+counter1;

                if (counter1 < 10)
                    result += " ";
                result += printTowerRow(island, 1)+Type_Student.GNOME+"(X)"+counter2;

                if (counter1 < 10)
                    result += " ";
            }
            default -> {
                for (Student s : students) {
                    if (s.type()==Type_Student.FAIRY)
                        counter1++;
                    if (s.type()==Type_Student.UNICORN)
                        counter2++;
                }
                result = Type_Student.FAIRY+" (X)"+counter1;

                if (counter1 < 10)
                    result += " ";
                result += Type_Student.UNICORN+" (X)"+counter2;

                if (counter1 < 10)
                    result += " ";
                result += " ";
            }
        }

        return result+"\u001B[0m";
    }

    private Island findIsland (int island) {
        int counter = 0;

        for (Land land : lands)
        {
            if (counter+land.size() > island)
                return land.getIslands().get(island-counter);
            else
                counter += land.size();
        }

        return null;
    }

    private String printTowerRow (int island, int row) {
        Island i = findIsland(island);

        if (i.getTower() != null)
            if (row == 1)
                return i.getTower().getColor().toString()+"|_|\u001B[0m";
            else
                return i.getTower().getColor().toString()+"     /_\\\u001B[0m     ";
        else if (row ==1)
            return "   ";
        else
            return "             ";
    }

    private String printMN (int island) {
        Island i = findIsland(island);
        String arrow;

        if (motherNature.getPosition().equals(i)) {
            if (island>3 && island<10)
                arrow = "↑";
            else
                arrow = "↓";

            return "\u001b[36m(▲) "+arrow+"\u001B[0m";
        }
        else
            return "     ";
    }

}
