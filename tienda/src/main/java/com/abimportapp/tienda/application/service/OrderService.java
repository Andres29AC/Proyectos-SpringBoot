package com.abimportapp.tienda.application.service;

import com.abimportapp.tienda.application.repository.OrderRepository;
import com.abimportapp.tienda.domain.Order;

public class OrderService {
    private final OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public Order createOrder(Order order) {
        return orderRepository.createOrder(order);
    }
    public Iterable<Order> getOrders() {
        return orderRepository.getOrders();
    }
}
