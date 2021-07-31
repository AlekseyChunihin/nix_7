package ua.com.alevel.pieces;

import ua.com.alevel.game.ChessBoard;
import ua.com.alevel.game.ChessBoardSquare;

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
        int moveFromX = moveFromReq[0];
        int moveFromY = moveFromReq[1];
        int moveToX = moveToReq[0];
        int moveToY = moveToReq[1];
        ChessBoardSquare toSquare = ChessBoard.chessboard[moveToY][moveToX];
        int moveDistance = Math.abs(moveToX - moveFromX);
        if (!testKing) {
            if (toSquare.getTypeOfObjectOnTheSquare() == "king") {
                return false;
            }
        }
        String direction;
        if (moveToX > moveFromX) {
            if (moveToY < moveFromY) {
                direction = "topRite";
            } else {
                direction = "botRite";
            }
        } else {
            if (moveToY < moveFromY) {
                direction = "topLeft";
            } else {
                direction = "botLeft";
            }
        }
        ChessBoardSquare testSquare;
        for (int diagMoveAway = 1; diagMoveAway <= moveDistance; diagMoveAway++) {
            if (direction == "topRite") {
                testSquare = ChessBoard.chessboard[moveFromY - diagMoveAway][moveFromX + diagMoveAway];
            } else if (direction == "botRite") {
                testSquare = ChessBoard.chessboard[moveFromY + diagMoveAway][moveFromX + diagMoveAway];
            } else if (direction == "topLeft") {
                testSquare = ChessBoard.chessboard[moveFromY - diagMoveAway][moveFromX - diagMoveAway];
            } else { //botLeft
                testSquare = ChessBoard.chessboard[moveFromY + diagMoveAway][moveFromX - diagMoveAway];
            }
            if ((testSquare.getTypeOfObjectOnTheSquare() != "blank") && (diagMoveAway != moveDistance)) {
                return false;
            } else if ((diagMoveAway == moveDistance) && ((testSquare.getColor() != playerColor) || (testSquare.getTypeOfObjectOnTheSquare() == "blank"))) {
                return true;
            }
        }
        return false;
    }
}

