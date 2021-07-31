package ua.com.alevel.game;

public abstract class ChessBoardSquare {

    protected String representationOfASymbolOnTheSquare;
    public String color;
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

