package com.github.dirtox.supermarket;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Suite.SuiteClasses( { ProductTest.class, CartItemTest.class, CartTest.class })
public class SupermarketApplicationTests {

}
