package com.github.dirtox.supermarket.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Product {
    private final String name;
    private final BigDecimal price;
}
