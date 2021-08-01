package ua.com.alevel;

import ua.com.alevel.utils.ReverseString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner mainMenuChoice = new Scanner(System.in);
        while (true) {
            Scanner scanValue = new Scanner(System.in);
            System.out.println("\t\t\t\t\t\tMenu");
            System.out.println("Please, choose method, you want to use(press the corresponding number):");
            System.out.println("\t1 - public static String reverse(String str, boolean reverseEachWord)");
            System.out.println("\t2 - public static String reverse(String str, String dest)");
            System.out.println("\t3 - public static String reverse(String str, int firstIndex, int lastIndex)");
            System.out.println("\t4 - public static String reverse(String str, char firstChar, char lastChar)");
            System.out.println("\t0 - exit");
            String choice2 = mainMenuChoice.nextLine();
            switch (choice2) {
                case "1": {
                    System.out.println("Enter a string");
                    String string = scanValue.nextLine();
                    System.out.println("Enter 1 - reverse each word\n2 - reverse all sentence");
                    Scanner val = new Scanner(System.in);
                    if (!val.hasNextInt()) {
                        System.out.println("You entered an invalid value");
                    } else {
                        int choice = val.nextInt();
                        if (choice == 1) {
                            System.out.println(ReverseString.reverse(string, true));

                        } else if (choice == 2) {
                            System.out.println(ReverseString.reverse(string, false));
                        } else {
                            System.out.println("You entered an incorrect number");
                        }
                    }
                }
                break;
                case "2": {
                    System.out.println("Enter a string");
                    String string = scanValue.nextLine();
                    System.out.println("Enter a substring, you want to reverse");
                    String substring = scanValue.nextLine();
                    System.out.println(ReverseString.reverse(string, substring));

                }
                break;
                case "3": {
                    int firstIndex = -1, secondIndex = -1;
                    System.out.println("Enter a string");
                    String string = scanValue.nextLine();
                    System.out.println("Enter a first index - start of reverse and a second index - finish of reverse");
                    Scanner val1 = new Scanner(System.in);
                    Scanner val2 = new Scanner(System.in);
                    if (!val1.hasNextInt() && !val2.hasNextInt()) {
                        System.out.println("You entered an invalid value");
                    } else {
                        firstIndex = val1.nextInt();
                        secondIndex = val2.nextInt();
                        System.out.println(ReverseString.reverse(string, firstIndex, secondIndex));
                    }
                }
                break;
                case "4": {
                    {
                        char firstChar, secondChar;
                        System.out.println("Enter a string");
                        String string = scanValue.nextLine();
                        System.out.println("Enter a first character - start of reverse and a second character - finish of reverse");
                        Scanner val1 = new Scanner(System.in);
                        Scanner val2 = new Scanner(System.in);
                        firstChar = val1.next().charAt(0);
                        secondChar = val2.next().charAt(0);
                        System.out.println(ReverseString.reverse(string, firstChar, secondChar));

                    }
                }
                break;
                case "0": {
                    return;
                }
                default:
                    System.out.println("You entered an invalid value. Enter again please");
                    break;
            }
        }
    }
}
