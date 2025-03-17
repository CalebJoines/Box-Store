import java.util.ArrayList;
import java.util.Scanner;
public class WQSJoinesHoustonWalker {

    public static void main(String[] args) {
        System.out.println("Welcome to Wilmington Quick Shop.\nWould you like to sell an item?(1) Or add an item?(2):");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        ArrayList<FoodItem> foodArray = new ArrayList<FoodItem>();
        ArrayList<HouseholdItem> HouseholdArray = new ArrayList<HouseholdItem>();
        ArrayList<ElectronicsItem> ElectronicsArray = new ArrayList<ElectronicsItem>();
        ArrayList<ClothingItem> ClothingArray = new ArrayList<ClothingItem>();

        switch (input) {
            //If we chose to sell an Item
            case 1: {

            }
            //If adding to inventory:
            //Asks what type of item (Food, Electronics, Clothing, or Household).
            //Displays items currently available in inventory for the selected category.
            //Provides the option to add more of an existing item or create a new item.
            //Continue looping until the user confirms they are done adding items.
            //Displays the updated inventory for the item(s) added.
            case 2: {
                boolean condition = false;
                do {
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


                            break;
                        }

                        default:
                            System.out.println("");
                            condition = true;
                            break;
                    }
                } while (condition);

            }
            default :
                System.out.println("Invalid selection. Please enter 1 or 2.");
                break;
        }
    }
}
