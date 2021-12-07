package com.github.dirtox.supermarket;

import com.github.dirtox.supermarket.models.CartItem;
import com.github.dirtox.supermarket.models.Product;
import com.github.dirtox.supermarket.models.Quantity;
import com.github.dirtox.supermarket.services.Converter;
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
        Converter converter = new Converter();
        CartItem cartItem = new CartItem(product, new Quantity(false, new BigDecimal(5), null, converter));
        assertTrue(cartItem.getQuantity().compareTo(new BigDecimal(5)) == 0);
    }

    @Test
    public void cart_item_quantity_should_be_unitary_or_mass(){
        Product product1 = new Product("product1",new BigDecimal(50.5));
        Product product2 = new Product("product2",new BigDecimal(20));
        Converter converter = new Converter();
        CartItem cartItem1 = new CartItem(product1, new Quantity(false, new BigDecimal(2), null, converter));
        CartItem cartItem2 = new CartItem(product2, new Quantity(true, new BigDecimal(1.5), POUND, converter));
        assertFalse(cartItem1.isMass());
        assertTrue(cartItem2.isMass());
    }

    @Test
    public void cart_item_quantity_with_ounce_should_be_converted_to_pound(){
        Product product = new Product("product1",new BigDecimal(50.5));
        Converter converter = new Converter();
        CartItem cartItem = new CartItem(product, new Quantity(true, new BigDecimal(1), OUNCE, converter));
        assertTrue(cartItem.getQuantity().compareTo(new BigDecimal(0.0625)) == 0);
    }
}
