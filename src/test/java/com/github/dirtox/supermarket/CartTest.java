package com.github.dirtox.supermarket;

import com.github.dirtox.supermarket.models.Cart;
import com.github.dirtox.supermarket.models.CartItem;
import com.github.dirtox.supermarket.models.Product;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest {

    @Test
    public void adding_cart_items_to_cart_should_work(){
        Product product1 = new Product("Product 1", new BigDecimal(5));
        CartItem cartItem = new CartItem(product1, new BigDecimal(2));
        Cart cart = new Cart();
        cart.addItem(cartItem);
    }
}
