package ua.com.alevel;

import ua.com.alevel.controller.ControllersBinder;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main.main");
        ControllersBinder controllersBinder = new ControllersBinder();
        controllersBinder.start();
    }
}
