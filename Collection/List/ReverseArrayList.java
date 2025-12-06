package Assignment.Collection.List;
import java.util.ArrayList;
import java.util.List;

public class ReverseArrayList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        System.out.println("Original ArrayList: " + list);

        reverseArrayList(list);

        System.out.println("Reversed ArrayList: " + list);
    }

    public static void reverseArrayList(List<Integer> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            Integer temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
}
