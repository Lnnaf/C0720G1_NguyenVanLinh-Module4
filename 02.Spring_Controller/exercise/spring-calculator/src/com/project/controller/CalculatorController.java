package com.project.controller;

import com.project.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("")
    private String goHome(){
        return "index";
    }
    @Qualifier("calculatorServiceAddImpl")
    @Autowired
    private CalculatorService calculatorServicePlus;
    @GetMapping("plus")
    private String plus(@RequestParam double num1, double num2, Model model){
        model.addAttribute("operator","Addition");
        model.addAttribute("result",calculatorServicePlus.operator(num1,num2));
        return "index";
    }

    @Qualifier("calculatorServiceSubImpl")
    @Autowired
    private CalculatorService calculatorServiceSub;
    @GetMapping("sub")
    private String sub(@RequestParam double num1, double num2, Model model){
        model.addAttribute("operator","Subtraction");
        model.addAttribute("result",calculatorServiceSub.operator(num1,num2));
        return "index";
    }

    @Qualifier("calculatorServiceMultiImpl")
    @Autowired
    private CalculatorService calculatorServiceMulti;
    @GetMapping("multi")
    private String multi(@RequestParam double num1, double num2, Model model){
        model.addAttribute("operator","Multiplication");
        model.addAttribute("result",calculatorServiceMulti.operator(num1,num2));
        return "index";
    }

    @Qualifier("calculatorServiceDivisionImpl")
    @Autowired
    private CalculatorService calculatorServiceDivision;
    @GetMapping("division")
    private String division(@RequestParam double num1, double num2, Model model){
        if(num2==0){
            String result = "Infinity";
            model.addAttribute("operator","Division");
            model.addAttribute("result",result);
        }else{
            model.addAttribute("operator","Division");
            model.addAttribute("result",calculatorServiceDivision.operator(num1,num2));
        }
        return "index";
    }

}
