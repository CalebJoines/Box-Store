public class CleaningSupply extends HouseholdItem {
    public CleaningSupply(String name, String description, String brand, double price, String returnPolicy) {
        super(name, description, brand, price, returnPolicy);
    }
    public CleaningSupply(String name, double price) {
        super(name, price);
    }
}
