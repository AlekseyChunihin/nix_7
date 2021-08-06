package ua.com.alevel.level1.khightMove;

public class ChessBoard {

    private final static Integer ROWS = 8;
    private final static Integer COLUMNS = 8;
    public static ChessBoardSquare[][] chessboard = new ChessBoardSquare[ROWS][COLUMNS];
    final static char[] SIDE_LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    final static int[] SIDE_NUMBERS = {1, 2, 3, 4, 5, 6, 7, 8};

    public void initialPlacementOfPiecesOnTheChessBoard() {
        int rowsOfBlanks = ROWS - 1;
        for (int i = 0; i < rowsOfBlanks; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                chessboard[i][j] = new BlankSpace();
            }
        }
        chessboard[7][0] = new BlankSpace();
        chessboard[7][1] = new BlankSpace();
        chessboard[7][2] = new BlankSpace();
        chessboard[7][3] = new Knight("white");
        chessboard[7][4] = new BlankSpace();
        chessboard[7][5] = new BlankSpace();
        chessboard[7][6] = new BlankSpace();
        chessboard[7][7] = new BlankSpace();
    }

    public void drawBoard() {
        System.out.print("\n");
        System.out.println("|If you want to stop the movement of the knight, enter: stop|");
        System.out.println("-------------------------------------------------------------");
        System.out.print("\n   ");
        for (char ch : SIDE_LETTERS) {
            System.out.print("  " + ch + "  ");
        }
        System.out.print("\n   ");
        for (int i = 0; i < 8; i++) {
            System.out.print(" --- ");
        }
        System.out.println();
        for (int i = 0; i < 8; i++) {
            System.out.print(" " + (8 - i) + " ");
            for (ChessBoardSquare ch : chessboard[i]) {
                System.out.print("[" + ch.getRepresentationOfASymbolOnTheSquare() + "]");
            }
            System.out.print(" " + (8 - i) + " ");
            System.out.print("\n   ");
            for (int j = 0; j < 8; j++) {
                System.out.print(" --- ");
            }
            System.out.print("\n");
        }
        System.out.print("   ");
        for (char i : SIDE_LETTERS) {
            System.out.print("  " + i + "  ");
        }
        System.out.print("\n\n");
    }

    public void updateBoard(int[] startLocation, int[] finalLocation) {
        chessboard[finalLocation[1]][finalLocation[0]] = chessboard[startLocation[1]][startLocation[0]];
        chessboard[startLocation[1]][startLocation[0]] = new BlankSpace();
    }
}


