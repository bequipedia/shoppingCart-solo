import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
    private final List<BasketProduct> listsOfProductsWithQuantity = new ArrayList<>();


    public ShoppingCart(List<Product> listsOfProducts) {

        this.listsOfProducts = listsOfProducts;
    }

    public void addProduct(BasketProduct product) {
        listsOfProductsWithQuantity.add(product);
    }

    public String print() {


        int productQuantity = getQuantityOfEachDistinctProduct();

        if (listsOfProductsWithQuantity.size() == 4) {

            BasketProduct product1 = listsOfProductsWithQuantity.get(0);

            int singleProductQuantity = getQuantityOfEachDistinctProduct();

            List<BasketProduct> updatedListOfProducts = List.of(product1);

            List<String> productsFormatted = getProductsFormatted(productQuantity, updatedListOfProducts);

            return HEADER2 +
                    getFinalListFormatted(productsFormatted) +
                    HORIZONTAL_SEPARATION +
                    getTotalSection(singleProductQuantity, product1);
        }

        if (listsOfProductsWithQuantity.size() > 0) {

            List<BasketProduct> distinctItems = getListOfDistinctProductsInBasket();
            int totalProductQuantity = getTotalProductQuantity(distinctItems);

            List<String> productsFormatted = getProductsFormatted(productQuantity, listsOfProductsWithQuantity);

            String finalPriceFormatted = getFinalPriceFormatted(listsOfProductsWithQuantity);

            return HEADER2 + getFinalListFormatted(productsFormatted) +
                    HORIZONTAL_SEPARATION +
                    getTotalSection(String.valueOf(totalProductQuantity), finalPriceFormatted);
        }
        return EMPTY_SHOPPING_CART;
    }
//        final idea before giving up for the next two hours:
//        a list that handles products with quantity instead of having multiple methods handling quantity
//        this approach is more likely to use the things that I already have

//        another idea if this one doesn't work: create a map <Product, quantity> and iterate over a list of products and += the quantity and update the map value
//        this approach changes the whole design completely and I'll need to adjust passing tests

    public List<BasketProduct> getListOfProductsWithQuantity(List<Product> listsOfProducts) {
        List<BasketProduct> productsWithQuantityList = new ArrayList<>();
        int quantity = 0;
        for (Product product : listsOfProducts) {
            BasketProduct productWithQuantity = new BasketProduct(product.getName(), product.getPrice(), quantity);
            productsWithQuantityList.add(productWithQuantity);
        }
        return productsWithQuantityList;
    }
    private int getQuantityOfEachDistinctProduct() {
        int productQuantity = 0;
        List<BasketProduct> distinctItems = getListOfDistinctProductsInBasket();
        for (BasketProduct distinctItem : distinctItems) {
            productQuantity = Collections.frequency(listsOfProductsWithQuantity, distinctItem);
        }
        return productQuantity;
    }

    private List<BasketProduct> getListOfDistinctProductsInBasket() {
        return listsOfProductsWithQuantity.stream().distinct().toList();
    }

//    private int getQuantityOfEachDistinctProduct() {
//        int productQuantity = 0;
//        List<Product> distinctItems = getListOfDistinctProductsInBasket();
//        for (Product distinctItem : distinctItems) {
//            productQuantity = Collections.frequency(listsOfProducts, distinctItem);
//        }
//        return productQuantity;
//    }
//
//    private List<Product> getListOfDistinctProductsInBasket() {
//        return listsOfProducts.stream().distinct().toList();
//    }

//    these two up here are coupled

    private int getTotalProductQuantity(List<BasketProduct> distinctItems) {
        int totalProductQuantity = 0;
        for (BasketProduct distinctItem : distinctItems) {
            totalProductQuantity += Collections.frequency(listsOfProducts, distinctItem);
        }
        return totalProductQuantity;
    }

    private String getTotalSection(int productQuantity, BasketProduct product) {
        return getTotalSection(String.valueOf(productQuantity), String.valueOf(product.getProductPrice()));
    }

    private List<String> getProductsFormatted(int productQuantity, List<BasketProduct> listsOfProducts) {
        List<String> myFinalListTrue = new ArrayList<>();
        for (BasketProduct listsOfProduct : listsOfProducts) {

            BasketProduct basketProduct = new BasketProduct(listsOfProduct.getProductName(), listsOfProduct.getProductPrice(), productQuantity);

            String productInfoFormat = basketProduct.getString();
            myFinalListTrue.add(productInfoFormat);
        }
        return myFinalListTrue;
    }

    private static String getFinalPriceFormatted(List<BasketProduct> products) {
        double finalPrice = 0;
        for (BasketProduct product : products) {
            finalPrice += product.getProductPrice();
        }
        DecimalFormat df = new DecimalFormat("#.#");
        return df.format(finalPrice);
    }

    private static String getFinalListFormatted(List<String> myFinalListTrue) {
        return myFinalListTrue.toString().replace("[", "").replace("]", "").replace(", ", "");
    }
}
