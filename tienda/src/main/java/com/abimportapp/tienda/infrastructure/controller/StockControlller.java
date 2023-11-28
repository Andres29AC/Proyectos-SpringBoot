package com.abimportapp.tienda.infrastructure.controller;


import com.abimportapp.tienda.application.service.StockService;
import com.abimportapp.tienda.application.service.ValidateStock;
import com.abimportapp.tienda.domain.Product;
import com.abimportapp.tienda.domain.Stock;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/admin/products/stock")
public class StockControlller {
    private final StockService stockService;
    private final ValidateStock validateStock;

    public StockControlller(StockService stockService, ValidateStock validateStock) {
        this.stockService = stockService;
        this.validateStock = validateStock;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model){
        Product product = new Product();
        product.setId(id);
        List<Stock> stocks = stockService.getStockByProduct(product);
        model.addAttribute("stocks", stocks);
        model.addAttribute("idproduct", id);
        return "admin/stock/show";
    }
    @GetMapping("create-unit-product/{id}")
    public String create(@PathVariable Integer id, Model model){
        model.addAttribute("idproduct", id);
        return "admin/stock/create";
    }
    @PostMapping("/save-unit-product")
    public String save(Stock stock, @RequestParam("idproduct") Integer idproduct){
        stock.setDateCreated(LocalDateTime.now());
        stock.setDescription("Ingreso por inventario");
        Product product = new Product();
        product.setId(idproduct);
        stock.setProduct(product);
        stockService.saveStock(validateStock.calcularBalance(stock));
        return "redirect:/admin/products/show";
    }
}
