package ua.com.alevel.pieces;

import ua.com.alevel.game.ChessBoard;
import ua.com.alevel.game.ChessBoardSquare;

public class Rook extends Piece {

    public Rook(String color) {
        super(color, "rook");
        if (color.equals("white")) {
            this.representationOfASymbolOnTheSquare = "wRo";
        } else if (color.equals("black")) {
            this.representationOfASymbolOnTheSquare = "bRo";
        }
    }

    @Override
    public boolean checkMove(int[] moveFromReq, int[] moveToReq, String playerColor, boolean testKing) {
        int moveFromX = moveFromReq[0];
        int moveFromY = moveFromReq[1];
        int moveToX = moveToReq[0];
        int moveToY = moveToReq[1];
        ChessBoardSquare toSquare = ChessBoard.chessboard[moveToY][moveToX];
        String direction;
        if (!testKing) {
            if (toSquare.getTypeOfObjectOnTheSquare() == "king") {
                return false;
            }
        }
        if (moveToY == moveFromY) {
            if (moveToX > moveFromX) {
                direction = "rite";
            } else {
                direction = "left";
            }
        } else if (moveToX == moveFromX) {
            if (moveToY > moveFromY) {
                direction = "bot";
            } else {
                direction = "top";
            }
        } else {
            return false;
        }
        ChessBoardSquare testSquare;
        if ((direction == "rite") || (direction == "left")) {
            int displaceMax = Math.abs(moveToX - moveFromX);
            for (int displace = 1; displace <= displaceMax; displace++) {
                if (direction == "rite") {
                    testSquare = ChessBoard.chessboard[moveFromY][moveFromX + displace];

                    if ((testSquare.getTypeOfObjectOnTheSquare() != "blank") && (displace != displaceMax)) {
                        return false;
                    } else if ((displace == displaceMax) && ((testSquare.getTypeOfObjectOnTheSquare() == "blank") || (testSquare.getColor() != playerColor))) {
                        return true;
                    }
                } else {
                    testSquare = ChessBoard.chessboard[moveFromY][moveFromX - displace];

                    if ((testSquare.getTypeOfObjectOnTheSquare() != "blank") && (displace != displaceMax)) {
                        return false;
                    } else if ((displace == displaceMax) && ((testSquare.getTypeOfObjectOnTheSquare() == "blank") || (testSquare.getColor() != playerColor))) {
                        return true;
                    }
                }
            }
        } else {
            int displaceMax = Math.abs(moveToY - moveFromY);
            for (int displace = 1; displace <= displaceMax; displace++) {
                if (direction == "top") {
                    testSquare = ChessBoard.chessboard[moveFromY - displace][moveFromX];
                    if ((testSquare.getTypeOfObjectOnTheSquare() != "blank") && (displace != displaceMax)) {
                        return false;
                    } else if ((displace == displaceMax) && ((testSquare.getTypeOfObjectOnTheSquare() == "blank") || (testSquare.getColor() != playerColor))) {
                        return true;
                    }
                } else {
                    testSquare = ChessBoard.chessboard[moveFromY + displace][moveFromX];
                    if ((testSquare.getTypeOfObjectOnTheSquare() != "blank") && (displace != displaceMax)) {
                        return false;
                    } else if ((displace == displaceMax) && ((testSquare.getTypeOfObjectOnTheSquare() == "blank") || (testSquare.getColor() != playerColor))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
