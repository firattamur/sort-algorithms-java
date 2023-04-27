package org.sortalgorithmsjava;

import org.sortalgorithmsjava.sortingalgorithms.SortingAlgorithm;
import org.sortalgorithmsjava.sortingalgorithms.bubblesort.BubbleSort;
import org.sortalgorithmsjava.sortingalgorithms.countingsort.CountingSort;
import org.sortalgorithmsjava.sortingalgorithms.heapsort.HeapSort;
import org.sortalgorithmsjava.sortingalgorithms.insertionsort.InsertionSort;
import org.sortalgorithmsjava.sortingalgorithms.mergesort.MergeSort;
import org.sortalgorithmsjava.sortingalgorithms.quicksort.QuickSort;
import org.sortalgorithmsjava.sortingalgorithms.selectionsort.SelectionSort;
import org.sortalgorithmsjava.sortingalgorithms.shellsort.ShellSort;

import java.util.Random;

public class Main {

    private static final int ARRAY_SIZE = 10000;
    private static final int NUMBER_OF_RUNS = 10;
    private static final int MAX_VALUE = 100000;
    private static final Random random = new Random();

    public static void main(String[] args) {

        SortingAlgorithm[] algorithms = new SortingAlgorithm[]{
                new QuickSort(),
                new HeapSort(),
                new MergeSort(),
                new ShellSort(),
                new BubbleSort(),
                new CountingSort(),
                new SelectionSort(),
                new InsertionSort(),
        };

        int[][] data = generateData();

        for (SortingAlgorithm algorithm : algorithms) {

            long totalTime = 0;

            for (int[] array : data) {
                int[] arrayCopy = array.clone();

                long startTime = System.nanoTime();
                algorithm.sort(arrayCopy);
                long endTime = System.nanoTime();

                totalTime += endTime - startTime;
            }

            double averageTime = totalTime / (double) NUMBER_OF_RUNS;
            System.out.printf("%-20s: Average time = %.2f ms%n", algorithm.getClass().getSimpleName(), averageTime / 1_000_000);

        }

    }

    private static int[][] generateData() {
        int[][] data = new int[NUMBER_OF_RUNS][ARRAY_SIZE];

        for (int i = 0; i < NUMBER_OF_RUNS; i++) {
            for (int j = 0; j < ARRAY_SIZE; j++) {
                data[i][j] = random.nextInt(MAX_VALUE);
            }
        }

        return data;
    }

}
