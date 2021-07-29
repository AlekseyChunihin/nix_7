package ua.com.alevel.game;

import ua.com.alevel.pieces.*;

import java.util.ArrayList;

public class ChessBoard {

    private final static Integer ROWS = 8;
    private final static Integer COLUMNS = 8;
    private static ChessBoardSquare[][] chessboard = new ChessBoardSquare[ROWS][COLUMNS];
    private final char[] SIDE_LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    private final int[] SIDE_NUMBERS = {1, 2, 3, 4, 5, 6, 7, 8};

    public void initialPlacementOfPiecesOnTheChessBoard() {
        chessboard[0][0] = new Rook("black");
        chessboard[0][1] = new Knight("black");
        chessboard[0][2] = new Bishop("black");
        chessboard[0][3] = new Queen("black");
        chessboard[0][4] = new King("black");
        chessboard[0][5] = new Bishop("black");
        chessboard[0][6] = new Knight("black");
        chessboard[0][7] = new Rook("black");
        for (int j = 0; j < COLUMNS; j++) {
            chessboard[1][j] = new Pawn("black");
        }
        int rowsOfBlanks = ROWS - 2;
        for (int i = 2; i < rowsOfBlanks; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                chessboard[i][j] = new BlankSpace();
            }
            for (int j = 0; j < COLUMNS; j++) {
                chessboard[6][j] = new Pawn("white");
            }
            chessboard[7][0] = new Rook("white");
            chessboard[7][1] = new Knight("white");
            chessboard[7][2] = new Bishop("white");
            chessboard[7][3] = new Queen("white");
            chessboard[7][4] = new King("white");
            chessboard[7][5] = new Bishop("white");
            chessboard[7][6] = new Knight("white");
            chessboard[7][7] = new Rook("white");
        }
    }

    public void drawBoard() {
        System.out.print("\n   ");
        for (char ch : SIDE_LETTERS) {
            System.out.print("  " + ch + "  ");

        }
        System.out.print("\n   ");//+++

        for (int i = 0; i < 8; i++) {
            System.out.print(" --- ");//+++
        }
        System.out.println();
        for (int i = 0; i < 8; i++) {
            System.out.print(" " + (8 - i) + " ");
            for (ChessBoardSquare ch : chessboard[i]) {
                System.out.print("[" + ch.getRepresentationOfASymbolOnTheSquare() + "]");
            }
            System.out.print(" " + (8 - i) + " ");
            System.out.print("\n   ");//to get next line

            for (int j = 0; j < 8; j++) {
                System.out.print(" --- ");
            }
            System.out.print("\n");
        }
        System.out.print("   ");
        for (char i : SIDE_LETTERS) { //printing letters across the bottom
            System.out.print("  " + i + "  ");
        }
        System.out.print("\n\n");

    }

}

