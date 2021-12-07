package com.github.dirtox.supermarket.strategy;

import com.github.dirtox.supermarket.models.Product;
import com.github.dirtox.supermarket.models.Quantity;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.MathContext;

@AllArgsConstructor
public class BonusPricing implements PricingStrategy {
    private final int itemsBought;
    private final int bonusItems;

    @Override
    public BigDecimal getPricing(Product product, Quantity quantity){
        BigDecimal pack = new BigDecimal(itemsBought+bonusItems);
        if(quantity.getAmount().compareTo(pack) == 0)
            return product.getPrice().multiply(new BigDecimal(itemsBought), new MathContext(4));
        if(quantity.getAmount().compareTo(pack) < 0) {
            return product.getPrice()
                    .multiply(quantity.getAmount(), new MathContext(4));
        }
        BigDecimal rest = quantity.getAmount().remainder(pack);
        return product.getPrice().multiply(quantity.getAmount()
                .subtract(rest).divide(pack, new MathContext(4))).multiply(new BigDecimal(itemsBought))
                .add(product.getPrice().multiply(rest, new MathContext(4)));
    }
}
