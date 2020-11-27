package com.project.service;

import com.project.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    int randomId();
}
