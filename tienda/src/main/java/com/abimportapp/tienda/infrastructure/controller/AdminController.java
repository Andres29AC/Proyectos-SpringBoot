package com.abimportapp.tienda.infrastructure.controller;

import com.abimportapp.tienda.application.service.ProductService;
import com.abimportapp.tienda.domain.Product;
import com.abimportapp.tienda.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final ProductService productService;
    public AdminController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public String home(Model model) {
        Usuario usuario = new Usuario();
        usuario.setId(1);
        Iterable<Product> products = productService.getProductsByUser(usuario);
        model.addAttribute("products", products);
        return "admin/home";
    }
}
