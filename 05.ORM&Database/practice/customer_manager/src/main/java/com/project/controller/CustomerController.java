package com.project.controller;

import com.project.entity.Customer;
import com.project.repository.impl.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepositoryImpl customerRepository;
    @GetMapping("")
    public String showList(Customer customer,Model model){
        model.addAttribute("customer",customer);
        model.addAttribute("listCustomer",customerRepository.findAll());
        return "index";
    }
    @PostMapping("/edit")
    public String update(@ModelAttribute Customer customer, RedirectAttributes redirectAttrs){

        redirectAttrs.addFlashAttribute("message","Success!");
       return "redirect:/";
    }
}
