package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.ApartmentDao;
import ua.com.alevel.entity.Apartment;
import ua.com.alevel.entity.Tenant;
import ua.com.alevel.storage.ApartmentArray;

import java.util.UUID;

public class ApartmentDaoImpl implements ApartmentDao {

    ApartmentArray apartments = new ApartmentArray();

    @Override
    public void create(Apartment apartment) {
        apartment.setId(generateId());
        apartments.add(apartment);
    }

    @Override
    public void update(Apartment apartment) {
        Apartment inDbApartment = findApartmentById(apartment.getId());
        inDbApartment.setApartmentNumber(apartment.getApartmentNumber());
        inDbApartment.setApartmentCost(apartment.getApartmentCost());
        inDbApartment.setNumberOfRooms(apartment.getNumberOfRooms());
    }

    @Override
    public void addTenantToApartment(Apartment apartment, Tenant tenant) {
        Apartment inDbApartment = findApartmentById(apartment.getId());
        inDbApartment.setTenantIntoApartment(tenant);
    }

    @Override
    public void deleteTenantFromApartment(Apartment apartment, Tenant tenant) {
        Apartment inDbApartment = findApartmentById(apartment.getId());
        inDbApartment.removeTenantFromApartment(tenant);
    }

    @Override
    public Apartment findApartmentById(String id) {
        for (int i = 0; i < apartments.size(); i++) {
            if (apartments.get(i).getId().equals(id)) {
                return apartments.get(i);
            }
        }
        return null;
    }

    @Override
    public String generateId() {
        String id = UUID.randomUUID().toString();
        for (int i = 0; i < apartments.size(); i++) {
            if (apartments.get(i).getId().equals(id)) {
                return generateId();
            }
        }
        return id;
    }

    @Override
    public ApartmentArray findAllApartments() {
        return apartments;
    }

    @Override
    public void delete(String id) {
        apartments.delete(id);
    }
}
