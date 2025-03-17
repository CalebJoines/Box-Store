public class ElectronicsItem extends StoreItem{

    public ElectronicsItem(String name, String description, String brand, double price, String returnPolicy) {
        super(name, description, brand, price, returnPolicy);
    }

    public ElectronicsItem(String name, double price) {
        super(name, price);
    }
}
