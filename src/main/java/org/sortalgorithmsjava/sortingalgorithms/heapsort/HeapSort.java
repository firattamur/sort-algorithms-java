package org.sortalgorithmsjava.sortingalgorithms.heapsort;

import org.sortalgorithmsjava.sortingalgorithms.SortingAlgorithm;

public class HeapSort implements SortingAlgorithm {

    @Override
    public int[] sort(int[] data) {

        int n = data.length;

        buildMaxHeap(data);

        for (int i = n - 1; i >= 0; i--) {
            swap(data, 0, i);
            heapify(data, i, 0);
        }

        return data;

    }

    private void buildMaxHeap(int[] data) {

        int n = data.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(data, n, i);
        }

    }

    private void heapify(int[] data, int n, int i) {

        int largestIndex = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && data[left] > data[largestIndex]) {
            largestIndex = left;
        }

        if (right < n && data[right] > data[largestIndex]) {
            largestIndex = right;
        }

        if (largestIndex != i) {
            swap(data, i, largestIndex);
            heapify(data, n, largestIndex);
        }

    }

    private void swap(int[] data, int i, int j) {
        int temp = data[j];

        data[j] = data[i];
        data[i] = temp;
    }

}
