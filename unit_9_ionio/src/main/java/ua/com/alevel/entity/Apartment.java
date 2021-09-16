package ua.com.alevel.entity;

import ua.com.alevel.array.ApartmentTenants;

import java.math.BigDecimal;

public class Apartment {

    private String id;
    private int apartmentNumber;
    private BigDecimal apartmentCost;
    private int numberOfRooms;
    ApartmentTenants apartmentTenants;

    public Apartment() {
    }

    public Apartment(int apartmentNumber, BigDecimal apartmentCost, int numberOfRooms) {
        this.apartmentNumber = apartmentNumber;
        this.apartmentCost = apartmentCost;
        this.numberOfRooms = numberOfRooms;
        this.apartmentTenants = new ApartmentTenants(numberOfRooms);
    }

    public ApartmentTenants getTenantArray() {
        return apartmentTenants;
    }

    public void setApartmentTenants(ApartmentTenants apartmentTenants) {
        this.apartmentTenants = apartmentTenants;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTenantIntoApartment(Tenant tenant) {
        apartmentTenants.add(tenant);
    }

    public void removeTenantFromApartment(Tenant tenant) {
        apartmentTenants.delete(tenant.getId());
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
                ", amount of occupied rooms(with tenants)=" + apartmentTenants.amountOfTenants() +
                ", amount of free rooms in apartment=" + apartmentTenants.amountOfFreeSpaceInApartment() +
                '}';
    }
}
