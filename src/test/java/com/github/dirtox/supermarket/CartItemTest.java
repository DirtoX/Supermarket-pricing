package com.github.dirtox.supermarket;

import com.github.dirtox.supermarket.models.CartItem;
import com.github.dirtox.supermarket.models.Product;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartItemTest {

    @Test
    public void cart_item_should_have_product_quantity(){
        Product product = new Product("product1",new BigDecimal(50.5));
        CartItem cartItem = new CartItem(product, new BigDecimal(5));
        assertTrue(cartItem.getQuantity().compareTo(new BigDecimal(5)) == 0);
    }
}
