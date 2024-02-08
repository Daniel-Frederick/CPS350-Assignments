/* Sorting Algorithm: Shell Sort

Notes:
https://drive.google.com/file/d/1rFlWgjcd64FKnP5bPhHI1a8ZXMnU_38x/view?usp=drive_link
*/

public class ShellSort {

    public int[] shellSort(int[] array) {
        int n = array.length;
        int gap = n / 2;
    
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temp;
            }
            gap /= 2;
        }
        return array;
    }


}
