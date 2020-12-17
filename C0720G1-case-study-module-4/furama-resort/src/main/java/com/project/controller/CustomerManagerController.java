package com.project.controller;

import com.project.entity.Customer;
import com.project.service.ContractService;
import com.project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("employee")
public class CustomerManagerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ContractService contractService;

    @GetMapping("/customer-manager")
    public String customerManager(@PageableDefault(size = 5)Pageable pageable, Model model, Optional<String> search) {
        String nameAfterCheck = "";
        if (!search.isPresent()) {
            model.addAttribute("listCustomer", customerService.findAllPage(pageable));
        } else {
            nameAfterCheck = search.get();
            model.addAttribute("listCustomer", this.customerService.findAllByCustomerNameContaining(nameAfterCheck, pageable));
        }
        model.addAttribute("name", nameAfterCheck);
        model.addAttribute("customerObj", new Customer());
        model.addAttribute("listCustomerType", customerService.findAllCustomerType());
        model.addAttribute("listCustomerUsingService", contractService.findAllContractIsExpired());
        return "customer-manager";
    }

    @PostMapping("/create")
    public String createNewCustomer(@PageableDefault(size = 5) Pageable pageable, Model model, @Valid @ModelAttribute("customerObj") Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("flag","1");
            model.addAttribute("listCustomer", customerService.findAllPage(pageable));
            model.addAttribute("listCustomerType", customerService.findAllCustomerType());
            model.addAttribute("listCustomerType", customerService.findAllCustomerType());
            return "customer-manager";
        }
        customerService.save(customer);
        return "redirect:/employee/customer-manager";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        customerService.delete(id);
        return "customer-manager";
    }

    @PostMapping("/update")
    public String updateCustomer(Model model,@Valid @ModelAttribute("customerObj") Customer customer, BindingResult bindingResult,Pageable pageable) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("flag","2");
            model.addAttribute("listCustomer", customerService.findAllPage(pageable));
            model.addAttribute("listCustomerType", customerService.findAllCustomerType());
            model.addAttribute("listCustomerType", customerService.findAllCustomerType());
            return "customer-manager";
        }
        customerService.save(customer);
        return "redirect:/employee/customer-manager";
    }
}
