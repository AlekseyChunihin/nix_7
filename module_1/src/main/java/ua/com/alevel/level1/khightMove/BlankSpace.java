package ua.com.alevel.level1.khightMove;

public class BlankSpace extends ChessBoardSquare {

    public BlankSpace() {
        super("blank");
        representationOfASymbolOnTheSquare = "   ";
        color = null;
    }

    @Override
    public boolean checkMove(int[] moveFromReq, int[] moveToReq) {
        return false;
    }
}
