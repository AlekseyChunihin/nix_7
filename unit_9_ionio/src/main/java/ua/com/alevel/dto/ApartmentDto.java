package ua.com.alevel.dto;


import ua.com.alevel.array.ApartmentTenants;
import ua.com.alevel.entity.Apartment;

import java.math.BigDecimal;

public class ApartmentDto {

    private String id;
    private int apartmentNumber;
    private BigDecimal apartmentCost;
    private int numberOfRooms;
    ApartmentTenants apartmentTenants;

    public ApartmentDto() {
    }

    public ApartmentDto(Apartment apartment) {
        this.id = apartment.getId();
        this.apartmentNumber = apartment.getApartmentNumber();
        this.apartmentCost = apartment.getApartmentCost();
        this.numberOfRooms = apartment.getNumberOfRooms();
        this.apartmentTenants = apartment.getTenantArray();
    }

    public ApartmentTenants getTenantArray() {
        return apartmentTenants;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmountOfTenants() {
        return apartmentTenants.amountOfTenants();
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public BigDecimal getApartmentCost() {
        return apartmentCost;
    }

    public void setApartmentCost(BigDecimal apartmentCost) {
        this.apartmentCost = apartmentCost;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id='" + id + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", apartment room cost=" + apartmentCost +
                ", numberOfRooms=" + numberOfRooms +
                ", \namount of occupied rooms(with tenants)=" + apartmentTenants.amountOfTenants() +
                ", amount of free rooms in apartment=" + apartmentTenants.amountOfFreeSpaceInApartment() +
                '}';
    }
}
