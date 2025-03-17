public class StoreItem {
    private double price;
    private String brand;
    private String name;
    private String description;
    private String returnPolicy;
    public StoreItem(String name, String description, String brand, double price, String returnPolicy){
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.returnPolicy = returnPolicy;
    }
    public String getName(){return this.name;}
    public double getPrice(){return this.price;}
    public String getBrand(){return this.brand;}
    public String getDescription(){return this.description;}
    public String getReturnPolicy(){return this.returnPolicy;}
}
