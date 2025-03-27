/**
 * Represents a piece of furniture, which is a type of HouseholdItem.
 * This class includes information about the material of the furniture.
 * @author Caleb Joines
 */
public class Furniture extends HouseholdItem {
    private String material;

    /**
     * Constructs a Furniture object with detailed information.
     *
     * @param name         The name of the furniture.
     * @param description  A brief description of the furniture.
     * @param brand        The brand of the furniture.
     * @param price        The price of the furniture.
     * @param returnPolicy The return policy for the furniture.
     * @param material     The material of the furniture (e.g., "Oak Wood", "Leather").
     */
    public Furniture(String name, String description, String brand, double price, String returnPolicy, String material) {
        super(name, description, brand, price, returnPolicy);
        this.material = material;
    }

    /**
     * Constructs a Furniture object with a simplified set of information.
     *
     * @param name     The name of the furniture.
     * @param price    The price of the furniture.
     * @param material The material of the furniture (e.g., "Oak Wood", "Leather").
     */
    public Furniture(String name, double price, String material) {
        super(name, price);
        this.material = material;
    }

    /**
     * Gets the material of the furniture.
     *
     * @return The material of the furniture.
     */
    public String getMaterial() {
        return this.material;
    }

    /**
     * Sets the material of the furniture.
     *
     * @param material The material to set.
     */
    public void setMaterial(String material) {
        this.material = material;
    }
}