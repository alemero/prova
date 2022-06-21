package main.model.characterCards;

import main.client.View;
import main.model.*;

public class Ch_5 implements CharacterCard {

    private final short price;
    private boolean activated;
    private final String powerUp;
    private Island[] Islands= new Island[4];
    private Player player;
    private Match match;
    private View view;
    public Ch_5(Match match, View view){
        this.view=view;
        this.match=match;
        price=2;
        activated=false;
        for(int i=0; i<4; i++){
            Islands[i]=null;
        }
        powerUp="Place a No Entry tile on an Island of your choice. "+"" +
                "The first time Mother Nature ends her movement there, "+"" +
                "put the No Entry tile back onto this card DO NOT calculate influence"+"" +
                " on that Island, or place any Towers.";
    }

    @Override
    public void activatePowerUp() {
        Land land=view.chooseLand(match.getLands());
        try {
            land.setNoEntry(true);
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

    public Island[] getIslands() {
        return Islands;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }
}
