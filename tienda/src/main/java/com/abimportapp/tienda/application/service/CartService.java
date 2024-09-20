package com.abimportapp.tienda.application.service;

import com.abimportapp.tienda.domain.ItemCart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CartService {
    private List<ItemCart> listItems;
    private HashMap<Integer, ItemCart> hashItemCart;
    public CartService(){
        this.hashItemCart = new HashMap<>();
        this.listItems = new ArrayList<>();
    }
    public void addItemCart(Integer quantity, Integer idProduct, String nameProduct, BigDecimal price){
        ItemCart itemCart = new ItemCart(idProduct, nameProduct, quantity, price);
        hashItemCart.put(itemCart.getIdProduct(), itemCart);
        fillListItems();
    }
    public BigDecimal getTotalCart(){
        BigDecimal totalCart = BigDecimal.ZERO; //totalCart en 0
        for (ItemCart itemCart : listItems) {
            totalCart = totalCart.add(itemCart.getTotalPriceItem());
        }
        return totalCart;
    }
    public void removeItemCart(Integer idProduct){
        hashItemCart.remove(idProduct);
        fillListItems();
    }
    public void removeAllItemsCart(){
        hashItemCart.clear();
        listItems.clear();
    }
    private void fillListItems(){
        listItems.clear();
        hashItemCart.forEach(((integer, itemCart) -> listItems.add(itemCart)));

    }
    //TODO: Para mostrar por consola
    public List<ItemCart> getListItems() {
        return listItems;
    }
}
