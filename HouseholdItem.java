public class HouseholdItem extends StoreItem {

    public HouseholdItem(String name, String description, String brand, double price, String returnPolicy) {
        super(name, description, brand, price, returnPolicy);
    }

    public HouseholdItem(String name, double price) {
        super(name, price);
    }
}
