package org.sortalgorithmsjava.sortingalgorithms.mergesort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTest {

    private MergeSort mergeSort;

    @BeforeEach
    public void setup() {
        mergeSort = new MergeSort();
    }

    @Test
    public void testSort() {
        int[] array = new int[] { 2, 1, 3 };
        int[] expected = new int[] { 1, 2, 3 };

        int[] actual = mergeSort.sort(array);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortWithNegativeNumbers() {
        int[] array = new int[] { 2, 1, 3, -1 };
        int[] expected = new int[] { -1, 1, 2, 3 };

        int[] actual = mergeSort.sort(array);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortWithDuplicates() {
        int[] array = new int[] { 2, 1, 3, 4, 1 };
        int[] expected = new int[] { 1, 1, 2, 3, 4 };

        int[] actual = mergeSort.sort(array);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortWithDuplicatesAndNegativeNumbers() {
        int[] array = new int[] { 2, 1, 3, -1, 1, -2 };
        int[] expected = new int[] { -2, -1, 1, 1, 2, 3 };

        int[] actual = mergeSort.sort(array);

        assertArrayEquals(expected, actual);
    }

}
