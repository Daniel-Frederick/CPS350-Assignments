package resources.sorts;
/* Sorting Algorithm: Selection Sort

Notes:
https://drive.google.com/file/d/19XwxU2mo2wBEG8W6s1AvnD5X3Kd9zkQv/view?usp=drive_link
*/

public class SelectionSort {

    public int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        return array;
    }
    

}