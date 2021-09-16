package ua.com.alevel.service;

import ua.com.alevel.entity.Tenant;
import ua.com.alevel.storage.TenantArray;

public interface TenantService {

    public void create(Tenant tenant);

    public void update(Tenant tenant);

    public void delete(String id);

    public Tenant findTenantById(String id);

    public TenantArray findAllTenants();
}
