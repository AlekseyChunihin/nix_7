package ua.com.alevel;

import ua.com.alevel.entity.Apartment;
import ua.com.alevel.entity.Tenant;

import java.math.BigDecimal;

public class TenantGenerationUtil {

    public static final String NAME = "Name";

    public static Tenant generateTenant(String name, BigDecimal amountOfMoney) {
        Tenant tenant = new Tenant();
        tenant.setName(name);
        tenant.setAmountOfMoney(amountOfMoney);
        return tenant;
    }

    public static Tenant generateTenant(BigDecimal amountOfMoney) {
        Tenant tenant = new Tenant();
        tenant.setName(NAME);
        tenant.setAmountOfMoney(amountOfMoney);
        return tenant;
    }

    public static String getRandomTenantName() {
        int index = (int) (Math.random() * 10);
        String[] arrNames = new String[]{"Steve", "Elena", "John", "Ivan", "Masha", "Katya", "Denis", "test", "name", "FirstName LastName"};
        return arrNames[index];
    }
}
