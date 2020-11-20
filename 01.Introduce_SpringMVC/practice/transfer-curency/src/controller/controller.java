package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controller {
@GetMapping("/transfer")
    public String transfer(@RequestParam String usd, Model model){
    int rate = 23177;
    Double result = Double.parseDouble(usd)*rate;
    model.addAttribute("result",result);
    model.addAttribute("rate",rate);
    model.addAttribute("usd",usd);
    return "result";
}
}
