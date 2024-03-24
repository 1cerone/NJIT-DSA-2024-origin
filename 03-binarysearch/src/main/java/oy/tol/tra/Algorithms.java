package oy.tol.tra;

public class Algorithms {

    public static <T extends Comparable<T>> void sort(T[] array) {
        boolean swapped = true;
        int n = array.length;

        while (swapped) {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1].compareTo(array[i]) > 0) {
                    T temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
            n--;
        }
    }

    public static <T> void reverse(T[] array) {
        int left = 0;
        int right = array.length - 1;
        
        while (left < right) {
            T temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static <T extends Comparable<T>> int binarySearch(T value, T[] array, int fromIndex, int toIndex) {
        if (array == null || fromIndex < 0 || toIndex > array.length || fromIndex >= toIndex) {
            throw new IllegalArgumentException("Invalid array or range");
        }

        while (fromIndex <= toIndex) {
            int midIndex = (fromIndex + toIndex) / 2;
            T midValue = array[midIndex];

            int comparison = value.compareTo(midValue);
            if (comparison == 0) {
                return midIndex;
            } else if (comparison < 0) {
                toIndex = midIndex - 1;
            } else {
                fromIndex = midIndex + 1;
            }
        }

        return -1;
    }

}

