package ua.com.alevel.main;

import static ua.com.alevel.task1.Task1.sumOfDigitsInString;
import static ua.com.alevel.task2.Task2.charactersOccurrences;
import static ua.com.alevel.task3.Task3.lessonEndTime;

import java.util.Scanner;

public class BaseTypesMain {

    public static void main(String[] args) {
        Scanner mainMenuChoice = new Scanner(System.in);
        while (true) {
            Scanner scanValue = new Scanner(System.in);
            String string;
            System.out.println("\t\t\t\t\t\tMenu");
            System.out.println("Please, choose the number of the task(press the corresponding number):");
            System.out.println("\t1 - Task1(Sum of digits in string)");
            System.out.println("\t2 - Task2(Latin / Cyrillic characters occurrences in string)");
            System.out.println("\t3 - Task3(Problem about End of Lessons)");
            System.out.println("\t0 - exit");
            String choice2 = mainMenuChoice.next();
            switch (choice2) {
                case "1": {
                    System.out.println("Enter a string:");
                    string = scanValue.nextLine();
                    int result = sumOfDigitsInString(string);
                    if (result != -1) {
                        System.out.println("Sum of digits equals:" + result);
                    } else {
                        System.out.println("There are no numbers in your string");
                    }
                }
                break;
                case "2": {
                    System.out.println("Enter a string:");
                    string = scanValue.nextLine();
                    charactersOccurrences(string);
                }
                break;
                case "3": {
                    System.out.println("Enter the number of lesson from 1 to 10");
                    int number = scanValue.nextInt();
                    if (number <= 0 || number > 10) {
                        System.out.println("You entered an incorrect number");
                    } else {
                        lessonEndTime(number);
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
