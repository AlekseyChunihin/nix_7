package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.TenantDao;
import ua.com.alevel.entity.Tenant;
import ua.com.alevel.storage.TenantArray;

import java.util.UUID;

public class TenantDaoImpl implements TenantDao {

    TenantArray tenantArray = new TenantArray();

    @Override
    public void create(Tenant tenant) {
        tenant.setId(generateId());
        tenantArray.add(tenant);
    }

    @Override
    public void update(Tenant tenant) {
        Tenant inDbTenant = findTenantById(tenant.getId());
        inDbTenant.setName(tenant.getName());
        inDbTenant.setAmountOfMoney(tenant.getAmountOfMoney());
    }

    @Override
    public void delete(String id) {
        tenantArray.delete(id);
    }

    @Override
    public Tenant findTenantById(String id) {
        for (int i = 0; i < tenantArray.size(); i++) {
            if (tenantArray.get(i).getId().equals(id)) {
                return tenantArray.get(i);
            }
        }
        return null;
    }

    @Override
    public TenantArray findAllTenants() {
        return tenantArray;
    }

    @Override
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
