import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    @Test
    void should_add_products_to_shopping_cart() {
        // arrange
        List<Product> actualOutput = new ArrayList<>();
        ShoppingCart shoppingCart = new ShoppingCart(actualOutput);
        Product product1 = new Product("id1", "product_name1", 1.1);
        Product product2 = new Product("id2", "product_name2", 1.2);
        Product product3 = new Product("id3", "product_name3", 1.3);
        List<Product> expectedOutput = List.of(product1, product2, product3);

        // act
        shoppingCart.addProduct(product1);
        shoppingCart.addProduct(product2);
        shoppingCart.addProduct(product3);
        // assert

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void should_print_shopping_cart() {
        // arrange
        ShoppingCart shoppingCart = new ShoppingCart(List.of(new Product("product1_id", "product1_name", 1.1)));
        String expectedOutput = "---------------------------------------\n" +
                "|Product name|Price with VAT|Quantity| \n" +
                "|------------|--------------|--------|\n" + "product1_id, product1_name, 1.1";

        // act
        String actualOutput = shoppingCart.print();

        // assert
        assertEquals(expectedOutput, actualOutput);
    }
}

