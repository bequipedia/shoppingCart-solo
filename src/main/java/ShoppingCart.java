import java.util.List;

public class ShoppingCart {
    private static final String HEADER = "---------------------------------------\n" +
            "|Product name|Price with VAT|Quantity| \n" +
            "|------------|--------------|--------|\n";
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
//  HEADER =    "--------------------------------------------
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

        String listToString = listsOfProducts.toString().replace("[", "").replace("]", "");
        return HEADER + listToString;
    }
}
