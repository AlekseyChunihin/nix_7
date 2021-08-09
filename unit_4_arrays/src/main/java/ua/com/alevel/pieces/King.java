package ua.com.alevel.pieces;

import ua.com.alevel.game.ChessBoard;
import ua.com.alevel.game.ChessBoardSquare;

public class King extends Piece {

    public King(String color) {
        super(color, "king");
        if (color.equals("white")) {
            this.representationOfASymbolOnTheSquare = "wKi";
        } else if (color.equals("black")) {
            this.representationOfASymbolOnTheSquare = "bKi";
        }
    }

    @Override
    public boolean checkMove(int[] moveFromReq, int[] moveToReq, String playerColor, boolean testKing) {
        int moveFromX = moveFromReq[0];
        int moveFromY = moveFromReq[1];
        int moveToX = moveToReq[0];
        int moveToY = moveToReq[1];
        ChessBoardSquare toSquare = ChessBoard.chessboard[moveToY][moveToX];
        for (int moveAwayX = -1; moveAwayX <= 1; moveAwayX++) {
            for (int moveAwayY = -1; moveAwayY <= 1; moveAwayY++) {
                if (moveToX == moveFromX + moveAwayX && moveToY == moveFromY + moveAwayY) {
                    if (!toSquare.getTypeOfObjectOnTheSquare().equals("blank") && toSquare.getColor().equals(playerColor)) {
                        return true;
                    } else if (toSquare.getTypeOfObjectOnTheSquare().equals("blank")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
