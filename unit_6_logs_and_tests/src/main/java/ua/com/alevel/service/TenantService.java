package ua.com.alevel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.InMemoryTenantDao;
import ua.com.alevel.entity.Tenant;
import ua.com.alevel.storage.TenantArray;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TenantService {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");

    private final InMemoryTenantDao tenantDao = new InMemoryTenantDao();

    public void create(Tenant tenant) {
        if (isAmountOfMoneyCorrect(tenant.getAmountOfMoney()) && isNameValid(tenant.getName())) {
            LOGGER_INFO.info("create new tenant: " + tenant.getName());
            tenantDao.create(tenant);
        }
    }

    public void update(Tenant tenant) {
        if (isAmountOfMoneyCorrect(tenant.getAmountOfMoney()) && isNameValid(tenant.getName())) {
            LOGGER_INFO.info("update tenant: " + tenant.getName());
            tenantDao.update(tenant);
        }
    }

    public void delete(String id) {
        LOGGER_WARN.warn("remove tenant by id: " + id);
        tenantDao.delete(id);
    }

    public Tenant findTenantById(String id) {
        return tenantDao.findTenantById(id);
    }

    public TenantArray findAllTenants() {
        return tenantDao.findAllTenants();
    }

    private boolean isAmountOfMoneyCorrect(BigDecimal money) {
        return money.compareTo(BigDecimal.valueOf(0)) >= 0;
    }

    private boolean isNameValid(String name) {
        String regex = "^[\\p{L} .'-]+$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}