package com.abimportapp.tienda.domain;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
@Data
@ToString
public class Stock {
    private Integer id;
    //TODO:Fecha de creacion
    private LocalDateTime dateCreated;
    //TODO:unitIn sirve para saber cuantas unidades entran en el stock
    private Integer unitIn;
    //TODO:unitOut sirve para saber cuantas unidades salen del stock
    private Integer unitOut;
    private String description;
    //TODO:balance sirve para saber cuantas unidades quedan en el stock
    private Integer balance;
    private Product product;
}
