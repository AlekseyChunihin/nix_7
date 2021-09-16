package ua.com.alevel.dao;

import ua.com.alevel.entity.Tenant;
import ua.com.alevel.storage.TenantArray;

public interface TenantDao {

    public void create(Tenant tenant);

    public void update(Tenant tenant);

    public void delete(String id);

    public Tenant findTenantById(String id);

    public TenantArray findAllTenants();

    public String generateId();
}
