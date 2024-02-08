package frederick_daniel_customer_info;

public class CustomerSort extends Customer{
    
    // Shell Sort
    public int[] sortCustomerIDs(int[] ids) {
        int n = ids.length;
        int gap = n / 2;
    
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int temp = ids[i];
                int j = i;
                while (j >= gap && ids[j - gap] > temp) {
                    ids[j] = ids[j - gap];
                    j -= gap;
                }
                ids[j] = temp;
            }
            gap /= 2;
        }
        return ids;
    }
    

    // Insertion
    public String[] sortCustomerNames(String[] names) {
        for (int i = 1; i < names.length; i++) {
            String current = names[i];
            int j = i - 1;
            while (j >= 0 && names[j].compareTo(current) > 0) {
                names[j + 1] = names[j];
                j--;
            }
            names[j + 1] = current;
        }
    
        return names;
    }
    

}
