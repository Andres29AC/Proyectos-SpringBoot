package com.abimportapp.tienda.infrastructure.configuration;

import com.abimportapp.tienda.application.repository.ProductRepository;
import com.abimportapp.tienda.application.repository.StockRepository;
import com.abimportapp.tienda.application.service.ProductService;
import com.abimportapp.tienda.application.service.StockService;
import com.abimportapp.tienda.application.service.UploadFile;
import com.abimportapp.tienda.application.service.ValidateStock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public ProductService productService(ProductRepository productRepository,UploadFile uploadFile){
        return new ProductService(productRepository,uploadFile);
    }
    @Bean
    public UploadFile uploadFile(){
        return new UploadFile();
    }

    @Bean
    public StockService stockService(StockRepository stockRepository){
        return new StockService(stockRepository);
    }
    @Bean
    public ValidateStock validateStock(StockService stockService){
        return new ValidateStock(stockService);
    }
}
