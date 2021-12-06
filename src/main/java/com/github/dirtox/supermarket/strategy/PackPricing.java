package com.github.dirtox.supermarket.strategy;

import com.github.dirtox.supermarket.models.Product;
import com.github.dirtox.supermarket.models.Quantity;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.MathContext;

@AllArgsConstructor
public class PackPricing implements PricingStrategy {
    private final int x;
    private final BigDecimal y;
    @Override
    public BigDecimal getPricing(Product product, Quantity quantity){
        BigDecimal rest = quantity.getAmount().remainder(new BigDecimal(x));
        return y.multiply(quantity.getAmount()
                .subtract(rest).divide(new BigDecimal(x), new MathContext(4)))
                .add(product.getPrice().multiply(rest, new MathContext(4)));
    }
}
