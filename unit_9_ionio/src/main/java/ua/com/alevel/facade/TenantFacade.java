package ua.com.alevel.facade;

import ua.com.alevel.controller.ApartmentController;
import ua.com.alevel.dto.ApartmentDto;
import ua.com.alevel.dto.TenantDto;
import ua.com.alevel.entity.Apartment;
import ua.com.alevel.service.impl.ApartmentServiceImpl;

import java.math.BigDecimal;
import java.util.List;

public interface TenantFacade {

    public void create(String name, BigDecimal amountOfMoney);
    public void update(TenantDto tenantDto);
    public void deleteTenantEverywhere(String id, ApartmentServiceImpl apartmentServiceImpl);
    public void deleteTenantFromApartment(String id, ApartmentServiceImpl apartmentServiceImpl);
    //public void addTenantToApartment(String id, ApartmentServiceImpl apartmentServiceImpl);
    public TenantDto findById(String id);
    public List<TenantDto> findAllTenants();

    void addTenantToApartment(ApartmentDto apartmentDto, TenantDto tenantDto, ApartmentServiceImpl apartmentService);
}
