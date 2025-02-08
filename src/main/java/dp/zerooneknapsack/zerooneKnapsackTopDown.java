package dp.zerooneknapsack;

public class zerooneKnapsackTopDown {
    public static int knapsack(int[] profit, int[] weight, int w, int n) {

        int[][] dp = new int[n + 1][w + 1]; // DP table to store solutions to subproblems

        // Initialize the dp table
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                // Base case: If no items or no capacity, profit is 0
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                // If the current item can be included in the knapsack
                else if (weight[i - 1] <= j) {
                    // Max of including or excluding the current item
                    dp[i][j] = Math.max(profit[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
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
        int profit[] = new int[] {60, 100, 120};
        int weight[] = new int[] {10, 20, 30};
        int w = 50; // Capacity of the knapsack
        int n = profit.length; // Number of items
        System.out.println(knapsack(profit, weight, w, n)); // Output the maximum profit
    }
}
