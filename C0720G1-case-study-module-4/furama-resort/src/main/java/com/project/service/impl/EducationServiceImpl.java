package com.project.service.impl;

import com.project.entity.EducationDegree;
import com.project.repository.EducationDegreeRepository;
import com.project.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationServiceImpl implements EducationService {
    @Autowired
    private EducationDegreeRepository educationDegreeRepository;
    @Override
    public List<EducationDegree> findAllEducation() {
        return educationDegreeRepository.findAll();
    }
}
