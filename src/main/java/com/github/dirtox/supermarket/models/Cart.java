package com.github.dirtox.supermarket.models;

import java.util.ArrayList;

public class Cart {
    private ArrayList<CartItem> items;

    public Cart(){
        this.items = new ArrayList<CartItem>();
    }

    public void addItem(CartItem cartItem){
        this.items.add(cartItem);
    }

    public int getItemsNumber(){
        return this.items.size();
    }
}
