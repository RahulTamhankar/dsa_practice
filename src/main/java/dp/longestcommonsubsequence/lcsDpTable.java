package dp.longestcommonsubsequence;

public class lcsDpTable {

    public static int find(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        // Create the DP table with all elements initialized to 0
        int[][] dp = new int[n1 + 1][n2 + 1];

        // Fill the DP table using bottom-up dynamic programming approach
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0; // Base case when one string is empty, Base case of memoize recursive is 1st row 1st column herr
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // Characters match, so remove it from both i and j
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Characters don't match
                }
            }
        }

        // The value in dp[n1][n2] will hold the length of LCS
        return dp[n1][n2];
    }


    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";
        System.out.println("Longest common subsequence: " + find(s1, s2)); // Output the result
    }
}
