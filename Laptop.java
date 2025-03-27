/**
 * Represents a Laptop, which is a type of ElectronicsItem.
 * This class inherits from ElectronicsItem and provides constructors specific to laptops.
 * @author Caleb Joines
 */
public class Laptop extends ElectronicsItem {

    /**
     * Constructs a Laptop with detailed information.
     *
     * @param name         The name of the laptop.
     * @param description  A brief description of the laptop.
     * @param brand        The brand of the laptop.
     * @param price        The price of the laptop.
     * @param returnPolicy The return policy for the laptop.
     * @param screenWidth  The physical width of the laptop's screen (in inches).
     * @param screenHeight The physical height of the laptop's screen (in inches).
     */
    public Laptop(String name, String description, String brand, double price, String returnPolicy, double screenWidth, double screenHeight) {
        super(name, description, brand, price, returnPolicy, screenWidth, screenHeight);
    }

    /**
     * Constructs a Laptop with a simplified set of information.
     *
     * @param name         The name of the laptop.
     * @param price        The price of the laptop.
     * @param screenWidth  The physical width of the laptop's screen (in inches).
     * @param screenHeight The physical height of the laptop's screen (in inches).
     */
    public Laptop(String name, double price, double screenWidth, double screenHeight) {
        super(name, price, screenWidth, screenHeight);
    }
}