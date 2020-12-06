package com.project.controller;

import com.project.entity.Product;
import com.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Scanner;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("product",productService.findAll());
        return "index";
    }
    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirect) {
        productService.update(product);
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirect) {
        productService.remove(id);;
        redirect.addFlashAttribute("message","success!");
        return "redirect:/";
    }
    @GetMapping("/detail")
    public String detail(@RequestParam int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/detail";
    }

    @GetMapping("/create")
    public String goCreateStudent(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String createStudent(Model model, @ModelAttribute Product product,
                                RedirectAttributes redirectAttributes) {
        product.setId_product(productService.randomId());
        this.productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Register successfully!");
        return "redirect:/";
    }

}
