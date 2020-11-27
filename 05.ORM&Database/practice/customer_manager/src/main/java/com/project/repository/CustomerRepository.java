package com.project.repository;

import com.project.entity.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    void save(Customer customer);
    void update(Customer customer);
}
