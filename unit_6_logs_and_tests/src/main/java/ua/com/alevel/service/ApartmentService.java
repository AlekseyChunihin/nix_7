package ua.com.alevel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.InMemoryApartmentDao;
import ua.com.alevel.entity.Apartment;
import ua.com.alevel.entity.Tenant;
import ua.com.alevel.storage.ApartmentArray;

import java.math.BigDecimal;

public class ApartmentService {

    private final InMemoryApartmentDao apartmentDao = new InMemoryApartmentDao();

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");

    public void create(Apartment apartment) {
        if (isApartmentNumberCorrectAndUnique(apartment.getApartmentNumber()) && isNumberOfRoomsCorrect(apartment.getNumberOfRooms()) && isApartmentCostCorrect(apartment.getApartmentCost())) {
            LOGGER_INFO.info("create new apartment with number: " + apartment.getApartmentNumber());
            apartmentDao.create(apartment);
        }
    }

    public void update(Apartment apartment) {
        if (isApartmentNumberCorrectAndUnique(apartment.getApartmentNumber()) && isNumberOfRoomsCorrect(apartment.getNumberOfRooms()) && isApartmentCostCorrect(apartment.getApartmentCost()) && isApartmentWithoutTenants(apartment.getId())) {
            LOGGER_INFO.info("update apartment with number: " + apartment.getApartmentNumber());
            apartmentDao.update(apartment);
        }
    }

    public void delete(String id) {
        if (isApartmentWithoutTenants(id)) {
            LOGGER_WARN.warn("remove apartment by id: " + id);
            apartmentDao.delete(id);
        }
    }

    public void addTenantToApartment(Apartment apartment, Tenant tenant) {
        if (doesTheTenantHaveEnoughMoneyToPayForTheApartment(tenant.getAmountOfMoney(), apartment.getApartmentCost())
                && doesTheApartmentHasFreeRoom(apartment)) {
            LOGGER_INFO.info("add tenant " + tenant.getName() + " to apartment with number: " + apartment.getApartmentNumber());
            tenant.setAmountOfMoney(tenant.getAmountOfMoney().subtract(apartment.getApartmentCost()));
            tenant.setApartment(apartment);
            apartmentDao.addTenantToApartment(apartment, tenant);
        }
    }

    public void deleteTenantFromApartment(Apartment apartment, Tenant tenant) {
        if (isApartmentConsistsTenants(apartment.getId()) && doesTheTenantLiveInTheApartment(apartment, tenant.getId())) {
            LOGGER_INFO.info("remove tenant " + tenant.getName() + " from apartment with number: " + apartment.getApartmentNumber());
            apartmentDao.deleteTenantFromApartment(apartment, tenant);
            tenant.setApartment(null);
        }
    }

    public ApartmentArray findAllApartments() {
        return apartmentDao.findAllApartments();
    }

    public Apartment findApartmentById(String id) {
        return apartmentDao.findApartmentById(id);
    }

    private boolean isApartmentCostCorrect(BigDecimal cost) {
        return cost.compareTo(BigDecimal.valueOf(100)) > 0;
    }

    private boolean isNumberOfRoomsCorrect(int numberOfRooms) {
        return numberOfRooms > 0 && numberOfRooms < 5;
    }

    private boolean isApartmentNumberCorrectAndUnique(int apartmentNumber) {
        ApartmentArray apartmentArray = findAllApartments();
        for (int i = 0; i < apartmentArray.size(); i++) {
            if (apartmentArray.get(i).getApartmentNumber() == apartmentNumber) {
                return false;
            }
        }
        return apartmentNumber > 0;
    }

    private boolean isApartmentWithoutTenants(String id) {
        return (findApartmentById(id).getAmountOfTenants() == 0);
    }

    private boolean isApartmentConsistsTenants(String id) {
        return (findApartmentById(id).getAmountOfTenants() > 0);
    }

    private boolean doesTheTenantHaveEnoughMoneyToPayForTheApartment(BigDecimal amountOfMoneyOfTheTenant, BigDecimal apartmentCost) {
        return amountOfMoneyOfTheTenant.compareTo(apartmentCost) > 0;
    }

    private boolean doesTheTenantLiveInTheApartment(Apartment apartment, String tenantId) {
        return apartment.getTenantArray().find(tenantId);
    }

    private boolean doesTheApartmentHasFreeRoom(Apartment a) {
        return a.getTenantArray().amountOfTenants() < a.getNumberOfRooms();
    }
}