package ua.com.alevel.game;

public class ChessMatch {
    public void startMatch() {
        ChessBoard chessBoard = new ChessBoard();
        System.out.println("############WELCOME TO CHESS GAME############");
        System.out.println("IF PLAYER WANTS TO SURRENDER HE MUST ENTER:resign");
        String name1 = chessBoard.getPlayerName(1, null);
        String name2 = chessBoard.getPlayerName(2, name1);
        Player player1 = new Player(name1, "white");
        Player player2 = new Player(name2, "black");
        chessBoard.initialPlacementOfPiecesOnTheChessBoard();
        while (true) {
            for (int runNum = 1; runNum <= 2; runNum++) {
                chessBoard.drawBoard();
                int[][] move = new int[2][2];
                while (true) {
                    if (runNum == 1) {
                        move = player1.getMove();
                        if (move == null) {
                            System.out.println("Player " + player2.getName() + " is Winner!!!");
                            return;
                        }
                    } else {
                        move = player2.getMove();
                        if (move == null) {
                            System.out.println("Player " + player1.getName() + " is Winner!!!");
                            return;
                        }
                    }
                    if (move[0][0] == -1) {
                        System.out.println("Invalid location. Try again.");
                        continue;
                    }
                    int[] moveFrom = move[0];
                    int[] moveTo = move[1];
                    ChessBoardSquare fromSquare = ChessBoard.chessboard[moveFrom[1]][moveFrom[0]];
                    boolean checkValue;
                    if (runNum == 1) {
                        checkValue = fromSquare.checkMove(moveFrom, moveTo, "white", false);
                    } else {
                        checkValue = fromSquare.checkMove(moveFrom, moveTo, "black", false);
                    }
                    if (checkValue) {
                        chessBoard.updateBoard(moveFrom, moveTo);

                        if (runNum == 1) {
                            if (chessBoard.checkForCheckOrMate("white") == "check") {
                                System.out.println("Check!");
                            }
                        } else {
                            if (chessBoard.checkForCheckOrMate("black") == "check") {
                                System.out.println("Check!");
                            }
                        }
                        break;
                    }
                    System.out.println("Invalid move. Try again.");
                }
            }
        }
    }
}
