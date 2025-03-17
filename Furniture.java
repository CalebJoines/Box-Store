public class Furniture extends HouseholdItem{
    private String material;
    public Furniture(String name, String description, String brand, double price, String returnPolicy, String material) {
        super(name, description, brand, price, returnPolicy);
        this.material = material;
    }
    public Furniture(String name, double price, String material) {
        super(name, price);
        this.material = material;
    }

    public String getMaterial(){
        return this.material;
    }

    public void setMaterial(String material){
        this.material = material;
    }
}
