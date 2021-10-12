package ua.com.alevel;

import ua.com.alevel.controller.ManagementController;

public class Main {

    public static void main(String[] args) {
        ManagementController managementController = new ManagementController();
        managementController.modeSelectionMenu(args);
    }
}
