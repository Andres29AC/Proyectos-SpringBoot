package com.abimportapp.tienda.infrastructure.adapter;

import com.abimportapp.tienda.domain.Product;
import com.abimportapp.tienda.infrastructure.entity.ProductEntity;
import com.abimportapp.tienda.infrastructure.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository  extends CrudRepository<ProductEntity, Integer> {
    Iterable<ProductEntity> findByUserEntity (UsuarioEntity userEntity);
}
