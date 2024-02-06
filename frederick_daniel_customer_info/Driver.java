package frederick_daniel_customer_info;
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.out;

public class Driver {

    public static void main(String[] args) {
        // Initilize Scanners
        Scanner recordsScanner = new Scanner(System.in);
        Scanner idScanner = new Scanner(System.in); 
        Scanner nameScanner = new Scanner(System.in);   

        try {
        // ask the user for the number of customer records they intend to input.
        out.print("How many number of customer records do you have?  ");
        // Integer of all customers
        int records = recordsScanner.nextInt();
    
        //Initilize arrays
        int[] ids = new int[records];
        String[] names = new String[records];

        for(int i = 0; i < records; i++) {
            out.println("\nEnter Customer "+ (i+1) + " information: ");
        
            // Prompt user to enter the customer's ID (integer)
            out.println("Enter customer's ID(Only numbers): ");
            // Integer of Customer's ID  
            int id = idScanner.nextInt();
            ids[i] = id;
    
            // Prompt user to enter the customer's full name (String)
            out.println("\nEnter customer's full name(First and Last): ");
            // String of Customer's full name
            String name = nameScanner.nextLine();
            names[i] = name;            
        }
        out.println();

        // Debugging: For displaying all the elements in both arrays
        // for(int i = 0; i < ids.length; i++) {
        //     out.print(ids[i] + ", ");
        // }

        // out.println();

        // for(int i = 0; i < ids.length; i++) {
        //     out.print(names[i] + ", ");
        // }

        // TODO: Sort the arrays
        // sortCustomerIDs
        // sortCustomerNames

        // Display the sorted customer arrays
        for(int i = 0; i < ids.length; i++) {
            out.print(ids[i] + ", ");
        }

        out.println();

        for(int i = 0; i < ids.length; i++) {
            out.print(names[i] + ", ");
        }

    } catch (Exception e) {
        throw new InputMismatchException("Wrong input!");
    }

 

    }

}