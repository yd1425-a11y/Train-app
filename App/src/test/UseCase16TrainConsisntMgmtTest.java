package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase16TrainConsistMgmtTest {

    // Bubble Sort Implementation
    private void bubbleSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];

                    arr[j] = arr[j + 1];

                    arr[j + 1] = temp;
                }
            }
        }
    }


    @Test
    void testSort_BasicSorting() {

        int[] capacities = {72, 56, 24, 70, 60};

        bubbleSort(capacities);

        assertArrayEquals(
                new int[]{24, 56, 60, 70, 72},
                capacities
        );
    }


    @Test
    void testSort_AlreadySortedArray() {

        int[] capacities = {24, 56, 60, 70, 72};

        bubbleSort(capacities);

        assertArrayEquals(
                new int[]{24, 56, 60, 70, 72},
                capacities
        );
    }


    @Test
    void testSort_DuplicateValues() {

        int[] capacities = {72, 56, 56, 24};

        bubbleSort(capacities);

        assertArrayEquals(
                new int[]{24, 56, 56, 72},
                capacities
        );
    }


    @Test
    void testSort_SingleElementArray() {

        int[] capacities = {50};

        bubbleSort(capacities);

        assertArrayEquals(
                new int[]{50},
                capacities
        );
    }


    @Test
    void testSort_AllEqualValues() {

        int[] capacities = {40, 40, 40};

        bubbleSort(capacities);

        assertArrayEquals(
                new int[]{40, 40, 40},
                capacities
        );
    }
}