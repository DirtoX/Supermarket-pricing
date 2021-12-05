package com.github.dirtox.supermarket;

import com.github.dirtox.supermarket.models.Cart;
import com.github.dirtox.supermarket.models.CartItem;
import com.github.dirtox.supermarket.models.Product;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest {

    @Test
    public void adding_cart_items_to_cart_should_work(){
        Product product1 = new Product("Product 1", new BigDecimal(5));
        CartItem cartItem = new CartItem(product1, new BigDecimal(2));
        Cart cart = new Cart();
        cart.addItem(cartItem);
        assertEquals(cart.getItemsNumber(), 1);
    }

    @Test
    public void removing_cart_items_to_cart_should_work(){
        Product product1 = new Product("Product 1", new BigDecimal(5));
        CartItem cartItem = new CartItem(product1, new BigDecimal(2));
        Cart cart = new Cart();
        cart.addItem(cartItem);
        assertEquals(cart.getItemsNumber(), 1);
        cart.removeItem(cartItem);
        assertEquals(cart.getItemsNumber(), 0);
        cart.addItem(cartItem);
        assertEquals(cart.getItemsNumber(), 1);
        cart.removeItem(0);
        assertEquals(cart.getItemsNumber(), 0);
    }

    @Test
    public void adding_duplicate_items_should_change_quantity(){
        Product product1 = new Product("Product 1", new BigDecimal(5));
        CartItem cartItem = new CartItem(product1, new BigDecimal(2));
        Cart cart = new Cart();
        cart.addItem(cartItem);
        cart.addItem(cartItem);
        assertEquals(cart.getItemsNumber(), 1);
        assertTrue(cartItem.getQuantity().compareTo(new BigDecimal(4)) == 0);
    }

}
