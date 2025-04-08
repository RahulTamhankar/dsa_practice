package dp.longestcommonsubsequence;


//🔗 The relationship between LCS and Shortest Common Supersequence (SCS)
//Let’s take two strings:
//
//str1 = "abc"
//
//str2 = "ac"
//
//🔸 LCS(str1, str2) = "ac"
//🔸 Length of SCS = str1.length() + str2.length() - LCS.length()
//→ In this case: 3 + 2 - 2 = 3 → SCS is "abc"
//
//🧠 So why use LCS to get SCS?
//Because the shortest common supersequence is the shortest string that has both str1 and str2 as subsequences.
//
//We don’t want to repeat the common parts (LCS) in both strings — so we:
//
//Include non-LCS characters from both strings, and
//
//Merge them in such a way that the common subsequence appears only once.
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
        String str1 = "HELLO";
        String str2 = "GEEK";
        System.out.println("Shortest Common Supersequence: " + shortestCommonSupersequence(str1, str2));
    }
}

//in back trackking both will give the same subsequence right ?
//ChatGPT said:
//Actually, no, backtracking in the Edit Distance (Levenshtein Distance) and Longest Common Subsequence (LCS) problems will not give the same subsequence. They have different goals and thus different approaches to backtracking.
//
//Let’s clarify this:
//
//1. Backtracking in the Edit Distance (Levenshtein Distance):
//Goal: The objective of the Edit Distance problem is to find the minimum number of operations required (insertions, deletions, substitutions) to transform one string into another.
//
//Backtracking Process:
//
//Once the DP table is filled, backtracking is used to identify which operations were applied to transform the source string to the target string.
//The sequence of operations (insertions, deletions, substitutions) used to reach the optimal solution is traced back from the bottom-right corner of the DP table to the top-left corner.
//Result: This gives us the transformation operations needed to convert one string into another, not the common subsequence. The subsequences in this case are just intermediate steps for these transformations.
//
//2. Backtracking in the Longest Common Subsequence (LCS):
//Goal: The objective of the LCS problem is to find the longest subsequence that is common to both strings. This subsequence doesn't need to be contiguous, but the order must be preserved.
//
//Backtracking Process:
//
//After filling the DP table, backtracking starts from the bottom-right corner and traces back to find the common subsequence.
//When characters of both strings match (X[i-1] == Y[j-1]), it adds that character to the subsequence.
//If the characters don’t match, the algorithm moves either up or left, depending on whether the previous value was larger from the top or from the left.
//Result: This gives the longest common subsequence between the two strings, not a sequence of operations or transformations.
//
//Key Differences in Backtracking Results:
//In Edit Distance, the backtracking gives you the steps (insertions, deletions, substitutions) that are used to transform one string into another.
//In LCS, the backtracking gives you the longest common subsequence, which is the longest sequence that both strings share in the same relative order.
//Example:
//Let’s take two strings for example:
//
//X = "sitting"
//Y = "kitten"
//Edit Distance Backtracking:
//The goal here is to transform "sitting" into "kitten" with the minimum number of operations (insertions, deletions, or substitutions).
//Backtracking might show that:
//Substitute 's' with 'k'
//Leave 'i' as is
//Substitute 't' with 't' (no operation needed)
//Substitute 't' with 't' (no operation needed)
//Substitute 'i' with 'e'
//Substitute 'n' with 'n'
//Insert 'g' to match the length of the strings.
//LCS Backtracking:
//The LCS of "sitting" and "kitten" is "kitt", which is the longest common subsequence shared by both strings in the same order (but not necessarily consecutively).
//The backtracking for LCS would give us the subsequence: "kitt".
//Conclusion:
//Backtracking in Edit Distance gives the sequence of transformations (insertions, deletions, substitutions).
//Backtracking in LCS gives the longest common subsequence (the characters that appear in both strings in order, but not necessarily consecutively).
//So, no, the backtracking results will not be the same because the problems have different objectives: one focuses on transformations (Edit Distance) and the other on finding a common subsequence (LCS).

// static String printShortestSuperSeq(String X, String Y)
//    {
//        int m = X.length();
//        int n = Y.length();
//
//        // dp[i][j] contains length of
//        // shortest supersequence
//        // for X[0..i-1] and Y[0..j-1]
//        int dp[][] = new int[m + 1][n + 1];
//
//        // Fill table in bottom up manner
//        for (int i = 0; i <= m; i++)
//        {
//            for (int j = 0; j <= n; j++)
//            {
//
//                // Below steps follow recurrence relation
//                if (i == 0)
//                {
//                    dp[i][j] = j;
//                }
//                else if (j == 0)
//                {
//                    dp[i][j] = i;
//                }
//                else if (X.charAt(i - 1) == Y.charAt(j - 1))
//                {
//                    dp[i][j] = 1 + dp[i - 1][j - 1];
//                }
//                else
//                {
//                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
//                }
//            }
//        }


