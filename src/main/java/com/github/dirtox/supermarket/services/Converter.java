package com.github.dirtox.supermarket.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Converter {
    public Converter(){ }

    public BigDecimal toPound(BigDecimal value){
        return value.divide(new BigDecimal(16),4, RoundingMode.HALF_EVEN);
    }
}
