import java.util.ArrayList;
import java.util.Scanner;
public class WQSJoinesHoustonWalker {

    public static void main(String[] args) {
        System.out.println("Welcome to Wilmington Quick Shop.");
        Scanner sc = new Scanner(System.in);

        ArrayList<FoodItem> foodArray = new ArrayList<FoodItem>();
        ArrayList<HouseholdItem> householdArray = new ArrayList<HouseholdItem>();
        ArrayList<ElectronicsItem> electronicsArray = new ArrayList<ElectronicsItem>();
        ArrayList<ClothingItem> clothingArray = new ArrayList<ClothingItem>();

        // For testing FoodItems
        foodArray.add(new Fruit("Apple", "Gala Apple", "Generic", 1.00, "14 days", "4/1/25", true));
        foodArray.add(new Vegetable("Cucumber", "Cucumber", "Generic", 1.00, "14 days", "4/1/25", true));

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

        boolean exitMainLoop = false;
        // Used to select item category within action selection
        int typeOfItem = 0;

        while (!exitMainLoop) {
            System.out.print("Would you like to purchase an item (1), add an item (2), or exit (0)? ");
            int input = sc.nextInt();
            sc.nextLine();
            switch (input) {
                case 0:
                    // Exit program
                    exitMainLoop = true;
                    break;
                case 1:
                    // Sell an item
                    System.out.print("Enter which type of item you wish to purchase (Food (1), Electronics (2), Clothing (3), or Household (4)): ");
                    typeOfItem = sc.nextInt();
                    sc.nextLine();

                    /* This is supposed to work like so:
                     * 1. Ask which item type to purchase
                     * 2. Display available options in a table
                     * 3. Allow adding multiple items to a cart until "check out"
                     * 4. Display "order summary" grouped by type and confirm checkout
                     * 5. Calculate total, which includes tax (differs between food and non-food items)
                     * 6. Display updated inventory for sold items.
                     * 7. Display return policy for sold items.
                     *
                     * We could have per-category carts, and a private class which holds a StoreItem and
                     * the amount in cart (to delay inventory changes until checkout).
                     */

                    switch (typeOfItem) {
                        case 1:
                            // FoodItem
                            /* This is a preliminary implementation of purchasing.
                             * Note: This needs to be refactored to support the cart, and looping.
                             */
                            displayFoodItemsWithNumbers(foodArray);
                            System.out.print("Which item to purchase (input number here): ");
                            // Note: This number starts from 1.
                            int fiIndex = sc.nextInt();

                            if (fiIndex > foodArray.size() || fiIndex <= 0) {
                                // Out-of-bounds
                                System.out.println("That is an invalid item number!");
                                break;
                            }

                            FoodItem fiItem = foodArray.get(fiIndex - 1);

                            if (fiItem.getStockCount() == 0) {
                                // Can't buy something which is out of stock.
                                System.out.printf("%s is out of stock.\n",
                                                  fiItem.getName());
                                sc.nextLine(); // Consume newline
                                break;
                            }

                            System.out.printf("%s has %d stock.\n",
                                              fiItem.getName(),
                                              fiItem.getStockCount());

                            System.out.print("Enter amount to purchase: ");
                            // Purchase count
                            int fiPurCount = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Continue with purchase [y/n]? ");
                            String confirm = sc.nextLine();
                            if (confirm.equalsIgnoreCase("n")) {
                                // Do *not* purchase
                                System.out.println("Cancelled.");
                            } else if (confirm.equalsIgnoreCase("y")) {
                                // Do purchase
                                boolean success = fiItem.subtractStockCount(fiPurCount);
                                if (!success) {
                                    // Not enough stock
                                    System.out.println("There is not enough stock for that purchase.");
                                    break;
                                }

                                System.out.printf("%s now has %d stock.\n",
                                                  fiItem.getName(),
                                                  fiItem.getStockCount());
                            } else {
                                // Invalid input
                                System.out.println("Answer must be y or n.");
                            }
                            break;
                        case 2:
                            // ElectronicsItem
                            break;
                        case 3:
                            // ClothingItem
                            break;
                        case 4:
                            // HouseholdItem
                            break;
                        default:
                            // Invalid selection
                            break;
                    } // switch (typeOfItem)
                    break;
                //If adding to inventory:
                //Asks what type of item (Food, Electronics, Clothing, or Household).
                //Displays items currently available in inventory for the selected category.
                //Provides the option to add more of an existing item or create a new item.
                //Continue looping until the user confirms they are done adding items.
                //Displays the updated inventory for the item(s) added.
                case 2:
                    // Create item or add to inventory
                    boolean condition = true;
                    while (condition) {
                        System.out.print("Enter which type of item you wish for (Food (1), Electronics (2), Clothing (3), or Household (4)): ");
                        typeOfItem = sc.nextInt();
                        sc.nextLine();
                        switch (typeOfItem) {
                            case 1:
                                // FoodItem
                                displayFoodItems(foodArray);
                                System.out.print("Would you like to add stock of an existing item (1), or add a new item (2)? ");
                                int fiAction = sc.nextInt();
                                // Sink newline
                                sc.nextLine();
                                if (fiAction == 1) {
                                    // Restock existing item
                                    System.out.print("Enter item name: ");
                                    String name = sc.nextLine();
                                    System.out.print("Enter item brand: ");
                                    String brand = sc.nextLine();

                                    for (FoodItem item: foodArray) {
                                        String testName = item.getName();
                                        String testBrand = item.getBrand();
                                        if (testName.equalsIgnoreCase(name)
                                            && testBrand.equalsIgnoreCase(brand)) {
                                            // Item matches (stop iterating here)
                                            System.out.print("Enter amount of stock to add: ");
                                            int newStockCount = sc.nextInt();
                                            sc.nextLine(); // Is this necessary or correct?
                                            item.addStockCount(newStockCount);
                                            System.out.printf("%s now has %d stock.\n", name, item.getStockCount());
                                            // There shouldn't be any duplicates, stop at first match.
                                            break;
                                        }
                                    }
                                } else if (fiAction == 2) {
                                    // Add new item
                                    createNewFoodItem(sc, foodArray);
                                } else {
                                    // Invalid action
                                    System.out.println("Invalid selection (must be 1 or 2)!");
                                }

                                break;
                            case 2:
                                // ElectronicsItem
                                break;
                            case 3:
                                // ClothingItem
                                break;
                            case 4:
                                // HouseholdItem
                                displayHouseholdItems(householdArray);
                                System.out.print("Would you like to add more of an existing item (1), or create a new item (2)? ");
                                int userInput = sc.nextInt();
                                sc.nextLine();
                                if (userInput == 1) {
                                    System.out.print("Enter item name: ");
                                    String name = sc.nextLine();
                                    System.out.print("Enter item brand: ");
                                    String brand = sc.nextLine();
                                    for (int i=0; i<householdArray.size(); i++) {
                                        HouseholdItem testItem = householdArray.get(i);
                                        if (testItem.getName().equalsIgnoreCase(name) && testItem.getBrand().equalsIgnoreCase(brand)) {
                                            System.out.print("Please enter how much stock you wish to add: ");
                                            int stockCount = sc.nextInt();
                                            sc.nextLine();
                                            testItem.addStockCount(stockCount);
                                            System.out.println(testItem.getName() + " has " + testItem.getStockCount() + " in stock.");
                                        }
                                    }
                                }
                                else if (userInput == 2) {
                                    createNewHouseholdItem(sc, householdArray);
                                }
                                else {
                                    System.out.println("Not a valid input.");
                                }
                                break;
                            default:
                                break;
                        } // switch (typeOfItem)
                        System.out.print("Have you completed adding items? (y/n): ");
                        String completed = sc.nextLine();
                        if (completed.equalsIgnoreCase("y")) {
                            condition = false;
                            System.out.println("UPDATED INVENTORY:");
                            displayHouseholdItems(householdArray);
                            System.out.println();
                            displayFoodItems(foodArray);
                        }
                    } // End item-addition loop
                    break;
                default:
                    System.out.println("Invalid selection. Please enter 0, 1, or 2.");
                    break;
            } // switch (input)
        } // while (!exitMainLoop)
    }

