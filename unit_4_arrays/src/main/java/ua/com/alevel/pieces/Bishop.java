package ua.com.alevel.pieces;

public class Bishop extends Piece {

    public Bishop(String color) {
        super(color, "knight");
        if (color.equals("white")) {
            this.representationOfASymbolOnTheSquare = " ♗ ";
        } else if (color.equals("black")) {
            this.representationOfASymbolOnTheSquare = " ♝ ";
        }
    }

    @Override
    public boolean checkMove(int[] moveFromReq, int[] moveToReq, String playerColor, boolean testKing) {
        //TODO
        return false;
    }
}
