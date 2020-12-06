package com.project.controller;

import com.project.entity.BlogEntity;
import com.project.entity.Category;
import com.project.service.BlogService;
import com.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("" )
    public String goList(Model model, @PageableDefault(size = 5) Pageable pageable, Optional<String> name) {
        String nameAfterCheck = "";

        if (!name.isPresent()) {
            model.addAttribute("listBlog", this.blogService.findAll(pageable));
        } else {
            nameAfterCheck = name.get();
            model.addAttribute("listBlog", this.blogService.findAllByNameContaining(nameAfterCheck, pageable));
        }
        model.addAttribute("name", nameAfterCheck);
        model.addAttribute("listCategory", categoryService.findAll());
        return "blog-list";
    }

    @PostMapping("create")
    public String create(@ModelAttribute BlogEntity blogEntity, RedirectAttributes redirect) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String strDate = dateFormat.format(date);
        blogEntity.setDate(strDate);
        blogService.save(blogEntity);
        redirect.addFlashAttribute("message", "Success");
        return "redirect:/";
    }

    @GetMapping("posting")
    public String posting(Model model) {
        model.addAttribute("blog", new BlogEntity());
        model.addAttribute("listCategory",categoryService.findAll());
        return "blog-post";
    }

    @GetMapping("detail")
    public String detail(Model model, @RequestParam int id) {
        BlogEntity blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        model.addAttribute("listCategory",categoryService.findAll());
        return "blog-detail";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog-delete";
    }

    @PostMapping("delete")
    public String deletePost(@ModelAttribute BlogEntity blogEntity) {
        blogService.delete(blogEntity);
        return "redirect:/";
    }

    @GetMapping("update")
    public String updateForm(@RequestParam int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog-update";
    }

    @PostMapping("update")
    public String update(@ModelAttribute BlogEntity blogEntity) {
        blogService.save(blogEntity);
        return "redirect:/";
    }

    @GetMapping("category")
    public String list(@RequestParam Optional<Integer> id, Model model, @PageableDefault(size = 1) Pageable pageable) {
        int id2 = 0;
        if (id.isPresent()) {
            id2 = id.get();
            model.addAttribute("listBlog", blogService.findAllByCategory_id(id2, pageable));
        }
        model.addAttribute("id", id2);
        model.addAttribute("listCategory", categoryService.findAll());
        return "blog-list-by-category";
    }
    @GetMapping("admin")
    public String goAdmin(Model model){
        model.addAttribute("listCategory",categoryService.findAll());
        return "admin-dashboard";
    }
    @GetMapping("addCategory")
    public String add(Model model) {
        model.addAttribute("category", new Category());
        return "category-adding";
    }

    @PostMapping("category-adding")
    public String adding(@ModelAttribute Category category, RedirectAttributes redirect) {
        categoryService.save(category);
        redirect.addFlashAttribute("message", "Success");
        return "redirect:/admin";
    }
    @GetMapping("form-update-category")
    public String updateFormCategory(@RequestParam int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category-update";
    }

    @PostMapping("category-update")
    public String updateCategory(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/admin";
    }
    @GetMapping("form-delete-category")
    public String deleteFormCategory(@RequestParam int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category-delete";
    }

    @PostMapping("category-delete")
    public String deleteCategory(@RequestParam int id) {
        categoryService.delete(id);
        return "redirect:/admin";
    }
}
