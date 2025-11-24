package Assignment.sorting_algorithms;

import java.util.Arrays;

public class CountingSortDemo {
    public static void countingSort(int[] ages, int minAge, int maxAge) {
        int range = maxAge - minAge + 1;

        int[] count = new int[range];
        for (int age : ages) {
            count[age - minAge]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[ages.length];
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }

        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        int[] studentAges = {12, 15, 10, 18, 14, 13, 12, 17, 11, 16};

        System.out.println("Original Ages: " + Arrays.toString(studentAges));

        countingSort(studentAges, 10, 18);

        System.out.println("Sorted Ages (Ascending): " + Arrays.toString(studentAges));
    }
}

