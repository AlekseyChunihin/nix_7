package ua.com.alevel.dao;

import ua.com.alevel.entity.Apartment;
import ua.com.alevel.entity.Tenant;
import ua.com.alevel.storage.ApartmentArray;

public interface ApartmentDao {

    public void create(Apartment apartment);

    public void update(Apartment apartment);

    public void addTenantToApartment(Apartment apartment, Tenant tenant);

    public void deleteTenantFromApartment(Apartment apartment, Tenant tenant);

    public Apartment findApartmentById(String id);

    public String generateId();

    public ApartmentArray findAllApartments();

    public void delete(String id);
}
