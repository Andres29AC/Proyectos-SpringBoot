package com.abimportapp.tienda.infrastructure.controller;

import com.abimportapp.tienda.application.service.CartService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping("/user/cart")
@Slf4j //Esto es para que se generen los logs
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @PostMapping("/add-product")
    public String addProductCart(@RequestParam Integer quantity,@RequestParam Integer idProduct,@RequestParam String nameProduct,@RequestParam BigDecimal price){
        cartService.addItemCart(quantity,idProduct,nameProduct,price);
        showCart();
        return "redirect:/home";
    }

    private void showCart() {
        cartService.getListItems().forEach(
                itemCart -> log.info("Item: {}",itemCart)
        );
    }

    @GetMapping("/get-cart")
    public String getCard(Model model, HttpSession session){
        showCart();
        model.addAttribute("cart",cartService.getListItems());
        model.addAttribute("total",cartService.getTotalCart());
        model.addAttribute("id",session.getAttribute("userId").toString());
        return "user/cart/cart";
    }
    @GetMapping("/delete-item-cart/{id}")
    public String deleteItemCart(@PathVariable Integer id){
        cartService.removeItemCart(id);
        return "redirect:/user/cart/get-cart";
    }
}
