package ua.com.alevel;

import org.junit.jupiter.api.*;
import ua.com.alevel.entity.Tenant;
import ua.com.alevel.service.TenantService;
import ua.com.alevel.storage.TenantArray;

import java.math.BigDecimal;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TenantServiceTest {

    private final static TenantService tenantService = new TenantService();
    private final static int TENANTS_SIZE = 10;

    @BeforeAll
    public static void setUpValidTenants() {
        for (int i = 0; i < TENANTS_SIZE; i++) {
            Tenant tenant = TenantGenerationUtil.generateTenant(TenantGenerationUtil.getRandomTenantName(), BigDecimal.valueOf(i * 1000));
            tenantService.create(tenant);
        }
        Assertions.assertEquals(TENANTS_SIZE, tenantService.findAllTenants().size());
    }

    @Test
    @Order(1)
    public void createTenantIfAmountOfMoneyIsNotValid() {
        Tenant tenant = TenantGenerationUtil.generateTenant(BigDecimal.valueOf(-1));
        tenantService.create(tenant);
        TenantArray tenantArray = tenantService.findAllTenants();
        Assertions.assertNotEquals(TENANTS_SIZE + 1, tenantArray.size());
    }

    @Test
    @Order(2)
    public void createTenantIfAmountOfMoneyIsValid() {
        Tenant tenant = TenantGenerationUtil.generateTenant(BigDecimal.valueOf(250));
        tenantService.create(tenant);
        TenantArray tenantArray = tenantService.findAllTenants();
        Assertions.assertEquals(TENANTS_SIZE + 1, tenantArray.size());
    }

    @Test
    @Order(3)
    public void createTenantIfNameIsNotValid() {
        Tenant tenant = TenantGenerationUtil.generateTenant("test1", BigDecimal.valueOf(250));
        tenantService.create(tenant);
        TenantArray tenantArray = tenantService.findAllTenants();
        Assertions.assertNotEquals(TENANTS_SIZE + 2, tenantArray.size());
    }

    @Test
    @Order(4)
    public void createTenantIfNameAndAmountOfMoneyIsNotValid() {
        Tenant tenant = TenantGenerationUtil.generateTenant("test1", BigDecimal.valueOf(-23));
        tenantService.create(tenant);
        TenantArray tenantArray = tenantService.findAllTenants();
        Assertions.assertNotEquals(TENANTS_SIZE + 2, tenantArray.size());
    }

    @Test
    @Order(5)
    public void updateTenantIfNameAndAmountOfMoneyIsNotValid() {
        TenantArray tenantArray = tenantService.findAllTenants();
        String id = tenantArray.get(0).getId();
        Tenant tenant = new Tenant();
        tenant.setId(id);
        tenant.setName("test1");
        tenant.setAmountOfMoney(BigDecimal.valueOf(-11123));
        tenantService.update(tenant);
        Assertions.assertNotEquals(tenant.getName(), tenantService.findAllTenants().get(0).getName());
    }

    @Test
    @Order(6)
    public void updateTenantIfNameIsNotValid() {
        TenantArray tenantArray = tenantService.findAllTenants();
        String id = tenantArray.get(0).getId();
        Tenant tenant = new Tenant();
        tenant.setId(id);
        tenant.setName("test1");
        tenant.setAmountOfMoney(BigDecimal.valueOf(2500));
        tenantService.update(tenant);
        Assertions.assertNotEquals(tenant.getName(), tenantService.findAllTenants().get(0).getName());
    }

    @Test
    @Order(7)
    public void updateTenantIfAmountOfMoneyIsNotValid() {
        TenantArray tenantArray = tenantService.findAllTenants();
        String id = tenantArray.get(0).getId();
        Tenant tenant = new Tenant();
        tenant.setId(id);
        tenant.setName("test");
        tenant.setAmountOfMoney(BigDecimal.valueOf(-2500));
        tenantService.update(tenant);
        Assertions.assertNotEquals(tenant.getAmountOfMoney(), tenantService.findAllTenants().get(0).getAmountOfMoney());
    }

    @Test
    @Order(8)
    public void delete() {
        TenantArray tenantArray = tenantService.findAllTenants();
        Assertions.assertEquals(TENANTS_SIZE + 1, tenantArray.size());
        Tenant tenant = tenantArray.get(0);
        tenantService.delete(tenant.getId());
        tenantArray = tenantService.findAllTenants();
        Assertions.assertEquals(TENANTS_SIZE, tenantArray.size());
    }
}
