public class ElectronicsItem extends StoreItem{

    private double screenWidth;
    private double screenHeight;
    public ElectronicsItem(String name, String description, String brand, double price, String returnPolicy, double screenWidth, double screenHeight) {
        super(name, description, brand, price, returnPolicy);
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
    }

    public ElectronicsItem(String name, double price, double screenWidth, double screenHeight) {
        super(name, price);
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
    }
}
