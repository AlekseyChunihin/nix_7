package ua.com.alevel.pieces;

public class Rook extends Piece {

    public Rook(String color) {
        super(color, "rook");
        if (color.equals("white")) {
            this.representationOfASymbolOnTheSquare = " ♖ ";
        } else if (color.equals("black")) {
            this.representationOfASymbolOnTheSquare = " ♜ ";
        }
    }

    @Override
    public boolean checkMove(int[] moveFromReq, int[] moveToReq, String plyColor, boolean testKing) {
        return false;
//TODO
    }
}
