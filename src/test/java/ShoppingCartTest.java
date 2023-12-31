import org.junit.jupiter.api.Test;

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
    void should_print_shopping_cart_with_single_item() {
        // arrange
        Product product1 = new Product("product1_id", "product1_name", 1.1);
        ShoppingCart shoppingCart = new ShoppingCart(List.of(product1));
        String expectedOutput =
                "--------------------------------------------\n" +
                "| Product name  | Price with VAT | Quantity |\n" +
                "| -----------   | -------------- | -------- |\n" +
                " product1_name\t\t1.1 €\t\t1\n" +
                "|-------------------------------------------|\n" +
                "---------------------------------------------\n" +
                " Total products: 1\n" +
                " Total price: 1.1 €\n" +
                "---------------------------------------------";


        // act
        String actualOutput = shoppingCart.print();

        // assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void should_print_product_quantity_in_cart() {
        // arrange
        Product product1 = new Product("product1_id", "product1_name", 1.1);

        ShoppingCart shoppingCart = new ShoppingCart(List.of(product1, product1, product1, product1));
        String expectedOutput =
                "--------------------------------------------\n" +
                "| Product name  | Price with VAT | Quantity |\n" +
                "| -----------   | -------------- | -------- |\n" +
                " product1_name\t\t1.1 €\t\t4\n" +
                "|-------------------------------------------|\n" +
                "---------------------------------------------\n" +
                " Total products: 4\n" +
                " Total price: 1.1 €\n" +
                "---------------------------------------------";

        // act
        String actualOutput = shoppingCart.print();

        // assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void should_print_cart_with_no_products() {
        // arrange

        ShoppingCart shoppingCart = new ShoppingCart(List.of());
        String expectedOutput = """
                --------------------------------------------
                | Product name  | Price with VAT | Quantity |
                | -----------   | -------------- | -------- |      
                |-------------------------------------------|
                ---------------------------------------------
                 Total products: 0                        
                 Total price: 0 €                      
                ---------------------------------------------""";

        // act
        String actualOutput = shoppingCart.print();

        // assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void should_print_shopping_cart_with_multiple_items() {
        // arrange
        Product product1 = new Product("product1_id", "product1_name", 1.1);
        Product product2 = new Product("product2_id", "product2_name", 1.2);
        Product product3 = new Product("product3_id", "product3_name", 1.3);
        ShoppingCart shoppingCart = new ShoppingCart(List.of(product1, product2, product3));
        String expectedOutput =
                "--------------------------------------------\n" +
                        "| Product name  | Price with VAT | Quantity |\n" +
                        "| -----------   | -------------- | -------- |\n" +
                        " product1_name\t\t1.1 €\t\t1\n" +
                        " product2_name\t\t1.2 €\t\t1\n" +
                        " product3_name\t\t1.3 €\t\t1\n" +
                        "|-------------------------------------------|\n" +
                        "---------------------------------------------\n" +
                        " Total products: 3\n" +
                        " Total price: 3.6 €\n" +
                        "---------------------------------------------";


        // act
        String actualOutput = shoppingCart.print();

        // assert
        assertEquals(expectedOutput, actualOutput);
    }

}

