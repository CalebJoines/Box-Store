public class Fruit extends FoodItem {
    public Fruit(String name, String description, String brand, double price, String returnPolicy, String expirationDate, boolean isPerishable) {
        super(name, description, brand, price, returnPolicy, expirationDate, isPerishable);
    }
    public Fruit(String name, double price, String expirationDate) {
        super(name, price, expirationDate);
    }
}
