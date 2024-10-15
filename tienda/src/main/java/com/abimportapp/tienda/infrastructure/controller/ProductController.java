package com.abimportapp.tienda.infrastructure.controller;

import com.abimportapp.tienda.application.service.ProductService;
import com.abimportapp.tienda.domain.Product;
import com.abimportapp.tienda.domain.Usuario;
import jakarta.servlet.http.HttpSession;
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
    public String saveProduct(Product product, @RequestParam("img") MultipartFile multipartFile,HttpSession session) throws IOException {
        log.info("Product: {}" , product);
        productService.saveProduct(product,multipartFile,session);
        //return "admin/products/create";
        return "redirect:/admin";
    }
    @GetMapping("/show")
    public String showProduct(Model model,HttpSession session){
        log.info("userId desde la variable de sesion: {}", session.getAttribute("userId").toString());
        Usuario usuario = new Usuario();
        usuario.setId(Integer.parseInt(session.getAttribute("userId").toString()));
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
