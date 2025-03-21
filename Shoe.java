/**
 * Subclass for shoe items
 * @author Connor W.
 */
public class Shoe extends ClothingItem {
    private String securementType;
    private String type;

    public Shoe(String name, String description, String brand, double price, String returnPolicy, String size, String gender, String color, String material, String securementType, String type) {
        super(name, description, brand, price, returnPolicy, size, gender, color, material);
        this.securementType = securementType;
        this.type = type;
    }

    public Shoe(String name, double price, String size, String gender, String color, String material, String securementType, String type) {
        super(name, price, size, gender, color, material);
        this.securementType = securementType;
        this.type = type;
    }

    // Getters
    /**
     *
     * @return String securementType
     */
    public String getSecurementType() {return securementType;}
    /**
     *
     * @return String type
     */
    public String getType() {return type;}

    // Setters
    /**
     *
     * @param securementType
     */
    public void setSecurementType(String securementType) {this.securementType = securementType;}
    /**
     *
     * @param type
     */
    public void setType(String type) {this.type = type;}

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
