package com.project.controller;

import com.project.entity.SmartPhone;
import com.project.service.SmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SmartPhoneController {
    @Autowired
    private SmartPhoneService smartPhoneService;
    @GetMapping("")
    public String homePage(){
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createSmartphonePage() {
        ModelAndView mav = new ModelAndView("new-phone");
        mav.addObject("sPhone", new SmartPhone());
        return mav;
    }
    @RequestMapping(value = "/createnewPhone", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SmartPhone createSmartphone(@RequestBody SmartPhone smartphone) {
        return smartPhoneService.save(smartphone);
    }
}
