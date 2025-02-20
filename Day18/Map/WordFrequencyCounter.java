package Map;
import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text:");
        String text = sc.nextLine();
        
        //convert to lowercase, remove punctuation
        text = text.toLowerCase().replaceAll("[^a-z ]", "");
        String[] words = text.split("\\s+");

        // Count frequency using HashMap
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println("Word Frequency: " + wordCount);
        sc.close();
    }
}

