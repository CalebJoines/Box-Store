public class Outerwear extends ClothingItem {
    private String type;
    private Boolean isWaterproof;

    public Outerwear(String name, String description, String brand, double price, String returnPolicy, String size, String gender, String color, String material, String type, Boolean isWaterproof) {
        super(name, description, brand, price, returnPolicy, size, gender, color, material);
        this.type = type;
        this.isWaterproof = isWaterproof;
    }

    public Outerwear(String name, double price, String size, String gender, String color, String material, String type, Boolean isWaterproof) {
        super(name, price, size, gender, color, material);
        this.type = type;
        this.isWaterproof = isWaterproof;
    }

    public String getType() {return type;}
    public Boolean isWaterproof() {return isWaterproof;}

    public void setType(String type) {this.type = type;}
    public void setWaterproof(Boolean isWaterproof) {this.isWaterproof = isWaterproof;}
}
