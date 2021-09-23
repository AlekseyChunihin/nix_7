package ua.com.alevel.dao;

import ua.com.alevel.entity.Apartment;

import java.util.List;

public interface ApartmentDao {

    void create(Apartment apartment);

    void update(Apartment apartment);

    void addTenantToApartment(Apartment apartment, String tenantId);

    void deleteTenantFromApartment(Apartment apartment, String tenantId);

    Apartment findApartmentById(String id);

    String generateId();

    List<Apartment> findAllApartments();

    void delete(String id);
}
