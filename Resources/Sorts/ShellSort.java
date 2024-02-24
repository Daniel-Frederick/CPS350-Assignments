package resources.sorts;
/* Sorting Algorithm: Shell Sort
key concept: Decrease and conquer

Insertion Sort: 

Key Concept - 

Time Complexity:
best - O(n log(n)) or O(n^(3/2)) depending on the gap sequence used
average - O(n log(n)) or O(n^(3/2))
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
No, the gap sequence determines the order in which the elements 
    are sorted and the same sequence is applied regardless of the 
    input data, so Shell Sort does not exhibit adaptive behavior.

Effective for large datasets?
Yes, while its worst-case time complexity is O(n^2), the average time complexity 
    can be improved to O(n log(n)) or O(n^(3/2)) depending on the gap sequence used.

Effective for partially sorted datasets?
Yes, its gap sequence allows it to efficiently sort subsets of the dataset
    with larger gaps, reducing the overall number of inversions.

Effective for small datasets?
yes, its in-place nature and simplicity make it suitable for sorting small collections of elements.

---- ---- ---- ----
Notes:
Prof: https://drive.google.com/file/d/1rFlWgjcd64FKnP5bPhHI1a8ZXMnU_38x/view?usp=drive_link
Mine: 
*/

public class ShellSort<T extends Comparable<T>> {

    // <T extends Comparable<T>> is used for the Generics. T = Type
    // Shell Sort with Generics
    public T[] shellSort(T[] array) {
        int n = array.length;
        int gap = n / 2;

        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                T temp = array[i];
                int j = i;
                while (j >= gap && array[j - gap].compareTo(temp) > 0) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temp;
            }
            gap /= 2;
        }
        return array;
    }

    // For ints
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
