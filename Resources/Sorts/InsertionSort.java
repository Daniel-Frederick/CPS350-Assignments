package resources.sorts;
/* Sorting Algorithm: Insertion Sort

Notes: 
https://drive.google.com/file/d/11wnJUGiEu9B61M4X-kwIUu2m6_9E7-no/view?usp=drive_link
https://drive.google.com/file/d/119We9yJCa2o8iHoRrhTzw3K_6pmYLPSq/view?usp=drive_link
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