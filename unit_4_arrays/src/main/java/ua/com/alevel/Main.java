package ua.com.alevel;

import ua.com.alevel.game.ChessBoard;

public class Main {

    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.initialPlacementOfPiecesOnTheChessBoard();
        chessBoard.drawBoard();
    }
}
