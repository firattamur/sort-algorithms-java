package org.sortalgorithmsjava.sortingalgorithms.quicksort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTest {

    private QuickSort quickSort;

    @BeforeEach
    public void setUp() {
        quickSort = new QuickSort();
    }

    @Test
    public void testSort() {
        int[] array = new int[]{2, 1, 3};
        int[] expected = new int[]{1, 2, 3};

        int[] actual = quickSort.sort(array);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortWithNegativeNumbers() {
        int[] array = new int[]{2, 1, 3, -1};
        int[] expected = new int[]{-1, 1, 2, 3};

        int[] actual = quickSort.sort(array);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortWithDuplicates() {
        int[] array = new int[]{2, 1, 3, 4, 1};
        int[] expected = new int[]{1, 1, 2, 3, 4};

        int[] actual = quickSort.sort(array);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortWithDuplicatesAndNegativeNumbers() {
        int[] array = new int[]{2, 1, 3, -1, 1, -2};
        int[] expected = new int[]{-2, -1, 1, 1, 2, 3};

        int[] actual = quickSort.sort(array);

        assertArrayEquals(expected, actual);
    }


}
