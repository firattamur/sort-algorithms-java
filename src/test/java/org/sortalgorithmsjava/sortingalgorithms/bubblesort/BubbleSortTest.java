package org.sortalgorithmsjava.sortingalgorithms.bubblesort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BubbleSortTest {

    private BubbleSort bubbleSort;

    @BeforeEach
    public void setup() {
        bubbleSort = new BubbleSort();
    }

    @Test
    public void testSort() {
        int[] array = new int[] { 2, 1, 3 };
        int[] expected = new int[] { 1, 2, 3 };

        int[] actual = bubbleSort.sort(array);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortWithNegativeNumbers() {
        int[] array = new int[] { 2, 1, 3, -1 };
        int[] expected = new int[] { -1, 1, 2, 3 };

        int[] actual = bubbleSort.sort(array);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortWithDuplicates() {
        int[] array = new int[] { 2, 1, 3, -1, 1 };
        int[] expected = new int[] { -1, 1, 1, 2, 3 };

        int[] actual = bubbleSort.sort(array);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortWithDuplicatesAndNegativeNumbers() {
        int[] array = new int[] { 2, 1, 3, -1, 1, -2 };
        int[] expected = new int[] { -2, -1, 1, 1, 2, 3 };

        int[] actual = bubbleSort.sort(array);

        Assertions.assertArrayEquals(expected, actual);
    }

}
