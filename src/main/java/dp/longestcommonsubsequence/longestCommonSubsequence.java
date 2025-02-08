package dp.longestcommonsubsequence;

public class longestCommonSubsequence {

    // Recursive method to find the length of the longest common subsequence
    public static int find(String s1, String s2) {
        if (s1.equals("") || s2.equals("")) {
            return 0; // If either string is empty, the LCS is 0
        }

        int n1 = s1.length();
        int n2 = s2.length();

        // Check if the last characters of both strings match
        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
            return 1 + find(s1.substring(0, n1 - 1), s2.substring(0, n2 - 1)); // If they match, include this character in the LCS
        } else {
            // Otherwise, find the LCS by either ignoring the last character of s1 or s2
            return Math.max(find(s1.substring(0, n1 - 1), s2),
                    find(s1, s2.substring(0, n2 - 1)));
        }
    }

    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";
        System.out.println("Longest common subsequence: " + find(s1, s2)); // Output the result
    }
}
//Anyone who is getting confused with Top-down and bottom up,
// Recursion memoization is always TOP-DOWN(and not bottom up),
// as we take a bigger problem and recusively solve for the smaller subproblems.
// Whereas in tabular DP where we start filling the table from top left to bottom right is actually BOTTOM-UP because we compute dp values of smaller
// subproblems first and then using these values compute dp value of bigger problems.
//PS: Top down and Bottom up is decided by the essence of methodology and not by whether we are filling table from top to bottom or vice versa!


//
//Recursion
//A
//|
//B
//|
//C
//|
//D
//
//DP(2 se jyada recursive calls-->subproblems)
//              A
//      B               C
//D       E       F           G