/**
 * Represents a cleaning supply item, which is a type of HouseholdItem.
 * This class includes information about the use and application methods of the cleaning supply.
 * @author Caleb Joines
 */
public class CleaningSupply extends HouseholdItem {
    private String useMethod;
    private String applicationMethod;

    /**
     * Constructs a CleaningSupply with detailed information.
     *
     * @param name              The name of the cleaning supply.
     * @param description       A brief description of the cleaning supply.
     * @param brand             The brand of the cleaning supply.
     * @param price             The price of the cleaning supply.
     * @param returnPolicy      The return policy for the cleaning supply.
     * @param useMethod         The method of using the cleaning supply (e.g., "Wipe with cloth").
     * @param applicationMethod The method of applying the cleaning supply (e.g., "Spray", "Pour").
     */
    public CleaningSupply(String name, String description, String brand, double price, String returnPolicy, String useMethod, String applicationMethod) {
        super(name, description, brand, price, returnPolicy);
        this.useMethod = useMethod;
        this.applicationMethod = applicationMethod;
    }

    /**
     * Constructs a CleaningSupply with a simplified set of information.
     *
     * @param name              The name of the cleaning supply.
     * @param price             The price of the cleaning supply.
     * @param useMethod         The method of using the cleaning supply (e.g., "Wipe with cloth").
     * @param applicationMethod The method of applying the cleaning supply (e.g., "Spray", "Pour").
     */
    public CleaningSupply(String name, double price, String useMethod, String applicationMethod) {
        super(name, price);
        this.useMethod = useMethod;
        this.applicationMethod = applicationMethod;
    }

    /**
     * Gets the method of using the cleaning supply.
     *
     * @return The use method.
     */
    public String getUseMethod() {
        return this.useMethod;
    }

    /**
     * Gets the method of applying the cleaning supply.
     *
     * @return The application method.
     */
    public String getApplicationMethod() {
        return this.applicationMethod;
    }

    /**
     * Sets the method of using the cleaning supply.
     *
     * @param useMethod The use method to set.
     */
    public void setUseMethod(String useMethod) {
        this.useMethod = useMethod;
    }

    /**
     * Sets the method of applying the cleaning supply.
     *
     * @param applicationMethod The application method to set.
     */
    public void setApplicationMethod(String applicationMethod) {
        this.applicationMethod = applicationMethod;
    }
}