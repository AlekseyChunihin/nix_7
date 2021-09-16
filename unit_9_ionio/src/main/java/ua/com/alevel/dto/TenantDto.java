package ua.com.alevel.dto;

import ua.com.alevel.entity.Apartment;
import ua.com.alevel.entity.Tenant;

import java.math.BigDecimal;

public class TenantDto {

    String id;
    String name;
    BigDecimal amountOfMoney;
    Apartment apartment;

    public TenantDto() {
    }

    public TenantDto(Tenant tenant) {
        this.id = tenant.getId();
        this.name = tenant.getName();
        this.amountOfMoney = tenant.getAmountOfMoney();
        this.apartment = tenant.getApartment();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(BigDecimal amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", amountOfMoney=" + amountOfMoney +
                ", \napartment=" + apartment +
                '}';
    }
}
