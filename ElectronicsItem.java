/**
 * Represents an electronics item in the store's inventory.
 * This class extends StoreItem and adds screen width and height attributes.
 * @author Caleb Joines
 */
public class ElectronicsItem extends StoreItem {

    private double screenWidth;
    private double screenHeight;

    /**
     * Constructs an ElectronicsItem with detailed information.
     *
     * @param name         The name of the electronics item.
     * @param description  A brief description of the item.
     * @param brand        The brand of the item.
     * @param price        The price of the item.
     * @param returnPolicy The return policy for the item.
     * @param screenWidth  The physical width of the screen (in inches).
     * @param screenHeight The physical height of the screen (in inches).
     */
    public ElectronicsItem(String name, String description, String brand, double price, String returnPolicy, double screenWidth, double screenHeight) {
        super(name, description, brand, price, returnPolicy);
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
    }

    /**
     * Constructs an ElectronicsItem with a simplified set of information.
     *
     * @param name         The name of the electronics item.
     * @param price        The price of the item.
     * @param screenWidth  The physical width of the screen (in inches).
     * @param screenHeight The physical height of the screen (in inches).
     */
    public ElectronicsItem(String name, double price, double screenWidth, double screenHeight) {
        super(name, price);
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
    }

    /**
     * Get the screen's physical width.
     *
     * @return Screen width (in inches).
     */
    public double getScreenWidth() {
        return screenWidth;
    }

    /**
     * Gets the screen's physical height.
     *
     * @return Screen height (in inches).
     */
    public double getScreenHeight() {
        return screenHeight;
    }
}