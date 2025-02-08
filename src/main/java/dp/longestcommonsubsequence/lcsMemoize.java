package dp.longestcommonsubsequence;

public class lcsMemoize {

    // Recursive method to find the length of the longest common subsequence using memoization
    public static int find(String s1, String s2, int n1, int n2, int[][] dp) {
        // Base case: if either string is empty, return 0
        if (n1 == 0 || n2 == 0) {
            return 0;
        }

        // Check if the result is already computed
        if (dp[n1][n2] != -1) {
            return dp[n1][n2];
        }

        // Check if the last characters of both strings match
        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
            dp[n1][n2] = 1 + find(s1, s2, n1 - 1, n2 - 1, dp); // If they match, include this character in the LCS
        } else {
            // Otherwise, find the LCS by either ignoring the last character of s1 or s2
            dp[n1][n2] = Math.max(find(s1, s2, n1 - 1, n2, dp),
                    find(s1, s2, n1, n2 - 1, dp));
        }

        return dp[n1][n2]; // Ensure this return statement is correct
    }

    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";
        int n1 = s1.length();
        int n2 = s2.length();

        // Initialize the memoization table with -1 (indicating uncomputed values)
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                dp[i][j] = -1; // Initialize all values to -1
            }
        }

        // Call the memoized function
        System.out.println("Longest common subsequence: " + find(s1, s2, n1, n2, dp)); // Output the result
    }
}
