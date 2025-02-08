package dp.unboundedknapsack;

public class unbounded {
    public static int knapSack(int capacity, int[] val, int[] wt) {

        // 2D matrix for tabulation (storing max profit for each item and capacity).
        int[][] dp = new int[val.length + 1][capacity + 1];

        // Loop through items.
        for (int i = 1; i <= val.length; i++) {  // Start from 1, as 0 is the base case row.
            // Loop through all possible knapsack capacities.
            for (int j = 0; j <= capacity; j++) {
                // If current item can fit in the knapsack.
                //Add the value val[i-1] then deduct from j. Where i is processed there it can be processed again
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    // If current item can't fit in the knapsack, carry forward the value from the previous row.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The final answer is stored in dp[val.length][capacity].
        return dp[val.length][capacity];
    }

    public static void main(String[] args) {

        // Test data: values, weights, and knapsack capacity.
        int[] val = { 1, 1 };
        int[] wt = { 2, 1 };
        int capacity = 3;

        // Output the maximum profit.
        System.out.println(knapSack(capacity, val, wt));
    }
}
