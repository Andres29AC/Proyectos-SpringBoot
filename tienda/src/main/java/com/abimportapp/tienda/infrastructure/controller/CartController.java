package com.abimportapp.tienda.infrastructure.controller;

import com.abimportapp.tienda.application.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String getCard(Model model){
        showCart();
        model.addAttribute("cart",cartService.getListItems());
        model.addAttribute("total",cartService.getTotalCart());
        return "user/cart/cart";
    }
}
