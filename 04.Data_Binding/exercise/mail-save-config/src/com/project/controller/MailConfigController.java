package com.project.controller;

import com.project.entity.MailConfig;
import com.project.service.MailConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MailConfigController {
    @GetMapping("")
    public String goHomePage(){
        return "index";
    }
    @Autowired
    private MailConfigService mailConfigService;
    @GetMapping("/list")
    public String showList(Model model){
        List<String> listLanguage = mailConfigService.getLanguage();
        List<String> listSizePage = mailConfigService.getSizePage();
        model.addAttribute("listLanguage",listLanguage);
        model.addAttribute("listSizePage",listSizePage);
        model.addAttribute("mailConfig",new MailConfig());
        return "list";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("mailConfig") MailConfig mailConfig,Model model){
        model.addAttribute("language",mailConfig.getLanguage());
        model.addAttribute("pageSize",mailConfig.getPageSize());
        model.addAttribute("spamFilter",mailConfig.isSpamFilter());
        model.addAttribute("signature",mailConfig.getSignature());
        return "result";
    }

}
