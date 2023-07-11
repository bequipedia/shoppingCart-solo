import java.util.Collections;
import java.util.List;

public class ShoppingCart {
    //    private static final String VERTICAL_SEPARATION = "|";
    private static final String HEADER2 = "--------------------------------------------\n" +
            "| Product name  | Price with VAT | Quantity |\n" +
            "| -----------   | -------------- | -------- |\n";
    private static final String HORIZONTAL_SEPARATION = "|-------------------------------------------|\n";
    private static final String EMPTY_SHOPPING_CART = HEADER2 +
            HORIZONTAL_SEPARATION +
            getTotalSection("0", "0");

    private static String getTotalSection(String totalProducts, String totalPrice) {
        return "---------------------------------------------\n" +
                " Total products: " + totalProducts + "\n" +
                " Total price: " + totalPrice + " €\n" +
                "---------------------------------------------";
    }

    private final List<Product> listsOfProducts;

    public ShoppingCart(List<Product> listsOfProducts) {

        this.listsOfProducts = listsOfProducts;
    }

    public void addProduct(Product product) {
        listsOfProducts.add(product);
    }

    public String print() {
// I will need a specific format to print the shopping list
//        look for the repetition to extract constants
//        """
//  HEADER2 =    "--------------------------------------------
//                | Product name  | Price with VAT | Quantity |
//                | -----------   | -------------- | -------- |"
//
//  VERTICAL_SEPARATION = "|"
//                | Iceberg       | 2.17 €         | 3        |
//                | Tomato        | 0.73 €         | 1        |
//                | Chicken       | 1.83 €         | 1        |
//                | Bread         | 0.88 €         | 2        |
//                | Corn          | 1.50 €         | 1        |
//
//  HORIZONTAL_SEPARATION = "-------------------------------------------" \\
//  VERTICAL_SEPARATION + HORIZONTAL_SEPARATION = |-------------------------------------------|
//
//                | Promotion: 5% off with code PROMO_5       |
//
//                ---------------------------------------------
//
//                | Total products: 8                         |
//                | Total price: 11.71 €                      |
//
//                ---------------------------------------------;
//
//
//
//
        if (listsOfProducts.size() > 0) {

            Product product1 = listsOfProducts.get(0);
            String productName = product1.getName();
            double productPrice = product1.getPrice();

            int productQuantity = 0;
            List<Product> distinctItems = listsOfProducts.stream().distinct().toList();
            for (Product distinctItem : distinctItems) {
                productQuantity = Collections.frequency(listsOfProducts, distinctItem);
            }
//        int finalPrice = productQuantity * productPrice;

            String productInfoFormat = " " + productName + "\t\t" + productPrice + " €" + "\t\t" + productQuantity + "\n";
            return HEADER2 + productInfoFormat +
                    HORIZONTAL_SEPARATION +
                    getTotalSection(String.valueOf(productQuantity), String.valueOf(product1.getPrice()));

        }
        return EMPTY_SHOPPING_CART;
    }
}
