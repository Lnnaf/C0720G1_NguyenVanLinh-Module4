package com.project.service.impl;

import com.project.entity.Service;
import com.project.repository.ServiceRepository;
import com.project.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;
    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void delete(Integer id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public List<Service> findAllService() {
        return serviceRepository.findAll();
    }

    @Override
    public Service findById(Integer id) {
        return serviceRepository.findById(id).orElse(null);
    }
}
