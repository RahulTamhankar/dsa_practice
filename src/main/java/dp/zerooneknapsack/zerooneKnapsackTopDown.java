package dp.zerooneknapsack;

public class zerooneKnapsackTopDown {
    public static int knapsack(int[] val, int[] weight, int w, int n) {

        int[][] dp = new int[n + 1][w + 1]; // DP table to store solutions to subproblems

        // Initialize the dp table
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                // Base case: If no items or no capacity, val is 0
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                // If the current item can be included in the knapsack
                else if (weight[i - 1] <= j) {
                    // Max of including or excluding the current item
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
                } else {
                    // If the item cannot be included, just carry forward the previous value
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][w]; // The result will be at the bottom-right corner of the table
    }

    public static void main(String[] args) {
        // Example input
        int val[] = new int[] {1, 2, 3};
        int weight[] = new int[] {2, 3, 4};
        int w = 5; // Capacity of the knapsack
        int n = val.length; // Number of items
        System.out.println(knapsack(val, weight, w, n)); // Output the maximum val
    }
}
