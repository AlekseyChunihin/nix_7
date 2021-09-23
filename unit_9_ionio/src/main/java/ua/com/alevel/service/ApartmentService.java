package ua.com.alevel.service;

import ua.com.alevel.entity.Apartment;
import ua.com.alevel.entity.Tenant;

import java.util.List;

public interface ApartmentService {

    void create(Apartment apartment);

    void update(Apartment apartment);

    void delete(String id);

    void addTenantToApartment(Apartment apartment, Tenant tenant);

    void deleteTenantFromApartment(Apartment apartment, Tenant tenant);

    List<Apartment> findAllApartments();

    Apartment findApartmentById(String id);

}
