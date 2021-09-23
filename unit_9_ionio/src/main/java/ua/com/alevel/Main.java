package ua.com.alevel;

import ua.com.alevel.controller.ControllersBinder;

public class Main {

    public static void main(String[] args) {
        ControllersBinder controllersBinder = new ControllersBinder();
        controllersBinder.start();
    }
}
