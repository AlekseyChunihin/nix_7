package ua.com.alevel;

import ua.com.alevel.array.ApartmentTenants;
import ua.com.alevel.entity.Apartment;

import java.math.BigDecimal;

public class ApartmentGenerationUtil {

    public static Apartment generateApartment(int apartmentNumber, BigDecimal apartmentCost, int numberOfRooms) {
        return new Apartment(apartmentNumber, apartmentCost, numberOfRooms);
    }

    public static int getRandomApartmentNumberOfRooms() {
        return (int) (Math.random() * 4) + 1;
    }
}
