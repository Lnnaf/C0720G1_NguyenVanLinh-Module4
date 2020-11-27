package com.project.service.impl;

import com.project.entity.Customer;
import com.project.repository.CustomerRepository;
import com.project.repository.impl.CustomerRepositoryImpl;
import com.project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepositoryImpl customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public int randomId() {
        return (int)(Math.random()*1000);
    }
}
