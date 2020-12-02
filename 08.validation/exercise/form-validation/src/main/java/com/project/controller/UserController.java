package com.project.controller;

import com.project.entity.User;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("")
    public String home(Model model){
        model.addAttribute("listUser",userService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String goForm(Model model){
        model.addAttribute("user",new User());
        return "form";
    }
    @PostMapping("create")
    public String create(RedirectAttributes redirectAttributes,@Valid @ModelAttribute User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "form";
        }
        userService.save(user);
        redirectAttributes.addFlashAttribute("message","Success!");
        return "redirect:/";
    }
}
