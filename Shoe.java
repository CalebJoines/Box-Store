/**
 * Subclass for shoe items
 * @author Connor W.
 */
public class Shoe extends ClothingItem {
    private String securementType;
    private String type;

    /**
     * Creates a shoe object (full-feature)
     * @param name the item's name
     * @param description description of the item
     * @param brand the brand of the item
     * @param price the price of the item
     * @param returnPolicy the item's return policy
     * @param size the size of the item
     * @param gender the gender of the item (if applicable)
     * @param color the color of the item
     * @param material the material the item is made from
     * @param securementType the way the shoe is secured
     * @param type the type of shoe
     */
    public Shoe(String name, String description, String brand, double price, String returnPolicy, String size, String gender, String color, String material, String securementType, String type) {
        super(name, description, brand, price, returnPolicy, size, gender, color, material);
        this.securementType = securementType;
        this.type = type;
    }

    /**
     * Creates a Shoe object (basic)
     * @param name the item's name
     * @param price the price of the item
     * @param size the size of the item
     * @param gender the gender of the item (if applicable)
     * @param color the color of the item
     * @param material the material the item is made from
     * @param securementType the way the shoe is secured
     * @param type the type of shoe
     */
    public Shoe(String name, double price, String size, String gender, String color, String material, String securementType, String type) {
        super(name, price, size, gender, color, material);
        this.securementType = securementType;
        this.type = type;
    }

    // Getters
    /**
     * Gets the securement type of the item
     * @return String securementType
     */
    public String getSecurementType() {return securementType;}
    /**
     * Gets the type of the item
     * @return String type
     */
    public String getType() {return type;}

    // Setters
    /**
     * Sets the securement type of the item
     * @param securementType
     */
    public void setSecurementType(String securementType) {this.securementType = securementType;}
    /**
     * Sets the type of the item
     * @param type
     */
    public void setType(String type) {this.type = type;}

}
