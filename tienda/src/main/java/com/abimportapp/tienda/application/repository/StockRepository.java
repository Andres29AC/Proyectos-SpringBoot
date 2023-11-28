package com.abimportapp.tienda.application.repository;

import com.abimportapp.tienda.domain.Product;
import com.abimportapp.tienda.domain.Stock;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository
public interface StockRepository {
    Stock saveStock(Stock stock);
    List<Stock> getStockByProduct(Product product);

}
