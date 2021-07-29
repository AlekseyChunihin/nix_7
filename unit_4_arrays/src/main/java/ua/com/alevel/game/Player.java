package ua.com.alevel.game;

import java.util.Scanner;

public class Player {

    private final String name;
    private final String color;
    private final Scanner scanner = new Scanner(System.in);

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
    }
}
