package dp.longestcommonsubsequence;

public class shortestCommonSuperSequence {
    public static int find(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;  // base case: empty string comparison
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];  // characters match
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);  // take max from left or top
                }
            }
        }


        // The length of the shortest common supersequence is calculated by:
        // Length of s1 + Length of s2 - Length of the Longest Common Subsequence (LCS)
        //AGGTABGXTXAYB-(longest subsequence ie GTAB)-->AGGTABGXTXAYB-GTAB=AGGXTXAYB-->9
        return n1 + n2 - dp[n1][n2];
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        // Output the result
        System.out.println("Shortest Common Supersequence length: " + find(s1, s2));
    }
}
