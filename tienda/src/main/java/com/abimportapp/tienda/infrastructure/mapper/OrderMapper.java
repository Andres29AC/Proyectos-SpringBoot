package com.abimportapp.tienda.infrastructure.mapper;

import com.abimportapp.tienda.domain.Order;
import com.abimportapp.tienda.infrastructure.entity.OrderEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class})
public interface OrderMapper {
    //Mappings nos servira para mapear los atributos de la entidad a los atributos del dominio
    @Mappings(
            {
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "dateCreated", target = "dateCreated"),
                    @Mapping(source = "user", target = "user"),
            }
    )
    Order toOrder(OrderEntity orderEntity);
    Iterable<Order> toOrders(Iterable<OrderEntity> orderEntities);
    @InheritInverseConfiguration
    OrderEntity toOrderEntity(Order order);
}
