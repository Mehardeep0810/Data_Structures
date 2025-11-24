package Assignment.sorting_algorithms;

import java.util.Arrays;

public class BubbleSortDemo {
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] studentMarks = {78, 45, 89, 32, 65, 90, 54};

        System.out.println("Original Marks: " + Arrays.toString(studentMarks));

        bubbleSort(studentMarks);

        System.out.println("Sorted Marks (Ascending): " + Arrays.toString(studentMarks));
    }
}

