package ua.com.alevel.dao;

import ua.com.alevel.entity.Apartment;
import ua.com.alevel.entity.Tenant;
import ua.com.alevel.storage.ApartmentArray;

import java.util.UUID;

public class InMemoryApartmentDao {

ApartmentArray apartments = new ApartmentArray();

    public void create(Apartment apartment) {
        apartment.setId(generateId());
        apartments.add(apartment);
    }

    public void update(Apartment apartment) {
        Apartment inDbApartment = findApartmentById(apartment.getId());
        inDbApartment.setApartmentNumber(apartment.getApartmentNumber());
        inDbApartment.setApartmentCost(apartment.getApartmentCost());
        inDbApartment.setNumberOfRooms(apartment.getNumberOfRooms());
    }

    public void addTenantToApartment(Apartment apartment, Tenant tenant) {
        Apartment inDbApartment = findApartmentById(apartment.getId());
        inDbApartment.setTenantIntoApartment(tenant);
    }

    public void deleteTenantFromApartment(Apartment apartment, Tenant tenant) {
        Apartment inDbApartment = findApartmentById(apartment.getId());
        inDbApartment.removeTenantFromApartment(tenant);
    }

    public Apartment findApartmentById(String id) {
        for (int i = 0; i < apartments.size(); i++) {
            if (apartments.get(i).getId().equals(id)) {
                return apartments.get(i);
            }
        }
        return null;
    }

    public String generateId() {
        String id = UUID.randomUUID().toString();
        for (int i = 0; i < apartments.size(); i++) {
            if(apartments.get(i).getId().equals(id)){
                return generateId();
            }
        }
        return id;
    }

    public ApartmentArray findAllApartments() {
        return apartments;
    }

    public void delete(String id) {
        apartments.delete(id);
    }
}
