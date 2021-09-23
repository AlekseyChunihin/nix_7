package ua.com.alevel.dao;

import ua.com.alevel.entity.Tenant;

import java.util.List;

public interface TenantDao {

    void create(Tenant tenant);

    void update(Tenant tenant);

    void delete(String id);

    Tenant findTenantById(String id);

    List<Tenant> findAllTenants();

    String generateId();
}
