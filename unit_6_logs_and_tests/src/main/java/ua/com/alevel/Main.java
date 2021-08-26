package ua.com.alevel;

import ua.com.alevel.controller.ApartmentController;
import ua.com.alevel.controller.ControllersBinder;
import ua.com.alevel.controller.TenantController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ControllersBinder controllersBinder = new ControllersBinder();
        controllersBinder.start();
    }
}
