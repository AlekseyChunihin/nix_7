package ua.com.alevel.facade;

import ua.com.alevel.dto.ApartmentDto;
import ua.com.alevel.dto.TenantDto;

import java.math.BigDecimal;
import java.util.List;

public interface ApartmentFacade {

    void create(int apartmentNumber, BigDecimal cost, int numberOfRooms);

    void update(ApartmentDto apartmentDto);

    void addTenantToApartment(ApartmentDto apartmentDto, TenantDto tenantDto);

    void deleteTenantFromApartment(ApartmentDto apartmentDto, TenantDto tenantDto);

    void deleteById(String id);

    ApartmentDto findById(String id);

    List<ApartmentDto> findAllApartments();
}
