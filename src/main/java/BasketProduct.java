public class BasketProduct {


    private String productName;

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    private double productPrice;
    private int productQuantity;

    public BasketProduct(String productName, double productPrice, int productQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    String getString() {

        return " " + productName + "\t\t" + productPrice + " €" + "\t\t" + productQuantity + "\n";
    }
}