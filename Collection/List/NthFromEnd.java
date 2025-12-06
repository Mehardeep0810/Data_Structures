package Assignment.Collection.List;

import java.util.LinkedList;

public class NthFromEnd {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int N = 2;
        String result = findNthFromEnd(list, N);

        System.out.println("Original List: " + list);
        System.out.println("Nth element from end (N=" + N + "): " + result);
    }

    public static <T> T findNthFromEnd(LinkedList<T> list, int N) {
        if (N <= 0 || N > list.size()) {
            throw new IllegalArgumentException("Invalid N value");
        }

        var first = list.listIterator();
        var second = list.listIterator();

        for (int i = 0; i < N; i++) {
            if (first.hasNext()) {
                first.next();
            } else {
                return null; 
            }
        }

        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next(); 
    }
}

