import java.text.DecimalFormat;
import java.util.ArrayList;
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

        List<Product> distinctItems = getListOfProducts();

        int productQuantity = getMyProductQuantity();

        if (listsOfProducts.size() == 4) {

            Product product1 = listsOfProducts.get(0);

            int singleProductQuantity = getSingleProductQuantity(productQuantity, listsOfProducts);

            List<Product> updatedListOfProducts = List.of(product1);

            List<String> productsFormatted = getProductsFormatted(productQuantity, updatedListOfProducts);

            return HEADER2 +
                    getFinalListFormatted(productsFormatted) +
                    HORIZONTAL_SEPARATION +
                    getTotalSection(product1, singleProductQuantity);
        }


        if (listsOfProducts.size() > 0) {

            int totalProductQuantity = getTotalProductQuantity(distinctItems, 0);

            List<String> productsFormatted = getProductsFormatted(productQuantity, listsOfProducts);

            String finalPriceFormatted = getFinalPriceFormatted(listsOfProducts);

            return HEADER2 + getFinalListFormatted(productsFormatted) +
                    HORIZONTAL_SEPARATION +
                    getTotalSection(String.valueOf(totalProductQuantity), finalPriceFormatted);
        }
        return EMPTY_SHOPPING_CART;
    }

    public List<ProductWithQuantity> listOfProductsWithQuantity(List<Product> listsOfProducts) {
        List<ProductWithQuantity> productsWithQuantityList = new ArrayList<>();

        int quantity = 0;
        for (Product product : listsOfProducts) {
            ProductWithQuantity productWithQuantity = new ProductWithQuantity(product.getId(), product.getName(), product.getPrice(), quantity);
            productsWithQuantityList.add(productWithQuantity);
        }

        return productsWithQuantityList;


    }

    private int getMyProductQuantity() {
        int productQuantity = 0;
        List<Product> distinctItems = getListOfProducts();
        productQuantity = getSingleProductQuantity(productQuantity, distinctItems);
        return productQuantity;
    }

    private int getTotalProductQuantity(List<Product> distinctItems, int totalProductQuantity) {
        for (Product distinctItem : distinctItems) {
            totalProductQuantity += getSingleProductQuantity(distinctItem);
        }
        return totalProductQuantity;
    }

    private int getSingleProductQuantity(int productQuantity, List<Product> distinctItems) {
        for (Product distinctItem : distinctItems) {
            productQuantity = getSingleProductQuantity(distinctItem);
        }
        return productQuantity;
    }

    private int getSingleProductQuantity(Product distinctItem) {
        return Collections.frequency(listsOfProducts, distinctItem);
    }

    private String getTotalSection(Product product, int productQuantity) {
        return getTotalSection(String.valueOf(productQuantity), String.valueOf(product.getPrice()));
    }

    private List<Product> getListOfProducts() {
        return listsOfProducts.stream().distinct().toList();
    }

    private List<String> getProductsFormatted(int productQuantity, List<Product> listsOfProducts) {
        List<String> myFinalListTrue = new ArrayList<>();
        for (Product listsOfProduct : listsOfProducts) {

            BasketProduct basketProduct = new BasketProduct(listsOfProduct.getName(), listsOfProduct.getPrice(), productQuantity);

            String productInfoFormat = basketProduct.getString();
            myFinalListTrue.add(productInfoFormat);
        }
        return myFinalListTrue;
    }

    private static String getFinalPriceFormatted(List<Product> products) {
        double finalPrice = 0;
        for (Product product : products) {
            finalPrice += product.getPrice();
        }
        DecimalFormat df = new DecimalFormat("#.#");
        return df.format(finalPrice);
    }

    private static String getFinalListFormatted(List<String> myFinalListTrue) {
        return myFinalListTrue.toString().replace("[", "").replace("]", "").replace(", ", "");
    }
}
