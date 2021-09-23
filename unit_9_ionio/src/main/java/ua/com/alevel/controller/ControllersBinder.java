package ua.com.alevel.controller;

import ua.com.alevel.dto.ApartmentDto;
import ua.com.alevel.dto.TenantDto;

import java.util.List;
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
            System.out.println("\t5 - ADD tenant to apartment");
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
                    deleteTenantEverywhere(id);
                }
                break;
                case "4": {
                    System.out.println("enter id of the tenant");
                    String id = scanValue.nextLine();
                    deleteTenantFromApartment(id);
                }
                break;
                case "5": {
                    System.out.println("enter id of the tenant");
                    String id = scanValue.nextLine();
                    addTenantToApartment(id);
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

    public void addTenantToApartment(String id) {
        if (tenantController.tenantFacade.findById(id) == null) {
            System.out.println("tenant with this id does not exist");
        } else {
            if (tenantController.tenantFacade.findById(id).getApartment() == null) {
                List<ApartmentDto> apartmentDtos = apartmentController.apartmentFacade.findAllApartments();
                if (apartmentDtos.size() == 0) {
                    System.out.println("You need to create an apartment before adding tenants to it");
                    return;
                }
                System.out.println("choose the apartment from the list(input apartment id)");
                for (int i = 0; i < apartmentDtos.size(); i++) {
                    System.out.println(apartmentDtos.get(i));
                }
                Scanner scanApartment = new Scanner(System.in);
                String apartmentId = scanApartment.nextLine();
                int i;
                for (i = 0; i < apartmentDtos.size(); i++) {
                    if (apartmentDtos.get(i).getId().equals(apartmentId)) {
                        if (apartmentDtos.get(i).getAmountOfTenants() == apartmentDtos.get(i).getNumberOfRooms()) {
                            System.out.println("This apartment is already full of tenants. Choose another apartment");
                            break;
                        }
                        TenantDto tenantDto = tenantController.tenantFacade.findById(id);
                        apartmentController.apartmentFacade.addTenantToApartment(apartmentDtos.get(i), tenantDto);
                        break;
                    }
                }
                if (i == apartmentDtos.size()) {
                    System.out.println("You have entered incorrect apartment number");
                }
            } else {
                System.out.println("This tenant already lives in the apartment. First evict him from the old apartment before adding to the new one.");
            }
        }
    }

    public void deleteTenantEverywhere(String id) {
        if (tenantController.tenantFacade.findById(id) == null) {
            System.out.println("tenant with this id does not exist");
        } else {
            TenantDto tenantDto = tenantController.tenantFacade.findById(id);
            if (tenantController.tenantFacade.findById(id).getApartment() != null) {
                ApartmentDto apartmentDto = apartmentController.apartmentFacade.findById(tenantDto.getApartment().getId());
                apartmentController.apartmentFacade.deleteTenantFromApartment(apartmentDto, tenantDto);
                System.out.println("tenant has been deleted from apartment successfully");
            }
            tenantController.tenantFacade.delete(tenantDto.getId());
            System.out.println("tenant has been deleted from storage successfully");
        }
    }

    public void deleteTenantFromApartment(String id) {
        if (tenantController.tenantFacade.findById(id) == null) {
            System.out.println("tenant with this id does not exist");
        } else {
            if (tenantController.tenantFacade.findById(id).getApartment() != null) {
                TenantDto tenantDto = tenantController.tenantFacade.findById(id);
                ApartmentDto apartmentDto = apartmentController.apartmentFacade.findById(tenantDto.getApartment().getId());
                apartmentController.apartmentFacade.deleteTenantFromApartment(apartmentDto, tenantDto);
                System.out.println("tenant has been deleted from apartment successfully");
            }
        }
    }
}
