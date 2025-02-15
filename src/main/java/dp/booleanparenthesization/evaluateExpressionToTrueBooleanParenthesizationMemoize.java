package dp.booleanparenthesization;

import java.util.HashMap;
import java.util.Map;

public class evaluateExpressionToTrueBooleanParenthesizationMemoize {

    // Define the memoization map to store the results of subproblems
    private static Map<String, Integer> m = new HashMap<>();

    // Recursive function to solve the problem
    public static int solve(String s, int i, int j, boolean isTrue) {
        // Base case: If the indices cross, return 0
        if (i > j) return 0;

        // Base case: If there is only one character left, evaluate based on its value
        if (i == j) {
            if (isTrue) {
                return s.charAt(i) == 't' ? 1 : 0;  // 't' represents True
            } else {
                return s.charAt(i) == 'f' ? 1 : 0;  // 'f' represents False
            }
        }

        // Create a unique key to store results for this subproblem
        String temp = i + " " + j + " " + isTrue;

        // If the result for this subproblem is already computed, return the stored value
        if (m.containsKey(temp)) {
            return m.get(temp);
        }

        int ans = 0;

        // Iterate through the expression, considering each operator
        for (int k = i + 1; k < j; k += 2) {
            char operator = s.charAt(k);

            // Calculate the number of ways for the left and right sides of the expression
            int lt = solve(s, i, k - 1, true);  // Left side True
            int lf = solve(s, i, k - 1, false); // Left side False
            int rt = solve(s, k + 1, j, true);  // Right side True
            int rf = solve(s, k + 1, j, false); // Right side False

            // Based on the operator, calculate the result
            if (operator == '&') {
                if (isTrue) {
                    ans += lt * rt; // True if both sides are true
                } else {
                    ans += lf * rf + lf * rt + lt * rf; // All other combinations
                }
            } else if (operator == '|') {
                if (isTrue) {
                    ans += (lt * rt) + (lt * rf) + (lf * rt); // True if any side is true
                } else {
                    ans += lf * rf; // False only when both sides are false
                }
            } else if (operator == '^') {
                if (isTrue) {
                    ans += lt * rf + rt * lf; // True when one side is true and the other is false
                } else {
                    ans += lt * rt + lf * rf; // False when both sides are the same
                }
            }
        }

        // Store the result in the memoization map to avoid recomputation
        m.put(temp, ans);

        return ans;
    }

    public static void main(String[] args) {
        String s = "t^f&t";  // Example expression
        int i = 0, j = s.length() - 1;

        // Call the solve function and print the result
        System.out.println(solve(s, i, j, true));  // Return the number of ways to get True result
    }
}


//memoization with 3D DP
//https://leetcode.com/discuss/general-discussion/1279635/boolean-parenthesization-easy-c