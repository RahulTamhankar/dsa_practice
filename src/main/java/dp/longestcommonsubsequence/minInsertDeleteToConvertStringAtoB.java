package dp.longestcommonsubsequence;

public class minInsertDeleteToConvertStringAtoB {

    public static int[] minDeletionsAndInsertions(String a, String b) {
        int lcs = subsequence(a, b);  // Calculate the length of the LCS
        int deletion = a.length() - lcs;  // Deletions = length of a - LCS
        int insertion = b.length() - lcs; // Insertions = length of b - LCS
        return new int[] {deletion, insertion};
    }

    public static int subsequence(String a, String b) {
        int n1 = a.length();
        int n2 = b.length();
        int[][] dp = new int[n1 + 1][n2 + 1]; // Fix the array size to [n1 + 1][n2 + 1]

        // Fill the dp array
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0; // Base case: if one of the strings is empty, LCS is 0
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // Characters match
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Take max of previous results
                }
            }
        }

        return dp[n1][n2]; // The length of the LCS is found in the bottom-right cell
    }

    public static void main(String[] args) {
        String string = "heap";
        String string1 = "pea";

        // Get the minimum deletions and insertions
        int[] result = minDeletionsAndInsertions(string, string1);
        System.out.println("Deletions: " + result[0]);
        System.out.println("Insertions: " + result[1]);
    }
}
//You’re modifying a, not b, so subtractions always
// happen from a when calculating deletions, and from b when calculating insertions