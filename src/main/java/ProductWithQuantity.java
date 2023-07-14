public class ProductWithQuantity extends Product{
    private int quantity;

    public ProductWithQuantity(String id, String name, double price, int quantity) {
        super(id, name, price);
        this.quantity = quantity;
    }
}
