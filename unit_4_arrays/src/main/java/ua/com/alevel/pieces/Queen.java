package ua.com.alevel.pieces;

import ua.com.alevel.game.ChessBoard;
import ua.com.alevel.game.ChessBoardSquare;

public class Queen extends Piece {

    public Queen(String color) {
        super(color, "queen");
        if (color.equals("white")) {
            this.representationOfASymbolOnTheSquare = "wQu";
        } else if (color.equals("black")) {
            this.representationOfASymbolOnTheSquare = "bQu";
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
        String type;
        if (!testKing) {
            if (toSquare.getTypeOfObjectOnTheSquare() == "king") {
                return false;
            }
        }
        if (moveToY == moveFromY) {
            if (moveToX > moveFromX) {
                direction = "rite";
                type = "straight";
            } else {
                direction = "left";
                type = "straight";
            }
        } else if (moveToX == moveFromX) {
            if (moveToY > moveFromY) {
                direction = "bot";
                type = "straight";
            } else {
                direction = "top";
                type = "straight";
            }
        } else if (moveToX > moveFromX) {
            if (moveToY < moveFromY) {
                direction = "topRite";
                type = "diagonal";
            } else {
                direction = "botRite";
                type = "diagonal";
            }
        } else if (moveToX < moveFromX) {
            if (moveToY < moveFromY) {
                direction = "topLeft";
                type = "diagonal";
            } else {
                direction = "botLeft";
                type = "diagonal";
            }
        } else {
            return false;
        }
        ChessBoardSquare testSquare;
        if (type == "diagonal") {
            int moveDistance = Math.abs(moveToX - moveFromX);
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
        } else {
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
        }
        return false;
    }
}