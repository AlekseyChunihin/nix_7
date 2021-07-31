package ua.com.alevel.pieces;

import ua.com.alevel.game.ChessBoard;
import ua.com.alevel.game.ChessBoardSquare;

public class King extends Piece {

    public King(String color) {
        super(color, "knight");
        if (color.equals("white")) {
            this.representationOfASymbolOnTheSquare = " ♔ ";
        } else if (color.equals("black")) {
            this.representationOfASymbolOnTheSquare = " ♚ ";
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
                    if ((toSquare.getTypeOfObjectOnTheSquare() != "blank") && (toSquare.getColor() != playerColor)) {
                        return true;
                    } else if (toSquare.getTypeOfObjectOnTheSquare() == "blank") {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
