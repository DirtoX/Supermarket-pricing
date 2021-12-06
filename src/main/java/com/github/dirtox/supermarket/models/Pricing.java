package com.github.dirtox.supermarket.models;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.MathContext;

@AllArgsConstructor
public class Pricing {
    private final PricingType pricingType;
    private final int x;
    private final BigDecimal y;
    private final int z;

    private BigDecimal buyXForY(Product product, Quantity quantity){
        BigDecimal rest = quantity.getAmount().remainder(new BigDecimal(x));
        return y.multiply(quantity.getAmount()
                .subtract(rest).divide(new BigDecimal(x), new MathContext(4)))
                .add(product.getPrice().multiply(rest, new MathContext(4)));
    }

    private BigDecimal buyXGetZ(Product product, Quantity quantity) {
        BigDecimal pack = new BigDecimal(x+z);
        if(quantity.getAmount().compareTo(pack) == 0)
            return product.getPrice().multiply(new BigDecimal(x), new MathContext(4));
        if(quantity.getAmount().compareTo(pack) < 0) {
            return product.getPrice()
                    .multiply(quantity.getAmount(), new MathContext(4));
        }
        BigDecimal rest = quantity.getAmount().remainder(pack);
        return product.getPrice().multiply(quantity.getAmount()
                .subtract(rest).divide(pack, new MathContext(4))).multiply(new BigDecimal(x))
                .add(product.getPrice().multiply(rest, new MathContext(4)));
    }

    public BigDecimal getPricingStrategy(Product product, Quantity quantity){
        if(pricingType == PricingType.PACK_PRICE) return this.buyXForY(product, quantity);
        else return this.buyXGetZ(product,quantity);
    }
}
