package ua.com.alevel.controller;

import ua.com.alevel.dto.ApartmentDto;
import ua.com.alevel.facade.ApartmentFacade;
import ua.com.alevel.facade.impl.ApartmentFacadeImpl;
import ua.com.alevel.service.impl.ApartmentServiceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ApartmentController {

    public ApartmentFacade apartmentFacade = new ApartmentFacadeImpl();

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
        apartmentFacade.create(apartmentNumber, cost, numberOfRooms);
        /*Apartment apartment = new Apartment(apartmentNumber, cost, numberOfRooms);
        apartmentServiceImpl.create(apartment);*/
    }

    public void update(String id) {
        if (apartmentFacade.findById(id) == null) {
            System.out.println("apartment with this id does not exist");
        } else {
            if (apartmentFacade.findById(id).getAmountOfTenants() > 0) {
                System.out.println("You must evict tenants before update an apartment");
            } else {
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
                ApartmentDto apartmentDto = new ApartmentDto();
                apartmentDto.setApartmentNumber(apartmentNumber);
                apartmentDto.setApartmentCost(cost);
                apartmentDto.setNumberOfRooms(numberOfRooms);
                apartmentDto.setId(id);
                apartmentFacade.update(apartmentDto);
            /*Apartment apartment = new Apartment(apartmentNumber, cost, numberOfRooms);
            apartment.setId(id);
            apartmentServiceImpl.update(apartment);*/
            }
        }
    }

    public void delete(String id) {
        if (apartmentFacade.findById(id) == null) {
            System.out.println("apartment with this id does not exist");
        } else {
            apartmentFacade.deleteById(id);
        }
    }

    public void findApartmentById(String id) {
        ApartmentDto apartmentDto = apartmentFacade.findById(id);
        //Apartment apartment = apartmentServiceImpl.findApartmentById(id);
        if (apartmentDto == null) {
            System.out.println("apartment with this id does not exist");
        } else {
            System.out.println(apartmentDto);
        }
    }

    public void findAllApartments() {
        List<ApartmentDto> apartments = apartmentFacade.findAllApartments();
        //ApartmentArray apartments = apartmentServiceImpl.findAllApartments();
        if (apartments.size() > 0) {
            for (ApartmentDto apartment : apartments) {
                System.out.println(apartment);
            }
        } else {
            System.out.println("storage of apartments is empty");
        }
    }
}