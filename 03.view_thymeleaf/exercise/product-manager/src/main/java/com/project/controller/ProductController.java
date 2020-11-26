package com.project.controller;

import com.project.model.Product;
import com.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("success", "Modified product successfully!");
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/";
    }
    @GetMapping("/detail")
    public String detail(@RequestParam int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/detail";
    }
}
