package ua.com.alevel.pieces;

public class Pawn extends Piece {

    public Pawn(String color) {
        super(color, "queen");
        if (color.equals("white")) {
            this.representationOfASymbolOnTheSquare = " ♙ ";
        } else if (color.equals("black")) {
            this.representationOfASymbolOnTheSquare = " ♟ ";
        }
    }

    @Override
    public boolean checkMove(int[] moveFromReq, int[] moveToReq, String playerColor, boolean testKing) {
        //TODO
        return false;
    }

}
