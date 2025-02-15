package dp.booleanparenthesization;

public class evaluateExpressionToTrueBooleanParenthesizationRecursive {

    public static int solve(String s, int i, int j, boolean isTrue) {
        // If the indices are out of range, return 0
        if (i > j) return 0;

        // If only one character is left, evaluate the result based on its value
        if (i == j) {
            if (isTrue) {
                return s.charAt(i) == 't' ? 1 : 0; // 't' represents True
            } else {
                return s.charAt(i) == 'f' ? 1 : 0; // 'f' represents False
            }
        }

        int ans = 0;

        // Recursively evaluate the expression for every operator in the string
        for (int k = i + 1; k < j; k += 2) {
            char operator = s.charAt(k);

            // Calculate the number of ways for left and right sides of the expression
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

        return ans;
    }

    public static void main(String[] args) {
        String s = "t^f&t";
        int i = 0, j = s.length() - 1;
        System.out.println(solve(s, i, j, true));  // Return the number of ways to get True result
    }
}
