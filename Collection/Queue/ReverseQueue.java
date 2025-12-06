package Assignment.Collection.Queue;

import java.util.*;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));
        System.out.println("Original Queue: " + queue);

        reverse(queue);

        System.out.println("Reversed Queue: " + queue);
    }

    public static void reverse(Queue<Integer> queue) {
        if (queue.isEmpty()) return;
        int front = queue.remove();
        reverse(queue);
        queue.add(front);
    }
}

