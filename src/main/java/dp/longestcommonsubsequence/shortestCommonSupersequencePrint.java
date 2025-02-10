package dp.longestcommonsubsequence;

public class shortestCommonSupersequencePrint {

    public static String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        // dp array to store lengths of longest common subsequence (LCS)
        int[][] dp = new int[n + 1][m + 1];

        // Fill the dp array using dynamic programming
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0; // Base case: LCS of empty string and another string is 0
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // If characters match, extend the LCS
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Else take the max of ignoring one character from either string
                }
            }
        }

        // Reconstruct the shortest common supersequence
        int i = n, j = m;
        StringBuilder s = new StringBuilder();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                s.append(str2.charAt(j - 1)); // If characters match, add to result
                i--;
                j--;
            } else {
                if (dp[i][j - 1] < dp[i - 1][j]) {
                    s.append(str1.charAt(i - 1)); // If moving up in dp is better, take from str1
                    i--;
                } else {
                    s.append(str2.charAt(j - 1)); // Otherwise, take from str2
                    j--;
                }
            }
        }

        // Add remaining characters from str1 if any
        while (i > 0) {
            s.append(str1.charAt(i - 1));
            i--;
        }

        // Add remaining characters from str2 if any
        while (j > 0) {
            s.append(str2.charAt(j - 1));
            j--;
        }

        // Reverse the result as we constructed it backwards
        s.reverse();
        return s.toString();
    }

    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        System.out.println("Shortest Common Supersequence: " + shortestCommonSupersequence(str1, str2));
    }
}