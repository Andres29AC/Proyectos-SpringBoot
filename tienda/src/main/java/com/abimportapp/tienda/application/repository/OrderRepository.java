package com.abimportapp.tienda.application.repository;

import com.abimportapp.tienda.domain.Order;

public interface OrderRepository {
    public Order createOrder(Order order);
    public Iterable<Order> getOrders();
}
