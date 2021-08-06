package ua.com.alevel;

import java.math.BigDecimal;
import java.util.Scanner;

import ua.com.alevel.level1.khightMove.KnightMove;
import ua.com.alevel.level3.Window;

import static ua.com.alevel.level1.uniqueSymbols.UniqueSymbols.uniqueSymbolsCount;
import static ua.com.alevel.level1.triangleArea.TriangleArea.area;
import static ua.com.alevel.level2.ValidString.isStringValid;

public class Main {

    public static void main(String[] args) {
        Scanner mainMenuChoice = new Scanner(System.in);
        while (true) {
            Scanner scanValue = new Scanner(System.in);
            System.out.println("\t\t\t\t\t\tMenu");
            System.out.println("Please, choose the number of the task(press the corresponding number):");
            System.out.println("\t1 - Level 1. 1)Amount of unique figures");
            System.out.println("\t2 - Level 1. 2)Knight move");
            System.out.println("\t3 - Level 1. 3)Triangle area");
            System.out.println("\t4 - Level 2. Validation of input string");
            System.out.println("\t5 - Level 3. Game life");
            System.out.println("\t0 - exit");
            String choice2 = mainMenuChoice.nextLine();
            switch (choice2) {
                case "1": {
                    System.out.println("Enter, how many figures you want to enter ");
                    int size;
                    do {
                        while (!scanValue.hasNextInt()) {
                            scanValue.next();
                            System.out.println("You have entered incorrect value, try again");
                        }
                        size = scanValue.nextInt();
                        if (size < 0) {
                            System.out.println("You have entered incorrect value, try again");
                        }
                    } while (size < 0);
                    int[] arr = new int[size];
                    for (int i = 0; i < arr.length; i++) {
                        while (!scanValue.hasNextInt()) {
                            System.out.println("You have entered incorrect value, try again");
                            scanValue.next();
                        }
                        arr[i] = scanValue.nextInt();
                    }
                    System.out.println("the number of unique values in your sequence of numbers is equals to:  " + uniqueSymbolsCount(arr));
                }
                break;
                case "2": {
                    KnightMove knightMove = new KnightMove();
                    knightMove.startMatch();
                }
                break;
                case "3": {
                    int xA, yA, xB, yB, xC, yC;
                    System.out.println("Enter xA");
                    while (!scanValue.hasNextInt()) {
                        scanValue.next();
                        System.out.println("You have entered incorrect value, try again");
                    }
                    xA = scanValue.nextInt();
                    System.out.println("Enter yA");
                    while (!scanValue.hasNextInt()) {
                        scanValue.next();
                        System.out.println("You have entered incorrect value, try again");
                    }
                    yA = scanValue.nextInt();
                    System.out.println("Enter xB");
                    while (!scanValue.hasNextInt()) {
                        scanValue.next();
                        System.out.println("You have entered incorrect value, try again");
                    }
                    xB = scanValue.nextInt();
                    System.out.println("Enter yB");
                    while (!scanValue.hasNextInt()) {
                        scanValue.next();
                        System.out.println("You have entered incorrect value, try again");
                    }
                    yB = scanValue.nextInt();
                    System.out.println("Enter xC");
                    while (!scanValue.hasNextInt()) {
                        scanValue.next();
                        System.out.println("You have entered incorrect value, try again");
                    }
                    xC = scanValue.nextInt();
                    System.out.println("Enter yC");
                    while (!scanValue.hasNextInt()) {
                        scanValue.next();
                        System.out.println("You have entered incorrect value, try again");
                    }
                    yC = scanValue.nextInt();
                    BigDecimal result = area(xA, yA, xB, yB, xC, yC);
                    if (result.equals(BigDecimal.valueOf(-1))) {
                        System.out.println("The triangle with given coordinates does not exist");
                    } else {
                        System.out.println("Triangle area is equals to: " + result);
                    }
                }
                break;
                case "4": {
                    String string;
                    Scanner scanString = new Scanner(System.in);
                    System.out.println("Enter your string");
                    string = scanString.nextLine();
                    if (isStringValid(string)) {
                        System.out.println("String is valid");
                    } else System.out.println("String is not valid");
                }
                break;
                case "5": {
                    System.out.println("################################|WELCOME TO GAME OF LIFE|################################");
                    System.out.println("\t\t\t\tRULES:");
                    System.out.println("Click by mouse on panel to create new cells." +
                            "\nOne click create 8 alive cells because then the cell population continues to live for a very long time" +
                            "\nBy default, one cell population is created on panel" +
                            "\nIf you want to stop the game close the panel window");
                    System.out.println("           Black color - there is no cell\n" +
                            "           White color - the cell is alive\n" +
                            "           Dark gray - the cell is dead\n" +
                            "           Light gray - the cell was born");
                    Window window = new Window();
                    javax.swing.SwingUtilities.invokeLater(window);
                }
                break;
                case "0": {
                    System.out.println("!!!!!!!");
                    return;
                }
                default:
                    System.out.println("You entered an invalid value. Enter again please");
                    break;
            }
        }
    }
}
