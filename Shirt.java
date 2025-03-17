public class Shirt extends ClothingItem{
    private String type;

    public Shirt(String name, String description, String brand, double price, String returnPolicy, String size, String gender, String color, String material, String type) {
        super(name, description, brand, price, returnPolicy, size, gender, color, material);
        this.type = type;
    }
    public Shirt(String name, double price, String size, String gender, String color, String material, String type) {
        super(name, price, size, gender, color, material);
        this.type = type;
    }
}
