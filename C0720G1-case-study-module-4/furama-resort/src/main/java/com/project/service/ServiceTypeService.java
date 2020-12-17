package com.project.service;

import com.project.entity.Service;
import com.project.entity.ServiceType;

import java.util.List;

public interface ServiceTypeService {
    void save(ServiceType serviceType);
    void delete(Integer id);
    List<ServiceType> findAllServiceType();
    ServiceType findById(Integer id);
}
