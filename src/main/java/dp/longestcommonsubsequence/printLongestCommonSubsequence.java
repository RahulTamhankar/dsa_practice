package dp.longestcommonsubsequence;

public class printLongestCommonSubsequence {

    public static String find(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        // Fill the DP table
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                // Compare characters at positions (i-1) and (j-1)
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];  // Length of current common subsequence
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);  // Take the max of left or top cell
                }
            }
        }

        // Reconstruct the longest common subsequence
        int i = n1;
        int j = n2;
        StringBuilder subseq = new StringBuilder();

        // Backtrack to find the LCS
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                subseq.append(s1.charAt(i - 1));  // Append the character if they match
                i--;
                j--;
            } else {
                // Move in the direction where the value is greater (either left or top)
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        // Since we built the subsequence from the end, we need to reverse it
        return subseq.reverse().toString();  // Reverse and return the subsequence
    }

    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";

        // Output the result
        System.out.println("Longest common subsequence: " + find(s1, s2));
    }
}


//    so here dp is used with backtracking? also is it a common practice to always backtrack from end to beginning in dsa problems? if I want to do from beginning to end what extra steps and a careful reconstruction strategy to ensure the subsequence is correctly built?The key difference is that when you work from the end, you don't need to worry about the order and can directly append characters as you backtrack. When working from the beginning, you need to caref
//        ChatGPT said:
//        Yes, you're right! In Dynamic Programming (DP), the technique of backtracking is commonly used to reconstruct the solution after filling the DP table. Let's break down your questions and explore the concepts further:
//
//        1. DP with Backtracking:
//        Yes, DP with backtracking is a standard approach in problems like Longest Common Subsequence (LCS), Longest Increasing Subsequence (LIS), Knapsack, and many others.
//
//        DP helps in solving the problem by filling a table with solutions to subproblems.
//        Once the table is filled, backtracking is used to reconstruct the solution (like the actual subsequence, path, or sequence) by looking at the decisions made during the DP process.
//        2. Is Backtracking from the End to the Beginning Common Practice in DSA Problems?
//        Yes, it is quite common in many DP-based problems (like LCS, LPS, etc.) to backtrack from the end to the beginning. Here’s why:
//
//        Bottom-Up DP: Typically, DP solves a problem in a bottom-up manner, meaning the solution for subproblems (subsequences or subarrays) is calculated first. The DP table is filled starting from dp[0][0] (or dp[1][1] for 1-based indexing) up to dp[m][n] (or dp[m-1][n-1]).
//        Backtracking: After filling the table, we backtrack from the end (dp[m][n]) to the start (dp[0][0]) to find the actual solution (e.g., the longest common subsequence). This is easier because:
//        We know the "end" of the solution.
//        We can simply trace the decisions made (like matching characters) by following the DP table’s values.
//        For instance, in LCS, the value dp[i][j] tells us whether we match a character from both strings (dp[i-1][j-1] + 1), or we have to take the maximum of dp[i-1][j] and dp[i][j-1]. When backtracking, we can immediately decide if a character from s1 and s2 is part of the LCS by comparing these values.
//
//        3. What if You Want to Do Backtracking from Beginning to End?
//        If you want to reconstruct the solution from the beginning to the end, here’s what changes and what you have to do differently:
//
//        Key Challenges When Working from Beginning to End:
//        Order Preservation: The most significant issue when reconstructing from the beginning is ensuring that the characters are appended to the subsequence in the correct order. In typical backtracking from the end to the beginning, we don't have to worry about this because we are collecting the solution as we move backward.
//
//        When moving forward, we don’t yet know if a character will be part of the solution because we haven’t fully explored all possible subsequences yet.
//
//        Extra Steps: To overcome this challenge, you have to collect characters and store them as you go, and then reorder them after you have scanned through the entire table.
//


//
//    why we move diagonally when i-1==j-1 and up or left when not equal to maximum.. whats the logic behind it?
//        ChatGPT said:
//        Great question! The logic behind moving diagonally or up/left while filling the DP table in problems like the Longest Common Subsequence (LCS) can be understood by looking at the relationship between subproblems in dynamic programming.
//        Let’s break it down step by step to understand why we make these specific moves:
//
//        1. When i-1 == j-1 (Diagonal Movement):
//        In the case of LCS, we are comparing characters of two strings s1 and s2 at positions i-1 and j-1.
//
//        Diagonal movement (dp[i-1][j-1] + 1) is used when s1[i-1] == s2[j-1], meaning the characters match at these positions.
//
//        The diagonal movement indicates that we have found a matching character, so we add 1 to the value of the previous subproblem dp[i-1][j-1]. This subproblem represents the longest common subsequence of the strings up to the previous characters.
//
//        Logic:
//
//        If characters match, we extend the common subsequence by 1 and move diagonally.
//        The value at dp[i][j] is determined by the value at dp[i-1][j-1] (the previous subsequence without the current matching characters) plus 1.
//        Example:
//
//        If s1 = "ABC" and s2 = "ABC", when s1[2] == s2[2] (both C), the subsequence grows by 1, and we move diagonally from dp[2][2] to dp[1][1].
//        2. When Characters Don’t Match (Move Up or Left):
//        When the characters don't match (s1[i-1] != s2[j-1]), we need to decide whether to keep the longest subsequence from either string up to the current point. This is where we have to compare the values of dp[i-1][j] (up) and dp[i][j-1] (left).
//
//        Up movement (dp[i-1][j]) represents ignoring the current character in s1 and looking for the longest common subsequence in the first i-1 characters of s1 and j characters of s2.
//
//        Left movement (dp[i][j-1]) represents ignoring the current character in s2 and looking for the longest common subsequence in the first i characters of s1 and j-1 characters of s2.
//
//        The max of these two values determines the longest subsequence possible when the characters at s1[i-1] and s2[j-1] don't match. We move either up or left based on which choice gives us the longer subsequence.
//
//        Logic:
//
//        When characters don’t match, we want to ignore one of the characters and try to build the longest subsequence with the remaining characters.
//        Moving up means we consider ignoring the character in s1.
//        Moving left means we consider ignoring the character in s2.
//        We choose the maximum of these two options to ensure the subsequence length is maximized.
//        Example:
//
//        If s1 = "ABCD" and s2 = "ACD", when s1[2] (B) and s2[2] (C) don’t match, we move up or left based on which path gives the longest subsequence.
//        3. Why Diagonal, Up, or Left? The Intuition:
//        The movement strategy stems from the idea of optimizing the subsequence by:
//
//        Diagonal: When the characters match, it means we can extend the common subsequence, so we move diagonally to continue building the solution.
//        Up or Left: When the characters don’t match, we need to ignore one of the characters and still maintain the best possible subsequence length. So, we choose the longer subsequence (either by ignoring the current character in s1 or s2), and move up or left accordingly.
//        The DP table is used to store the results of these subproblems, and by combining these results, we ultimately find the longest common subsequence.
//
//        4. In Summary:
//        Diagonal movement (dp[i-1][j-1] + 1) is used when the characters match because it means we can extend the current subsequence by one character.
//        Up or Left movement (Math.max(dp[i-1][j], dp[i][j-1])) is used when the characters don't match, as we need to explore two potential subsequences—one where we exclude the character from s1 and one where we exclude the character from s2—and we choose the longer one.
//        These movements ensure that we explore all possibilities and build the longest common subsequence step-by-step by considering smaller subproblems and combining their solutions.
//


