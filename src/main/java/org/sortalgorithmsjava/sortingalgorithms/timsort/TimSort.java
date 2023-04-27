package org.sortalgorithmsjava.sortingalgorithms.timsort;

import org.sortalgorithmsjava.sortingalgorithms.SortingAlgorithm;

public class TimSort implements SortingAlgorithm {

    private static final int RUN_SIZE = 32;

    @Override
    public int[] sort(int[] data) {

        int n = data.length;

        for (int i = 0; i < n; i += RUN_SIZE) {
            insertionSort(data, i, Math.min((i + RUN_SIZE - 1), (n - 1)));
        }

        int size = RUN_SIZE;

        while (size < n) {

            for (int left = 0; left < n; left += 2 * size) {

                int mid = Math.min((left + size - 1), (n - 1));
                int right = Math.min((left + 2 * size - 1), (n - 1));

                if (mid < right) {
                    merge(data, left, mid, right);
                }

            }

            size *= 2;

        }

        return data;

    }

    private void swap(int[] data, int i, int j) {
        int temp = data[j];

        data[j] = data[i];
        data[i] = temp;
    }

    private void insertionSort(int[] data, int left, int right) {

        for (int i = left + 1; i <= right; i++) {

            int temp = data[i];
            int j = i - 1;

            while (j >= left && data[j] > temp) {
                data[j + 1] = data[j];
                j--;
            }

            data[j + 1] = temp;

        }

    }

    private void merge(int[] data, int left, int mid, int right) {

        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = data[left + i];
        }

        for (int i = 0; i < rightSize; i++) {
            rightArray[i] = data[mid + i + 1];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftSize && j < rightSize) {

            if (leftArray[i] <= rightArray[j]) {
                data[k] = leftArray[i];
                i++;
            } else {
                data[k] = rightArray[j];
                j++;
            }

            k++;

        }

        while (i < leftSize) {
            data[k] = leftArray[i];
            k++;
            i++;
        }

        while (j < rightSize) {
            data[k] = rightArray[j];
            k++;
            j++;
        }

    }

}
