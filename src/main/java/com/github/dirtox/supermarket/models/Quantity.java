package com.github.dirtox.supermarket.models;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@AllArgsConstructor
public class Quantity {
    private final boolean isMass;
    private BigDecimal amount;

    public void addAmount(BigDecimal amount){
        if(this.isMass) this.amount = this.amount.add(amount);
        else this.amount =  this.amount.add(amount.setScale(0, RoundingMode.UP));
    }

    public boolean isMass(){
        return this.isMass;
    }

    public BigDecimal getAmount(){
        return this.amount;
    }
}
