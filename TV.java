/**
 * Represents a TV, which is a type of ElectronicsItem.
 * This class inherits from ElectronicsItem and provides constructors specific to TVs.
 * @author Caleb Joines
 */
public class TV extends ElectronicsItem {

    /**
     * Constructs a TV with detailed information.
     *
     * @param name         The name of the TV.
     * @param description  A brief description of the TV.
     * @param brand        The brand of the TV.
     * @param price        The price of the TV.
     * @param returnPolicy The return policy for the TV.
     * @param screenWidth  The physical width of the TV's screen (in inches).
     * @param screenHeight The physical height of the TV's screen (in inches).
     */
    public TV(String name, String description, String brand, double price, String returnPolicy, double screenWidth, double screenHeight) {
        super(name, description, brand, price, returnPolicy, screenWidth, screenHeight);
    }

    /**
     * Constructs a TV with a simplified set of information.
     *
     * @param name         The name of the TV.
     * @param price        The price of the TV.
     * @param screenWidth  The physical width of the TV's screen (in inches).
     * @param screenHeight The physical height of the TV's screen (in inches).
     */
    public TV(String name, double price, double screenWidth, double screenHeight) {
        super(name, price, screenWidth, screenHeight);
    }
}