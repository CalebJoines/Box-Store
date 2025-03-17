public class FoodItem extends StoreItem {
    private String expirationDate;
    private boolean isPerishable;

    public FoodItem(String name, String description, String brand, double price, String returnPolicy, String expirationDate, boolean isPerishable) {
        super(name, description, brand, price, returnPolicy);
        this.expirationDate = expirationDate;
        this.isPerishable = isPerishable;
    }

    public FoodItem(String name, double price, String expirationDate) {
        super(name, price);
        this.expirationDate = expirationDate;
        this.isPerishable = true; // Defaulting to true since most food items are perishable
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isPerishable() {
        return isPerishable;
    }

    public void setPerishable(boolean perishable) {
        isPerishable = perishable;
    }
}
