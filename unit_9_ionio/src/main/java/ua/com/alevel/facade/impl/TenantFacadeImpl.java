package ua.com.alevel.facade.impl;

import ua.com.alevel.controller.ApartmentController;
import ua.com.alevel.dto.ApartmentDto;
import ua.com.alevel.dto.TenantDto;
import ua.com.alevel.entity.Apartment;
import ua.com.alevel.entity.Tenant;
import ua.com.alevel.facade.TenantFacade;
import ua.com.alevel.service.impl.ApartmentServiceImpl;
import ua.com.alevel.service.TenantService;
import ua.com.alevel.service.impl.TenantServiceImpl;
import ua.com.alevel.storage.TenantArray;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TenantFacadeImpl implements TenantFacade {

    TenantService tenantService = new TenantServiceImpl();

    @Override
    public void create(String name, BigDecimal amountOfMoney) {
        Tenant tenant = new Tenant(name, amountOfMoney);
        tenantService.create(tenant);
    }

    public Apartment convertApartmentDtoToApartment(ApartmentDto apartmentDto) {
        Apartment apartment = new Apartment();
        apartment.setId(apartmentDto.getId());
        apartment.setApartmentNumber(apartmentDto.getApartmentNumber());
        apartment.setApartmentCost(apartmentDto.getApartmentCost());
        apartment.setNumberOfRooms(apartmentDto.getNumberOfRooms());
        apartment.setApartmentTenants(apartmentDto.getTenantArray());
        return apartment;
    }

    @Override
    public void update(TenantDto tenantDto) {
        Tenant tenant = tenantService.findTenantById(tenantDto.getId());
        tenant.setName(tenantDto.getName());
        tenant.setAmountOfMoney(tenantDto.getAmountOfMoney());
        tenantService.update(tenant);
    }

    @Override
    public void deleteTenantEverywhere(String id, ApartmentServiceImpl apartmentServiceImpl) {
        if (findById(id).getApartment() != null) {
            deleteTenantFromApartment(id, apartmentServiceImpl);
        }
        tenantService.delete(id);
    }

    @Override
    public void deleteTenantFromApartment(String id, ApartmentServiceImpl apartmentServiceImpl) {
        apartmentServiceImpl.deleteTenantFromApartment(tenantService.findTenantById(id).getApartment(), tenantService.findTenantById(id));
    }

    @Override
    public TenantDto findById(String id) {
        Tenant tenant = tenantService.findTenantById(id);
        TenantDto tenantDto;
        if (tenant != null) {
            tenantDto = new TenantDto(tenant);
            return tenantDto;
        }
        return null;
    }

    @Override
    public List<TenantDto> findAllTenants() {
        List<TenantDto> tenantDtos = new ArrayList<>();
        TenantArray tenants = tenantService.findAllTenants();
        for (int i = 0; i < tenants.size(); i++) {
            tenantDtos.add((new TenantDto(tenants.get(i))));
        }
        return tenantDtos;
    }

    @Override
    public void addTenantToApartment(ApartmentDto apartmentDto, TenantDto tenantDto, ApartmentServiceImpl apartmentServiceImpl) {
        Tenant tenant = tenantService.findTenantById(tenantDto.getId());
        Apartment apartment = apartmentServiceImpl.findApartmentById(apartmentDto.getId());
        apartmentServiceImpl.addTenantToApartment(apartment, tenant);

    }
}

