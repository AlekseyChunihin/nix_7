package ua.com.alevel;

import java.util.Scanner;

public class BaseTypesMain {

    public static void main(String[] args) {
        System.out.println("Enter a string:");
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        System.out.println(string);
    }
}
