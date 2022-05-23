package main.client;

import it.polimi.ingsw.model.*;

import java.util.List;

public class GuiInplementationView implements View {
    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public Wizards getWizard(List<Wizards> wizards) {
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
    public void run() {

    }
}
