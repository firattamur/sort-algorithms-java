package org.sortalgorithmsjava.sortingalgorithms.selectionsort;

import org.sortalgorithmsjava.sortingalgorithms.SortingAlgorithm;

/*

    Selection Sort:

        * Selection sort is a sorting algorithm, specifically an in-place comparison sort.
        * It has O(n^2) time complexity, making it inefficient on large lists, and generally performs worse than the similar insertion sort.

    Time Complexity : O(n^2)
    Space Complexity: O(1)

*/
public class SelectionSort implements SortingAlgorithm {

    @Override
    public int[] sort(int[] data) {

        int n = data.length;

        for (int i=0; i<n-1; i++) {
            int minIndex = i;

            for (int j=i+1; j<n; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }

            swap(data, i, minIndex);
        }

        return data;

    }

    private void swap(int[] data, int i, int j) {
        int temp = data[j];

        data[j] = data[i];
        data[i] = temp;
    }

}
