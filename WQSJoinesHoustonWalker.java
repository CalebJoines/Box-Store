import java.util.Scanner;
public class WQSJoinesHoustonWalker {
    public static void main(String[] args) {
        System.out.println("Welcome to Wilmington Quickstop.\n Would you like to sell an item?(1) Or add an item?(2):");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        switch (input) {
            //If we chose to sell an Item
            case 1: {

            }
            //If we chose to buy an item
            case 2: {
            }
            default :
                System.out.println("Invalid selection. Please enter 1 or 2.");
                break;
        }
    }
}
