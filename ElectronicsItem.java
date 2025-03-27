public class ElectronicsItem extends StoreItem {

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

    /**
     * Get the screen's physical width.
     *
     * @return Screen width (in inches)
     */
    public double getScreenWidth() {return screenWidth;}

    /**
     * Gets the screen's physical height.
     *
     * @return Screen height (in inches)
     */
    public double getScreenHeight() {return screenHeight;}
}
