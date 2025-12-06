package Assignment.Collection.List;

import java.util.*;

public class FrequencyCounter {
    public static void main(String[] args) {
       
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange");

        Map<String, Integer> frequencyMap = getFrequency(fruits);

        System.out.println("Frequency Map: " + frequencyMap);
    }

    public static Map<String, Integer> getFrequency(List<String> list) {
        Map<String, Integer> map = new HashMap<>();

        for (String item : list) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }
        return map;
    }
}
