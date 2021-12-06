package com.github.dirtox.supermarket.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
public class CartItem {
    private final Product product;
    private Quantity quantity;
    private final Pricing pricing;

    public void addQuantity(BigDecimal amount){
        this.quantity.addAmount(amount);
    }

    public BigDecimal getQuantity(){
        return this.quantity.getAmount();
    }

    public boolean isMass(){
        return this.quantity.isMass();
    }

    public Product getProduct(){ return this.product;}

    public boolean havePricing(){ return pricing != null; }

    public BigDecimal getPricingStrategy(){ return this.pricing.getPricingStrategy(this.product,this.quantity);}
}
