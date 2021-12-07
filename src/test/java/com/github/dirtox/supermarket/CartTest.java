package com.github.dirtox.supermarket;

import com.github.dirtox.supermarket.models.*;
import com.github.dirtox.supermarket.strategy.BonusPricing;
import com.github.dirtox.supermarket.strategy.PackPricing;
import com.github.dirtox.supermarket.strategy.PricingStrategy;
import com.github.dirtox.supermarket.services.Converter;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest {

    @Test
    public void adding_cart_items_to_cart_should_work(){
        Product product1 = new Product("Product 1", new BigDecimal(5));
        Converter converter = new Converter();
        CartItem cartItem = new CartItem(product1, new Quantity(false, new BigDecimal(2), null, converter));
        Cart cart = new Cart();
        assertEquals(cart.getItemsNumber(), 0);
        cart.addItem(cartItem);
        assertEquals(cart.getItemsNumber(), 1);
    }

    @Test
    public void removing_cart_items_from_cart_should_work(){
        Product product1 = new Product("Product 1", new BigDecimal(5));
        Converter converter = new Converter();
        CartItem cartItem = new CartItem(product1, new Quantity(false, new BigDecimal(2), null, converter));
        Cart cart = new Cart();
        cart.addItem(cartItem);
        assertEquals(cart.getItemsNumber(), 1);
        cart.removeItem(cartItem);
        assertEquals(cart.getItemsNumber(), 0);
    }

    @Test
    public void adding_duplicate_items_should_change_quantity(){
        Product product1 = new Product("Product 1", new BigDecimal(5));
        Converter converter = new Converter();
        CartItem cartItem = new CartItem(product1, new Quantity(false, new BigDecimal(2), null, converter));
        Cart cart = new Cart();
        cart.addItem(cartItem);
        cart.addItem(cartItem);
        assertEquals(cart.getItemsNumber(), 1);
        assertTrue(cartItem.getQuantity().compareTo(new BigDecimal(4)) == 0);
    }

    @Test
    public void cart_cash_out(){
        Product product1 = new Product("Product 1", new BigDecimal(5));
        Product product2 = new Product("Product 2", new BigDecimal(10));
        Product product3 = new Product("Product 3", new BigDecimal(2));
        Converter converter = new Converter();
        CartItem cartItem1 = new CartItem(product1, new Quantity(false, new BigDecimal(3), null, converter));
        CartItem cartItem2 = new CartItem(product2, new Quantity(false, new BigDecimal(1), null, converter));
        CartItem cartItem3 = new CartItem(product3, new Quantity(true, new BigDecimal(4.5), MassUnit.OUNCE, converter));
        Cart cart = new Cart();
        cart.addItem(cartItem1);
        cart.addItem(cartItem2);
        cart.addItem(cartItem2);
        cart.addItem(cartItem3);
        assertTrue(cart.cashOut().compareTo(new BigDecimal(35.56).setScale(2, RoundingMode.HALF_EVEN)) == 0);
    }

    @Test
    public void buy_x_for_y_pack_price_strategy_should_work(){
        Product product1 = new Product("Product 1", new BigDecimal(5));
        Product product2 = new Product("Product 2", new BigDecimal(10));
        PricingStrategy pricing = new PackPricing(3,new BigDecimal(12));
        Converter converter = new Converter();
        CartItem cartItem1 = new CartItem(product1, new Quantity(false, new BigDecimal(4), null, converter), pricing);
        CartItem cartItem2 = new CartItem(product2, new Quantity(false, new BigDecimal(3), null, converter));
        Cart cart = new Cart();
        cart.addItem(cartItem1);
        cart.addItem(cartItem2);
        assertTrue(cart.cashOut().compareTo(new BigDecimal(47).setScale(2, RoundingMode.HALF_EVEN)) == 0);
    }

    @Test
    public void buy_x_get_z_bonus_price_strategy_should_work(){
        Product product1 = new Product("Product 1", new BigDecimal(5));
        Product product2 = new Product("Product 2", new BigDecimal(10));
        PricingStrategy pricing = new BonusPricing(2,1);
        Converter converter = new Converter();
        CartItem cartItem1 = new CartItem(product1, new Quantity(false, new BigDecimal(6), null, converter), pricing);
        CartItem cartItem2 = new CartItem(product2, new Quantity(false, new BigDecimal(1), null, converter));
        Cart cart = new Cart();
        cart.addItem(cartItem1);
        cart.addItem(cartItem2);
        assertTrue(cart.cashOut().compareTo(new BigDecimal(30).setScale(2, RoundingMode.HALF_EVEN)) == 0);
    }

}
