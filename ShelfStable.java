/**
 * A class to represent "shelf stable" food items (such as canned goods).
 * @author Landon H.
 */
public class ShelfStable extends FoodItem {
    /**
     * Create a ShelfStable food (full-featured)
     * @param name The item's name
     * @param description A description of the item
     * @param brand The item's brand
     * @param price The item's price
     * @param returnPolicy The item's return policy
     * @param expirationDate The item's expiration date
     * @param isPerishable Whether the item is perishable
     */
    public ShelfStable(String name, String description, String brand, double price, String returnPolicy, String expirationDate, boolean isPerishable) {
        super(name, description, brand, price, returnPolicy, expirationDate, isPerishable);
	// ShelfStable is non-perishable
	setPerishable(false);
    }

    /**
     * Create a ShelfStable food (basic)
     * @param name The item's name
     * @param price The item's price
     * @param expirationDate The item's expiration date
     */
    public ShelfStable(String name, double price, String expirationDate) {
        super(name, price, expirationDate);
	// ShelfStable is non-perishable
	setPerishable(false);
    }
}
