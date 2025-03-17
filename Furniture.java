public class Furniture extends HouseholdItem{
    public Furniture(String name, String description, String brand, double price, String returnPolicy) {
        super(name, description, brand, price, returnPolicy);
    }
    public Furniture(String name, double price) {
        super(name, price);
    }
}
