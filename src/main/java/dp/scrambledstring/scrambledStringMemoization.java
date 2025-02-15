package dp.scrambledstring;

import java.util.HashMap;

public class scrambledStringMemoization {

    // Make the memoization map static to be accessible in static methods
    private static HashMap<String, Boolean> mp = new HashMap<>();

    // Helper function to solve the problem using memoization
    public static boolean solve(String x, String y) {
        // If the strings are equal, they are scrambled versions of each other
        if (x.equals(y)) {
            return true;
        }

        // If the length of strings is less than or equal to 1, they can't be scrambled
        if (x.length() <= 1) {
            return false;
        }

        // Create a unique key for the current pair of strings
        String key = x + " " + y;

        // If the result for this pair is already computed, return it from the map
        if (mp.containsKey(key)) {
            return mp.get(key);
        }

        boolean flag = false;
        int n = x.length();

        // Try splitting the strings at every possible position
        for (int i = 1; i < n; i++) {

            // Check two conditions:
            // 1. Without swapping the substrings
            boolean cond1 = solve(x.substring(0, i), y.substring(n - i)) && solve(x.substring(i), y.substring(0, n - i));

            // 2. With swapping the substrings
            boolean cond2 = solve(x.substring(0, i), y.substring(0, i)) && solve(x.substring(i), y.substring(i));

            // If either condition is true, then the strings are scrambled
            if (cond1 || cond2) {
                flag = true;
                break;
            }
        }

        // Store the result in the memoization map
        mp.put(key, flag);

        return flag;
    }

    // Main function to check if one string is a scrambled version of the other
    public static boolean isScramble(String x, String y) {
        // If the lengths of the strings are not the same, return false
        if (x.length() != y.length()) {
            return false;
        }

        // Clear the memoization map before starting
        mp.clear();

        // Call the helper function
        return solve(x, y);
    }

    // Main method to test the solution
    public static void main(String[] args) {

        String s1 = "great";
        String s2 = "rgeat";

        // Check if s2 is a scrambled string of s1
        boolean result = isScramble(s1, s2);

        // Print the result
        System.out.println("Is \"" + s2 + "\" a scrambled version of \"" + s1 + "\"? " + result);
    }
}
