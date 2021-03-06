package com.github.dirtox.supermarket.strategy;

import com.github.dirtox.supermarket.models.Product;
import com.github.dirtox.supermarket.models.Quantity;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class NormalPricing implements PricingStrategy {
    @Override
    public BigDecimal getPricing(Product product, Quantity quantity){
        return product.getPrice().multiply(quantity.getAmount());
    }
}
