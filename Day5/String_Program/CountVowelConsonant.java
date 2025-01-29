// 1. Count Vowels and Consonants
public class CountVowelConsonent {
    public static void main(String[] args) {
        String str = "Hello World".toLowerCase();
        int vowels = 0, consonants = 0;
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) != -1) vowels++;
                else consonants++;
            }
        }
        System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
    }
}