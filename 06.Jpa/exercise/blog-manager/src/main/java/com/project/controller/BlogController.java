package com.project.controller;

import com.project.entity.BlogEntity;
import com.project.service.BlogService;
import com.project.service.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class BlogController {
    @Autowired
    private BlogServiceImpl blogService;

    @GetMapping("")
    public String goList(Model model) {
        model.addAttribute("listBlog", blogService.findAll());
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
        return "blog-post";
    }
    @GetMapping("detail")
    public String detail(Model model, @RequestParam int id) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog-detail";
    }
    @GetMapping("delete")
    public String delete(@RequestParam int id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "blog-delete";
    }
    @PostMapping("delete")
    public  String deletePost(@ModelAttribute BlogEntity blogEntity){
        blogService.delete(blogEntity);
        return "redirect:/";
    }
    @GetMapping("update")
    public String updateForm(@RequestParam int id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "blog-update";
    }
    @PostMapping("update")
    public  String update(@ModelAttribute BlogEntity blogEntity){
        blogService.save(blogEntity);
        return "redirect:/";
    }

}
