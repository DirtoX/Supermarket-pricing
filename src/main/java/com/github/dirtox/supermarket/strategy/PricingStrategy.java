package com.github.dirtox.supermarket.strategy;


import com.github.dirtox.supermarket.models.Product;
import com.github.dirtox.supermarket.models.Quantity;

import java.math.BigDecimal;

public interface PricingStrategy {
     BigDecimal getPricing(Product product, Quantity quantity);
}
