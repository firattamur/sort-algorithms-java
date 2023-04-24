package org.sortalgorithmsjava.sortingalgorithms.insertionsort;

import org.sortalgorithmsjava.sortingalgorithms.SortingAlgorithm;

/*

    Insertion Sort:

        * Insertion sort sorts the array in-place by iterating over the array and inserting each element into its correct position.

    Time Complexity : O(n^2)
    Space Complexity: O(1)

*/
public class InsertionSort implements SortingAlgorithm {

    @Override
    public int[] sort(int[] data) {

        int n = data.length;

        for (int i=0; i<n; i++) {

            int j = i;

            while (j > 0 && data[j-1] > data[j]) {
                swap(data, j, j-1);
                j--;
            }

        }

        return data;

    }

    private void swap(int[] data, int i, int j) {
        int temp = data[j];

        data[j] = data[i];
        data[i] = temp;
    }

}
