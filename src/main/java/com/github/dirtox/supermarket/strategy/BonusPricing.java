package com.github.dirtox.supermarket.strategy;

import com.github.dirtox.supermarket.models.Product;
import com.github.dirtox.supermarket.models.Quantity;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@AllArgsConstructor
public class BonusPricing implements PricingStrategy {
    private final int itemsBought;
    private final int bonusItems;

    @Override
    public BigDecimal getPricing(Product product, Quantity quantity){
        BigDecimal pack = new BigDecimal(itemsBought+bonusItems);
        if(quantity.getAmount().compareTo(pack) == 0)
            return product.getPrice().multiply(new BigDecimal(itemsBought));
        if(quantity.getAmount().compareTo(pack) < 0) {
            return product.getPrice()
                    .multiply(quantity.getAmount());
        }
        BigDecimal rest = quantity.getAmount().remainder(pack);
        return product.getPrice().multiply(quantity.getAmount()
                .subtract(rest).divide(pack,2, RoundingMode.HALF_EVEN)).multiply(new BigDecimal(itemsBought))
                .add(product.getPrice().multiply(rest));
    }
}
