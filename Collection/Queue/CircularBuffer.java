package Assignment.Collection.Queue;

import java.util.*;

public class CircularBuffer {
    private int[] buffer;
    private int size;
    private int start = 0;
    private int count = 0;

    public CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
    }

    public void insert(int value) {
        buffer[(start + count) % size] = value;
        if (count < size) {
            count++;
        } else {
            start = (start + 1) % size; // overwrite oldest
        }
    }

    public List<Integer> getBuffer() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(buffer[(start + i) % size]);
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.insert(4);
        System.out.println("Buffer: " + cb.getBuffer()); // [2, 3, 4]
    }
}
