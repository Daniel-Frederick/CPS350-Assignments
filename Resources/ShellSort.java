package Resources;

/* Shell Sort


*/

public class ShellSort {
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
}
