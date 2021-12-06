package com.github.dirtox.supermarket;

import com.github.dirtox.supermarket.models.CartItem;
import com.github.dirtox.supermarket.models.Product;
import com.github.dirtox.supermarket.models.Quantity;
import org.junit.Test;

import java.math.BigDecimal;

import static com.github.dirtox.supermarket.models.MassUnit.OUNCE;
import static com.github.dirtox.supermarket.models.MassUnit.POUND;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartItemTest {

    @Test
    public void cart_item_should_have_product_quantity(){
        Product product = new Product("product1",new BigDecimal(50.5));
        CartItem cartItem = new CartItem(product, new Quantity(false, new BigDecimal(5), null), null);
        assertTrue(cartItem.getQuantity().compareTo(new BigDecimal(5)) == 0);
    }

    @Test
    public void cart_item_quantity_should_be_unitary_or_mass(){
        Product product1 = new Product("product1",new BigDecimal(50.5));
        Product product2 = new Product("product2",new BigDecimal(20));
        CartItem cartItem1 = new CartItem(product1, new Quantity(false, new BigDecimal(2), null), null);
        CartItem cartItem2 = new CartItem(product2, new Quantity(true, new BigDecimal(1.5), POUND), null);
        assertFalse(cartItem1.isMass());
        assertTrue(cartItem2.isMass());
    }

    @Test
    public void cart_item_quantity_with_ounce_should_be_converted_to_pound(){
        Product product = new Product("product1",new BigDecimal(50.5));
        CartItem cartItem = new CartItem(product, new Quantity(true, new BigDecimal(1), OUNCE), null);
        assertTrue(cartItem.getQuantity().compareTo(new BigDecimal(0.0625)) == 0);
    }
}
