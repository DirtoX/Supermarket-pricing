package com.github.dirtox.supermarket.models;

import java.math.BigDecimal;
import java.util.HashSet;

public class Cart {
    private HashSet<CartItem> items;

    public Cart(){
        this.items = new HashSet<CartItem>();
    }

    public void addItem(CartItem cartItem){
        if(!this.items.add(cartItem)){
            this.items.forEach(t -> {
                if(t.equals(cartItem)){
                    t.addQuantity(cartItem.getQuantity());
                }
            });
        }
    }

    public void removeItem(CartItem cartItem){
        this.items.remove(cartItem);
    }

    public int getItemsNumber(){
        return this.items.size();
    }

    public BigDecimal cashOut(){
        BigDecimal total = BigDecimal.ZERO;
        for(CartItem item : items){
            total = total.add(item.getProduct().getPrice().multiply(item.getQuantity()));
        }
        return total;
    }
}
