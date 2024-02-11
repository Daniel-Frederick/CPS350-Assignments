package frederick_daniel_customer_info;

public class CustomerSort extends Customer{
    
    // Shell Sort - Sort customer by ID
    public int[] sortCustomerIDs(int[] ids, String[] names) {
        int n = ids.length;
        int gap = n / 2; 
    
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int tempId = ids[i];
                String tempName = names[i];
                int j = i;
                while (j >= gap && ids[j - gap] > tempId) {
                    ids[j] = ids[j - gap];
                    names[j] = names[j - gap];
                    j -= gap;
                }
                ids[j] = tempId;
                names[j] = tempName;
            }
            gap /= 2;
        }
        return ids;
    }
    

    // Insertion sort - Sort customer by names
    public String[] sortCustomerNames(int[] ids, String[] names) {
        for (int i = 1; i < names.length; i++) {
            String currentName = names[i];
            int currentId = ids[i];
            int j = i - 1;
            if(names[j] != null) {
                while (j >= 0 && names[j].compareTo(currentName) > 0) {
                    names[j + 1] = names[j];
                    ids[j + 1] = ids[j];
                    j--;
                }
                names[j + 1] = currentName;
                ids[j + 1] = currentId;
            }
    }
    
        return names;
    }

}
