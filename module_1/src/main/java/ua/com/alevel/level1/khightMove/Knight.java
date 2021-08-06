package ua.com.alevel.level1.khightMove;

public class Knight extends Piece {

    public Knight(String color) {
        super(color, "knight");
            this.representationOfASymbolOnTheSquare = "Kni";
    }

    @Override
    public boolean checkMove(int[] moveFromReq, int[] moveToReq) {
        int moveFromX = moveFromReq[0];
        int moveFromY = moveFromReq[1];
        int moveToX = moveToReq[0];
        int moveToY = moveToReq[1];
        ChessBoardSquare toSquare = ChessBoard.chessboard[moveToY][moveToX];
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
            return toSquare.getTypeOfObjectOnTheSquare() == "blank";
        }
        return false;
    }
}
