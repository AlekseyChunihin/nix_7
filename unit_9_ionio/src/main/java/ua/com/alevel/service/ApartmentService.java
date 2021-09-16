package ua.com.alevel.service;

import ua.com.alevel.entity.Apartment;
import ua.com.alevel.entity.Tenant;
import ua.com.alevel.storage.ApartmentArray;

public interface ApartmentService {

    public void create(Apartment apartment);

    public void update(Apartment apartment);

    public void delete(String id);

    public void addTenantToApartment(Apartment apartment, Tenant tenant);

    public void deleteTenantFromApartment(Apartment apartment, Tenant tenant);

    public ApartmentArray findAllApartments();

    public Apartment findApartmentById(String id);

}
