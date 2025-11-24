package Assignment.sorting_algorithms;

import java.util.Arrays;

public class SelectionSortDemo {
    public static void selectionSort(int[] scores) {
        int n = scores.length;

        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum with the first unsorted element
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] examScores = {78, 45, 89, 32, 65, 90, 54};

        System.out.println("Original Exam Scores: " + Arrays.toString(examScores));

        selectionSort(examScores);

        System.out.println("Sorted Exam Scores (Ascending): " + Arrays.toString(examScores));
    }
}

