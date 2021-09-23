package ua.com.alevel.controller;

import ua.com.alevel.check_convert_date.DatesMenu;
import ua.com.alevel.find_the_shortest_path.FindTheShortestPathUtil;
import ua.com.alevel.first_unique_name.FindFirstUniqueNameUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    public void start() {
        menu();
    }

    public void menu() {
        Scanner mainMenuChoice = new Scanner(System.in);
        while (true) {
            Scanner scanValue = new Scanner(System.in);
            printMenuText();
            String choice2 = mainMenuChoice.nextLine();
            switch (choice2) {
                case "1": {
                    DatesMenu datesMenu = new DatesMenu();
                    datesMenu.menu();
                }
                break;
                case "2": {
                    System.out.println("Enter how many names you want to enter?");
                    int size = getSize();
                    ArrayList<String> names = new ArrayList<>();
                    System.out.println("Enter names:");
                    for (int i = 0; i < size; i++) {
                        names.add(scanValue.nextLine());
                    }
                    String name = FindFirstUniqueNameUtil.findFirstUniqueName(names);
                    if (name.equals("")) {
                        System.out.println("There are no unique names in the string");
                    } else System.out.println(name);
                }
                break;
                case "3": {
                    FindTheShortestPathUtil.findTheShortestPath();
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

    public int getSize() {
        Scanner scanChoice = new Scanner(System.in);
        int size;
        do {
            while (!scanChoice.hasNextInt()) {
                scanChoice.next();
                System.out.println("You have entered incorrect value, try again");
            }
            size = scanChoice.nextInt();
            if (size <= 0) {
                System.out.println("You have entered incorrect value, try again");
            }
        } while (size <= 0);
        return size;
    }

    private void printMenuText() {
        System.out.println("\t\t\t\t\t\tMenu");
        System.out.println("Please, choose what you want to do(press the corresponding number):");
        System.out.println("\t1 - Convert dates to numbers");
        System.out.println("\t2 - Find first unique name");
        System.out.println("\t3 - Find the shortest path(File with results will be created after the end of the program)");
        System.out.println("\t0 - exit");
    }
}
