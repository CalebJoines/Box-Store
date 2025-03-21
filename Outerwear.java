/**
 * Subclass for outerwear items
 * @author Connor W.
 */
public class Outerwear extends ClothingItem {

    private String type;
    private Boolean isWaterproof;

    /**
     * Creates an Outerwear object (full-feature)
     * @param name the item's name
     * @param description description of the item
     * @param brand the brand of the item
     * @param price the price of the item
     * @param returnPolicy the item's return policy
     * @param size the size of the item
     * @param gender the gender of the item (if applicable)
     * @param color the color of the item
     * @param material the material the item is made from
     * @param type the type of outerwear the item is
     * @param isWaterproof if the item is waterproof or not
     */
    public Outerwear(String name, String description, String brand, double price, String returnPolicy, String size, String gender, String color, String material, String type, Boolean isWaterproof) {
        super(name, description, brand, price, returnPolicy, size, gender, color, material);
        this.type = type;
        this.isWaterproof = isWaterproof;
    }

    /**
     * Creates an Outerwear object (basic)
     * @param name the item's name
     * @param price the price of the item
     * @param size the size of the item
     * @param gender the gender of the item (if applicable)
     * @param color the color of the item
     * @param material the material the item is made from
     * @param type the type of outerwear the item is
     * @param isWaterproof if the item is waterproof or not
     */
    public Outerwear(String name, double price, String size, String gender, String color, String material, String type, Boolean isWaterproof) {
        super(name, price, size, gender, color, material);
        this.type = type;
        this.isWaterproof = isWaterproof;
    }
    // Getters
    /**
     * Gets the type of Outerwear the item is
     * @return String type
     */
    public String getType() {return type;}
    /**
     * Gets whether the item is waterproof or not
     * @return Boolean isWaterproof
     */
    public Boolean isWaterproof() {return isWaterproof;}

    // Setters
    /**
     * Sets the type of outerwear
     * @param type
     */
    public void setType(String type) {this.type = type;}
    /**
     * Sets whether the outerwear is waterproof or not
     * @param isWaterproof
     */
    public void setWaterproof(Boolean isWaterproof) {this.isWaterproof = isWaterproof;}

    /**
     *
     *
     * @return String
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
