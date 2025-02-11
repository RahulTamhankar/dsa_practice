package dp.longestcommonsubsequence;

// LEETCODE Question Name: Is Subsequence (EASY)
public class sequencePatternMatching {

    // Function to calculate the LCS and check subsequence
    public static boolean seqPattern(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        // DP table to store lengths of longest common subsequences
        int[][] dp = new int[n1 + 1][n2 + 1];

        // Building the DP table
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;  // Base case: empty string
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];  // Characters match, extend the subsequence
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);  // Choose the longer subsequence
                }
            }
        }

        // If the length of the LCS is equal to the length of s1, return true (subsequence)
        return dp[n1][n2] == n1;
    }

    public static void main(String[] args) {
        // Example input strings
        String s1 = "abc";
        String s2 = "ahbgdc";

        // Call the function to check if s1 is a subsequence of s2
        boolean result = seqPattern(s1, s2);

        // Print the result
        System.out.println("Is s1 a subsequence of s2? " + result);
    }
}
