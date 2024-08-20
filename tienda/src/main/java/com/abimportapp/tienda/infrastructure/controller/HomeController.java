package com.abimportapp.tienda.infrastructure.controller;

import com.abimportapp.tienda.application.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final ProductService productService;
    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String home(Model model){
        model.addAttribute("products", productService.getProducts());
        return "home";
    }
    @GetMapping("/product-detail/{id}")
    public String productDetail(){
        return "user/productdetail";
    }
}