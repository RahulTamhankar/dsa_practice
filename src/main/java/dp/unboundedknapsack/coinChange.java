
package dp.unboundedknapsack;

public class coinChange {

    public static int coinChange(int[] coins, int N) {
        int n = coins.length;  // number of available coin types

        // dp[i][j] will store the number of ways to make change for j using the first i coins
        int[][] dp = new int[n + 1][N + 1];

        // Iterate through the DP table and initialize base cases
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= N; j++) {
                if (j == 0) {
                    dp[i][j] = 1;  // There's one way to make change for 0 (by not using any coin)
                } else if (i == 0) {
                    dp[i][j] = 0;  // No way to make change for j > 0 with 0 coins
                } else if (coins[i - 1] <= j) {
                    // Either include the current coin or exclude it
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    // Exclude the current coin
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Return the number of ways to make change for N using all available coins
        return dp[n][N];
    }

    public static void main(String[] args) {
        // Example input: N = 4, coins = {1, 2, 3}
        int N = 4;
        int[] coins = {1, 2, 3};

        // Output the number of ways to make change for N
        System.out.println("Number of ways to make change for " + N + ": " + coinChange(coins, N));
    }
}
