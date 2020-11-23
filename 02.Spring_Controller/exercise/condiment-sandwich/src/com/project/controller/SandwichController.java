package com.project.controller;

import com.project.service.SandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SandwichController {
    @Autowired
    private SandwichService sandwichService;

    @GetMapping("/")
    public String goHome() {
        return "index";
    }

    @GetMapping("/condiments")
    public String addCondiments(@RequestParam(value = "condiment") String[] condiment, Model model) {
        List<String> list_condiment;
        if(condiment.length==0){

            return goHome();
        }else {
            list_condiment = sandwichService.showAllCondiment(condiment);
            model.addAttribute("list_condiment", list_condiment);
            return "list_condiment";
        }
    }
}
