package ua.com.alevel.pieces;

import ua.com.alevel.game.ChessBoardSquare;

public abstract class Piece extends ChessBoardSquare {

    public Piece(String color, String typeOfObjectOnTheSquare) {
        super(typeOfObjectOnTheSquare);
        this.color = color;
    }
}
