public class TV extends ElectronicsItem{

    public TV(String name, String description, String brand, double price, String returnPolicy, double screenWidth, double screenHeight) {
        super(name, description, brand, price, returnPolicy, screenWidth, screenHeight);
    }
    public TV(String name, double price, double screenWidth, double screenHeight) {
        super(name, price, screenWidth, screenHeight);
    }
}
