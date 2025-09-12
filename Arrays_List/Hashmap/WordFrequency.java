package Arrays_List.Hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class WordFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence: ");
        String sentence = sc.nextLine();

        // Convert to lowercase and remove punctuation usingg regex
        sentence = sentence.toLowerCase().replaceAll("[^a-z0-9 ]", "");

        // Split words by spaces
        String[] words = sentence.split("\\s+");

        
        HashMap<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) continue; // ignore empty entries
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

       
        System.out.println("\nWord Frequencies:");
        for (String key : wordCount.keySet()) {
            System.out.println(key + " _ " + wordCount.get(key));
        }

        sc.close();
    }
}
