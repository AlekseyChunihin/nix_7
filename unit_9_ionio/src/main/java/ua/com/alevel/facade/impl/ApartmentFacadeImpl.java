package ua.com.alevel.facade.impl;

import ua.com.alevel.dto.ApartmentDto;
import ua.com.alevel.dto.TenantDto;
import ua.com.alevel.entity.Apartment;
import ua.com.alevel.entity.Tenant;
import ua.com.alevel.facade.ApartmentFacade;
import ua.com.alevel.service.ApartmentService;
import ua.com.alevel.service.impl.ApartmentServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ApartmentFacadeImpl implements ApartmentFacade {

    public ApartmentService apartmentService = new ApartmentServiceImpl();

    @Override
    public void create(int apartmentNumber, BigDecimal cost, int numberOfRooms) {
        Apartment apartment = new Apartment(apartmentNumber, cost, numberOfRooms);
        apartmentService.create(apartment);
    }

    @Override
    public void update(ApartmentDto apartmentDto) {
        Apartment apartment = apartmentService.findApartmentById(apartmentDto.getId());
        apartment.setApartmentNumber(apartmentDto.getApartmentNumber());
        apartment.setApartmentCost(apartmentDto.getApartmentCost());
        apartment.setNumberOfRooms(apartmentDto.getNumberOfRooms());
        apartmentService.update(apartment);
    }

    public Apartment convertApartmentDtoToApartment(ApartmentDto apartmentDto) {
        Apartment apartment = new Apartment();
        apartment.setId(apartmentDto.getId());
        apartment.setApartmentTenants(apartmentDto.getTenantArray());
        apartment.setApartmentCost(apartmentDto.getApartmentCost());
        apartment.setApartmentNumber(apartmentDto.getApartmentNumber());
        apartment.setNumberOfRooms(apartmentDto.getNumberOfRooms());
        return apartment;
    }

    public Tenant convertTenantDtoToTenant(TenantDto tenantDto) {
        Tenant tenant = new Tenant();
        tenant.setId(tenantDto.getId());
        tenant.setApartment(tenantDto.getApartment());
        tenant.setName(tenantDto.getName());
        tenant.setAmountOfMoney(tenantDto.getAmountOfMoney());
        return tenant;
    }

    @Override
    public void addTenantToApartment(ApartmentDto apartmentDto, TenantDto tenantDto) {
        Apartment apartment = convertApartmentDtoToApartment(apartmentDto);
        Tenant tenant = convertTenantDtoToTenant(tenantDto);
        apartmentService.addTenantToApartment(apartment, tenant);
    }

    @Override
    public void deleteTenantFromApartment(ApartmentDto apartmentDto, TenantDto tenantDto) {
        Apartment apartment = convertApartmentDtoToApartment(apartmentDto);
        Tenant tenant = convertTenantDtoToTenant(tenantDto);
        apartmentService.deleteTenantFromApartment(apartment, tenant);
    }

    @Override
    public void deleteById(String id) {
        apartmentService.delete(id);
    }

    @Override
    public ApartmentDto findById(String id) {
        Apartment apartment = apartmentService.findApartmentById(id);
        if (apartment != null) {
            return new ApartmentDto(apartment);
        }
        return null;
    }

    @Override
    public List<ApartmentDto> findAllApartments() {
        List<ApartmentDto> apartmentDtos = new ArrayList<>();
        List<Apartment> apartments = apartmentService.findAllApartments();
        for (int i = 0; i < apartments.size(); i++) {
            apartmentDtos.add((new ApartmentDto(apartments.get(i))));
        }
        return apartmentDtos;
    }
}
