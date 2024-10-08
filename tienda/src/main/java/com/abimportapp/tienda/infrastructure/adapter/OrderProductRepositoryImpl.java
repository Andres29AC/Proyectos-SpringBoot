package com.abimportapp.tienda.infrastructure.adapter;

import com.abimportapp.tienda.application.repository.OrderProductRepository;
import com.abimportapp.tienda.domain.Order;
import com.abimportapp.tienda.domain.OrderProduct;
import com.abimportapp.tienda.infrastructure.mapper.OrderMapper;
import com.abimportapp.tienda.infrastructure.mapper.OrderProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class OrderProductRepositoryImpl implements OrderProductRepository {
    private final OrderProductCrudRepository productCrudRepository;
    private final OrderMapper orderMapper;
    private final OrderProductMapper orderProductMapper;
    //Constructor
    public OrderProductRepositoryImpl(OrderProductCrudRepository productCrudRepository, OrderMapper orderMapper, OrderProductMapper orderProductMapper) {
        this.productCrudRepository = productCrudRepository;
        this.orderMapper = orderMapper;
        this.orderProductMapper = orderProductMapper;
    }
    @Override
    public OrderProduct create(OrderProduct orderProduct) {
        return orderProductMapper.toOrderProduct(productCrudRepository.save(orderProductMapper.toOrderProductEntity(orderProduct)));
    }

    @Override
    public Iterable<OrderProduct> getOrderProducts() {
        return orderProductMapper.toOrderProducts(productCrudRepository.findAll());
    }

    @Override
    public List<OrderProduct> getOrderProductsByOrder(Order order) {
        return orderProductMapper.toOrderProductsList(productCrudRepository.findByPkOrderEntity(orderMapper.toOrderEntity(order)));
    }
}
