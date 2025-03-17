public class Phone extends ElectronicsItem{

    public Phone(String name, String description, String brand, double price, String returnPolicy, double screenWidth, double screenHeight) {
        super(name, description, brand, price, returnPolicy, screenWidth, screenHeight);
    }
    public Phone(String name, double price, double screenWidth, double screenHeight) {
        super(name, price, screenWidth, screenHeight);
    }
}