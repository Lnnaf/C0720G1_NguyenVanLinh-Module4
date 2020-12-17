package com.project.service;

import com.project.entity.Contract;
import com.project.entity.Service;

import java.util.List;

public interface ServiceService {
    void save(Service service);
    void delete(Integer id);
    List<Service> findAllService();
    Service findById(Integer id);
}
