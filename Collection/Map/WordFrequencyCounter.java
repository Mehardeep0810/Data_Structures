package Assignment.Collection.Map;

import java.util.*;

public class WordFrequencyCounter {
    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        text = text.toLowerCase().replaceAll("[^a-z0-9\\s]", "");

        String[] words = text.split("\\s+");
        for (String word : words) {
            if (!word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        String input = "Hello world, hello Java!";
        System.out.println(countWords(input)); // {hello=2, world=1, java=1}
    }
}
