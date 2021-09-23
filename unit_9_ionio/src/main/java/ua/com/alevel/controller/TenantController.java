package ua.com.alevel.controller;

import ua.com.alevel.dto.TenantDto;
import ua.com.alevel.facade.TenantFacade;
import ua.com.alevel.facade.impl.TenantFacadeImpl;

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
        }
    }

    public void findTenantById(String id) {
        TenantDto tenantDto = tenantFacade.findById(id);
        if (tenantDto == null) {
            System.out.println("tenant with this id does not exist");
        } else {
            System.out.println(tenantDto);
        }
    }

    public void findAllTenants() {
        List<TenantDto> tenants = tenantFacade.findAllTenants();
        if (tenants.size() > 0) {
            for (TenantDto tenant : tenants) {
                System.out.println(tenant);
            }
        } else {
            System.out.println("storage of tenants is empty");
        }
    }
}
