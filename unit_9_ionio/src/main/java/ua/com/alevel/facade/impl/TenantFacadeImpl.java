package ua.com.alevel.facade.impl;

import ua.com.alevel.dto.TenantDto;
import ua.com.alevel.entity.Tenant;
import ua.com.alevel.facade.TenantFacade;
import ua.com.alevel.service.TenantService;
import ua.com.alevel.service.impl.TenantServiceImpl;

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

    @Override
    public void update(TenantDto tenantDto) {
        Tenant tenant = tenantService.findTenantById(tenantDto.getId());
        tenant.setName(tenantDto.getName());
        tenant.setAmountOfMoney(tenantDto.getAmountOfMoney());
        tenantService.update(tenant);
    }

    @Override
    public void delete(String id) {
        tenantService.delete(id);
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
        List<Tenant> tenants = tenantService.findAllTenants();
        for (Tenant tenant : tenants) {
            tenantDtos.add((new TenantDto(tenant)));
        }
        return tenantDtos;
    }
}

