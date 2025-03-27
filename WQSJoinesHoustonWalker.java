import java.util.ArrayList;
import java.util.Scanner;

/**
 * A driver class for the inventory program.
 * @author Landon H.
 * @author Caleb J.
 * @author Connor W.
 */
public class WQSJoinesHoustonWalker {
    /**
     * A class to hold a StoreItem in cart and its purchase count.
     * This is used to implement a cart more easily.
     * @author Landon H.
     */
    private static class CartItem {
        // Note: The static allows it to be used like other classes without exposing externally.
        int numInCart;
        StoreItem item;
        /**
         * Create a CartItem with a set amount in cart.
         * @param item The StoreItem to add to cart.
         * @param numInCart The amount of the item to add to cart.
         */
        public CartItem(StoreItem item, int numInCart) {
            this.item = item;
            // This must be >= 1.
            this.numInCart = numInCart;
        }

        /**
         * Retrieve the amount in cart.
         * @return Number of item in cart.
         */
        public int getNumInCart() {
            return numInCart;
        }

        /**
         * Retrieve the item in cart.
         * @return The StoreItem in cart.
         */
        public StoreItem getItem() {
            return item;
        }
    }

    // For expedience I'm implementing taxes as constants here.
    private static final double NONFOOD_TAX = 0.05; // 5% sales tax on non-food as example
    private static final double FOOD_TAX = 0.02; // 2% sales tax on food as example

    /**
     * The entrypoint for the inventory program.
     *
     * @param args List of command-line arguments (unused)
     */
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

        // Adding Household Items
        householdArray.add(new CleaningSupply("Glass Cleaner", "Cleans windows", "Windex", 5.99, "30 days", "Spray", "Wipe with cloth"));
        householdArray.add(new CleaningSupply("Dish Soap", "Cuts grease", "Dawn", 3.49, "No returns", "Pour", "Scrub with sponge"));
        householdArray.add(new CleaningSupply("Floor Cleaner", "Removes stains", "Pine-Sol", 6.99, "14 days", "Mop", "Dilute in water"));
        householdArray.add(new CleaningSupply("Bathroom Spray", "Kills germs", "Lysol", 7.99, "30 days", "Spray", "Wipe with towel"));
        householdArray.add(new Furniture("Office Chair", "Ergonomic chair", "IKEA", 99.99, "60 days", "Leather"));
        householdArray.add(new Furniture("Dining Table", "Wooden dining table", "Ashley", 199.99, "90 days", "Oak Wood"));
        householdArray.add(new Furniture("Sofa", "Comfortable 3-seater", "La-Z-Boy", 499.99, "120 days", "Fabric"));
        householdArray.add(new Furniture("Bed Frame", "Queen size frame", "Wayfair", 299.99, "45 days", "Metal"));

        // Adding Electronics items
        electronicsArray.add(new Laptop("Gaming Laptop", "High-performance laptop", "Alienware", 1500.99, "30-day return", 15.6, 9.0));
        electronicsArray.add(new Laptop("Ultrabook", 999.99, 14.0, 8.0));
        electronicsArray.add(new Phone("Smartphone X", "Flagship phone", "TechBrand", 899.49, "14-day return", 6.1, 2.8));
        electronicsArray.add(new Phone("Budget Phone", 299.99, 6.5, 3.0));
        electronicsArray.add(new TV("4K Smart TV", "High-resolution television", "Sony", 1200.75, "60-day return", 55.0, 30.0));
        electronicsArray.add(new TV("LED TV", 499.99, 42.0, 25.0));

