package ua.com.alevel.level1.khightMove;

public class KnightMove {

    public void startMatch() {
        ChessBoard chessBoard = new ChessBoard();
        String name1 = "Knight mover";
        KnightMover player1 = new KnightMover(name1, "white");
        chessBoard.initialPlacementOfPiecesOnTheChessBoard();
        while (true) {
            chessBoard.drawBoard();
            int[][] move = new int[2][2];
            while (true) {
                move = player1.getMove();
                if (move == null) {
                    System.out.println("Exit!!!");
                    return;
                }
                if (move[0][0] == -1) {
                    System.out.println("Invalid location. Try again.");
                    continue;
                }
                int[] moveFrom = move[0];
                int[] moveTo = move[1];
                ChessBoardSquare fromSquare = ChessBoard.chessboard[moveFrom[1]][moveFrom[0]];
                boolean checkValue;
                checkValue = fromSquare.checkMove(moveFrom, moveTo);
                if (checkValue) {
                    chessBoard.updateBoard(moveFrom, moveTo);
                    break;
                }
                System.out.println("Invalid move. Try again.");
            }
        }
    }
}
