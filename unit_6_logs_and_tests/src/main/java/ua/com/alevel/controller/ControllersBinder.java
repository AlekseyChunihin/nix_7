package ua.com.alevel.controller;

import java.util.Scanner;

public class ControllersBinder {

    ApartmentController apartmentController = new ApartmentController();
    TenantController tenantController = new TenantController();

    public void start() {
        menu();
    }

    public void menu() {
        Scanner mainMenuChoice = new Scanner(System.in);
        while (true) {
            Scanner scanValue = new Scanner(System.in);
            System.out.println("\t\t\t\t\t\tMenu");
            System.out.println("Please, choose what you want to do(press the corresponding number):");
            System.out.println("\t1 - CREATE tenant");
            System.out.println("\t2 - UPDATE tenant");
            System.out.println("\t3 - DELETE tenant everywhere(in apartment and storage)");
            System.out.println("\t4 - DELETE tenant from apartment");
            System.out.println("\t5 - Add tenant to apartment");
            System.out.println("\t6 - FIND tenant by id");
            System.out.println("\t7 - FIND all tenants");
            System.out.println("\t8 - CREATE apartment");
            System.out.println("\t9 - UPDATE apartment(can not update if in apartment live tenants)");
            System.out.println("\t10 - DELETE apartment(apartment can be deleted only if there is no tenants live in it)");
            System.out.println("\t11 - FIND apartment by id");
            System.out.println("\t12 - FIND all apartments");
            System.out.println("\t0 - exit");
            String choice2 = mainMenuChoice.nextLine();
            switch (choice2) {
                case "1": {
                    tenantController.create();
                }
                break;
                case "2": {
                    System.out.println("enter id of the tenant");
                    String id = scanValue.nextLine();
                    tenantController.update(id);
                }
                break;
                case "3": {
                    System.out.println("enter id of the tenant");
                    String id = scanValue.nextLine();
                    tenantController.deleteTenantEverywhere(id, apartmentController.apartmentService);
                }
                break;
                case "4": {
                    System.out.println("enter id of the tenant");
                    String id = scanValue.nextLine();
                    tenantController.deleteTenantFromApartment(id, apartmentController.apartmentService);
                }
                break;
                case "5": {
                    System.out.println("enter id of the tenant");
                    String id = scanValue.nextLine();
                    tenantController.addTenantToApartment(id, apartmentController.apartmentService);
                }
                break;
                case "6": {
                    System.out.println("enter id of the tenant");
                    String id = scanValue.nextLine();
                    tenantController.findTenantById(id);
                }
                break;
                case "7": {
                    tenantController.findAllTenants();
                }
                break;
                case "8": {
                    apartmentController.create();
                }
                break;
                case "9": {
                    System.out.println("enter id of the apartment");
                    String id = scanValue.nextLine();
                    apartmentController.update(id);
                }
                break;
                case "10": {
                    System.out.println("enter id of the apartment");
                    String id = scanValue.nextLine();
                    apartmentController.delete(id);
                }
                break;
                case "11": {
                    System.out.println("enter id of the apartment");
                    String id = scanValue.nextLine();
                    apartmentController.findApartmentById(id);
                }
                break;
                case "12": {
                    apartmentController.findAllApartments();
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
