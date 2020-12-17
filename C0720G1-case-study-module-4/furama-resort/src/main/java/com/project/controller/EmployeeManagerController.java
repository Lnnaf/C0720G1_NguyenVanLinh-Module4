package com.project.controller;

import com.project.entity.Employee;
import com.project.entity.WebUser;
import com.project.service.DivisionService;
import com.project.service.EducationService;
import com.project.service.EmployeeService;
import com.project.service.PositionService;
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
public class EmployeeManagerController {
    @Autowired
    private PositionService positionService;
    @Autowired
    private EducationService educationService;
    @Autowired
    private DivisionService divisionService;
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/employee-manager")
    public String employeeManager(Model model, @PageableDefault(size = 5)Pageable pageable,Optional<String> search){
        String nameAfterCheck = "";
        if (!search.isPresent()) {
            model.addAttribute("listEmployee", employeeService.findAllPage(pageable));
        } else {
            nameAfterCheck = search.get();
            model.addAttribute("listEmployee", this.employeeService.findAllByEmployeeNameContaining(nameAfterCheck, pageable));
        }
        model.addAttribute("name", nameAfterCheck);
        model.addAttribute("employeeObj",new Employee());
        model.addAttribute("listPosition",positionService.findAllPosition());
        model.addAttribute("listEducation",educationService.findAllEducation());
        model.addAttribute("listDivision",divisionService.findAllDivision());
        return "employee-manager";
    }
    @PostMapping("/employee-create")
    public String employeeCreate(@PageableDefault(size = 5)Pageable pageable,Model model, @Valid @ModelAttribute("employeeObj") Employee employee, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            model.addAttribute("flag","1");
            model.addAttribute("listEmployee", employeeService.findAllPage(pageable));
            model.addAttribute("listPosition",positionService.findAllPosition());
            model.addAttribute("listEducation",educationService.findAllEducation());
            model.addAttribute("listDivision",divisionService.findAllDivision());
            return "employee-manager";
        }else {
            WebUser webUser = new WebUser();
            webUser.setUsername("default");
            employee.setWebUser(webUser);
            employeeService.save(employee);
            return "redirect:/employee-manager";
        }
    }
    @GetMapping("/employee-delete/{id}")
    public String employeeDelete(@PathVariable Integer id){
        employeeService.delete(id);
        return "redirect:/employee-manager";
    }
    @PostMapping("/employee-edit")
    public String employeeUpdate(@PageableDefault(size = 5)Pageable pageable,Model model, @Valid @ModelAttribute("employeeObj") Employee employee, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            model.addAttribute("flag","2");
            model.addAttribute("listEmployee", employeeService.findAllPage(pageable));
            model.addAttribute("listPosition",positionService.findAllPosition());
            model.addAttribute("listEducation",educationService.findAllEducation());
            model.addAttribute("listDivision",divisionService.findAllDivision());
            return "employee-manager";
        }else {
            employeeService.save(employee);
            return "redirect:/employee-manager";
        }
    }

}
