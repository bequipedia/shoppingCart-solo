import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartAcceptanceTest {
    //    As customer
//    I want to add Iceberg to my shopping cart
//    I want to add Tomatoe to my shopping cart
//    I want to add Chicken to my shopping cart
//    I want to add Bread to my shopping cart
//    I want to add Corn to my shopping cart
//    I want to see my shopping cart

    //    add products to shopping cart
//    shopping cart should have the list of products
//    each product have: id, name and price
//    the list of products should be able to get the amount of each product added to the shopping cart
//
//    print shopping cart with the products

    @Test
    void should_print_shopping_cart_with_products_added() {
        // arrange
        ShoppingCart shoppingCart = new ShoppingCart(new ArrayList<>());
        String id = "product_id";
        String name = "Iceberg";
        double price = 2.17;
        Product product = new Product(id, name, price);
        String expectedOutput = """
                --------------------------------------------
                | Product name  | Price with VAT | Quantity |
                | -----------   | -------------- | -------- |
                 Iceberg		2.17 €		3                       
                |-------------------------------------------|
                ---------------------------------------------
                 Total products: 3                        
                 Total price: 2.17 €                      
                ---------------------------------------------""";

        // act
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);
        String actualOutput = shoppingCart.print();

        // assert
        assertEquals(expectedOutput, actualOutput);
    }

//    @Test
//    void should_print_shopping_cart_with_products_added() {
//        // arrange
//        ShoppingCart shoppingCart = new ShoppingCart(new ArrayList<>());
//        String id = "product_id";
//        String name = "Iceberg";
//        double price = 2.17;
//        Product product = new Product(id, name, price);
//        String expectedOutput = """
//                --------------------------------------------
//                | Product name  | Price with VAT | Quantity |
//                | -----------   | -------------- | -------- |
//                 Iceberg    2.17 €      3
//                 Tomato     0.73 €      1
//                 Chicken    1.83 €      1
//                 Bread      0.88 €      2
//                 Corn       1.50 €      1
//                |-------------------------------------------|
//                 Promotion: 5% off with code PROMO_5  (last thing to implement )
//                ---------------------------------------------
//                 Total products: 8
//                 Total price: 11.71 €
//                ---------------------------------------------""";
//
//        // act
//        shoppingCart.addProduct(product);
//        String actualOutput = shoppingCart.print();
//
//        // assert
//        assertEquals(expectedOutput, actualOutput);
//    }
}
