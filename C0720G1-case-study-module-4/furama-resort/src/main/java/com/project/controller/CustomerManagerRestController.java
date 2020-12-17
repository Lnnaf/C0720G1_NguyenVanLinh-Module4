package com.project.controller;
import com.project.entity.*;
import com.project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class CustomerManagerRestController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private AttachServiceService attachServiceService;
    @GetMapping("/customer-detail/{id}")
    public  ResponseEntity<Customer> getCustomerDetail(@PathVariable Integer id){
        Customer customer = customerService.findById(id);
        return  new ResponseEntity<>(customer,HttpStatus.ACCEPTED);
    }
    @GetMapping("/service-detail/{id}")
    public  ResponseEntity<Service> getServiceDetail(@PathVariable Integer id){
        Service service = serviceService.findById(id);
        return  new ResponseEntity<>(service,HttpStatus.ACCEPTED);
    }
    @GetMapping("/employee-detail/{id}")
    public  ResponseEntity<Employee> getEmployeeDetail(@PathVariable Integer id){
        Employee employee = employeeService.findById(id);
        return  new ResponseEntity<>(employee,HttpStatus.ACCEPTED);
    }
    @GetMapping("/attach-detail/{id}")
    public  ResponseEntity<AttachService> getAttachDetail(@PathVariable Integer id){
        AttachService employee = attachServiceService.findById(id);
        return  new ResponseEntity<>(employee,HttpStatus.ACCEPTED);
    }
    @GetMapping("test")
    public  ResponseEntity<List<Contract>> getContractIsExpired(){
        List<Contract> contracts = contractService.findAllContractIsExpired();
        return  new ResponseEntity<>(contracts,HttpStatus.ACCEPTED);
    }
}
