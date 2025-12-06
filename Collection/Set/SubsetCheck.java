package Assignment.Collection.Set;

import java.util.*;

public class SubsetCheck {
    public static void main(String[] args) {
        // Example sets
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);

        boolean isSubset = checkSubset(set1, set2);

        System.out.println("Is Set1 a subset of Set2? " + isSubset);
    }

    public static <T> boolean checkSubset(Set<T> set1, Set<T> set2) {
        return set2.containsAll(set1);
    }
}

