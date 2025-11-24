package Assignment.stacks_queues;

import java.util.*;

public class ZeroSumSubarrays {
    public static void findSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Case 1: sum == 0 → subarray from 0 to i
            if (sum == 0) {
                System.out.println("Subarray: [0.." + i + "]");
            }

            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    System.out.println("Subarray: [" + (start + 1) + ".." + i + "]");
                }
            }

            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 3, -2, 4, -2, -2};
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Zero-sum subarrays:");
        findSubarrays(arr);
    }
}

