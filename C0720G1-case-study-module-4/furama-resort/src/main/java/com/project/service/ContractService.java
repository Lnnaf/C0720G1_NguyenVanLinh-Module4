package com.project.service;

import com.project.entity.Contract;
import com.project.entity.Customer;
import com.project.entity.CustomerType;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface ContractService {
    void save(Contract contract);
    void delete(Integer id);
    List<Contract> findAll();
    List<Contract> findAllContractIsExpired();
    Contract findById(Integer id);
    void checkDate(Contract contract, BindingResult bindingResult);
}
