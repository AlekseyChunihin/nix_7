package ua.com.alevel.dao;

import ua.com.alevel.entity.Tenant;
import ua.com.alevel.storage.TenantArray;

import java.util.UUID;

public class InMemoryTenantDao {

    TenantArray tenantArray = new TenantArray();

    public void create(Tenant tenant) {
        tenant.setId(generateId());
        tenantArray.add(tenant);
    }

    public void update(Tenant tenant) {
        Tenant inDbTenant = findTenantById(tenant.getId());
        inDbTenant.setName(tenant.getName());
        inDbTenant.setAmountOfMoney(tenant.getAmountOfMoney());
    }

    public void delete(String id) {
        tenantArray.delete(id);
    }

    public Tenant findTenantById(String id) {
        for (int i = 0; i < tenantArray.size(); i++) {
        if (tenantArray.get(i).getId().equals(id)) {
                return tenantArray.get(i);
            }
        }
        return null;
    }

    public TenantArray findAllTenants() {
        return tenantArray;
    }

    public String generateId() {
        String id = UUID.randomUUID().toString();
        for (int i = 0; i < tenantArray.size(); i++) {
            if (tenantArray.get(i).getId().equals(id)) {
                return generateId();
            }
        }
        return id;
    }
}
