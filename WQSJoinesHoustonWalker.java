import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
public class WQSJoinesHoustonWalker {

    public static void main(String[] args) {
        System.out.println("Welcome to Wilmington Quick Shop.\nWould you like to sell an item?(1) Or add an item?(2):");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        ArrayList<FoodItem> foodArray = new ArrayList<FoodItem>();
        ArrayList<HouseholdItem> householdArray = new ArrayList<HouseholdItem>();
        ArrayList<ElectronicsItem> electronicsArray = new ArrayList<ElectronicsItem>();
        ArrayList<ClothingItem> clothingArray = new ArrayList<ClothingItem>();

        // Adding CleaningSupply objects (AI generated)
        householdArray.add(new CleaningSupply("Glass Cleaner", "Cleans windows", "Windex", 5.99, "30 days", "Spray", "Wipe with cloth"));
        householdArray.add(new CleaningSupply("Dish Soap", "Cuts grease", "Dawn", 3.49, "No returns", "Pour", "Scrub with sponge"));
        householdArray.add(new CleaningSupply("Floor Cleaner", "Removes stains", "Pine-Sol", 6.99, "14 days", "Mop", "Dilute in water"));
        householdArray.add(new CleaningSupply("Bathroom Spray", "Kills germs", "Lysol", 7.99, "30 days", "Spray", "Wipe with towel"));

        // Adding Furniture objects (AI Generated)
        householdArray.add(new Furniture("Office Chair", "Ergonomic chair", "IKEA", 99.99, "60 days", "Leather"));
        householdArray.add(new Furniture("Dining Table", "Wooden dining table", "Ashley", 199.99, "90 days", "Oak Wood"));
        householdArray.add(new Furniture("Sofa", "Comfortable 3-seater", "La-Z-Boy", 499.99, "120 days", "Fabric"));
        householdArray.add(new Furniture("Bed Frame", "Queen size frame", "Wayfair", 299.99, "45 days", "Metal"));


        switch (input) {
            //If we chose to sell an Item
            case 1: {
                System.out.println("Test");
                break;
            }
            //If adding to inventory:
            //Asks what type of item (Food, Electronics, Clothing, or Household).
            //Displays items currently available in inventory for the selected category.
            //Provides the option to add more of an existing item or create a new item.
            //Continue looping until the user confirms they are done adding items.
            //Displays the updated inventory for the item(s) added.
            case 2: {
                boolean condition = true;
                while (condition) {
                    condition = false;
                    System.out.println("Enter which type of item you wish for (Food (1), Electronics (2), Clothing (3), or Household (4):");
                    int typeOfItem = sc.nextInt();
                    switch (typeOfItem) {
                        case 1: {

                            break;
                        }
                        case 2: {


                            break;
                        }
                        case 3: {


                            break;
                        }
                        case 4: {
                            displayHouseholdItems(householdArray);
                            System.out.println("Would you like to add more of an existing item?(1) Or Create a new item?(2)");
                            int userInput = sc.nextInt();
                            if (userInput == 1){
                                //add existing item method
                            }
                            else{
                                //create new item method
                            }
                            break;
                        }
                        default:
                            System.out.println("");
                            condition = true;
                            break;
                    }
                }
                break;
            }
            default:
                System.out.println("Invalid selection. Please enter 1 or 2.");
                break;
        }

    }

    public static void displayHouseholdItems(ArrayList<HouseholdItem> items) {
        System.out.printf("%-20s %-15s %-10s %-30s %-15s %-15s %-20s\n",
                "Name", "Brand", "Price", "Description", "Return Policy", "Type", "Additional Info");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");

        for (HouseholdItem item : items) {
            String type = "General";
            String additionalInfo = "";

            if (item instanceof CleaningSupply) {
                CleaningSupply cs = (CleaningSupply) item;
                type = "Application";
                additionalInfo = "Use: " + cs.getUseMethod() + ", Apply: " + cs.getApplicationMethod();
            } else if (item instanceof Furniture) {
                Furniture f = (Furniture) item;
                type = "Furniture";
                additionalInfo = "Material: " + f.getMaterial();
            }

            System.out.printf("%-20s %-15s $%-9.2f %-30s %-15s %-15s %-20s\n",
                    item.getName(), item.getBrand(), item.getPrice(), item.getDescription(),
                    item.getReturnPolicy(), type, additionalInfo);
        }
    }

}
