package com.project.service;

import com.project.entity.RentType;
import com.project.entity.ServiceType;

import java.util.List;

public interface RentTypeService {
    void save(RentType rentType);
    void delete(Integer id);
    List<RentType> findAllRentType();
    RentType findById(Integer id);
}
