package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.IDictionaryService;


@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;
    @GetMapping("/search")
    public String showResult(@RequestParam String keyWord,Model model){
       String result = dictionaryService.findWord(keyWord);
       model.addAttribute("result",result);
        return "result";
    }

}
