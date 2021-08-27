package ua.com.alevel.controller;

import ua.com.alevel.entity.Apartment;
import ua.com.alevel.service.ApartmentService;
import ua.com.alevel.storage.ApartmentArray;

import java.math.BigDecimal;
import java.util.Scanner;

public class ApartmentController {
    ApartmentService apartmentService = new ApartmentService();

    public void create() {
        Scanner scanBigDecimalValue = new Scanner(System.in);
        Scanner scanNumber = new Scanner(System.in);
        System.out.println("enter apartment Number(must be unique and >0)");
        while (!scanNumber.hasNextInt()) {
            scanNumber.next();
            System.out.println("You have entered incorrect value, try again");
        }
        int apartmentNumber = scanNumber.nextInt();
        System.out.println("enter apartment room cost(must be bigger than 100)");
        while (!scanBigDecimalValue.hasNextInt()) {
            scanBigDecimalValue.next();
            System.out.println("You have entered incorrect value, try again");
        }
        BigDecimal cost = scanBigDecimalValue.nextBigDecimal();
        System.out.println("enter number of rooms(apartment can have number of rooms in range >0 and <5)");
        while (!scanNumber.hasNextInt()) {
            scanNumber.next();
            System.out.println("You have entered incorrect value, try again");
        }
        int numberOfRooms = scanNumber.nextInt();
        Apartment apartment = new Apartment(apartmentNumber, cost, numberOfRooms);
        apartmentService.create(apartment);
    }

    public void update(String id) {
        if (apartmentService.findApartmentById(id) == null) {
            System.out.println("apartment with this id does not exist");
        } else {
            if (apartmentService.findApartmentById(id).getAmountOfTenants() > 0) {
                System.out.println("You must evict tenants before update an apartment");
            }
            Scanner scanBigDecimalValue = new Scanner(System.in);
            Scanner scanNumber = new Scanner(System.in);
            System.out.println("enter apartment Number(must be unique and >0)");
            while (!scanNumber.hasNextInt()) {
                scanNumber.next();
                System.out.println("You have entered incorrect value, try again");
            }
            int apartmentNumber = scanNumber.nextInt();
            System.out.println("enter apartment room cost(must be bigger than 100)");
            while (!scanBigDecimalValue.hasNextInt()) {
                scanBigDecimalValue.next();
                System.out.println("You have entered incorrect value, try again");
            }
            BigDecimal cost = scanBigDecimalValue.nextBigDecimal();
            System.out.println("enter number of rooms(apartment can have number of rooms in range >0 and <5)");
            while (!scanNumber.hasNextInt()) {
                scanNumber.next();
                System.out.println("You have entered incorrect value, try again");
            }
            int numberOfRooms = scanNumber.nextInt();
            Apartment apartment = new Apartment(apartmentNumber, cost, numberOfRooms);
            apartment.setId(id);
            apartmentService.update(apartment);
        }
    }

    public void delete(String id) {
        if (apartmentService.findApartmentById(id) == null) {
            System.out.println("apartment with this id does not exist");
        } else {
            apartmentService.delete(id);
        }
    }

    public void findApartmentById(String id) {
        Apartment apartment = apartmentService.findApartmentById(id);
        if (apartment == null) {
            System.out.println("apartment with this id does not exist");
        } else {
            System.out.println(apartment);
        }
    }

    public void findAllApartments() {
        ApartmentArray apartments = apartmentService.findAllApartments();
        if (apartments.size() > 0) {
            for (int i = 0; i < apartments.size(); i++) {
                System.out.println(apartments.get(i));
            }
        } else {
            System.out.println("storage of apartments is empty");
        }
    }
}