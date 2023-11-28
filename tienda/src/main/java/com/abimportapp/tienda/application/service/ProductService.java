package com.abimportapp.tienda.application.service;

import com.abimportapp.tienda.application.repository.ProductRepository;
import com.abimportapp.tienda.domain.Product;
import com.abimportapp.tienda.domain.Usuario;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

public class ProductService {

    private final ProductRepository productRepository;
    private final UploadFile uploadFile;

    public ProductService(ProductRepository productRepository, UploadFile uploadFile) {
        this.productRepository = productRepository;
        this.uploadFile = uploadFile;
    }

    public Iterable<Product> getProducts(){
        return  productRepository.getProducts();
    }

    public Iterable<Product> getProductsByUser(Usuario user){
        return productRepository.getProductsByUser(user);
    }

    public Product getProductById(Integer id){
        return  productRepository.getProductById(id);
    }

    public Product saveProduct(Product product, MultipartFile multipartFile) throws IOException {
        if(product.getId()==null){
            Usuario user = new Usuario();
            user.setId(1);
            product.setDateCreated(LocalDateTime.now());
            product.setDateUpdated(LocalDateTime.now());
            product.setUser(user);
            product.setImage(uploadFile.upload(multipartFile));
            return   productRepository.saveProduct(product);
        }else{
            //TODO: Para modificacion o actualizacion
            Product productUp = productRepository.getProductById(product.getId());
            //Si no se carga una imagen toma la que se le guardo al registrar
            if (multipartFile.isEmpty()) {
                product.setImage(productUp.getImage());
            }else{//guarda la que se le envia actualmente
                //antes se elimina pero si no es por defecto
                if(!productUp.getImage().equals("default.jpg")){
                    uploadFile.delete(productUp.getImage());
                }
                product.setImage(uploadFile.upload(multipartFile));
            }
            product.setCode(productUp.getCode());
            product.setUser(productUp.getUser());
            product.setDateCreated(productUp.getDateCreated());
            product.setDateUpdated(LocalDateTime.now());
            return productRepository.saveProduct(product);
        }
    }
    public void deleteProductById(Integer id){
        productRepository.deleteProductById(id);
    }
}
