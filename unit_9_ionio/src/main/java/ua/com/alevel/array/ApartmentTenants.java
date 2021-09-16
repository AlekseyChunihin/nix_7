package ua.com.alevel.array;

import ua.com.alevel.entity.Tenant;

public class ApartmentTenants {

    int current;
    Tenant[] tenants;

    public ApartmentTenants(int size) {
        tenants = new Tenant[size + 1];
        current = 0;
    }

    public void add(Tenant tenant) {
        tenants[current] = tenant;
        current++;
    }

    public void delete(String tenantId) {
        int i;
        if (current == 0) {
            System.out.println("This apartment is empty.");
        } else {
            for (i = 0; i < current; i++) {
                if (tenants[i].getId().equals(tenantId)) {
                    break;
                }
            }
            if (i == current) {
                System.out.println("This apartment does not have a tenant with this id");
                return;
            }
            for (int j = i; j < current; j++) {
                tenants[i] = tenants[i + 1];
            }
            current--;
        }
    }

    public boolean find(String tenantId) {
        if (current == 0) {
            return false;
        }
        for (int i = 0; i < current; i++) {
            if (tenants[i].getId().equals(tenantId)) {
                return true;
            }
        }
        return false;
    }

    public int amountOfTenants() {
        return current;
    }

    public int amountOfFreeSpaceInApartment() {
        return (tenants.length - 1) - amountOfTenants();
    }
}
