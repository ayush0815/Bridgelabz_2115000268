public class LinearSearchSentence {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                return sentence; // Return the first sentence containing the word
            }
        }
        return "Not Found"; // Return "Not Found" if the word is not in any sentence
    }
    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox jumps over the lazy dog.",
            "Java is a powerful programming language.",
            "I love solving algorithmic problems.",
            "Today is a bright and sunny day."
        };

        String wordToSearch = "java"; // Word to search (case-insensitive)
        String result = findSentenceWithWord(sentences, wordToSearch);

        System.out.println("Result: " + result);
    }
}
