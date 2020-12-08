package com.project.service;

import com.project.entity.SmartPhone;

public interface SmartPhoneService {
    Iterable<SmartPhone> findAll();
    SmartPhone findById(Integer id);
    SmartPhone save(SmartPhone phone);
    SmartPhone remove(Integer id);
}
