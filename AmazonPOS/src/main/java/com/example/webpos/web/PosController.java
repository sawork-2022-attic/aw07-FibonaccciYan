package com.example.webpos.web;

import com.example.webpos.biz.PosService;
import com.example.webpos.model.Cart;
import com.example.webpos.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class PosController {

    private PosService posService;

    private Cart cart;

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Autowired
    public void setPosService(PosService posService) {
        this.posService = posService;
    }

    @GetMapping("/")
    public String pos(Model model) {
        // posService.add("PD1",2);
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("total", posService.total(posService.getCart()));
        return "index";
    }

    @GetMapping("/add/{productId}/{amount}")
    public String add(Model model, @PathVariable String productId, @PathVariable int amount) {
        if(amount > 0) {
            posService.add(productId, amount);
        }
        return "redirect:/";
    }

    @GetMapping("/sub/{productId}/{amount}")
    public String sub(Model model, @PathVariable String productId, @PathVariable int amount) {
        posService.sub(productId, amount);
        return "redirect:/";
    }

    @GetMapping("/delete/{productId}")
    public String delete(Model model, @PathVariable String productId) {
        posService.delete(productId);
        return "redirect:/";
    }

    @GetMapping("/clear")
    public String clear(Model model) {
        posService.newCart();
        return "redirect:/";
    }
}
