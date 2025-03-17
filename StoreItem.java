public class StoreItem {
    private double price;
    private String brand;
    private String name;
    private String description;
    private String returnPolicy;
    public StoreItem(String name, String description, String brand, double price, String returnPolicy) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.returnPolicy = returnPolicy;
    }
    public StoreItem(String name, double price){
        this.name = name;
        this.price = price;
        this.brand = "Generic";
        this.description = "";
        this.returnPolicy = "";
    }
    public String getName() {return this.name;}
    public double getPrice() {return this.price;}
    public void setPrice(double price) {this.price = price;}
    public String getBrand() {return this.brand;}
    public String getDescription() {return this.description;}
    public void setDescription(String description) {this.description = description;}
    public String getReturnPolicy() {return this.returnPolicy;}
    public void setReturnPolicy(String returnPolicy) {this.returnPolicy = returnPolicy;}
}
