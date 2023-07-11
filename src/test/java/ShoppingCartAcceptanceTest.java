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
        String id1 = "product_id1";
        String name1 = "Iceberg";
        double price1 = 2.17;
        Product product1 = new Product(id1, name1, price1);
        String id2 = "id2";
        String name2 = "Tomato";
        double price2 = 0.73;
        Product product2 = new Product(id2, name2, price2);
        String id3 = "id3";
        String name3 = "Chicken";
        double price3 = 1.83;
        Product product3 = new Product(id3, name3, price3);
        String id4 = "id4";
        String name4 = "Bread";
        double price4 = 0.88;
        Product product4 = new Product(id4, name4, price4);
        String id5 = "id5";
        String name5 = "Corn";
        double price5 = 1.50;
        Product product5 = new Product(id5, name5, price5);
        String expectedOutput = """
                --------------------------------------------
                | Product name  | Price with VAT | Quantity |
                | -----------   | -------------- | -------- |
                 Iceberg		2.17 €		3                 
                 Tomato		0.73 €		1
                 Chicken		1.83 €		1
                 Bread		0.88 €		2
                 Corn		1.50 €		1      
                |-------------------------------------------|
                ---------------------------------------------
                 Total products: 8                        
                 Total price: 7.11 €                      
                ---------------------------------------------""";

        // act
        shoppingCart.addProduct(product1);
        shoppingCart.addProduct(product1);
        shoppingCart.addProduct(product1);
        shoppingCart.addProduct(product2);
        shoppingCart.addProduct(product3);
        shoppingCart.addProduct(product4);
        shoppingCart.addProduct(product4);
        shoppingCart.addProduct(product5);
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
