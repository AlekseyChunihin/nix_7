package ua.com.alevel.dao.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ua.com.alevel.dao.TenantDao;
import ua.com.alevel.entity.Tenant;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TenantDaoImpl implements TenantDao {

    public static final String TENANTS_JSON = "src/main/resources/tenants.json";

    @Override
    public void create(Tenant tenant) {
        List<Tenant> tenants = fromJsonToListTenants();
        tenant.setId(generateId());
        tenants.add(tenant);
        fromListTenantsToJson(tenants);
    }

    @Override
    public void update(Tenant tenant) {
        Tenant inDbTenant = findTenantById(tenant.getId());
        inDbTenant.setName(tenant.getName());
        inDbTenant.setAmountOfMoney(tenant.getAmountOfMoney());
        List<Tenant> tenants = fromJsonToListTenants();
        for (int i = 0; i < tenants.size(); i++) {
            if (tenants.get(i).getId().equals(inDbTenant.getId())) {
                tenants.set(i, inDbTenant);
            }
        }
        fromListTenantsToJson(tenants);
    }

    public void updateApartment(Tenant tenant) {
        Tenant inDbTenant = findTenantById(tenant.getId());
        if (tenant.getApartment() == null) {
            inDbTenant.setApartment(null);
        } else {
            inDbTenant.setAmountOfMoney(tenant.getAmountOfMoney());
            inDbTenant.setApartment(tenant.getApartment());
        }
        List<Tenant> tenants = fromJsonToListTenants();
        for (int i = 0; i < tenants.size(); i++) {
            if (tenants.get(i).getId().equals(inDbTenant.getId())) {
                tenants.set(i, inDbTenant);
            }
        }
        fromListTenantsToJson(tenants);
    }

    @Override
    public void delete(String id) {
        List<Tenant> tenants = fromJsonToListTenants();
        tenants.removeIf(tenant -> tenant.getId().equals(id));
        fromListTenantsToJson(tenants);
    }

    @Override
    public Tenant findTenantById(String id) {
        List<Tenant> tenants = fromJsonToListTenants();
        for (Tenant tenant : tenants) {
            if (tenant.getId().equals(id)) {
                return tenant;
            }
        }
        return null;
    }

    @Override
    public List<Tenant> findAllTenants() {
        return fromJsonToListTenants();
    }

    @Override
    public String generateId() {
        List<Tenant> tenants = fromJsonToListTenants();
        String id = UUID.randomUUID().toString();
        for (int i = 0; i < tenants.size(); i++) {
            if (tenants.get(i).getId().equals(id)) {
                return generateId();
            }
        }
        return id;
    }

    public List<Tenant> fromJsonToListTenants() {
        Gson gson = new Gson();
        String s = null;
        try {
            s = Files.readString(Paths.get(TENANTS_JSON));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(s.isEmpty()){
            return new ArrayList<>();
        }
        return gson.fromJson(s, new TypeToken<List<Tenant>>() {
        }.getType());
    }

    public void fromListTenantsToJson(List<Tenant> tenants) {
        Gson gson = new Gson();
        String tenantsInJsonFormat = gson.toJson(tenants);
        Path path = Paths.get(TENANTS_JSON);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            writer.write(tenantsInJsonFormat);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
