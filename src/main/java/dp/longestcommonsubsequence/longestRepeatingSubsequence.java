package dp.longestcommonsubsequence;

public class longestRepeatingSubsequence {

    public static int findLongestRepeatingSubsequence(String s1) {
        int n = s1.length();
        int[][] dp = new int[n + 1][n + 1];  // DP table to store lengths of LRS

        // Fill the DP table
        //can also use
        // // Fill the DP table
        //        for (int i = 0; i <= n; i++) {  // Start loop from 0 for initialization
        //            for (int j = 0; j <= n; j++) {  // Start loop from 0 for initialization
        //                if (i == 0 || j == 0) {
        //                    dp[i][j] = 0;  // Initialize base case for empty subsequence
        //                } else {
        //                    // If the characters match and the indices are not the same (i != j)
        //                    if (s1.charAt(i - 1) == s1.charAt(j - 1) && i != j) {
        //                        dp[i][j] = 1 + dp[i - 1][j - 1]; // Add 1 to the previous matching subsequence length
        //                    } else {
        //                        // If characters don't match, take the max of excluding one character from either string
        //                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        //                    }
        //                }
        //            }
        //        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // If the characters match and the indices are not the same (i != j)
                if (s1.charAt(i - 1) == s1.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // Add 1 to the previous matching subsequence length
                } else {
                    // If characters don't match, take the max of excluding one character from either string
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Return the value at dp[n][n] which contains the length of the Longest Repeating Subsequence (LRS)
        return dp[n][n];
    }

    public static void main(String[] args) {
        // Example input string
        String s1 = "aab";

        // Call the function to find the length of the longest repeating subsequence
        int result = findLongestRepeatingSubsequence(s1);

        // Print the result
        System.out.println("Length of Longest Repeating Subsequence: " + result);
    }
}

//Avoid Same Position Repetition:
//
//If i == j, you are comparing the same character at the same index, which doesn’t make sense for a subsequence that repeats at different positions.
//
//The condition i != j ensures that we are comparing different positions in the string for repeating characters.
// This is critical because in any valid repeating subsequence, the characters must come from different positions in the string