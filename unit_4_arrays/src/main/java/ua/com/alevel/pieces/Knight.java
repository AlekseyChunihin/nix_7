package ua.com.alevel.pieces;

import ua.com.alevel.game.ChessBoard;
import ua.com.alevel.game.ChessBoardSquare;

public class Knight extends Piece {

    public Knight(String color) {
        super(color, "knight");
        if (color.equals("white")) {
            this.representationOfASymbolOnTheSquare = " ♘ ";
        } else if (color.equals("black")) {
            this.representationOfASymbolOnTheSquare = " ♞ ";
        }
    }

    @Override
    public boolean checkMove(int[] moveFromReq, int[] moveToReq, String playerColor, boolean testKing) {
        int moveFromX = moveFromReq[0];
        int moveFromY = moveFromReq[1];
        int moveToX = moveToReq[0];
        int moveToY = moveToReq[1];
        ChessBoardSquare toSquare = ChessBoard.chessboard[moveToY][moveToX];
        if (!testKing) {
            if (toSquare.getTypeOfObjectOnTheSquare() == "king") {
                return false;
            }
        }
        boolean locationPass = false;
        for (int displaceX = -2; displaceX <= 2; displaceX++) {
            if (displaceX != 0) {
                if (moveToX == moveFromX + displaceX) {
                    if (Math.abs(displaceX) == 1) {
                        for (int displaceY = -2; displaceY <= 2; displaceY += 4) {
                            if (moveToY == moveFromY + displaceY) {
                                locationPass = true;
                            }
                        }
                    } else {
                        for (int displaceY = -1; displaceY <= 1; displaceY += 2) {
                            if (moveToY == moveFromY + displaceY) {
                                locationPass = true;
                            }
                        }
                    }
                }
            }
        }
        if (locationPass) {
            if ((toSquare.getTypeOfObjectOnTheSquare() == "blank") || (toSquare.getColor() != playerColor)) {
                return true;
            }
        }
        return false;
    }
}
