package Assignment.sorting_algorithms;

import java.util.Arrays;

public class InsertionSortDemo {
    public static void insertionSort(int[] ids) {
        int n = ids.length;

        for (int i = 1; i < n; i++) {
            int key = ids[i]; 
            int j = i - 1;

            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }

            ids[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] employeeIDs = {105, 102, 110, 101, 108, 103};

        System.out.println("Original Employee IDs: " + Arrays.toString(employeeIDs));

        insertionSort(employeeIDs);

        System.out.println("Sorted Employee IDs (Ascending): " + Arrays.toString(employeeIDs));
    }
}

