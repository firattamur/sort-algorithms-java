package org.sortalgorithmsjava.sortingalgorithms.countingsort;

import org.sortalgorithmsjava.sortingalgorithms.SortingAlgorithm;

/*

    Counting Sort:

        * Counting sort sorts the array by counting the number of occurrences of each element in the array.
        * It then reconstructs the array by iterating over the count array and inserting each element into its correct position.
        * Counting sort is only applicable to arrays with integer values. It is not a comparison sort.
        * It has O(n + k) time complexity, where n is the number of elements in the array and k is the range of values in the array.
        * It is efficient for large arrays with a small range of values.
        * It is not a stable sort.
        * It is not an in-place sort.
        * To work with negative values, we can offset the array by the minimum value in the array.

    Time Complexity : O(n + k)
    Space Complexity: O(n + k)


*/

public class CountingSort implements SortingAlgorithm {

    @Override
    public int[] sort(int[] data) {

        int[] minMax = findMinMax(data);
        int min = minMax[0];
        int max = minMax[1];

        offsetArray(data, -min);

        int[] count = countOccurrences(data, min, max);
        reconstructArray(data, count);

        offsetArray(data, min);

        return data;

    }

    private int[] findMinMax(int[] data) {
        int min = data[0];
        int max = data[0];

        for (int i=1; i<data.length; i++) {
            if (data[i] < min) {
                min = data[i];
            } else if (data[i] > max) {
                max = data[i];
            }
        }

        return new int[] {min, max};
    }

    private void offsetArray(int[] data, int offset) {
        for (int i=0; i<data.length; i++) {
            data[i] += offset;
        }
    }

    private int[] countOccurrences(int[] data, int min, int max) {
        int[] count = new int[max - min + 1];

        for (int value : data) {
            count[value]++;
        }

        return count;
    }

    private void reconstructArray(int[] data, int[] count) {
        int j = 0;

        for (int i=0; i<count.length; i++) {
            while (count[i] > 0) {
                data[j++] = i;
                count[i]--;
            }
        }
    }

}
