public class ClothingItem extends StoreItem{
    private String size;
    private String gender;
    private String color;
    private String material;

    public ClothingItem(String name, double price, String size, String gender, String color, String material) {
        super(name, price);
        this.size = size;
        this.gender = gender;
        this.color = color;
        this.material = material;
    }

    public ClothingItem(String name, String description, String brand, double price, String returnPolicy, String size, String gender, String color, String material) {
        super(name, description, brand, price, returnPolicy);
        this.size = size;
        this.gender = gender;
        this.color = color;
        this.material = material;
    }

    public String getSize() {return size;}
    public String getGender() {return gender;}
    public String getColor() {return color;}
    public String getMaterial() {return material;}

    public void setSize(String size) {this.size = size;}
    public void setGender(String gender) {this.gender = gender;}
    public void setColor(String color) {this.color = color;}
    public void setMaterial(String material) {this.material = material;}
}
