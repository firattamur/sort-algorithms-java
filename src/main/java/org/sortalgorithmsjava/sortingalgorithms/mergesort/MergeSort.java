package org.sortalgorithmsjava.sortingalgorithms.mergesort;

import org.sortalgorithmsjava.sortingalgorithms.SortingAlgorithm;

/*

    Merge Sort:

        * Merge sort is a divide and conquer algorithm that sorts the array by dividing it into smaller sub-arrays and then merging them back together in sorted order.
        * The divide and conquer approach is used to solve many problems in computer science.
        * The merge sort algorithm is a recursive algorithm that continually splits a list in half.
        * If the list is empty or has one item, it is sorted by definition (the base case).
        * If the list has more than one item, we split the list and recursively invoke a merge sort on both halves.
        * Once the two halves are sorted, the fundamental operation, called a merge, is performed.
        * Merging is the process of taking two smaller sorted lists and combining them together into a single, sorted, new list.
        * The new list is created by picking the smaller of the two values from the two lists and moving it to the new list.
        * This is done until all the items have been moved from the two lists into the new list.

    Time Complexity : O(n log n)
    Space Complexity: O(n)

*/
public class MergeSort implements SortingAlgorithm {

    @Override
    public int[] sort(int[] data) {

        if (data.length <= 1) {
            return data;
        }

        int mid = data.length / 2;

        int[] left  = new int[mid];
        int[] right = new int[data.length - mid];

        arraySplit(data, left, right);

        sort(left);
        sort(right);

        merge(data, left, right);

        return data;

    }

    private void merge(int[] data, int[] left, int[] right) {

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {

            if (left[i] < right[j]) {
                data[k++] = left[i++];
            } else {
                data[k++] = right[j++];
            }

        }

        while (i < left.length) {
            data[k++] = left[i++];
        }

        while (j < right.length) {
            data[k++] = right[j++];
        }

    }

    private void arraySplit(int[] data, int[] left, int[] right) {

        int mid = data.length / 2;

        System.arraycopy(data, 0, left, 0, mid);
        System.arraycopy(data, mid, right, 0, data.length - mid);

    }


}
