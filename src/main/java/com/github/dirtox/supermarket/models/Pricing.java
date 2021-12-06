package com.github.dirtox.supermarket.models;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.MathContext;

@AllArgsConstructor
public class Pricing {
    private final PricingType pricingType;
    private final int x;
    private final BigDecimal y;

    private BigDecimal buyXForY(Product product, Quantity quantity){
        BigDecimal rest = quantity.getAmount().remainder(new BigDecimal(x));
        return y.multiply(quantity.getAmount()
                .subtract(rest).divide(new BigDecimal(x), new MathContext(4)))
                .add(product.getPrice().multiply(rest, new MathContext(4)));
    }

    public BigDecimal getPricingStrategy(Product product, Quantity quantity){
        return this.buyXForY(product, quantity);
    }
}
