package ua.com.alevel.facade;

import ua.com.alevel.dto.TenantDto;

import java.math.BigDecimal;
import java.util.List;

public interface TenantFacade {

    void create(String name, BigDecimal amountOfMoney);

    void update(TenantDto tenantDto);

    void delete(String id);

    TenantDto findById(String id);

    List<TenantDto> findAllTenants();
}