    public static void displayHouseholdItems(ArrayList<HouseholdItem> items) {
        System.out.printf("%-20s %-15s %-10s %-30s %-15s %-15s %-20s\n",
                "Name", "Brand", "Price", "Description", "Return Policy", "Type", "Additional Info");
        System.out.println("-".repeat(120));

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

    public static void displayFoodItems(ArrayList<FoodItem> items) {
        System.out.printf("%-21s%-16s%-9s%-31s%-16s%-16s%-11s%-14s\n", "Name",
                          "Brand", "Price", "Description", "Return Policy",
                          "Expiration Date", "Perishable", "Type");
        System.out.println("-".repeat(135));
        //
        for (FoodItem item: items) {
            String type = "Food";
            // Determine type
            if (item instanceof Fruit) {
                type = "Fruit";
            } else if (item instanceof Vegetable) {
                type = "Vegetable";
            } else if (item instanceof ShelfStable) {
                type = "Shelf Stable";
            }
            System.out.printf("%-21s%-16s$%-8.2f%-31s%-16s%-16s%-11b%s\n",
                              item.getName(), item.getBrand(), item.getPrice(),
                              item.getDescription(), item.getReturnPolicy(),
                              item.getExpirationDate(), item.isPerishable(),
                              type);
        }
    }

    /**
     * Prints a table of FoodItems with numbers to allow selection.
     * Note: It displays numbers starting from 1.
     *
     * @param items The FoodItems to display
     */
    public static void displayFoodItemsWithNumbers(ArrayList<FoodItem> items) {
        System.out.printf("%-7s%-21s%-16s%-9s%-31s%-16s%-16s%-11s%-14s\n",
                          "Number", "Name", "Brand", "Price", "Description",
                          "Return Policy", "Expiration Date", "Perishable",
                          "Type");
        System.out.println("-".repeat(142));
        //
        for (int i = 0; i < items.size(); i++) {
            FoodItem item = items.get(i);
            String type = "Food";
            // Determine type
            if (item instanceof Fruit) {
                type = "Fruit";
            } else if (item instanceof Vegetable) {
                type = "Vegetable";
            } else if (item instanceof ShelfStable) {
                type = "Shelf Stable";
            }
            System.out.printf("%-7d%-21s%-16s$%-8.2f%-31s%-16s%-16s%-11b%s\n",
                              i + 1, item.getName(), item.getBrand(),
                              item.getPrice(), item.getDescription(),
                              item.getReturnPolicy(), item.getExpirationDate(),
                              item.isPerishable(), type);
        }
    }

    public static void createNewHouseholdItem(Scanner sc, ArrayList<HouseholdItem> householdArray) {
        System.out.print("What type of household item would you like to add? (Cleaning Supply (1) or Furniture (2)): ");
        int typeChoice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter item name: ");
        String name = sc.nextLine();
        System.out.print("Enter item brand: ");
        String brand = sc.nextLine();
        System.out.print("Enter item price: ");
        double price = sc.nextDouble();
        sc.nextLine(); // Consume newline
        System.out.print("Enter item description: ");
        String description = sc.nextLine();
        System.out.print("Enter return policy: ");
        String returnPolicy = sc.nextLine();

        if (typeChoice == 1) { // Cleaning Supply
            System.out.print("Enter application method (e.g., Spray, Pour, Mop): ");
            String applicationMethod = sc.nextLine();
            System.out.print("Enter use method (e.g., Wipe with cloth, Scrub with sponge): ");
            String useMethod = sc.nextLine();

            householdArray.add(new CleaningSupply(name, description, brand, price, returnPolicy, applicationMethod, useMethod));
        } else if (typeChoice == 2) { // Furniture
            System.out.print("Enter furniture material: ");
            String material = sc.nextLine();

            householdArray.add(new Furniture(name, description, brand, price, returnPolicy, material));
        } else {
            System.out.println("Invalid choice. Item not added.");
        }

        System.out.println("Item successfully added to inventory!");
    }

    public static void createNewFoodItem(Scanner sc, ArrayList<FoodItem> foodArray) {
        System.out.print("What type of food item do you want to add, Fruit (1), Vegetable (2), or Shelf-Stable (3)? ");
        int typeChoice = sc.nextInt();
        // Absorb newline

        System.out.print("Enter item name: ");
        String name = sc.nextLine();
        System.out.print("Enter item brand: ");
        String brand = sc.nextLine();
        System.out.print("Enter item price: ");
        double price = sc.nextDouble();
        sc.nextLine(); // Consume newline
        System.out.print("Enter item description: ");
        String description = sc.nextLine();
        System.out.print("Enter return policy: ");
        String returnPolicy = sc.nextLine();
        System.out.print("Enter expiration date: ");
        String expirationDate = sc.nextLine();
        System.out.print("Enter if perishable: ");
        boolean isPerishable = sc.nextBoolean();

        if (typeChoice == 1) {
            // Fruit
            foodArray.add(new Fruit(name, description, brand, price, returnPolicy, expirationDate, isPerishable));
        } else if (typeChoice == 2) {
            // Vegetable
            foodArray.add(new Vegetable(name, description, brand, price, returnPolicy, expirationDate, isPerishable));
        } else if (typeChoice == 3) {
            // Shelf-Stable
            foodArray.add(new ShelfStable(name, description, brand, price, returnPolicy, expirationDate, isPerishable));
        } else {
            // Invalid answer
            System.out.println("Invalid answer! Selection must be 1, 2, or 3!");
        }
    }

}
