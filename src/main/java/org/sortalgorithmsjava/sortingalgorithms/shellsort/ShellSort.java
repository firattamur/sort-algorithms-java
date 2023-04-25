package org.sortalgorithmsjava.sortingalgorithms.shellsort;

import org.sortalgorithmsjava.sortingalgorithms.SortingAlgorithm;

/*

    Shell Sort:

        * Shell sort is a variation of insertion sort that sorts the array in-place by iterating over the array and inserting each element into its correct position.
        * Shell sort uses a gap sequence to determine the gap between elements to be compared.
        * Shell sort is an unstable sort.
        * Shell sort is an in-place sort.

    Time Complexity : O(n^2)
    Space Complexity: O(1)

*/
public class ShellSort implements SortingAlgorithm {

    @Override
    public int[] sort(int[] data) {

        int gap = data.length / 2;

        while (gap > 0) {

            for (int i=gap; i<data.length; i++) {

                int j = i;

                while (j >= gap && data[j-gap] > data[j]) {
                    swap(data, j, j-gap);
                    j -= gap;
                }

            }

            gap /= 2;

        }

        return data;

    }

    private void swap(int[] data, int i, int j) {
        int temp = data[j];

        data[j] = data[i];
        data[i] = temp;
    }


}
