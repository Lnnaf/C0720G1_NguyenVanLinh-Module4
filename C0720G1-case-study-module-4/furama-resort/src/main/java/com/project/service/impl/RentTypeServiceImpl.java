package com.project.service.impl;

import com.project.entity.RentType;
import com.project.repository.RentTypeRepository;
import com.project.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;
    @Override
    public void save(RentType rentType) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<RentType> findAllRentType() {
        return rentTypeRepository.findAll();
    }

    @Override
    public RentType findById(Integer id) {
        return null;
    }
}
