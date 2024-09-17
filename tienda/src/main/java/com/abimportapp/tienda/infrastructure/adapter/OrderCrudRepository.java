package com.abimportapp.tienda.infrastructure.adapter;

import com.abimportapp.tienda.infrastructure.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderCrudRepository extends CrudRepository<OrderEntity, Integer > {
}
