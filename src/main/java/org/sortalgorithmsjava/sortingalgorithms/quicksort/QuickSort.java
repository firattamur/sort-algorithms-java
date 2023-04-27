package org.sortalgorithmsjava.sortingalgorithms.quicksort;

import org.sortalgorithmsjava.sortingalgorithms.SortingAlgorithm;

/*

    Quick Sort:

        * Quick sort sorts the array in-place by partitioning the array into two sub-arrays around a pivot element.
        * It then recursively sorts the sub-arrays.
        * It has O(n log n) time complexity, where n is the number of elements in the array.
        * It is not a stable sort.
        * It is an in-place sort.
        * Worst case time complexity is O(n^2), which occurs when the array is already sorted or nearly sorted.

    Time Complexity : O(n log n)
    Space Complexity: O(log n)

*/
public class QuickSort implements SortingAlgorithm {

    @Override
    public int[] sort(int[] data) {
        return quickSort(data, 0, data.length - 1);
    }

    private int[] quickSort(int[] data, int low, int high) {

        if (low < high) {

            int pivotIndex = partition(data, low, high);

            quickSort(data, low, pivotIndex - 1);
            quickSort(data, pivotIndex + 1, high);

        }

        return data;

    }

    private int partition(int[] data, int low, int high) {

        int pivot = data[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (data[j] < pivot) {
                i++;
                swap(data, i, j);
            }

        }

        swap(data, i + 1, high);

        return i + 1;
    }

    private void swap(int[] data, int i, int j) {
        int temp = data[j];

        data[j] = data[i];
        data[i] = temp;
    }

}
