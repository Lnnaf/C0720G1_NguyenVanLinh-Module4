package com.project.service;

import com.project.entity.Customer;
import com.project.entity.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);
    void delete(Integer id);
    List<Customer> findAll();
    Customer findById(Integer id);
    List<CustomerType>findAllCustomerType();
    Page<Customer> findAllPage(Pageable pageable);
    Page<Customer> findAllByCustomerNameContaining(String name,Pageable pageable);
}
