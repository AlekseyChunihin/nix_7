package ua.com.alevel;

import org.junit.jupiter.api.*;
import ua.com.alevel.entity.Apartment;
import ua.com.alevel.entity.Tenant;
import ua.com.alevel.service.ApartmentService;
import ua.com.alevel.service.TenantService;
import ua.com.alevel.storage.ApartmentArray;

import java.math.BigDecimal;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApartmentServiceTest {

    private final static ApartmentService apartmentService = new ApartmentService();
    private final static TenantService tenantService = new TenantService();
    private final static int APARTMENTS_SIZE = 10;

    @BeforeAll
    public static void setUpValidApartments() {
        for (int i = 0; i < APARTMENTS_SIZE; i++) {
            Apartment apartment = ApartmentGenerationUtil.generateApartment(i + 1, BigDecimal.valueOf(200 * (i + 1)), ApartmentGenerationUtil.getRandomApartmentNumberOfRooms());
            apartmentService.create(apartment);
        }
        Assertions.assertEquals(APARTMENTS_SIZE, apartmentService.findAllApartments().size());
    }

    @Test
    @Order(1)
    public void createApartmentIfApartmentNumberIsNotValid() {
        Apartment apartment = ApartmentGenerationUtil.generateApartment(-12, BigDecimal.valueOf(100), 1);
        apartmentService.create(apartment);
        Assertions.assertNotEquals(APARTMENTS_SIZE + 1, apartmentService.findAllApartments().size());
    }

    @Test
    @Order(2)
    public void createApartmentIfApartmentNumberIsNotUnique() {
        Apartment apartment = ApartmentGenerationUtil.generateApartment(1, BigDecimal.valueOf(100), 1);
        apartmentService.create(apartment);
        Assertions.assertNotEquals(APARTMENTS_SIZE + 1, apartmentService.findAllApartments().size());
    }

    @Test
    @Order(3)
    public void createApartmentIfNumberOfRoomsIsNotValid() {
        Apartment apartment = ApartmentGenerationUtil.generateApartment(12, BigDecimal.valueOf(100), 7);
        apartment.setApartmentNumber(12);
        apartment.setNumberOfRooms(7);
        apartment.setApartmentCost(BigDecimal.valueOf(100));
        apartmentService.create(apartment);
        Assertions.assertNotEquals(APARTMENTS_SIZE + 1, apartmentService.findAllApartments().size());
    }

    @Test
    @Order(4)
    public void createApartmentIfApartmentCostIsNotValid() {
        Apartment apartment = ApartmentGenerationUtil.generateApartment(12, BigDecimal.valueOf(0), 3);
        apartment.setApartmentNumber(12);
        apartment.setNumberOfRooms(3);
        apartment.setApartmentCost(BigDecimal.valueOf(0));
        apartmentService.create(apartment);
        Assertions.assertNotEquals(APARTMENTS_SIZE + 1, apartmentService.findAllApartments().size());
    }

    @Test
    @Order(5)
    public void updateApartmentIfApartmentNumberIsNotValid() {
        String id = apartmentService.findAllApartments().get(0).getId();
        Apartment apartment = new Apartment();
        apartment.setId(id);
        apartment.setApartmentNumber(-50);
        apartment.setNumberOfRooms(3);
        apartment.setApartmentCost(BigDecimal.valueOf(100));
        apartmentService.update(apartment);
        Assertions.assertNotEquals(apartment.getApartmentNumber(), apartmentService.findAllApartments().get(0).getApartmentNumber());
    }

    @Test
    @Order(6)
    public void updateApartmentIfApartmentNumberIsNotUnique() {
        String id = apartmentService.findAllApartments().get(0).getId();
        Apartment apartment = new Apartment();
        apartment.setId(id);
        apartment.setApartmentNumber(2);
        apartment.setNumberOfRooms(3);
        apartment.setApartmentCost(BigDecimal.valueOf(100));
        apartmentService.update(apartment);
        Assertions.assertNotEquals(apartment.getApartmentNumber(), apartmentService.findAllApartments().get(0).getApartmentNumber());
    }

    @Test
    @Order(7)
    public void updateApartmentIfNumberOfRoomsIsNotValid() {
        String id = apartmentService.findAllApartments().get(0).getId();
        Apartment apartment = new Apartment();
        apartment.setId(id);
        apartment.setApartmentNumber(20);
        apartment.setNumberOfRooms(6);
        apartment.setApartmentCost(BigDecimal.valueOf(0));
        apartmentService.update(apartment);
        Assertions.assertNotEquals(apartment.getNumberOfRooms(), apartmentService.findAllApartments().get(0).getNumberOfRooms());
    }

    @Test
    @Order(8)
    public void updateApartmentIfApartmentCostIsNotValid() {
        String id = apartmentService.findAllApartments().get(0).getId();
        Apartment apartment = new Apartment();
        apartment.setId(id);
        apartment.setApartmentNumber(20);
        apartment.setNumberOfRooms(6);
        apartment.setApartmentCost(BigDecimal.valueOf(0));
        apartmentService.update(apartment);
        Assertions.assertNotEquals(apartment.getApartmentCost(), apartmentService.findAllApartments().get(0).getApartmentCost());
    }

    @Test
    @Order(9)
    public void addTenantToApartmentIfAmountOfMoneyTenantLessThanCostOfApartment() {
        Tenant tenant = TenantGenerationUtil.generateTenant("test", BigDecimal.valueOf(1));
        tenantService.create(tenant);
        Apartment apartment = apartmentService.findAllApartments().get(0);
        apartmentService.addTenantToApartment(apartment, tenant);
        Assertions.assertEquals(0, apartment.getAmountOfTenants());
    }

    @Test
    @Order(10)
    public void addTenantToApartmentIfAmountOfMoneyTenantEnoughToGetRoomInApartment() {
        Tenant tenant = TenantGenerationUtil.generateTenant("test", BigDecimal.valueOf(1000));
        tenantService.create(tenant);
        Apartment apartment = apartmentService.findAllApartments().get(0);
        apartmentService.addTenantToApartment(apartment, tenant);
        Assertions.assertEquals(1, apartment.getAmountOfTenants());
    }

    @Test
    @Order(11)
    public void addTenantToApartmentIfApartmentIsFullOfTenants() {
        Apartment apartment = apartmentService.findAllApartments().get(1);
        int numberOfRooms = apartment.getNumberOfRooms();
        Tenant[] tenants = new Tenant[numberOfRooms];
        for (int i = 0; i < tenants.length; i++) {
            tenants[i] = TenantGenerationUtil.generateTenant("test", BigDecimal.valueOf(1000));
            tenantService.create(tenants[i]);
        }
        for (int i = 0; i < numberOfRooms; i++) {
            apartmentService.addTenantToApartment(apartment, tenants[i]);
        }
        Tenant tenantRedundant = TenantGenerationUtil.generateTenant("test", BigDecimal.valueOf(1000));
        apartmentService.addTenantToApartment(apartment, tenantRedundant);
        Assertions.assertNotEquals(apartment.getAmountOfTenants() + 1, apartment.getAmountOfTenants());
    }

    @Test
    @Order(12)
    public void deleteTenantFromApartmentIfHeDoesNotLiveInApartment() {
        Apartment apartment = apartmentService.findAllApartments().get(1);
        Tenant tenant = TenantGenerationUtil.generateTenant("test", BigDecimal.valueOf(1000));
        tenantService.create(tenant);
        apartmentService.deleteTenantFromApartment(apartment, tenant);
        Assertions.assertNotEquals(apartment.getAmountOfTenants() - 1, apartment.getAmountOfTenants());
    }

    @Test
    @Order(13)
    public void deleteTenantFromApartmentIfHeLivesInApartment() {
        Apartment apartment = apartmentService.findAllApartments().get(2);
        Tenant tenant = TenantGenerationUtil.generateTenant("test", BigDecimal.valueOf(1000));
        tenantService.create(tenant);
        apartmentService.addTenantToApartment(apartment, tenant);
        apartmentService.deleteTenantFromApartment(apartment, tenant);
        Assertions.assertEquals(0, apartment.getAmountOfTenants());
    }

    @Test
    @Order(14)
    public void deleteApartmentIfTenantsLiveInIt() {
        Apartment apartment = apartmentService.findAllApartments().get(1);
        apartmentService.delete(apartment.getId());
        Assertions.assertNotEquals(APARTMENTS_SIZE - 1, apartmentService.findAllApartments().size());
    }

    @Test
    @Order(15)
    public void deleteApartmentIfTenantsDoesNotLiveInIt() {
        ApartmentArray apartmentArray = apartmentService.findAllApartments();
        Apartment apartment = apartmentArray.get(3);
        Assertions.assertEquals(APARTMENTS_SIZE, apartmentArray.size());
        apartmentService.delete(apartment.getId());
        Assertions.assertEquals(APARTMENTS_SIZE - 1, apartmentArray.size());
    }
}
