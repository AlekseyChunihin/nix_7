package ua.com.alevel.game;

import java.util.Scanner;

public class Player {

    private final String name;
    private final String color;

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    private int convertCharToInt(char charIn) {
        int numOut = -1;
        for (int i = 0; i < ChessBoard.SIDE_LETTERS.length; i++) {
            if (ChessBoard.SIDE_LETTERS[i] == charIn) {
                numOut = i;
            }
        }
        return numOut;
    }

    private int convertCharNumToInt(char charIn) {
        int numOut = -1;
        int convertedNum = Character.getNumericValue(charIn);
        for (int i : ChessBoard.SIDE_NUMBERS) {
            if (i == convertedNum) {
                numOut = convertedNum;
            }
        }
        return numOut;
    }

    public int[][] getMove() {
        Scanner scanner = new Scanner(System.in);
        int[][] move = new int[2][2];
        for (int runNum = 1; runNum <= 2; runNum++) {
            while (true) {
                if (runNum == 1) {
                    System.out.print(name + ", input location of a piece to make a move. (example: D2 or d2)\n>> ");
                } else {
                    System.out.print(name + ", input end location of a piece. (example: D4 or d4)\n>> ");
                }
                String moveIn = scanner.nextLine().trim();
                if (moveIn.equals("resign")) {
                    return null;
                }
                if (!moveIn.isEmpty() && moveIn.length() <= 2 && !(moveIn.contains(" ") || moveIn.contains("\t"))) {

                    if (!Character.isDigit(moveIn.charAt(0)) && Character.isDigit(moveIn.charAt(1))) {
                        int x, y;

                        if ((x = convertCharToInt(Character.toUpperCase(moveIn.charAt(0)))) != -1) {
                            if ((y = convertCharNumToInt(moveIn.charAt(1))) != -1) {
                                y = 8 - y;
                                int tempArray[] = {x, y};
                                if (runNum == 1) {
                                    if (ChessBoard.chessboard[y][x].getTypeOfObjectOnTheSquare() == "blank" || ChessBoard.chessboard[y][x].getColor() != color) {

                                        tempArray[0] = -1;
                                        tempArray[1] = -1;
                                        int[][] errorArray = {tempArray, tempArray};
                                        return errorArray;
                                    }
                                }

                                move[runNum - 1] = tempArray;
                                break;
                            }
                        }
                    }
                }
                System.out.println("Invalid location. Try again.");
            }
        }
        return move;
    }
}
