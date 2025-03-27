/**
 * Subclass for shirt items
 * @author Connor W.
 */
public class Shirt extends ClothingItem{
    private String type;

    /**
     * Creates a Shirt object (full-feature)
     * @param name the item's name
     * @param description description of the item
     * @param brand the brand of the item
     * @param price the price of the item
     * @param returnPolicy the item's return policy
     * @param size the size of the item
     * @param gender the gender of the item (if applicable)
     * @param color the color of the item
     * @param material the material the item is made from
     * @param type the type of shirt
     */
    public Shirt(String name, String description, String brand, double price, String returnPolicy, String size, String gender, String color, String material, String type) {
        super(name, description, brand, price, returnPolicy, size, gender, color, material);
        this.type = type;
    }

    /**
     * Creates a shirt object (basic)
     * @param name the item's name
     * @param price the price of the item
     * @param size the size of the item
     * @param gender the gender of the item (if applicable)
     * @param color the color of the item
     * @param material the material the item is made from
     * @param type the type of shirt
     */
    public Shirt(String name, double price, String size, String gender, String color, String material, String type) {
        super(name, price, size, gender, color, material);
        this.type = type;
    }
    // Getters
    /**
     * Gets the type of shirt
     * @return String type
     */
    public String getType() {return type;}

    // Setters
    /**
     * Sets the type of shirt
     * @param type the type of shirt
     */
    public void setType(String type) {this.type = type;}
}
