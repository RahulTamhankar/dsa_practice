package dp.longestcommonsubsequence;

public class longestCommonSubstring {

    public static int find(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        int maxLength = 0;  // To keep track of the maximum length of common substring

        // Fill the DP table
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                // Compare characters at positions (i-1) and (j-1)
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];  // Length of current common substring
                    maxLength = Math.max(maxLength, dp[i][j]);  // Update maxLength
                } else {
                    dp[i][j] = 0;  // No common substring at these positions
                }
            }
        }

        return maxLength;  // Return the length of the longest common substring
    }

    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";

        // Output the result
        System.out.println("Longest common substring length: " + find(s1, s2));
    }
}
