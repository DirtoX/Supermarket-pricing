package com.github.dirtox.supermarket.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CartItem {
    private final Product product;
    private BigDecimal quantity;

    public void addQuantity(BigDecimal amount){
        this.quantity = this.quantity.add(amount);
    }
}
