package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ITransferService;

@Controller
public class TransferController {
    @Autowired
    private ITransferService service;

    @GetMapping("/transfer")
    public String transfer(@RequestParam Double usd, Model model) {
        double result = service.transfer(usd);
        model.addAttribute("result", result);
        model.addAttribute("usd", usd);
        return "result";
    }
}
