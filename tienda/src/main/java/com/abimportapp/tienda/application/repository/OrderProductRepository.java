package com.abimportapp.tienda.application.repository;

import com.abimportapp.tienda.domain.Order;
import com.abimportapp.tienda.domain.OrderProduct;

import java.util.List;

public interface OrderProductRepository {
    public OrderProduct create(OrderProduct orderProduct);
    public Iterable<OrderProduct> getOrderProducts();
    List<OrderProduct> getOrderProductsByOrder(Order order);
}
