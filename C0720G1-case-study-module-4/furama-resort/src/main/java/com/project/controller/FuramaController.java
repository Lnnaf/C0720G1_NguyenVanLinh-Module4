package com.project.controller;

import com.project.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class FuramaController {
    @GetMapping("")
    public String homePage(Model model){
        return "index";
    }
    @GetMapping("login")
    public String loginPage(){
        return "login";
    }
    @GetMapping("/403")
    public String page403(){
        return "403";
    }
}
