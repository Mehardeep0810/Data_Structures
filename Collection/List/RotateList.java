package Assignment.Collection.List;

import java.util.*;

public class RotateList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Original List: " + list);

        int k = 2; 
        List<Integer> rotated = rotateList(list, k);

        System.out.println("Rotated List: " + rotated);
    }

    public static <T> List<T> rotateList(List<T> list, int k) {
        int n = list.size();
        if (n == 0) return list;

       
        k = k % n;

        List<T> rotated = new ArrayList<>();
        rotated.addAll(list.subList(k, n));  
        rotated.addAll(list.subList(0, k));  

        return rotated;
    }
}

