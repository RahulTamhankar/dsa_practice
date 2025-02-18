package backtracking;

import java.util.ArrayList;
import java.util.List;

public class allPossiblePalindromicPartitions {

    // Function to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        // Initialize two pointers: one at the start and one at the end
        int start = 0, end = str.length() - 1;

        // Loop through the string while the start pointer is less than the end pointer
        while (start < end) {
            // If characters at the start and end do not match, return false
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            // Move the start pointer forward and the end pointer backward
            start++;
            end--;
        }
        // If all characters matched, the string is a palindrome
        return true;
    }

    // Helper function to generate all palindromic partitions of the string
    public static void helper(String s, List<List<String>> result, List<String> current, int index) {
        // Base case: when the index reaches the end of the string, the current partition is valid
        if (index == s.length()) {
            // Add a copy of the current partition (backtracking ensures we don't modify the original list)
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every possible substring starting from the current index
        for (int i = index; i < s.length(); i++) {
            // Extract the substring from the current index to the current position
            String substring = s.substring(index, i + 1);

            // Check if the substring is a palindrome
            if (isPalindrome(substring)) {
                // If it's a palindrome, add it to the current partition
                current.add(substring);

                // Recursively partition the remaining string (starting from the next index)
                helper(s, result, current, i + 1);

                // Backtrack: remove the last added palindrome substring from the current partition
                current.remove(current.size() - 1);
            }
        }
    }

    // Main function to partition the string into all palindromic partitions
    public static List<List<String>> partition(String s) {
        // List to store all possible palindromic partitions
        List<List<String>> result = new ArrayList<>();

        // Temporary list to hold the current partition being explored
        List<String> current = new ArrayList<>();

        // Start the recursion from index 0
        helper(s, result, current, 0);

        // Return the list of all palindromic partitions
        return result;
    }

    // Example usage of the function
    public static void main(String[] args) {
        // Example string to partition
        String s = "aab";

        // Call the partition function and store the result
        List<List<String>> result = partition(s);

        // Output the result, which is a list of all palindromic partitions
        System.out.println(result); // Output: [[a, a, b], [aa, b]]
    }
}
