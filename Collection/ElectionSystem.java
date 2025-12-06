package Assignment.Collection;

import java.util.*;

public class ElectionSystem {
    private Map<String, Integer> hashMapVotes = new HashMap<>();
    private Map<String, Integer> linkedHashMapVotes = new LinkedHashMap<>();
    private Map<String, Integer> treeMapVotes = new TreeMap<>();

    // Cast a vote
    public void castVote(String candidate) {
        hashMapVotes.put(candidate, hashMapVotes.getOrDefault(candidate, 0) + 1);
        linkedHashMapVotes.put(candidate, linkedHashMapVotes.getOrDefault(candidate, 0) + 1);
        treeMapVotes.put(candidate, treeMapVotes.getOrDefault(candidate, 0) + 1);
    }

    // Display results
    public void displayResults() {
        System.out.println("HashMap Results: " + hashMapVotes);
        System.out.println("LinkedHashMap Results (Insertion Order): " + linkedHashMapVotes);
        System.out.println("TreeMap Results (Sorted by Candidate): " + treeMapVotes);
    }
}

