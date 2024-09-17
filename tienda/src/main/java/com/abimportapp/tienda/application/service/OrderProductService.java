package com.abimportapp.tienda.application.service;

import com.abimportapp.tienda.application.repository.OrderProductRepository;
import com.abimportapp.tienda.domain.Order;
import com.abimportapp.tienda.domain.OrderProduct;

import java.util.List;

public class OrderProductService {
    private final OrderProductRepository orderProductRepository;
    //NOTE: Constructor
    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }
    public OrderProduct create(OrderProduct orderProduct) {
        return orderProductRepository.create(orderProduct);
    }
    public Iterable<OrderProduct> getOrderProduct() {
        return orderProductRepository.getOrderProducts();
    }
    public List<OrderProduct> getOrderProductsByOrder(Order order) {
        return orderProductRepository.getOrderProductsByOrder(order);
    }
}
