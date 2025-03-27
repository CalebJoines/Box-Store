/**
 * Represents a generic store item with basic attributes like name, price, brand, description, and return policy.
 * This class also includes methods for managing stock count.
 * @author Caleb Joines
 * @author Landon H.
 * @author Connor W.
 */
public class StoreItem {
    private double price;
    private String brand;
    private String name;
    private String description;
    private String returnPolicy;
    private int stockCount;

    /**
     * Constructs a StoreItem with detailed information.
     *
     * @param name         The name of the store item.
     * @param description  A brief description of the item.
     * @param brand        The brand of the item.
     * @param price        The price of the item.
     * @param returnPolicy The return policy for the item.
     */
    public StoreItem(String name, String description, String brand, double price, String returnPolicy) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.returnPolicy = returnPolicy;
        this.stockCount = 1;
    }

    /**
     * Constructs a StoreItem with a simplified set of information (name and price).
     * Defaults are used for brand, description, and return policy.
     *
     * @param name  The name of the store item.
     * @param price The price of the item.
     */
    public StoreItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.brand = "Generic";
        this.description = "";
        this.returnPolicy = "";
        this.stockCount = 1;
    }

    /**
     * Gets the name of the store item.
     *
     * @return The name of the item.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the price of the store item.
     *
     * @return The price of the item.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Sets the price of the store item.
     *
     * @param price The new price of the item.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the brand of the store item.
     *
     * @return The brand of the item.
     */
    public String getBrand() {
        return this.brand;
    }

    /**
     * Gets the description of the store item.
     *
     * @return The description of the item.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of the store item.
     *
     * @param description The new description of the item.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the return policy of the store item.
     *
     * @return The return policy of the item.
     */
    public String getReturnPolicy() {
        return this.returnPolicy;
    }

    /**
     * Sets the return policy of the store item.
     *
     * @param returnPolicy The new return policy of the item.
     */
    public void setReturnPolicy(String returnPolicy) {
        this.returnPolicy = returnPolicy;
    }

    /**
     * Gets the current stock count of the store item.
     *
     * @return The stock count.
     */
    public int getStockCount() {
        return this.stockCount;
    }

    /**
     * Adds to the current stock count of the store item.
     *
     * @param count The amount to add to the stock.
     */
    public void addStockCount(int count) {
        this.stockCount += count;
    }

    /**
     * Subtracts from the current stock count of the store item.
     *
     * @param count The amount to subtract from the stock.
     * @return true if the subtraction was successful, false if there was not enough stock.
     */
    public boolean subtractStockCount(int count) {
        if (count > this.stockCount) {
            return false;
        } else {
            this.stockCount -= count;
            return true;
        }
    }
}