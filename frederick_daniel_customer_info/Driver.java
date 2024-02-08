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

        CustomerSort sort = new CustomerSort();

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
            names[i] = name.trim();  
        }
        out.println();

        // Debugging: For displaying all the elements in both arrays
        System.out.println("Orginial arrays");
        for(int i = 0; i < ids.length; i++) {
            out.print(ids[i] + ", ");
        }

        out.println();

        for(int i = 0; i < ids.length; i++) {
            out.print(names[i] + ", ");
        }

        // TODO: Sort the arrays
        // sortCustomerIDs
        // out.println("before the sort one");
        sort.sortCustomerIDs(ids);

        // out.println("end of first start of second sort");
        // sortCustomerNames
        sort.sortCustomerNames(names);

        // Display the sorted customer arrays
        System.out.println();
        System.out.println("after sorting arrays");
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