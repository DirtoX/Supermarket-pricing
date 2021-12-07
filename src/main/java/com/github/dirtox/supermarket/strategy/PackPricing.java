package com.github.dirtox.supermarket.strategy;

import com.github.dirtox.supermarket.models.Product;
import com.github.dirtox.supermarket.models.Quantity;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.MathContext;

@AllArgsConstructor
public class PackPricing implements PricingStrategy {
    private final int itemsBought;
    private final BigDecimal packPrice;
    @Override
    public BigDecimal getPricing(Product product, Quantity quantity){
        BigDecimal rest = quantity.getAmount().remainder(new BigDecimal(itemsBought));
        return packPrice.multiply(quantity.getAmount()
                .subtract(rest).divide(new BigDecimal(itemsBought), new MathContext(4)))
                .add(product.getPrice().multiply(rest, new MathContext(4)));
    }
}
