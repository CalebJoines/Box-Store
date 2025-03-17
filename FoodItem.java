/**
 * Base class for food items.
 * @author Caleb J.
 * @author Landon H.
 */
public class FoodItem extends StoreItem {
    private String expirationDate;
    private boolean isPerishable;

    /**
     * Create a FoodItem (full-featured)
     * @param name The item's name
     * @param description A description of the item
     * @param brand The item's brand
     * @param price The item's price
     * @param returnPolicy The item's return policy
     * @param expirationDate The item's expiration date
     * @param isPerishable Whether the item is perishable
     */
    public FoodItem(String name, String description, String brand, double price, String returnPolicy, String expirationDate, boolean isPerishable) {
        super(name, description, brand, price, returnPolicy);
        this.expirationDate = expirationDate;
        this.isPerishable = isPerishable;
    }

    /**
     * Create a FoodItem (basic)
     * @param name The item's name
     * @param price The item's price
     * @param expirationDate The item's expiration date
     */
    public FoodItem(String name, double price, String expirationDate) {
        super(name, price);
        this.expirationDate = expirationDate;
        this.isPerishable = true; // Defaulting to true since most food items are perishable
    }

    /**
     * Get the item's expiration date.
     * @return The expiration date
     */
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * Set the item's expiration date.
     * @param expirationDate The item's expiration date
     */
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Gets whether the item is perishable.
     * @return Whether the item is perishable.
     */
    public boolean isPerishable() {
        return isPerishable;
    }

    /**
     * Sets whether the item is perishable.
     * @param perishable Whether the item is perishable.
     */
    public void setPerishable(boolean perishable) {
        isPerishable = perishable;
    }
}
