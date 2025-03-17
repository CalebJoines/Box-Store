public class ShelfStable extends FoodItem {
    public ShelfStable(String name, String description, String brand, double price, String returnPolicy, String expirationDate, boolean isPerishable) {
        super(name, description, brand, price, returnPolicy, expirationDate, isPerishable);
    }
    public ShelfStable(String name, double price, String expirationDate) {
        super(name, price, expirationDate);
    }
}
