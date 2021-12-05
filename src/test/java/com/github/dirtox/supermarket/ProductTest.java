package com.github.dirtox.supermarket;

import com.github.dirtox.supermarket.models.Product;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductTest {
    @Test
    public void product_should_have_a_name(){
        Product product = new Product("Product 1", new BigDecimal(5));
        assertEquals(product.getName(), "Product 1");
    }

    @Test
    public void product_should_have_a_price(){
        Product product = new Product("Product 1", new BigDecimal(5));
        assertTrue(product.getPrice().compareTo(new BigDecimal(5)) == 0);
    }
}
