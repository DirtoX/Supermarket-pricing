package com.github.dirtox.supermarket.models;

import com.github.dirtox.supermarket.strategy.NormalPricing;
import com.github.dirtox.supermarket.strategy.PricingStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

public class CartItem {
    private final Product product;
    private Quantity quantity;
    private final PricingStrategy pricingStrategy;

    public CartItem(Product product, Quantity quantity){
        this.product = product;
        this.quantity = quantity;
        this.pricingStrategy = new NormalPricing();
    }

    public CartItem(Product product, Quantity quantity, PricingStrategy pricingStrategy){
        this.product = product;
        this.quantity = quantity;
        this.pricingStrategy = pricingStrategy != null ? pricingStrategy : new NormalPricing();
    }

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

    public BigDecimal getPricing(){ return this.pricingStrategy.getPricing(this.product,this.quantity);}
}
