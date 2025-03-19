import java.util.ArrayList;
import java.util.Scanner;
public class WQSJoinesHoustonWalker {

    public static void main(String[] args) {
        System.out.println("Welcome to Wilmington Quick Shop.\nWould you like to sell an item?(1) Or add an item?(2):");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        sc.nextLine();

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
                    System.out.println("Enter which type of item you wish for (Food (1), Electronics (2), Clothing (3), or Household (4):");
                    int typeOfItem = sc.nextInt();
                    sc.nextLine();
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
                            sc.nextLine();
                            if (userInput == 1){
                                System.out.println("Enter item name:");
                                String name = sc.nextLine();
                                System.out.println("Enter item brand:");
                                String brand = sc.nextLine();
                                for (int i=0; i<householdArray.size(); i++){
                                    if(householdArray.get(i).getName().equalsIgnoreCase(name) && householdArray.get(i).getBrand().equalsIgnoreCase(brand)){
                                        System.out.println("Please enter how much stock you wish to add:");
                                        int stockCount = sc.nextInt();
                                        sc.nextLine();
                                        householdArray.get(i).addStockCount(stockCount);
                                        System.out.println(householdArray.get(i).getName()+" has "+householdArray.get(i).getStockCount()+" in stock.");
                                    }
                                }
                            }
                            else if (userInput == 2){
                                createNewHouseholdItem(sc, householdArray);
                            }
                            else{
                                System.out.println("Not a valid input.");
                            }

                            break;
                        }
                        default:
                            break;
                    }
                    System.out.println("Have you completed adding items? (y/n):");
                    String completed = sc.nextLine();
                    if(completed.equalsIgnoreCase("y")){
                        condition = false;
                        System.out.println("UPDATED INVENTORY:");
                        displayHouseholdItems(householdArray);
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

    public static void createNewHouseholdItem(Scanner sc, ArrayList<HouseholdItem> householdArray) {
        System.out.println("What type of household item would you like to add? (Cleaning Supply (1) or Furniture (2)):");
        int typeChoice = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter item name:");
        String name = sc.nextLine();
        System.out.println("Enter item brand:");
        String brand = sc.nextLine();
        System.out.println("Enter item price:");
        double price = sc.nextDouble();
        sc.nextLine(); // Consume newline
        System.out.println("Enter item description:");
        String description = sc.nextLine();
        System.out.println("Enter return policy:");
        String returnPolicy = sc.nextLine();

        if (typeChoice == 1) { // Cleaning Supply
            System.out.println("Enter application method (e.g., Spray, Pour, Mop):");
            String applicationMethod = sc.nextLine();
            System.out.println("Enter use method (e.g., Wipe with cloth, Scrub with sponge):");
            String useMethod = sc.nextLine();

            householdArray.add(new CleaningSupply(name, description, brand, price, returnPolicy, applicationMethod, useMethod));
        } else if (typeChoice == 2) { // Furniture
            System.out.println("Enter furniture material:");
            String material = sc.nextLine();

            householdArray.add(new Furniture(name, description, brand, price, returnPolicy, material));
        } else {
            System.out.println("Invalid choice. Item not added.");
        }

        System.out.println("Item successfully added to inventory!");
    }


}
