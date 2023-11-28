package com.abimportapp.tienda.application.service;

import com.abimportapp.tienda.application.repository.StockRepository;
import com.abimportapp.tienda.domain.Product;
import com.abimportapp.tienda.domain.Stock;

import java.util.List;

public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    public Stock saveStock(Stock stock) {
        return stockRepository.saveStock(stock);
    }
    public List<Stock> getStockByProduct(Product product) {
        return stockRepository.getStockByProduct(product);
    }
}
