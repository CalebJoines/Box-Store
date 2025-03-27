/**
 * Represents a household item in the store's inventory.
 * This class extends StoreItem and provides constructors specific to household items.
 * @author Caleb Joines
 */
public class HouseholdItem extends StoreItem {

    /**
     * Constructs a HouseholdItem with detailed information.
     *
     * @param name         The name of the household item.
     * @param description  A brief description of the item.
     * @param brand        The brand of the item.
     * @param price        The price of the item.
     * @param returnPolicy The return policy for the item.
     */
    public HouseholdItem(String name, String description, String brand, double price, String returnPolicy) {
        super(name, description, brand, price, returnPolicy);
    }

    /**
     * Constructs a HouseholdItem with a simplified set of information.
     *
     * @param name  The name of the household item.
     * @param price The price of the item.
     */
    public HouseholdItem(String name, double price) {
        super(name, price);
    }
}