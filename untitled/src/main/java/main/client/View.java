package main.client;

import main.model.*;

import java.util.ArrayList;
import java.util.List;

public interface View extends Runnable {
    String getUsername();
    Wizards getWizard(List<Wizards> wizards);
    Cloud getCloud(List<Cloud> clouds);
    AssistantCard getAssistantCard(List<AssistantCard> cards);
    int getNumStep(Player pl);
    void getWinner(Player pl);
    String getDestination(Match match);
    void printMatch(Match match);
    void printTurn(Player pl,String phase);
    void lastRound();
    int getNumPlayer();
    Student getStudent(Player pl);
    void getTitolo();
    void wakeUp(String state);
    void setMe(Player me);
    void setMatch(Match match);
    void setCards(List<AssistantCard> cards);
    void setWilly(List<Wizards> willy);
    void setClouds(List<Cloud> clouds);
}
