package org.sortalgorithmsjava.sortingalgorithms.bubblesort;

import org.sortalgorithmsjava.sortingalgorithms.SortingAlgorithm;

/*

    Bubble Sort:

        * Bubble sort is a simple sorting algorithm that repeatedly steps through the list to be sorted, compares each pair of adjacent items and swaps them if they are in the wrong order.
        * The pass through the list is repeated until no swaps are needed, which indicates that the list is sorted.

    Time Complexity : O(n^2)
    Space Complexity: O(1)

*/
public class BubbleSort implements SortingAlgorithm {

    @Override
    public int[] sort(int[] data) {

        int n = data.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    swap(data, j, j + 1);
                }
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
