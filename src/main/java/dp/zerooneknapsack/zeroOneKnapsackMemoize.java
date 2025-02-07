package dp.zerooneknapsack;

import java.util.Arrays;

public class zeroOneKnapsackMemoize {

    public static int knapsack(int[] profit, int[] weight, int w, int n, int[][] dp) {
        // Base case: If no items or weight capacity left
        if (n == 0 || w == 0) {
            return 0;
        }

        // If this subproblem has been solved before, return the cached value
        if (dp[n][w] != -1) {
            return dp[n][w];
        }

        // If the current item's weight is less than or equal to the capacity
        if (weight[n - 1] <= w) {
            // Choose the maximum of including or excluding the current item
            dp[n][w] = Math.max(
                    profit[n - 1] + knapsack(profit, weight, w - weight[n - 1], n - 1, dp), // Include the current item
                    knapsack(profit, weight, w, n - 1, dp) // Exclude the current item
            );
        } else {
            // If the current item's weight is more than the available capacity, don't include it
            dp[n][w] = knapsack(profit, weight, w, n - 1, dp);
        }

        return dp[n][w];
    }

    public static void main(String[] args) {
        // Example input
        int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int w = 50; // Capacity of the knapsack
        int n = profit.length; // Number of items
        int[][] dp = new int[n + 1][w + 1];

        // Initialize dp array with -1 (indicating uncalculated subproblems)
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Output the maximum profit
        System.out.println(knapsack(profit, weight, w, n, dp));
    }
}
