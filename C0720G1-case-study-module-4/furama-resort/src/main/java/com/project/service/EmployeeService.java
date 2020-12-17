package com.project.service;

import com.project.entity.Customer;
import com.project.entity.CustomerType;
import com.project.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee);
    void delete(Integer id);
    List<Employee> findAll();
    Employee findById(Integer id);
    Page<Employee> findAllPage(Pageable pageable);
    Page<Employee> findAllByEmployeeNameContaining(String nameAfterCheck, Pageable pageable);
}
