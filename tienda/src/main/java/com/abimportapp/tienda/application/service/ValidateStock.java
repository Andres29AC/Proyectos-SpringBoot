package com.abimportapp.tienda.application.service;

import com.abimportapp.tienda.domain.Product;
import com.abimportapp.tienda.domain.Stock;

import java.util.List;

public class ValidateStock {
    private final StockService stockService;

    public ValidateStock(StockService stockService) {
        this.stockService = stockService;
    }
    private boolean existBalance(Product product){
        List<Stock> stockList = stockService.getStockByProduct(product);
        return stockList.isEmpty() ? false : true;
    }
    public Stock calcularBalance(Stock stock){
        if (stock.getUnitIn() != 0){ //-->Ingreso por inventario
            if(existBalance(stock.getProduct())){
                List<Stock> stockList = stockService.getStockByProduct(stock.getProduct());
                Integer balance = stockList.get(stockList.size()-1).getBalance();
                stock.setBalance(balance + stock.getUnitIn());
            }else{
                stock.setBalance(stock.getUnitIn());
            }
        }else{//-->Cuando sea una venta
            List<Stock> stockList = stockService.getStockByProduct(stock.getProduct());
            Integer balance = stockList.get(stockList.size()-1).getBalance();
            stock.setBalance(balance - stock.getUnitIn());
        }
        return stock;
    }
}
