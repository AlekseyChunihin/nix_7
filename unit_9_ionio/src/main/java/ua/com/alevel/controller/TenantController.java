package ua.com.alevel.controller;

import ua.com.alevel.dto.ApartmentDto;
import ua.com.alevel.dto.TenantDto;
import ua.com.alevel.facade.ApartmentFacade;
import ua.com.alevel.facade.TenantFacade;
import ua.com.alevel.facade.impl.TenantFacadeImpl;
import ua.com.alevel.service.impl.ApartmentServiceImpl;
import ua.com.alevel.service.impl.TenantServiceImpl;
import ua.com.alevel.storage.ApartmentArray;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class TenantController {

    TenantFacade tenantFacade = new TenantFacadeImpl();

    public void create() {
        Scanner scanValue = new Scanner(System.in);
        System.out.println("enter tenant name(without numbers and non-alphabet symbols)");
        String name = scanValue.nextLine();
        System.out.println("enter the tenant's amount of money(>=0)");
        while (!scanValue.hasNextInt()) {
            scanValue.next();
            System.out.println("You have entered incorrect value, try again");
        }
        BigDecimal amountOfMoney = scanValue.nextBigDecimal();
        tenantFacade.create(name, amountOfMoney);
        /*Tenant tenant = new Tenant(name, amountOfMoney);
        tenantServiceImpl.create(tenant);*/
    }

    public void update(String id) {
        if (tenantFacade.findById(id) == null) {
            System.out.println("tenant with this id does not exist");
        } else {
            Scanner scanValue = new Scanner(System.in);
            System.out.println("enter tenant name(without numbers and non-alphabet symbols)");
            String name = scanValue.nextLine();
            System.out.println("enter the tenant's amount of money(>=0)");
            while (!scanValue.hasNextInt()) {
                scanValue.next();
                System.out.println("You have entered incorrect value, try again");
            }
            BigDecimal amountOfMoney = scanValue.nextBigDecimal();
            TenantDto tenantDto = new TenantDto();
            tenantDto.setName(name);
            tenantDto.setAmountOfMoney(amountOfMoney);
            tenantDto.setId(id);
            tenantFacade.update(tenantDto);
            /*Tenant tenant = new Tenant(name, amountOfMoney);
            tenant.setId(id);
            tenantServiceImpl.update(tenant);*/
        }
    }

    public void findTenantById(String id) {
        TenantDto tenantDto = tenantFacade.findById(id);
        //Tenant tenant = tenantServiceImpl.findTenantById(id);
        if (tenantDto == null) {
            System.out.println("tenant with this id does not exist");
        } else {
            System.out.println(tenantDto);
        }
    }

    public void findAllTenants() {
        List<TenantDto> tenants = tenantFacade.findAllTenants();
        //TenantArray tenantArray = tenantServiceImpl.findAllTenants();
        if (tenants.size() > 0) {
            for (TenantDto tenant : tenants) {
                System.out.println(tenant);
            }
        } else {
            System.out.println("storage of tenants is empty");
        }
    }
}
