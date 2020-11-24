package com.project.controller;

import com.project.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("")
    private String goHome(){
        return "index";
    }
    @Autowired
    private CalculatorService calculatorService;
    @PostMapping("operator")
    private String plus(@RequestParam double num1, double num2,String action, Model model){
        switch (action){
            case "add":
                model.addAttribute("operator","Addition");
                model.addAttribute("result",calculatorService.operatorAdd(num1,num2));
                break;
            case "sub":
                model.addAttribute("operator","Subtraction");
                model.addAttribute("result",calculatorService.operatorSub(num1,num2));
                break;
            case "multi":
                model.addAttribute("operator","Multiplication");
                model.addAttribute("result",calculatorService.operatorMulti(num1,num2));
                break;
            case "division":
                if(num2==0){
                    String result = "Infinity";
                    model.addAttribute("operator","Division");
                    model.addAttribute("result",result);
                }else{
                    model.addAttribute("operator","Division");
                    model.addAttribute("result",calculatorService.operatorDivision(num1,num2));
                }
                break;
        }
        return "index";
    }


}
