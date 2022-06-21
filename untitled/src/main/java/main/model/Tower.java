package main.model;

import java.io.Serializable;
import java.util.Objects;

public class Tower implements Serializable {
    private final Colors color;
    private final Board board;

    public Tower (Colors color, Board board){
        this.color = color;
        this.board = board;
    }

    public Colors getColor() {
        return color;
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public String toString() {
        return "torre di colore "+ color +' ';
    }
}
