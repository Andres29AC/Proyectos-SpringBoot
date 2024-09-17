package com.abimportapp.tienda.infrastructure.adapter;

import com.abimportapp.tienda.application.repository.OrderRepository;
import com.abimportapp.tienda.domain.Order;
import com.abimportapp.tienda.infrastructure.mapper.OrderMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderCrudRepository orderCrudRepository;
    private final OrderMapper orderMapper;
    //Constructor
    public OrderRepositoryImpl(OrderCrudRepository orderCrudRepository, OrderMapper orderMapper) {
        this.orderCrudRepository = orderCrudRepository;
        this.orderMapper = orderMapper;
    }
    @Override
    public Order createOrder(Order order) {
        return orderMapper.toOrder(orderCrudRepository.save(orderMapper.toOrderEntity(order)));
    }
    @Override
    public Iterable<Order> getOrders() {
        return orderMapper.toOrders(orderCrudRepository.findAll());
    }
}
