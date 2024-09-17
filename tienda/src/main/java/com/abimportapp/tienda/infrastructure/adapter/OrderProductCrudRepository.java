package com.abimportapp.tienda.infrastructure.adapter;

import com.abimportapp.tienda.infrastructure.entity.OrderEntity;
import com.abimportapp.tienda.infrastructure.entity.OrderProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderProductCrudRepository extends CrudRepository<OrderProductEntity, Integer> {
    List<OrderProductEntity> findByPkOrderEntity(OrderEntity orderEntity);
}
