package com.abimportapp.tienda.infrastructure.controller;

import com.abimportapp.tienda.application.service.ProductService;
import com.abimportapp.tienda.domain.Product;
import com.abimportapp.tienda.domain.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/admin/products")
@Slf4j
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/create")
    public String create() {
        return "admin/products/create";
    }
    @PostMapping("/save-product")
    public String saveProduct(Product product, @RequestParam("img") MultipartFile multipartFile) throws IOException {
        log.info("Product: {}" , product);
        productService.saveProduct(product,multipartFile);
        //return "admin/products/create";
        return "redirect:/admin";
    }
    @GetMapping("/show")
    public String showProduct(Model model){
        Usuario usuario = new Usuario();
        usuario.setId(1);
        Iterable<Product> products = productService.getProductsByUser(usuario);
        model.addAttribute("products", products);
        return "admin/products/show";
    }
    @GetMapping("/edit/{id}") //TODO:Paso de parametros
    public String editProduct(@PathVariable Integer id,Model model){
        Product product = productService.getProductById(id);
        log.info("Product: {}" , product);
        model.addAttribute("product", product);
        return "admin/products/edit";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id){
        productService.deleteProductById(id);
        return "redirect:/admin/products/show";
    }
}
