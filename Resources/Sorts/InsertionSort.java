package resources.sorts;
/* Sorting Algorithm: Insertion Sort

Time Complexity:
best - O(n) (When the array is already sorted)
average - O(n^2)
worst - O(n^2)

Space Complexity:
best - O(1)
average - O(1)
worst - O(1)

Stable? 
Yes, the relative order of elements with equal keys is preserved after sorting.

In-place sorting? 
Yes, space complexity is O(1).
    The amount of additional memory required by the algorithm remains 
    constant regardless of the size of the input data.

Effective for large datasets?
No, due to its O(n^2) time complexity. Its too slow.

Effective for partially sorted datasets?
Yes, when elements are already in close to their final sorted positions,
    Insertion Sort requires fewer comparisons and swaps, resulting in better performance.

Effective for small datasets?
Yes, Its simplicity and ease of implementation make it suitable for sorting small collections of elements.

---- ---- ---- ----
Notes: 
Prof: https://drive.google.com/file/d/11wnJUGiEu9B61M4X-kwIUu2m6_9E7-no/view?usp=drive_link
Mine: https://drive.google.com/file/d/119We9yJCa2o8iHoRrhTzw3K_6pmYLPSq/view?usp=drive_link
*/

public class InsertionSort<T extends Comparable<T>> {

    // <T extends Comparable<T>> is used for the Generics. T = Type
    // Insertion Sort with Generics
    public T[] sort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(current) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }

        return array;
    }

    // For ints
    public int[] sortIntegers(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    
        return array;
    }    

    // For Strings
    public String[] sortCustomerarray(String[] array) {
        for (int i = 1; i < array.length; i++) {
            String current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(current) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    
        return array;
    }

}