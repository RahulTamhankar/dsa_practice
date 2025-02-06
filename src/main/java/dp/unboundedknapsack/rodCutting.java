package dp.unboundedknapsack;

public class rodCutting {
    public static int cutRod(int[] prices, int n) {
        // dp[i][j] will store the maximum revenue obtainable using the first i pieces for rod of length j
        int[][] dp = new int[prices.length + 1][n + 1];

        // Loop through all possible lengths of rod (from 1 to n) and all pieces (from 1 to prices.length)
        for (int i = 1; i <= prices.length; i++) {  // Start from 1, as 0 is the base case row
            for (int j = 0; j <= n; j++) {  // Loop through all possible rod lengths (from 0 to n)
                // If current piece can fit into the rod (i.e., if the piece length i is less than or equal to j)
                if (i <= j) {
                    // We can either take the piece or not
                    dp[i][j] = Math.max(prices[i - 1] + dp[i][j - i], dp[i - 1][j]);
                } else {
                    // If current piece can't fit into the rod, carry forward the value from the previous row
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The final answer will be the maximum revenue for the rod of length n
        return dp[prices.length][n];
    }

    public static void main(String[] args) {
        // Example rod length and price array
        int n = 8;
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};  // prices for rod lengths 1 to 8

        // Output the maximum obtainable value
        System.out.println("Maximum obtainable value: " + cutRod(prices, n));
    }
}
