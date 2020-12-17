package com.project.service.impl;

import com.project.entity.Division;
import com.project.repository.DivisionRepository;
import com.project.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    private DivisionRepository divisionRepository;
    @Override
    public List<Division> findAllDivision() {
        return divisionRepository.findAll();
    }
}
