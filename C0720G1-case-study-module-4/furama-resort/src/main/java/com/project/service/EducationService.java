package com.project.service;

import com.project.entity.EducationDegree;
import com.project.entity.RentType;

import java.util.List;

public interface EducationService {
    List<EducationDegree> findAllEducation();
}
