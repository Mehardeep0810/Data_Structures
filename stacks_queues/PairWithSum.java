package Assignment.stacks_queues;

import java.util.*;

public class PairWithSum {
    public static boolean hasPair(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                System.out.println("Pair found: (" + num + ", " + complement + ")");
                return true;
            }
            seen.add(num);
        }
        System.out.println("No pair found.");
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 7, 2, 11, 15};
        int target = 9;

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Target Sum: " + target);

        hasPair(arr, target);
    }
}

