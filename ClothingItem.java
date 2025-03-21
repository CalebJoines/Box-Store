/**
 * Base Class for clothing items
 * @author Connor W.
 */
public class ClothingItem extends StoreItem{
    private String size;
    private String gender;
    private String color;
    private String material;

    /**
     * Creates a ClothingItem (full-featured)
     * @param name the item's name
     * @param description description of the item
     * @param brand the brand of the item
     * @param price the price of the item
     * @param returnPolicy the item's return policy
     * @param size the size of the item
     * @param gender the gender of the item (if applicable)
     * @param color the color of the item
     * @param material the material the item is made from
     */
    public ClothingItem(String name, String description, String brand, double price, String returnPolicy, String size, String gender, String color, String material) {
        super(name, description, brand, price, returnPolicy);
        this.size = size;
        this.gender = gender;
        this.color = color;
        this.material = material;
    }

    /**
     * Creates a ClothingItem (basic)
     * @param name the item's name
     * @param price the price of the item
     * @param size the size of the item
     * @param gender the gender of the item (if applicable)
     * @param color the color of the item
     * @param material the material the item is made from
     */
    public ClothingItem(String name, double price, String size, String gender, String color, String material) {
        super(name, price);
        this.size = size;
        this.gender = gender;
        this.color = color;
        this.material = material;
    }

    // Getters
    /**
     * Get the size of the item
     * @return String size
     */
    public String getSize() {return size;}
    /**
     * Get the gender of the item
     * @return String gender
     */
    public String getGender() {return gender;}
    /**
     * Get the color of the item
     * @return String color
     */
    public String getColor() {return color;}
    /**
     * Get the material of the item
     * @return String material
     */
    public String getMaterial() {return material;}

    // Setters
    /**
     * Sets the size of the item
     * @param size
     */
    public void setSize(String size) {this.size = size;}
    /**
     * Sets the gender of the item
     * @param gender
     */
    public void setGender(String gender) {this.gender = gender;}
    /**
     * Sets the color of the item
     * @param color
     */
    public void setColor(String color) {this.color = color;}
    /**
     * Sets the material of the item
     * @param material
     */
    public void setMaterial(String material) {this.material = material;}

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