        //Clothing Array
        clothingArray.add(new Shirt("Casual T-Shirt", "Comfortable cotton shirt", "BrandA", 19.99, "30-day return", "M", "Unisex", "Blue", "Cotton", "T-Shirt"));
        clothingArray.add(new Shirt("Formal Shirt", 29.99, "L", "Male", "White", "Polyester", "Dress Shirt"));
        clothingArray.add(new Outerwear("Winter Jacket", "Warm and cozy", "BrandB", 89.99, "60-day return", "L", "Female", "Black", "Wool", "Jacket", true));
        clothingArray.add(new Outerwear("Raincoat", 49.99, "M", "Unisex", "Yellow", "Synthetic", "Raincoat", true));



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
                    // Set to false to continue to checkout.
                    boolean continueShopping = true;
                    // The carts for each category, reset at each invocation.
                    ArrayList<CartItem> foodCart = new ArrayList<CartItem>();
                    ArrayList<CartItem> householdCart = new ArrayList<CartItem>();
                    ArrayList<CartItem> electronicsCart = new ArrayList<CartItem>();
                    ArrayList<CartItem> clothingCart = new ArrayList<CartItem>();
                    while (continueShopping) {
                        System.out.print("Enter which type of item you wish to purchase (Food (1), Electronics (2), Clothing (3), or Household (4)), or 0 to check out: ");
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
                            case 0:
                                // Check out
                                continueShopping = false;
                                break;
                            case 1:
                                // FoodItem
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
                                if (fiPurCount <= 0) {
                                    System.out.println("Invalid answer. You must purchase at least 1!");
                                    break;
                                }
                                // Add to cart.
                                CartItem fiCartItem = new CartItem(fiItem, fiPurCount);
                                foodCart.add(fiCartItem);
                                break;
                            case 2:
                                // ElectronicsItem
                                displayElectronicsItemsWithNumbers(electronicsArray);
                                System.out.print("Which item to purchase (input number here): ");
                                // Note: This number starts from 1.
                                int eiIndex = sc.nextInt();

                                if (eiIndex > electronicsArray.size() || eiIndex <= 0) {
                                    // Out-of-bounds
                                    System.out.println("That is an invalid item number!");
                                    break;
                                }

                                ElectronicsItem eiItem = electronicsArray.get(eiIndex - 1);

                                if (eiItem.getStockCount() == 0) {
                                    // Can't buy something which is out of stock.
                                    System.out.printf("%s is out of stock.\n",
                                                      eiItem.getName());
                                    sc.nextLine(); // Consume newline
                                    break;
                                }

                                System.out.printf("%s has %d stock.\n",
                                                  eiItem.getName(),
                                                  eiItem.getStockCount());

                                System.out.print("Enter amount to purchase: ");
                                // Purchase count
                                int eiPurCount = sc.nextInt();
                                sc.nextLine();
                                if (eiPurCount <= 0) {
                                    System.out.println("Invalid answer. You must purchase at least 1!");
                                    break;
                                }
                                // Add to cart.
                                CartItem eiCartItem = new CartItem(eiItem, eiPurCount);
                                electronicsCart.add(eiCartItem);
                                break;
                            case 3:
                                // ClothingItem
                                displayClothingItemsWithNumbers(clothingArray);
                                System.out.print("Which item to purchase (input number here): ");
                                // Note: This number starts from 1.
                                int ciIndex = sc.nextInt();

                                if (ciIndex > clothingArray.size() || ciIndex <= 0) {
                                    // Out-of-bounds
                                    System.out.println("That is an invalid item number!");
                                    break;
                                }

                                ClothingItem ciItem = clothingArray.get(ciIndex - 1);

                                if (ciItem.getStockCount() == 0) {
                                    // Can't buy something which is out of stock.
                                    System.out.printf("%s is out of stock.\n",
                                                      ciItem.getName());
                                    sc.nextLine(); // Consume newline
                                    break;
                                }

                                System.out.printf("%s has %d stock.\n",
                                                  ciItem.getName(),
                                                  ciItem.getStockCount());

                                System.out.print("Enter amount to purchase: ");
                                // Purchase count
                                int ciPurCount = sc.nextInt();
                                sc.nextLine();
                                if (ciPurCount <= 0) {
                                    System.out.println("Invalid answer. You must purchase at least 1!");
                                    break;
                                }
                                // Add to cart.
                                CartItem ciCartItem = new CartItem(ciItem, ciPurCount);
                                clothingCart.add(ciCartItem);
                                break;
                            case 4:
                                // HouseholdItem
                                displayHouseholdItemsWithNumbers(householdArray);
                                System.out.print("Which item to purchase (input number here): ");
                                // Note: This number starts from 1.
                                int hiIndex = sc.nextInt();

                                if (hiIndex > householdArray.size() || hiIndex <= 0) {
                                    // Out-of-bounds
                                    System.out.println("That is an invalid item number!");
                                    break;
                                }

                                HouseholdItem hiItem = householdArray.get(hiIndex - 1);

                                if (hiItem.getStockCount() == 0) {
                                    // Can't buy something which is out of stock.
                                    System.out.printf("%s is out of stock.\n",
                                                      hiItem.getName());
                                    sc.nextLine(); // Consume newline
                                    break;
                                }

                                System.out.printf("%s has %d stock.\n",
                                                  hiItem.getName(),
                                                  hiItem.getStockCount());

                                System.out.print("Enter amount to purchase: ");
                                // Purchase count
                                int hiPurCount = sc.nextInt();
                                sc.nextLine();
                                if (hiPurCount <= 0) {
                                    System.out.println("Invalid answer. You must purchase at least 1!");
                                    break;
                                }
                                // Add to cart.
                                CartItem hiCartItem = new CartItem(hiItem, hiPurCount);
                                householdCart.add(hiCartItem);
                                break;
                            default:
                                // Invalid selection
                                break;
                        } // switch (typeOfItem)
                    } // while (continueShopping)
                    // Here we perform check out.
                    System.out.println("Items in cart:\n");
                    // Note: Implement taxes later.
                    double foodSubtotal = 0;
                    double nonFoodSubtotal = 0;

                    System.out.println("Food Items:");
                    for (CartItem cartItem: foodCart) {
                        StoreItem item = cartItem.getItem();
                        int numInCart = cartItem.getNumInCart();
                        double cost = item.getPrice();

                        System.out.printf("%s (%d, $%.2f each)\n",
                                          item.getName(), numInCart, cost);
                        foodSubtotal += cost * numInCart;
                    }
                    System.out.println("\nElectronics Items:");
                    for (CartItem cartItem: electronicsCart) {
                        StoreItem item = cartItem.getItem();
                        int numInCart = cartItem.getNumInCart();
                        double cost = item.getPrice();

                        System.out.printf("%s (%d, $%.2f each)\n",
                                          item.getName(), numInCart, cost);
                        nonFoodSubtotal += cost * numInCart;
                    }
                    System.out.println("\nClothing Items:");
                    for (CartItem cartItem: clothingCart) {
                        StoreItem item = cartItem.getItem();
                        int numInCart = cartItem.getNumInCart();
                        double cost = item.getPrice();

                        System.out.printf("%s (%d, $%.2f each)\n",
                                          item.getName(), numInCart, cost);
                        nonFoodSubtotal += cost * numInCart;
                    }
                    System.out.println("\nHousehold Items:");
                    for (CartItem cartItem: householdCart) {
                        StoreItem item = cartItem.getItem();
                        int numInCart = cartItem.getNumInCart();
                        double cost = item.getPrice();

                        System.out.printf("%s (%d, $%.2f each)\n",
                                          item.getName(), numInCart, cost);
                        nonFoodSubtotal += cost * numInCart;
                    }
                    System.out.printf("\nSubtotal: $%.2f\n",
                                      foodSubtotal + nonFoodSubtotal);
                    // Calculate totals with tax here. Food is different from others.
                    double foodTotal = foodSubtotal + FOOD_TAX * foodSubtotal;
                    double nonFoodTotal = nonFoodSubtotal + NONFOOD_TAX * nonFoodSubtotal;

                    System.out.printf("Total: $%.2f\n",
                                      foodTotal + nonFoodTotal);
                    // Confirm purchase
                    System.out.print("Continue with purchase [y/n]? ");
                    String confirm = sc.nextLine();
                    if (confirm.equalsIgnoreCase("n")) {
                        // Don't purchase
                        System.out.println("Cancelled.");
                    } else if (confirm.equalsIgnoreCase("y")) {
                        // Continue with purchase
                        for (CartItem ci: foodCart) {
                            // FoodItem
                            // Use similar code for the other carts.
                            StoreItem item = ci.getItem();
                            int numInCart = ci.getNumInCart();
                            boolean success = item.subtractStockCount(numInCart);
                            if (success) {
                                // Enough stock (placed for debugging).
                                System.out.printf("Item %s now has %d stock. Return policy: %s\n",
                                                  item.getName(), item.getStockCount(),
                                                  item.getReturnPolicy());
                            } else {
                                // Not enough stock
                                System.out.printf("There is not enough stock to purchase %s.\n",
                                                  item.getName());
                            }
                        }
                        for (CartItem ci: electronicsCart) {
                            // ElectronicsItem
                            // Use similar code for the other carts.
                            StoreItem item = ci.getItem();
                            int numInCart = ci.getNumInCart();
                            boolean success = item.subtractStockCount(numInCart);
                            if (success) {
                                // Enough stock (placed for debugging).
                                System.out.printf("Item %s now has %d stock. Return policy: %s\n",
                                                  item.getName(), item.getStockCount(),
                                                  item.getReturnPolicy());
                            } else {
                                // Not enough stock
                                System.out.printf("There is not enough stock to purchase %s.\n",
                                                  item.getName());
                            }
                        }
                        for (CartItem ci: clothingCart) {
                            // ClothingItem
                            // Use similar code for the other carts.
                            StoreItem item = ci.getItem();
                            int numInCart = ci.getNumInCart();
                            boolean success = item.subtractStockCount(numInCart);
                            if (success) {
                                // Enough stock (placed for debugging).
                                System.out.printf("Item %s now has %d stock. Return policy: %s\n",
                                                  item.getName(), item.getStockCount(),
                                                  item.getReturnPolicy());
                            } else {
                                // Not enough stock
                                System.out.printf("There is not enough stock to purchase %s.\n",
                                                  item.getName());
                            }
                        }
                        for (CartItem ci: householdCart) {
                            // HouseholdItem
                            // Use similar code for the other carts.
                            StoreItem item = ci.getItem();
                            int numInCart = ci.getNumInCart();
                            boolean success = item.subtractStockCount(numInCart);
                            if (success) {
                                // Enough stock (placed for debugging).
                                System.out.printf("Item %s now has %d stock. Return policy: %s\n",
                                                  item.getName(), item.getStockCount(),
                                                  item.getReturnPolicy());
                            } else {
                                // Not enough stock
                                System.out.printf("There is not enough stock to purchase %s.\n",
                                                  item.getName());
                            }
                        }
                        // Insert code to purchase other categories here.
                    } else {
                        // Invalid input
                        System.out.println("Answer must be y or n.");
                    }
                    // Print inventory here.
                    System.out.println("UPDATED INVENTORY:");
                    displayFoodItems(foodArray);
                    System.out.println();
                    displayElectronicItems(electronicsArray);
                    System.out.println();
                    displayClothingItems(clothingArray);
                    System.out.println();
                    displayHouseholdItems(householdArray);
                    break;
                case 2:
                    // Create item or add to inventory
                    // If adding to inventory:
                    // Asks what type of item (Food, Electronics, Clothing, or Household).
                    // Displays items currently available in inventory for the selected category.
                    // Provides the option to add more of an existing item or create a new item.
                    // Continue looping until the user confirms they are done adding items.
                    // Displays the updated inventory for the item(s) added.
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
                                displayElectronicItems(electronicsArray);

                                System.out.print("Would you like to add stock of an existing item (1), or add a new item (2)? ");
                                int eiAction = sc.nextInt();
                                // Sink newline
                                sc.nextLine();
                                if (eiAction == 1) {
                                    System.out.print("Enter item name: ");
                                    String name = sc.nextLine();
                                    System.out.print("Enter item brand: ");
                                    String brand = sc.nextLine();

                                    for (ElectronicsItem item : electronicsArray) {
                                        if (item.getName().equalsIgnoreCase(name) && item.getBrand().equalsIgnoreCase(brand)) {
                                            System.out.print("Enter amount of stock to add: ");
                                            int newStockCount = sc.nextInt();
                                            sc.nextLine();
                                            item.addStockCount(newStockCount);
                                            System.out.printf("%s now has %d stock. ", name, item.getStockCount());
                                            break;
                                        }
                                    }
                                } else if (eiAction == 2) {
                                    // Add new item
                                    createNewElectronicsItem(sc, electronicsArray);
                                } else {
                                    // Invalid action
                                    System.out.println("Invalid selection (must be 1 or 2)!");
                                }

                                break;

                            case 3:
                                // ClothingItem
                                displayClothingItems(clothingArray);

                                System.out.print("Would you like to add stock of an existing item (1), or add a new item (2)? ");
                                int ciAction = sc.nextInt();
                                // Sink newline
                                sc.nextLine();
                                if (ciAction == 1) {
                                    System.out.print("Enter item name: ");
                                    String name = sc.nextLine();
                                    System.out.print("Enter item brand: ");
                                    String brand = sc.nextLine();

                                    for (ClothingItem item : clothingArray) {
                                        if (item.getName().equalsIgnoreCase(name) && item.getBrand().equalsIgnoreCase(brand)) {
                                            System.out.print("Enter amount of stock to add: ");
                                            int newStockCount = sc.nextInt();
                                            sc.nextLine();
                                            item.addStockCount(newStockCount);
                                            System.out.printf("%s now has %d stock. ", name, item.getStockCount());
                                            break;
                                        }
                                    }
                                } else if (ciAction == 2) {
                                    // Add new item
                                    createNewClothingItem(sc, clothingArray);
                                } else {
                                    // Invalid action
                                    System.out.println("Invalid selection (must be 1 or 2)!");
                                }
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
                            displayFoodItems(foodArray);
                            System.out.println();
                            displayElectronicItems(electronicsArray);
                            System.out.println();
                            displayClothingItems(clothingArray);
                            System.out.println();
                            displayHouseholdItems(householdArray);
                        }
                    } // End item-addition loop
                    break;
                default:
                    System.out.println("Invalid selection. Please enter 0, 1, or 2.");
                    break;
            } // switch (input)
        } // while (!exitMainLoop)
    }

    /**
     * Print food items in a table.
     *
     * @param items The array list of food items to display.
     */
    public static void displayFoodItems(ArrayList<FoodItem> items) {
        System.out.printf("%-21s%-16s%-6s%-9s%-31s%-16s%-16s%-11s%-14s\n", "Name",
                          "Brand", "Stock", "Price", "Description", "Return Policy",
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
            System.out.printf("%-21s%-16s%-6d$%-8.2f%-31s%-16s%-16s%-11b%s\n",
                              item.getName(), item.getBrand(), item.getStockCount(),
                              item.getPrice(), item.getDescription(),
                              item.getReturnPolicy(), item.getExpirationDate(),
                              item.isPerishable(), type);
        }
    }

    /**
     * Prints a table of FoodItems with numbers to allow selection.
     * Note: It displays numbers starting from 1.
     *
     * @param items The FoodItems to display
     */
    public static void displayFoodItemsWithNumbers(ArrayList<FoodItem> items) {
        System.out.printf("%-7s%-21s%-16s%-6s%-9s%-31s%-16s%-16s%-11s%-14s\n",
                          "Number", "Name", "Brand", "Stock", "Price",
                          "Description", "Return Policy", "Expiration Date",
                          "Perishable", "Type");
        System.out.println("-".repeat(148));
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
            System.out.printf("%-7d%-21s%-16s%-6d$%-8.2f%-31s%-16s%-16s%-11b%s\n",
                              i + 1, item.getName(), item.getBrand(),
                              item.getStockCount(), item.getPrice(),
                              item.getDescription(), item.getReturnPolicy(),
                              item.getExpirationDate(), item.isPerishable(),
                              type);
        }
    }

    /**
     * Print a table of ElectronicsItems.
     *
     * @param items The ElectronicsItems to display.
     */
    public static void displayElectronicItems(ArrayList<ElectronicsItem> items) {
        if (items == null || items.isEmpty()) {
            System.out.println("No electronic items available.");
            return;
        }
        System.out.printf("%-21s%-16s%-6s%-9s%-31s%-16s%-16s%-11s%n",
                "Name", "Brand", "Stock", "Price", "Description", "Return Policy", "Screen Width", "Screen Height");
        System.out.println("-".repeat(141)); // Requires Java 11+
        for (ElectronicsItem item : items) {
            String type = "Electronics";
            if (item instanceof Laptop) {
                type = "Laptop";
            } else if (item instanceof Phone) {
                type = "Phone";
            } else if (item instanceof TV) {
                type = "TV";
            }
            System.out.printf("%-21s%-16s%-6d$%-8.2f%-31s%-16s%-16.1f%-11.1f%-11s%n",
                    item.getName(), item.getBrand(), item.getStockCount(), item.getPrice(),
                    item.getDescription(), item.getReturnPolicy(),
                    item.getScreenWidth(), item.getScreenHeight(),
                    type);
        }
    }

    /**
     * Prints a table of ElectronicsItems with numbers to allow selection.
     * Note: It displays numbers starting from 1.
     *
     * @param items The ElectronicsItems to display
     */
    public static void displayElectronicsItemsWithNumbers(ArrayList<ElectronicsItem> items) {
        if (items == null || items.isEmpty()) {
            System.out.println("No electronic items available.");
            return;
        }
        System.out.printf("%-7s%-21s%-16s%-6s%-9s%-31s%-16s%-16s%-11s%n",
                "Number", "Name", "Brand", "Stock", "Price", "Description", "Return Policy", "Screen Width", "Screen Height");
        System.out.println("-".repeat(148)); // Requires Java 11+
        for (int i = 0; i < items.size(); i++) {
            ElectronicsItem item = items.get(i);
            String type = "Electronics";
            if (item instanceof Laptop) {
                type = "Laptop";
            } else if (item instanceof Phone) {
                type = "Phone";
            } else if (item instanceof TV) {
                type = "TV";
            }
            System.out.printf("%-7d%-21s%-16s%-6d$%-8.2f%-31s%-16s%-16.1f%-11.1f%-11s%n",
                    i + 1, item.getName(), item.getBrand(), item.getStockCount(), item.getPrice(),
                    item.getDescription(), item.getReturnPolicy(),
                    item.getScreenWidth(), item.getScreenHeight(),
                    type);
        }
    }

    /**
     * Print a table of ClothingItems.
     *
     * @param items The ClothingItems to display.
     */
    public static void displayClothingItems(ArrayList<ClothingItem> items) {
        if (items == null || items.isEmpty()) {
            System.out.println("No clothing items available.");
            return;
        }
        System.out.printf("%-21s%-16s%-6s%-9s%-31s%-16s%-16s%-11s%-14s%-16s%n",
                "Name", "Brand", "Stock", "Price", "Description", "Return Policy", "Size", "Gender", "Color", "Material");
        System.out.println("-".repeat(141)); // Requires Java 11+
        for (ClothingItem item : items) {
            String type = "Clothing";
            if (item instanceof Shirt) {
                type = "Shirt";
            } else if (item instanceof Outerwear) {
                type = "Outerwear";
            } else if (item instanceof Shoe) {
                type = "Shoe";
            }
            System.out.printf("%-21s%-16s%-6d$%-8.2f%-31s%-16s%-16s%-11s%-14s%-16s%-11s%n",
                    item.getName(), item.getBrand(), item.getStockCount(), item.getPrice(),
                    item.getDescription(), item.getReturnPolicy(),
                    item.getSize(), item.getGender(), item.getColor(), item.getMaterial(),
                    type);
        }
    }

    /**
     * Prints a table of ClothingItems with numbers to allow selection.
     * Note: It displays numbers starting from 1.
     *
     * @param items The ClothingItems to display
     */
    public static void displayClothingItemsWithNumbers(ArrayList<ClothingItem> items) {
        if (items == null || items.isEmpty()) {
            System.out.println("No clothing items available.");
            return;
        }
        System.out.printf("%-7s%-21s%-16s%-6s%-9s%-31s%-16s%-16s%-11s%-14s%-16s%n",
                "Number", "Name", "Brand", "Stock", "Price", "Description", "Return Policy", "Size", "Gender", "Color", "Material");
        System.out.println("-".repeat(148)); // Requires Java 11+
        for (int i = 0; i < items.size(); i++) {
            ClothingItem item = items.get(i);
            String type = "Clothing";
            if (item instanceof Shirt) {
                type = "Shirt";
            } else if (item instanceof Outerwear) {
                type = "Outerwear";
            } else if (item instanceof Shoe) {
                type = "Shoe";
            }
            System.out.printf("%-7d%-21s%-16s%-6d$%-8.2f%-31s%-16s%-16s%-11s%-14s%-16s%-11s%n",
                    i + 1, item.getName(), item.getBrand(), item.getStockCount(), item.getPrice(),
                    item.getDescription(), item.getReturnPolicy(),
                    item.getSize(), item.getGender(), item.getColor(), item.getMaterial(),
                    type);
        }
    }

    /**
     * Print information on HouseholdItems in a table.
     *
     * @param items The HouseholdItems array list to display.
     */
    public static void displayHouseholdItems(ArrayList<HouseholdItem> items) {
        System.out.printf("%-20s %-15s %-5s %-10s %-30s %-15s %-15s %-20s\n",
                "Name", "Brand", "Stock", "Price", "Description", "Return Policy", "Type", "Additional Info");
        System.out.println("-".repeat(126));

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

            System.out.printf("%-20s %-15s %-5d $%-9.2f %-30s %-15s %-15s %-20s\n",
                    item.getName(), item.getBrand(), item.getStockCount(), item.getPrice(), item.getDescription(),
                    item.getReturnPolicy(), type, additionalInfo);
        }
    }

    /**
     * Print information on HouseholdItems in a table, with numbers (indexed starting from 1).
     *
     * @param items The HouseholdItems array list to display.
     */
    public static void displayHouseholdItemsWithNumbers(ArrayList<HouseholdItem> items) {
        System.out.printf("%-6s %-20s %-15s %-5s %-10s %-30s %-15s %-15s %-20s\n",
                "Number", "Name", "Brand", "Stock", "Price", "Description", "Return Policy", "Type", "Additional Info");
        System.out.println("-".repeat(133));

        for (int i = 0; i < items.size(); i++) {
            HouseholdItem item = items.get(i);
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

            System.out.printf("%-6d %-20s %-15s %-5d $%-9.2f %-30s %-15s %-15s %-20s\n",
                    i + 1, item.getName(), item.getBrand(), item.getStockCount(), item.getPrice(), item.getDescription(),
                    item.getReturnPolicy(), type, additionalInfo);
        }
    }

    /**
     * Add a new food item to inventory.
     *
     * @param sc The Scanner to read input from
     * @param foodArray The array to add the new food item to
     */
    public static void createNewFoodItem(Scanner sc, ArrayList<FoodItem> foodArray) {
        System.out.print("What type of food item do you want to add, Fruit (1), Vegetable (2), or Shelf-Stable (3)? ");
        int typeChoice = sc.nextInt();
        // Absorb newline
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
        System.out.print("Enter expiration date: ");
        String expirationDate = sc.nextLine();
        System.out.print("Enter if perishable: ");
        boolean isPerishable = sc.nextBoolean();
        // Consume newline
        sc.nextLine();

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

    /**
     * Add a new electronics item to inventory.
     *
     * @param sc The Scanner to read input from
     * @param electronicsArray The array to add the new food item to
     */
    public static void createNewElectronicsItem(Scanner sc, ArrayList<ElectronicsItem> electronicsArray) {
        System.out.print("What type of electronics item do you want to add, Laptop (1), Phone (2), or TV (3)? ");
        int typeChoice = sc.nextInt();
        sc.nextLine(); // Consume newline

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
        System.out.print("Enter screen size (inches): ");
        double screenSize = sc.nextDouble();
        System.out.print("Enter screen width (inches): ");
        double screenWidth = sc.nextDouble();
        sc.nextLine(); // Consume newline

        if (typeChoice == 1) {
            // Laptop
            electronicsArray.add(new Laptop(name, description, brand, price, returnPolicy, screenSize, screenWidth));
        } else if (typeChoice == 2) {
            // Phone
            electronicsArray.add(new Phone(name, description, brand, price, returnPolicy, screenSize, screenWidth));
        } else if (typeChoice == 3) {
            // TV
            electronicsArray.add(new TV(name, description, brand, price, returnPolicy, screenSize, screenWidth));
        } else {
            // Invalid answer
            System.out.println("Invalid answer! Selection must be 1, 2, or 3!");
        }
        System.out.println("Item successfully added to inventory!");
    }

    /**
     * Add a new clothing item to inventory.
     *
     * @param sc The Scanner to read input from
     * @param clothingArray The array to add new clothing item to
     */
    public static void createNewClothingItem(Scanner sc, ArrayList<ClothingItem> clothingArray) {
        System.out.print("What type of clothing item would you like to add? (Outerwear (1), Shirt (2), or Shoe (3)): ");
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
        System.out.print("Enter clothing size: ");
        String size = sc.nextLine();
        System.out.print("Enter clothing gender (N/A if not applicable): ");
        String gender = sc.nextLine();
        System.out.print("Enter clothing color: ");
        String color = sc.nextLine();
        System.out.print("Enter clothing material: ");
        String material = sc.nextLine();

        if (typeChoice == 1) {
            // Outerwear
            System.out.print("Enter outerwear type: ");
            String owType = sc.nextLine();
            System.out.print("Enter if waterproof: ");
            boolean isWaterproof = sc.nextBoolean();
            sc.nextLine(); // Consume newline
            clothingArray.add(new Outerwear(name, description, brand, price, returnPolicy, size, gender, color, material, owType, isWaterproof));
        }
        else if (typeChoice == 2) {
            // Shirt
            System.out.print("Enter shirt type: ");
            String shtType = sc.nextLine();
            clothingArray.add(new Shirt(name, description, brand, price, returnPolicy, size, gender, color, material, shtType));
        }
        else if (typeChoice == 3) {
            // Shoe
            System.out.print("Enter shoe securement type: ");
            String securementType = sc.nextLine();
            System.out.print("Enter shoe type: ");
            String shoeType = sc.nextLine();
            clothingArray.add(new Shoe(name, description, brand, price, returnPolicy, size, gender, color, material, securementType, shoeType));
        }
        else {
            // Invalid input
            System.out.println("Invalid answer! Selection must be 1, 2, or 3!");
        }
        System.out.println("Item successfully added to inventory!");
    }

    /**
     * Add a new HouseholdItem to inventory.
     *
     * @param sc The Scanner to read input from
     * @param householdArray The array to add the household item to
     */
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
}
