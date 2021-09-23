package ua.com.alevel.dao.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ua.com.alevel.dao.ApartmentDao;
import ua.com.alevel.entity.Apartment;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ApartmentDaoImpl implements ApartmentDao {

    public static final String APARTMENTS_JSON = "src/main/resources/apartments.json";

    @Override
    public void create(Apartment apartment) {
        List<Apartment> apartments = fromJsonToListApartments();
        apartment.setId(generateId());
        apartments.add(apartment);
        fromListApartmentsToJson(apartments);
    }

    @Override
    public void update(Apartment apartment) {
        Apartment inDbApartment = findApartmentById(apartment.getId());
        inDbApartment.setApartmentNumber(apartment.getApartmentNumber());
        inDbApartment.setApartmentCost(apartment.getApartmentCost());
        inDbApartment.setNumberOfRooms(apartment.getNumberOfRooms());
        List<Apartment> apartments = fromJsonToListApartments();
        for (int i = 0; i < apartments.size(); i++) {
            if (apartments.get(i).getId().equals(apartment.getId())) {
                apartments.set(i, inDbApartment);
            }
        }
        fromListApartmentsToJson(apartments);
    }

    @Override
    public void addTenantToApartment(Apartment apartment, String tenantId) {
        Apartment inDbApartment = findApartmentById(apartment.getId());
        inDbApartment.setTenantIntoApartment(tenantId);
        List<Apartment> apartments = fromJsonToListApartments();
        for (int i = 0; i < apartments.size(); i++) {
            if (apartments.get(i).getId().equals(inDbApartment.getId())) {
                apartments.set(i, inDbApartment);
            }
        }
        fromListApartmentsToJson(apartments);
    }

    @Override
    public void deleteTenantFromApartment(Apartment apartment, String tenantId) {
        Apartment inDbApartment = findApartmentById(apartment.getId());
        inDbApartment.removeTenantFromApartment(tenantId);
        List<Apartment> apartments = fromJsonToListApartments();
        for (int i = 0; i < apartments.size(); i++) {
            if (apartments.get(i).getId().equals(inDbApartment.getId())) {
                apartments.set(i, inDbApartment);
            }
        }
        fromListApartmentsToJson(apartments);
    }

    @Override
    public Apartment findApartmentById(String id) {
        List<Apartment> apartments = fromJsonToListApartments();
        for (int i = 0; i < apartments.size(); i++) {
            if (apartments.get(i).getId().equals(id)) {
                return apartments.get(i);
            }
        }
        return null;
    }

    @Override
    public String generateId() {
        List<Apartment> apartments = fromJsonToListApartments();
        String id = UUID.randomUUID().toString();
        for (Apartment apartment : apartments) {
            if (apartment.getId().equals(id)) {
                return generateId();
            }
        }
        return id;
    }

    @Override
    public List<Apartment> findAllApartments() {
        return fromJsonToListApartments();
    }

    @Override
    public void delete(String id) {
        List<Apartment> apartments = fromJsonToListApartments();
        apartments.removeIf(apartment -> apartment.getId().equals(id));
        fromListApartmentsToJson(apartments);
    }

    public List<Apartment> fromJsonToListApartments() {
        Gson gson = new Gson();
        String s = null;
        try {
            s = Files.readString(Paths.get(APARTMENTS_JSON));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (s.isEmpty()) {
            return new ArrayList<>();
        }
        return gson.fromJson(s, new TypeToken<List<Apartment>>() {
        }.getType());
    }

    public void fromListApartmentsToJson(List<Apartment> apartments) {
        Gson gson = new Gson();
        String apartmentsInJsonFormat = gson.toJson(apartments);
        Path path = Paths.get(APARTMENTS_JSON);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            writer.write(apartmentsInJsonFormat);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
