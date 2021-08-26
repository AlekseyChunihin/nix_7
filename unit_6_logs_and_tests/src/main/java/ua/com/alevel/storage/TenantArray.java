package ua.com.alevel.storage;

import ua.com.alevel.entity.Tenant;

import java.util.ArrayList;

public class TenantArray {

    private static final int SIZE = 10;
    int current;
    Tenant[] tenants;

    public TenantArray() {
        current = 0;
        tenants = new Tenant[SIZE];
    }

    public void add(Tenant tenant) {
        if (current == tenants.length - 1) {
            Tenant[] tmp = new Tenant[tenants.length + SIZE];
            for (int i = 0; i < tenants.length; i++) {
                tmp[i] = tenants[i];
            }
            tenants = tmp;
        }
        tenants[current] = tenant;
        current++;
    }

    public void delete(String id) {
        int i;
        for (i = 0; i < current; i++) {
            if (tenants[i].getId().equals(id)) {
                break;
            }
        }
        for (int j = i; j < current; j++) {
            tenants[j] = tenants[j + 1];
        }
        current--;
    }

    public Tenant get(int i) {
        return tenants[i];
    }

    public int size() {
        return current;
    }
}
