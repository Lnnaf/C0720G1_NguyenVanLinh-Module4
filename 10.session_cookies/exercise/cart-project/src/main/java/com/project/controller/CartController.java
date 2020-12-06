package com.project.controller;

import com.project.entity.Cart;
import com.project.entity.Items;
import com.project.entity.Users;
import com.project.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"user", "cartItems"})
public class CartController {
    @Autowired
    private ItemService itemService;
    @GetMapping("")
    public String home(Model model, @ModelAttribute("user")Users user){
        user.setFullName("Alo");
            model.addAttribute("listItems",itemService.findAll());
        return "index";
    }
    @GetMapping("detail")
    public String detailItem(@RequestParam int id,Model model){
        model.addAttribute("itemObj",itemService.findById(id));

        return "detail";
    }
    @GetMapping("add-to-card")
    public String addCart(@RequestParam int id,@ModelAttribute("cart")Cart cart){
        if(cart.getListItems().size() == 0){
            List<Items> listItems = new ArrayList<>();
            listItems.add(itemService.findById(id));
            cart.setListItems(listItems);
        }else{
            List<Items> listItems = cart().getListItems();
            Items items = itemService.findById(id);
            listItems.add(items);
            cart.setListItems(listItems);
        }

        return "cart-item";
    }
    @ModelAttribute("user")
    public Users User(){
        return new Users();
    }
    @ModelAttribute("cartItems")
    public Cart cart(){
        return new Cart();
    }
}
