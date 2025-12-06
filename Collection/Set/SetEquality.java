package Assignment.Collection.Set;

import java.util.*;

public class SetEquality {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);

        boolean isEqual = checkEqual(set1, set2);

        System.out.println("Are the two sets equal? " + isEqual);
    }
    public static <T> boolean checkEqual(Set<T> set1, Set<T> set2) {
        return set1.equals(set2);
    }
}

