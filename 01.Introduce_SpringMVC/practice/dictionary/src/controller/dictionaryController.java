package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class dictionaryController {
    @GetMapping("/search")
    public static String showResult(@RequestParam String keyWord,Model model){
        Map<String,String> list = new HashMap<>();
        String result=null;
        list.put("hello","Xin Chào");
        list.put("Love","Tình Yêu");
        list.put("Bike","Xe Máy");
        list.put("Planet","Hành Tinh");

        for (Map.Entry<String, String> entry : list.entrySet()) {
            if(keyWord.equals(entry.getKey())) {
                result = list.get(keyWord);
                model.addAttribute("result", result);
                break;
            }else {
                result = "Can't find anything like that";
                model.addAttribute("result", result);
            }
        }

        return "result";
    }

}
