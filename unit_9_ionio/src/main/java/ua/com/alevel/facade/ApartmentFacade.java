package ua.com.alevel.facade;

import ua.com.alevel.dto.ApartmentDto;
import ua.com.alevel.service.impl.ApartmentServiceImpl;

import java.math.BigDecimal;
import java.util.List;

public interface ApartmentFacade {

    public void create(int apartmentNumber, BigDecimal cost, int numberOfRooms);

    public ApartmentServiceImpl getApartmentService();

    public void update(ApartmentDto apartmentDto);

    public void deleteById(String id);

    public ApartmentDto findById(String id);

    public List<ApartmentDto> findAllApartments();
}
