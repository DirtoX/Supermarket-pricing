package com.github.dirtox.supermarket;

import com.github.dirtox.supermarket.models.Product;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {
    @Test
    public void product_should_have_a_name(){
        Product product = new Product("Product 1");
        assertEquals(product.getName(), "Product 1");
    }
}
