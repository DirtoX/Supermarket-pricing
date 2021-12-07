package com.github.dirtox.supermarket.models;

import com.github.dirtox.supermarket.services.Converter;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@AllArgsConstructor
public class Quantity {
    private final boolean isMass;
    private BigDecimal amount;
    private final MassUnit massUnit;
    private final Converter converter;

    public void addAmount(BigDecimal amount){
       this.amount = this.isMass ? this.amount.add(amount).setScale(4, RoundingMode.HALF_EVEN)
               : this.amount.add(amount.setScale(0, RoundingMode.UP));
    }

    public boolean isMass(){
        return this.isMass;
    }

    public BigDecimal getAmount(){
        return massUnit == MassUnit.OUNCE ? this.converter.toPound(this.amount) : this.amount;
//        return this.amount;
    }

    public MassUnit getMassUnit(){
        return this.massUnit;
    }

//    public BigDecimal toPound(){
//        return this.amount.divide(new BigDecimal(16),new MathContext(4));
//    }
}
