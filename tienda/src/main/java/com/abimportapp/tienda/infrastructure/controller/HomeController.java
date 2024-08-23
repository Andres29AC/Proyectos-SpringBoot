package com.abimportapp.tienda.infrastructure.controller;

import com.abimportapp.tienda.application.service.ProductService;
import com.abimportapp.tienda.application.service.StockService;
import com.abimportapp.tienda.domain.Stock;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final ProductService productService;
    private final StockService stockService;

    public HomeController(ProductService productService, StockService stockService){
        this.productService = productService;
        this.stockService = stockService;
    }
    @GetMapping
    public String home(Model model){
        model.addAttribute("products", productService.getProducts());
        return "home";
    }
    @GetMapping("/product-detail/{id}")
    public String productDetail(@PathVariable Integer id, Model model){
        List<Stock> stocks = stockService.getStockByProduct(productService.getProductById(id));
        //Integer lastBalance = stocks.get(stocks.size()-1).getBalance();
        //model.addAttribute("product", productService.getProductById(id));
        //model.addAttribute("stock", lastBalance);
        if(!stocks.isEmpty()){
            Integer lastBalance = stocks.get(stocks.size()-1).getBalance();
            model.addAttribute("stock", lastBalance);
        }else{
            model.addAttribute("stock", 0);
        }
        model.addAttribute("product", productService.getProductById(id));
        return "user/productdetail";
    }
}