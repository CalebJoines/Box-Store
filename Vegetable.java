public class Vegetable extends FoodItem {
    public Vegetable(String name, String description, String brand, double price, String returnPolicy, String expirationDate, boolean isPerishable) {
        super(name, description, brand, price, returnPolicy, expirationDate, isPerishable);
    }
    public Vegetable(String name, double price, String expirationDate) {
        super(name, price, expirationDate);
    }
}