///////////////////////////////////////////////////////

//    so just by  for (int i = 0; i <= n; i++) {
//        for (int j = 0; j <= m; j++) {
//        if (i == 0 || j == 0) {
//        dp[i][j] = 0;  and  for (int i = 0; i <= m; i++)
//        {
//        for (int j = 0; j <= n; j++)
//        {
//
//        // Below steps follow recurrence relation
//        if (i == 0)
//        {
//        dp[i][j] = j;
//        }
//        else if (j == 0)
//        {
//        dp[i][j] = i; makes this differnece?
//        ChatGPT said:
//        Yes, the way you initialize the dp table in each of the loops — specifically, in the base cases — is a key difference between the Edit Distance and Longest Common Subsequence (LCS) algorithms.
//
//        Let’s break down how these base cases affect the overall problem and its solution:
//
//        1. LCS DP Table Initialization (Base Case):
//        For the Longest Common Subsequence (LCS) problem, the first row and the first column of the dp table are initialized to 0 because:
//
//        The LCS of an empty string and any other string is 0. In other words, if one of the strings is empty, there is no common subsequence.
//        java
//        Copy
//        Edit
//        for (int i = 0; i <= n; i++) {
//        for (int j = 0; j <= m; j++) {
//        if (i == 0 || j == 0) {
//        dp[i][j] = 0;  // LCS of empty string with any string is 0
//        } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
//        dp[i][j] = 1 + dp[i - 1][j - 1];  // If chars match, extend LCS
//        } else {
//        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);  // Take the max
//        }
//        }
//        }
//        Base case interpretation: When i == 0 or j == 0, you are dealing with an empty substring of one string. So the LCS length is 0 (since there's no common subsequence).
//        This is why LCS starts by filling in a 0 for any empty string combinations.
//        2. Edit Distance DP Table Initialization (Base Case):
//        For the Edit Distance (Levenshtein Distance) problem, the first row and the first column are initialized differently to reflect the number of operations required to convert an empty string to the other string (or vice versa):
//
//        java
//        Copy
//        Edit
//        for (int i = 0; i <= m; i++) {
//        for (int j = 0; j <= n; j++) {
//        if (i == 0) {
//        dp[i][j] = j;  // If string X is empty, we need 'j' insertions
//        } else if (j == 0) {
//        dp[i][j] = i;  // If string Y is empty, we need 'i' deletions
//        } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
//        dp[i][j] = 1 + dp[i - 1][j - 1];  // No operation if chars match
//        } else {
//        dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);  // Min of insert, delete, replace
//        }
//        }
//        }
//        Base case interpretation:
//        If i == 0, it means that the string X is empty, so we need to insert j characters from Y to match X (so dp[i][j] = j).
//        If j == 0, it means that Y is empty, so we need to delete i characters from X to match Y (so dp[i][j] = i).
//        In this case, the base cases represent the number of operations needed to make one string match the other when one of the strings is empty. Hence, the table is filled with i (deletions) or j (insertions).
//
//        Difference Explained by the Base Case Initialization:
//        In LCS: You initialize the table with 0 because you're finding the length of the common subsequence, and the subsequence of an empty string with any string is 0.
//
//        In Edit Distance: You initialize the table with i and j because you’re counting the number of operations required to transform one string to another. An empty string requires j insertions or i deletions.
//
//        Key Impact of the Difference:
//        LCS: The table initialization focuses on the absence of a common subsequence (hence starting with 0 for empty strings).
//        Edit Distance: The table initialization focuses on the number of transformations (insertions/deletions) needed to make two strings identical, hence starting with the lengths of the respective strings.
//        Example to illustrate:
//        For example, let’s take:
//
//        X = "abc"
//
//        Y = "ab"
//
//        LCS DP Table (Initialization):
//
//        When i == 0 or j == 0, dp[i][j] = 0, meaning no subsequence when one string is empty.
//        The longest common subsequence of "abc" and "ab" is "ab", so backtracking will give "ab".
//        Edit Distance DP Table (Initialization):
//
//        When i == 0, dp[i][j] = j, meaning j insertions are required to turn an empty string into the string Y (in this case, "ab").
//        When j == 0, dp[i][j] = i, meaning i deletions are required to turn string X into an empty string.
//        The final value in the DP table will tell you the minimum number of operations to convert "abc" to "ab" (in this case, 1 deletion of "c").
//        In Conclusion:
//        Yes, the difference in base case initialization (dp[i][j] = 0 for LCS vs dp[i][j] = i and dp[i][j] = j for Edit Distance) fundamentally distinguishes the two algorithms, shaping how the DP table is filled and the results you get when you backtrack.
//
//        LCS: Focuses on finding the longest subsequence shared by the two strings.
//        Edit Distance: Focuses on finding the minimum number of operations required to convert one string to another.