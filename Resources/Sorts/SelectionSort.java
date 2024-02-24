package resources.sorts;
/* Sorting Algorithm: Selection Sort

Key Concept - 

Time Complexity:
best - O(n^2)
average - O(n^2)
worst - O(n^2)

Space Complexity:
best - O(1)
average - O(1)
worst - O(1)

Stable? 
No, the relative order of elements with equal keys may not be preserved after sorting.

In-place sorting?
Yes, space complexity is O(1).
    The amount of additional memory required by the algorithm remains 
    constant regardless of the size of the input data.

Adaptive?
No, due to its time complexity being O(n^2), no matter how the dataset is.

Effective for large datasets?
No, due to its O(n^2) time complexity. Its too slow.

Effective for partially sorted datasets?
No, Selection Sort performs similarly on partially sorted and 
    completely unsorted datasets because it always scans the entire 
    array to find the minimum (or maximum) element during each iteration. 

Effective for small datasets?
Yes, its simplicity and ease of implementation make it suitable for sorting small collections of elements.

---- ---- ---- ----
Notes:
prof: https://drive.google.com/file/d/1oYyfNpjYrK2-6UruAhPpXDYZhHmZLP9b/view?usp=drive_link
Mine: https://drive.google.com/file/d/19XwxU2mo2wBEG8W6s1AvnD5X3Kd9zkQv/view?usp=drive_link
*/

public class SelectionSort<T extends Comparable<T>> {

    // <T extends Comparable<T>> is used for the Generics. T = Type
    // SelectionSort Sort with Generics
    public T[] selectionSort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        return array;
    }

    // For ints
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