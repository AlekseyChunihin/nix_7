package ua.com.alevel.game;

import ua.com.alevel.pieces.Piece;

public abstract class ChessBoardSquare {

    protected String representationOfASymbolOnTheSquare;
    public String color;//black, white or null for blanks
    public String typeOfObjectOnTheSquare;

    public ChessBoardSquare(String typeOfObjectOnTheSquare) {
        this.typeOfObjectOnTheSquare = typeOfObjectOnTheSquare;
    }

    public String getRepresentationOfASymbolOnTheSquare() {
        return representationOfASymbolOnTheSquare;
    }

    public String getColor() {
        return color;
    }

    public String getTypeOfObjectOnTheSquare() {
        return typeOfObjectOnTheSquare;
    }

    public abstract boolean checkMove(int[] moveFromReq, int[] moveToReq, String playerColor, boolean testKing);
}

