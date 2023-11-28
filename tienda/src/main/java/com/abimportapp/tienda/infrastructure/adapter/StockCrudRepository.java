package com.abimportapp.tienda.infrastructure.adapter;

import com.abimportapp.tienda.infrastructure.entity.ProductEntity;
import com.abimportapp.tienda.infrastructure.entity.StockEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StockCrudRepository extends CrudRepository<StockEntity, Integer> {
    List<StockEntity> findByProductEntity(ProductEntity productEntity);

}
