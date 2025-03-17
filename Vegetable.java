/**
 * A class to represent a Vegetable.
 * @author Landon H.
 */
public class Vegetable extends FoodItem {
    /**
     * Create a Vegetable (full-featured)
     * @param name The item's name
     * @param description A description of the item
     * @param brand The item's brand
     * @param price The item's price
     * @param returnPolicy The item's return policy
     * @param expirationDate The item's expiration date
     * @param isPerishable Whether the item is perishable
     */
    public Vegetable(String name, String description, String brand, double price, String returnPolicy, String expirationDate, boolean isPerishable) {
        super(name, description, brand, price, returnPolicy, expirationDate, isPerishable);
    }

    /**
     * Create a Vegetable (basic)
     * @param name The item's name
     * @param price The item's price
     * @param expirationDate The item's expiration date
     */
    public Vegetable(String name, double price, String expirationDate) {
        super(name, price, expirationDate);
    }
}
