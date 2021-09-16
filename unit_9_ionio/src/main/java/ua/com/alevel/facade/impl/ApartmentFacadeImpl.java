package ua.com.alevel.facade.impl;

import ua.com.alevel.dto.ApartmentDto;
import ua.com.alevel.entity.Apartment;
import ua.com.alevel.facade.ApartmentFacade;
import ua.com.alevel.service.ApartmentService;
import ua.com.alevel.service.impl.ApartmentServiceImpl;
import ua.com.alevel.storage.ApartmentArray;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ApartmentFacadeImpl implements ApartmentFacade {

    public ApartmentService apartmentService = new ApartmentServiceImpl();

    @Override
    public void create(int apartmentNumber, BigDecimal cost, int numberOfRooms) {
        Apartment apartment = new Apartment(apartmentNumber, cost, numberOfRooms);
        apartmentService.create(apartment);
    }

    public ApartmentServiceImpl getApartmentService() {
        return (ApartmentServiceImpl) apartmentService;
    }

    @Override
    public void update(ApartmentDto apartmentDto) {
        Apartment apartment = apartmentService.findApartmentById(apartmentDto.getId());
        apartment.setApartmentNumber(apartmentDto.getApartmentNumber());
        apartment.setApartmentCost(apartmentDto.getApartmentCost());
        apartment.setNumberOfRooms(apartmentDto.getNumberOfRooms());
        apartmentService.update(apartment);
    }

    @Override
    public void deleteById(String id) {
        apartmentService.delete(id);
    }

    @Override
    public ApartmentDto findById(String id) {
        Apartment apartment = apartmentService.findApartmentById(id);
        if(apartment != null) {
            return new ApartmentDto(apartment);
        }
        return null;
    }

    @Override
    public List<ApartmentDto> findAllApartments() {
        List<ApartmentDto> apartmentDtos = new ArrayList<>();
        ApartmentArray apartments  = apartmentService.findAllApartments();
        for (int i = 0; i < apartments.size(); i++) {
            apartmentDtos.add((new ApartmentDto(apartments.get(i))));
        }
        return apartmentDtos;
    }
}
