package com.abimportapp.tienda.application.repository;


import com.abimportapp.tienda.domain.Product;
import com.abimportapp.tienda.domain.Usuario;

public interface ProductRepository {
    Iterable<Product> getProducts();
    Iterable<Product> getProductsByUser(Usuario user);
    Product getProductById(Integer id);
    Product saveProduct(Product product);
    void deleteProductById(Integer id);
}
