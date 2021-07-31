package ua.com.alevel.pieces;

import ua.com.alevel.game.ChessBoard;
import ua.com.alevel.game.ChessBoardSquare;

public class Pawn extends Piece {

    public Pawn(String color) {
        super(color, "pawn");
        if (color.equals("white")) {
            this.representationOfASymbolOnTheSquare = "wPa";
        } else if (color.equals("black")) {
            this.representationOfASymbolOnTheSquare = "bPa";
        }
    }

    @Override
    public boolean checkMove(int[] moveFromReq, int[] moveToReq, String playerColor, boolean testKing) {
        int moveFromX = moveFromReq[0];
        int moveFromY = moveFromReq[1];
        int moveToX = moveToReq[0];
        int moveToY = moveToReq[1];
        int moveForwardTwo;
        int moveForwardOne;
        int pawnRowOnPlySide;
        ChessBoardSquare toSquare = ChessBoard.chessboard[moveToY][moveToX];
        if (!testKing) {
            if (toSquare.getTypeOfObjectOnTheSquare() == "king") {
                return false;
            }
        }
        if (playerColor == "white") {
            moveForwardTwo = -2;
            moveForwardOne = -1;
            pawnRowOnPlySide = 6;
        } else {
            moveForwardTwo = 2;
            moveForwardOne = 1;
            pawnRowOnPlySide = 1;
        }
        if (moveToY == moveFromY + moveForwardOne) {
            if ((moveToX == moveFromX - 1) || (moveToX == moveFromX + 1)) {
                if ((toSquare.getTypeOfObjectOnTheSquare() != "blank") && (toSquare.getColor() != playerColor)) {
                    return true;
                }
            } else if ((moveToX == moveFromX) && (toSquare.getTypeOfObjectOnTheSquare() == "blank")) {
                return true;
            }
        } else if ((moveToY == moveFromY + moveForwardTwo) && (moveToX == moveFromX) && (toSquare.getTypeOfObjectOnTheSquare() == "blank")) {
            if (moveFromY == pawnRowOnPlySide) {
                return true;
            }
        }
        return false;
    }
}
