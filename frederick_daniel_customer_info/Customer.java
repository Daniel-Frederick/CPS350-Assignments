package frederick_daniel_customer_info;

public abstract class Customer {
    
    // Abstract method for sorting customer IDs
    // Shell sort
    abstract int[] sortCustomerIDs(int[] ids, String[] names);

    // Abstract method for sorting customer names
    // Insertion Sort
    abstract String[] sortCustomerNames(int[] ids, String[] names);
}
