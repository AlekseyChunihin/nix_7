package ua.com.alevel.controller;

import ua.com.alevel.entity.Tenant;
import ua.com.alevel.service.ApartmentService;
import ua.com.alevel.service.TenantService;
import ua.com.alevel.storage.ApartmentArray;
import ua.com.alevel.storage.TenantArray;

import java.math.BigDecimal;
import java.util.Scanner;

public class TenantController {

    TenantService tenantService = new TenantService();

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
        Tenant tenant = new Tenant(name, amountOfMoney);
        tenantService.create(tenant);
    }

    public void update(String id) {
        if (tenantService.findTenantById(id) == null) {
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
            Tenant tenant = new Tenant(name, amountOfMoney);
            tenant.setId(id);
            tenantService.update(tenant);
        }
    }

    public void deleteTenantEverywhere(String id, ApartmentService apartmentService) {
        if (tenantService.findTenantById(id) == null) {
            System.out.println("tenant with this id does not exist");
        } else {
            deleteTenantFromApartment(id, apartmentService);
            tenantService.delete(id);
            System.out.println("tenant has been deleted from storage successfully");
        }
    }

    public void deleteTenantFromApartment(String id, ApartmentService apartmentService) {
        if (tenantService.findTenantById(id) == null) {
            System.out.println("tenant with this id does not exist");
        } else {
            if (tenantService.findTenantById(id).getApartment() != null) {
                apartmentService.deleteTenantFromApartment(tenantService.findTenantById(id).getApartment(), tenantService.findTenantById(id));
                System.out.println("tenant has been deleted from apartment successfully");
            }
        }
    }

    public void addTenantToApartment(String id, ApartmentService apartmentService) {
        if (tenantService.findTenantById(id) == null) {
            System.out.println("tenant with this id does not exist");
        } else {
            if (tenantService.findTenantById(id).getApartment() == null) {
                ApartmentArray apartments = apartmentService.findAllApartments();
                if (apartments.size() == 0) {
                    System.out.println("You need to create an apartment before adding tenants to it");
                    return;
                }
                System.out.println("choose the apartment from the list(input apartment id)");
                for (int i = 0; i < apartments.size(); i++) {
                    System.out.println(apartments.get(i));
                }
                Scanner scanApartment = new Scanner(System.in);
                String apartmentId = scanApartment.nextLine();
                int i;
                for (i = 0; i < apartments.size(); i++) {
                    if (apartments.get(i).getId().equals(apartmentId)) {
                        if (apartments.get(i).getAmountOfTenants() == apartments.get(i).getNumberOfRooms()) {
                            System.out.println("This apartment is already full of tenants. Choose another apartment");
                            break;
                        }
                        apartmentService.addTenantToApartment(apartments.get(i), tenantService.findTenantById(id));
                        break;
                    }
                }
                if (i == apartments.size()) {
                    System.out.println("You have entered incorrect apartment number");
                }
            } else {
                System.out.println("This tenant already lives in the apartment. First evict him from the old apartment before adding to the new one.");
            }
        }
    }

    public void findTenantById(String id) {
        Tenant tenant = tenantService.findTenantById(id);
        if (tenant == null) {
            System.out.println("tenant with this id does not exist");
        } else {
            System.out.println(tenant);
        }
    }

    public void findAllTenants() {
        TenantArray tenantArray = tenantService.findAllTenants();
        if (tenantArray.size() > 0) {
            for (int i = 0; i < tenantArray.size(); i++) {
                System.out.println(tenantArray.get(i));
            }
        } else {
            System.out.println("storage of tenants is empty");
        }
    }
}
