import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class PalindromeFrequencies {

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void palindromeFrequenciesFromFile(String filename) {
        File file = new File(filename);
        Map<String, Integer> palindromeFrequencies = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("[\\s.,;!?\"]+");
                for (String word : words) {
                    if (word.isEmpty())
                        continue;
                    if (isPalindrome(word)) {
                        palindromeFrequencies.put(word, palindromeFrequencies.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        System.out.println("Frequencies of Palindromes:");
        if (palindromeFrequencies.isEmpty()) {
            System.out.println("No palindromes found");
        } else {
            for (String key : palindromeFrequencies.keySet()) {
                System.out.println(key + ": " + palindromeFrequencies.get(key));
            }
        }
    }

    public static void main(String[] args) {
        // Create dummy file
        try (PrintWriter writer = new PrintWriter("palindrome_test.txt")) {
            writer.println("madam level hello world racecar");
            writer.println("A man a plan a canal Panama");
        } catch (IOException e) {
            System.err.println("Error creating dummy file: " + e.getMessage());
        }
        palindromeFrequenciesFromFile("palindrome_test.txt");
    }
}
