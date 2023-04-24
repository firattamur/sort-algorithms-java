package org.sortalgorithmsjava.sortingalgorithms.countingsort;

import org.sortalgorithmsjava.sortingalgorithms.SortingAlgorithm;

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
