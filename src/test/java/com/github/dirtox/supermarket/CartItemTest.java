package com.github.dirtox.supermarket;

import com.github.dirtox.supermarket.models.CartItem;
import com.github.dirtox.supermarket.models.Product;
import org.junit.Test;

import java.math.BigDecimal;

public class CartItemTest {

    @Test
    public void cart_item_should_have_product_quantity(){
        Product product = new Product("product1",new BigDecimal(50.5));
        CartItem cartItem = new CartItem(product, new BigDecimal(5));
    }
}
