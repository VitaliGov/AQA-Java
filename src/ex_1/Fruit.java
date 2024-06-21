package ex_1;

import java.util.HashMap;
import java.util.Map;

public class Fruit {
    public static void findOneWords() {
        String[] words = {"apple", "banana", "mango", "apple", "orange", "banana", "apple",
                "pear", "orange", "melon", "banana", "kiwi", "kiwi", "pear",
                "apple", "kiwi", "orange"};

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}