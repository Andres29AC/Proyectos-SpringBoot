package com.abimportapp.tienda.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Embeddable
public class OrderProductPK {
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderEntity orderEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductEntity productEntity;
}
