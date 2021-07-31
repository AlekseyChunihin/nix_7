package ua.com.alevel.game;

public class BlankSpace extends ChessBoardSquare {

    public BlankSpace() {
        super("blank");
        representationOfASymbolOnTheSquare = "   ";
        color = null;
    }

    @Override
    public boolean checkMove(int[] moveFromReq, int[] moveToReq, String playerColor, boolean testKing) {
        return false;
    }
}
