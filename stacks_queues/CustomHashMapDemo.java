package Assignment.stacks_queues;

import java.util.*;

class CustomHashMap<K, V> {
    // Node for linked list
    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private int capacity;              // size of bucket array
    private List<Node<K, V>> buckets;  // array of linked lists

    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(null); // initialize with null
        }
    }

    // Hash function
    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    // Insert or update
    public void put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> head = buckets.get(index);

        // Check if key already exists → update
        Node<K, V> temp = head;
        while (temp != null) {
            if (temp.key.equals(key)) {
                temp.value = value;
                return;
            }
            temp = temp.next;
        }

        // Insert new node at beginning
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = head;
        buckets.set(index, newNode);
    }

    // Retrieve value
    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> head = buckets.get(index);

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null; // not found
    }

    // Remove key
    public void remove(K key) {
        int index = getIndex(key);
        Node<K, V> head = buckets.get(index);
        Node<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    buckets.set(index, head.next);
                } else {
                    prev.next = head.next;
                }
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    // Display all key-value pairs
    public void display() {
        for (int i = 0; i < capacity; i++) {
            Node<K, V> head = buckets.get(i);
            System.out.print("Bucket " + i + ": ");
            while (head != null) {
                System.out.print("[" + head.key + "=" + head.value + "] -> ");
                head = head.next;
            }
            System.out.println("null");
        }
    }
}

public class CustomHashMapDemo {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>(5);

        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        map.put("David", 40);

        System.out.println("Value for Bob: " + map.get("Bob"));

        map.remove("Charlie");
        System.out.println("Value for Charlie after removal: " + map.get("Charlie"));

        System.out.println("\nHashMap contents:");
        map.display();
    }
}

