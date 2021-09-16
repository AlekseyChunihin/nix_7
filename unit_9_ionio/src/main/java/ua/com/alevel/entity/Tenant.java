package ua.com.alevel.entity;

import java.math.BigDecimal;

public class Tenant {

    String id;
    String name;
    BigDecimal amountOfMoney;
    Apartment apartment;


    public Tenant() {
    }

    public Tenant(String name, BigDecimal amountOfMoney) {
        this.name = name;
        this.amountOfMoney = amountOfMoney;
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
