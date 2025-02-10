package dp.longestcommonsubsequence;

public class minNoDeleteInStringToMakePalindrome {


    public static int subseq(String s1,String s2){

        int n1 = s1.length();
        int n2 = s2.length();
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
        return  n1-dp[n1][n2];
    }
    public static void main(String[] args) {
        String s1 = "aebcbda";

        // Reverse the string to get s2
        String s2 = new StringBuilder(s1).reverse().toString();

        // Call the palindrome method to compute the longest palindromic subsequence
        System.out.println("Longest Palindromic Subsequence length: " + subseq(s1, s2));
    }
}
