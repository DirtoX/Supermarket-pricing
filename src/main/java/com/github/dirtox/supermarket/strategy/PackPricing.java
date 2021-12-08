package com.github.dirtox.supermarket.strategy;

import com.github.dirtox.supermarket.models.Product;
import com.github.dirtox.supermarket.models.Quantity;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@AllArgsConstructor
public class PackPricing implements PricingStrategy {
    private final int itemsBought;
    private final BigDecimal packPrice;
    @Override
    public BigDecimal getPricing(Product product, Quantity quantity){
        BigDecimal rest = quantity.getAmount().remainder(new BigDecimal(itemsBought));
        return packPrice.multiply(quantity.getAmount()
                .subtract(rest).divide(new BigDecimal(itemsBought),2, RoundingMode.HALF_EVEN))
                .add(product.getPrice().multiply(rest));
    }
}
