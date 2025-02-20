package backtracking;

import java.util.*;

public class wordBreak {

    // Helper function for backtracking
    // This function attempts to break the string `s` into valid words from the dictionary `dict`
    static void helper(int ind, int n, List<String> dict, List<String> temp, List<String> ans, String s) {
        // Base case: If the index reaches the end of the string
        if (ind == s.length()) {
            // At this point, temp contains a valid sequence of words
            // Join the words in temp with a space and add it to the result list (ans)
            StringBuilder word = new StringBuilder();
            for (int i = 0; i < temp.size(); i++) {
                word.append(temp.get(i));  // Append the word
                if (i != temp.size() - 1) {
                    word.append(" ");  // Add space between words
                }
            }
            ans.add(word.toString());  // Add the combined word break to the result
            return;
        }

        // Try breaking the string from index `ind` to `s.length()`
        StringBuilder tem = new StringBuilder();
        for (int i = ind; i < s.length(); i++) {
            tem.append(s.charAt(i));  // Build a substring from `ind` to `i`

            // If the substring `tem` is a valid word in the dictionary
            if (dict.contains(tem.toString())) {
                // Add the valid word to the temporary list `temp`
                temp.add(tem.toString());

                // Recur with the next index (`i + 1`) to break the remaining part of the string
                helper(i + 1, n, dict, temp, ans, s);

                // Backtrack: Remove the last word and try a different combination
                temp.remove(temp.size() - 1);
            }
        }
    }

    // Main function to find all valid word breaks
    // This function initializes the backtracking process and returns all possible word breaks
    static List<String> wordBreak(int n, List<String> dict, String s) {
        // `temp` holds the current valid sequence of words
        List<String> temp = new ArrayList<>();
        // `ans` holds all valid word breaks found
        List<String> ans = new ArrayList<>();

        // Start the backtracking from index 0
        helper(0, n, dict, temp, ans, s);

        // Return all the valid word breaks
        return ans;
    }

    public static void main(String[] args) {
        // Example usage
        // Define a dictionary containing some valid words
        List<String> dict = Arrays.asList("cat", "cats", "and", "sand", "dog");

        // The string to be broken into words
        String s = "catsanddog";

        // Get the size of the dictionary (not really needed here, but kept for consistency)
        int n = dict.size();

        // Call the wordBreak function to get all valid word breaks
        List<String> result = wordBreak(n, dict, s);

        // Print all the valid word breaks found
        for (String str : result) {
            System.out.println(str);
        }
    }
}
