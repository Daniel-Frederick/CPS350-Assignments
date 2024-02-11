package frederick_daniel_customer_info;
import java.util.Scanner;
import static java.lang.System.out;

public class Driver {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner scanner = new Scanner(System.in);

        // Init a new CustomerSort Object 
        CustomerSort sort = new CustomerSort();

        // try-catch to help with debugging
        try {
            // init integer of number of customer records
            int records;

            // Prompt user to enter the number of customer records (integer)
            while (true) {
                // Ask the user for the number of customer records they intend to input.
                out.print("Enter the maximum number of customers: ");
                if (scanner.hasNextInt()) { // Check if input is an integer
                    int input = scanner.nextInt();
                    if (input > 0) { // Check if the integer is greater than 0
                        records = input;
                        break; // End while loop
                    } else {
                        out.println("Invalid input. Please enter a positive integer.");
                        scanner.nextLine(); // Consume the invalid input
                    }
                } else {
                    out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }
            
            
            // Initialize arrays
            int[] ids = new int[records];
            String[] names = new String[records];
            scanner.nextLine(); // Consume the newline character
            
            for(int i = 0; i < records; i++) {
                // Prompt user to add a customer
                out.println("Do you want to add a customer? (Y/N)");
                String addCustomer = scanner.nextLine().toLowerCase(); 

                if (addCustomer.equals("y") || addCustomer.equals("yes")) {
                    // Add a customer
                    out.println("\nEnter Customer "+ (i+1) + " information: ");

                    // init integer of a customer's id
                    int id;

                    // Prompt user to enter the customer's ID (integer)
                    while (true) {
                        out.print("Enter customer's ID (Only positive numbers): ");
                        // Ensure the input is an integer
                        if (scanner.hasNextInt()) { // Ask user for input
                            int cusID = scanner.nextInt();
                            // If input is an int, set value to id
                            if (cusID > 0) { // Check if the integer is greater than 0
                                id = cusID;
                                break; // End while loop
                           } 
                           else {
                                out.println("Invalid input. Please enter a positive integer.");
                                scanner.nextLine(); // Consume the invalid input
                            }
                        } 
                        else {
                            out.println("Invalid input, enter a valid integer.");
                            scanner.next(); // Get rid of non-int value
                        }
                    }
                    ids[i] = id;

                    scanner.nextLine(); // Consume the newline character

                    while (true) {
                        // Prompt user to enter the customer's full name (String)
                        out.println("\nEnter customer's full name (First and Last): ");
                        String cusName = scanner.nextLine();

                        // Ensure the input is a String
                        if (!cusName.isEmpty()) { // Ask user for input
                                names[i] = cusName.trim();
                                break; // End while loop
                        } 
                        else {
                            out.println("Invalid input, please enter a valid Name.");
                        }
                    }

                } else if (addCustomer.equals("n") || addCustomer.equals("no")) {
                    // User does not want to add anymore users so move on to sorting
                    break; // Exit the loop and move on to sorting
                } else {
                    // Invalid input, prompt the user to enter a valid response
                    out.println("Invalid input, please enter 'Y' or 'N'.");
                    // Repeat the loop to ask again
                    i--; // Decrement i to stay at the same index for re-asking
                }
            }

            out.println(); // Adds spacing for nicer formatting

            // Display all the elements in both arrays
            out.println("Records with no sorting: ");
            for(int i = 0; i < ids.length; i++) {
                if(ids[i] != 0 && names[i] != null) 
                    out.println(ids[i] + " - " + names[i]);
            }

            out.println();

            // sortCustomerIDs - Using Shell sort, sort customers by IDs
            sort.sortCustomerIDs(ids, names);

            out.println("After sorting by IDs: ");
            for(int i = 0; i < ids.length; i++) {
                if(ids[i] != 0 && names[i] != null) 
                    out.println(ids[i] + " - " + names[i]);
            }

            out.println();

            // sortCustomerNames - Using Insertion sort, sort customers by names
            sort.sortCustomerNames(ids, names);

            out.println("After sorting by names: ");
            // Display the sorted customer arrays
            for(int i = 0; i < names.length; i++) {
                if(ids[i] != 0 && names[i] != null) 
                    out.println(names[i] + " - " + ids[i]);
            }

        } catch (Exception e) {
            // Handle any unexpected errors
            e.printStackTrace();
        }
    }
}
