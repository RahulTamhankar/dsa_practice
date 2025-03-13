//package backtracking;
//
//import java.util.*;
//
//public class largestNumberInkSwaps {
//
//    // Recursive helper function for backtracking
//    public static void solve(StringBuilder str, int k, int start, StringBuilder ans) {
//        // Base case: If no swaps left or we've reached the end of the string
//        if (k == 0 || start == str.length() - 1) {
//            return; // No more swaps left, or we've reached the last character, so stop
//        }
//
//        // Find the maximum character in the remaining substring starting from 'start' index
//        char maxChar = getMaxChar(str, start);
//
//        // Iterate over the string starting from the 'start' index
//        for (int i = start + 1; i < str.length(); i++) {
//            // Only consider swapping if:
//            // 1. The current character is smaller than str[i] (i.e., str[start] < str[i])
//            // 2. str[i] is the largest character (maxChar) from the current index onwards
//            if (str.charAt(start) < str.charAt(i) && str.charAt(i) == maxChar) {
//                // Swap characters at 'start' and 'i' positions
//                swap(str, start, i);
//
//                // If the newly formed string is lexicographically greater than the current answer, update 'ans'
//                if (str.toString().compareTo(ans.toString()) > 0) {
//                    ans.setLength(0);  // Clear the current 'ans' string
//                    ans.append(str);   // Set 'ans' to the newly formed string
//                }
//
//                // Recursively call 'solve' with one fewer swap left (k-1) and move to the next character
//                solve(str, k - 1, start + 1, ans);
//
//                // Backtrack by undoing the previous swap (restore the original order)
//                swap(str, start, i);
//            }
//        }
//
//        // Try the next possible starting position with the same number of remaining swaps 'k'
//        //Horizontal Drifting of recursive nodes.. here after exploring all possibilities of start=0 we drift to start+1 , this does
//        //not contribute to the complexity as there are no swaps k is still k
//        //Eg start =7 in 721 then later start=2 and later start=1... like this recursion ends
//        solve(str, k, start + 1, ans);
//    }
//
//    // Function to find the largest number possible after k swaps
//    public static String findMaximumNum(String str, int k) {
//        // Convert input string 'str' into a StringBuilder for mutable string operations
//        StringBuilder ans = new StringBuilder(str);  // This will store the current largest number found
//        StringBuilder sb = new StringBuilder(str);   // This will be modified during recursion
//
//        // Start the backtracking process to explore all possible swaps
//        solve(sb, k, 0, ans);
//
//        // Return the largest number found (stored in 'ans')
//        return ans.toString();
//    }
//
//    // Utility function to swap characters at two positions in a StringBuilder
//    private static void swap(StringBuilder str, int i, int j) {
//        char temp = str.charAt(i);        // Store character at index 'i' temporarily
//        str.setCharAt(i, str.charAt(j));  // Set the character at index 'i' to the character at index 'j'
//        str.setCharAt(j, temp);           // Set the character at index 'j' to the temporarily stored character
//    }
//
//    // Utility function to get the maximum character from a specific index to the end of the string
//    private static char getMaxChar(StringBuilder str, int start) {
//        char maxChar = str.charAt(start);   // Start by assuming the character at 'start' is the largest
//        // Iterate through the rest of the string to find the largest character
//        for (int i = start + 1; i < str.length(); i++) {
//            if (str.charAt(i) > maxChar) {  // If we find a larger character, update 'maxChar'
//                maxChar = str.charAt(i);
//            }
//        }
//        return maxChar;  // Return the largest character found
//    }
//
//    public static void main(String[] args) {
//        // Example test case
//        int k = 4;            // Maximum number of swaps allowed
//        String str = "1234567";  // Input string (representing the number)
//
//        // Call the function to find the largest possible number after 'k' swaps
//        String result = findMaximumNum(str, k);
//
//        // Output the result
//        System.out.println(result);  // Output should be: 7654321
//    }
//}
//
//
////In this Q, the height of tree depends on K(Swaps) unlike permutation problem.. where we go till end. this tree will contribute to complexity
////and not horizontal drifting


package backtracking;

public class largestNumberInkSwaps {

    // Function to find the largest number possible after k swaps
    public static String findMaximumNum(String str, int k) {
        StringBuilder ans = new StringBuilder(str);  // Current largest number found
        StringBuilder sb = new StringBuilder(str);   // StringBuilder to modify during recursion

        // Start the backtracking process
        solve(sb, k, 0, ans);

        return ans.toString(); // Return the largest number found
    }

    // Recursive helper function for backtracking
    public static void solve(StringBuilder str, int k, int start, StringBuilder ans) {
        // Base case: if no swaps left or we've processed all characters
        if (k == 0 || start == str.length()) {
            return;
        }

        char maxChar = getMaxChar(str, start); // Find the max character in the remaining substring

        for (int i = start + 1; i < str.length(); i++) {
            if (str.charAt(start) < str.charAt(i) && str.charAt(i) == maxChar) {
                swap(str, start, i); // Swap characters at 'start' and 'i'

                // Update the result if we get a lexicographically greater string
                if (str.toString().compareTo(ans.toString()) > 0) {
                    ans.setLength(0); // Clear the current 'ans' string
                    ans.append(str);   // Set 'ans' to the newly formed string
                }

                // Recurse with one fewer swap
                solve(str, k - 1, start + 1, ans);

                // Backtrack by undoing the swap
                swap(str, start, i);
            }
        }

        // Try the next possible starting position without swapping
        solve(str, k, start + 1, ans);
    }


    // Utility function to swap characters at two positions in a StringBuilder
    private static void swap(StringBuilder str, int i, int j) {
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);
    }

    // Utility function to get the maximum character from a specific index to the end of the string
    private static char getMaxChar(StringBuilder str, int start) {
        char maxChar = str.charAt(start);
        for (int i = start + 1; i < str.length(); i++) {
            if (str.charAt(i) > maxChar) {
                maxChar = str.charAt(i);
            }
        }
        return maxChar;
    }

    public static void main(String[] args) {
        int k = 4;  // Maximum number of swaps allowed
        String str = "1234567";  // Input string (representing the number)

        // Call the function to find the largest possible number after 'k' swaps
        String result = findMaximumNum(str, k);

        // Output the result
        System.out.println(result);  // Output should be: 7654321
    }
}
