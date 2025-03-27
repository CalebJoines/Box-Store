/**
 * Represents a Phone, which is a type of ElectronicsItem.
 * This class inherits from ElectronicsItem and provides constructors specific to phones.
 * @author Caleb Joines
 */
public class Phone extends ElectronicsItem {

    /**
     * Constructs a Phone with detailed information.
     *
     * @param name         The name of the phone.
     * @param description  A brief description of the phone.
     * @param brand        The brand of the phone.
     * @param price        The price of the phone.
     * @param returnPolicy The return policy for the phone.
     * @param screenWidth  The physical width of the phone's screen (in inches).
     * @param screenHeight The physical height of the phone's screen (in inches).
     */
    public Phone(String name, String description, String brand, double price, String returnPolicy, double screenWidth, double screenHeight) {
        super(name, description, brand, price, returnPolicy, screenWidth, screenHeight);
    }

    /**
     * Constructs a Phone with a simplified set of information.
     *
     * @param name         The name of the phone.
     * @param price        The price of the phone.
     * @param screenWidth  The physical width of the phone's screen (in inches).
     * @param screenHeight The physical height of the phone's screen (in inches).
     */
    public Phone(String name, double price, double screenWidth, double screenHeight) {
        super(name, price, screenWidth, screenHeight);
    }
}