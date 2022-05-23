package main.model;

import java.io.Serializable;

public interface CharacterCard extends Serializable {

    void activatePowerUp();

    short getPrice();

    boolean hasBeenActivated();

    String getPowerUp();
}
