
package dp.unboundedknapsack;

public class coinChange {

    public static int countWays(int[] coins, int N) {
        // dp[i][j] will store the number of ways to make change for amount j using the first i coins
        int[][] dp = new int[coins.length + 1][N + 1];

        // Base case: There's one way to make change for 0 amount, which is by using no coins
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;  // One way to make 0 with any number of coins: use no coins
        }

        // Loop through all possible coins (from 1 to coins.length) and all possible amounts (from 0 to N)
        for (int i = 1; i <= coins.length; i++) {  // Loop over all coins
            for (int j = 0; j <= N; j++) {  // Loop over all possible amounts (from 0 to N)
                // If we can include the current coin, i.e., if the coin value is less than or equal to current amount j
                if (coins[i - 1] <= j) {
                    // Two options:
                    // 1. Include the coin: dp[i][j - coins[i - 1]] gives the ways to make j using the current coin
                    // 2. Exclude the coin: dp[i - 1][j] gives the ways to make j without using the current coin
                    //Just like knapsack if values not present in question so just remove it. wt is replaced by coin array
                    //ie. if(wt[i-1]<=j){
                    // t[i][j]=Max(val[i-1]+t[i][j-wt[i-1]],t[i-1][j]) (wt-->coins)
                    // }
                    //Also instead of || in question its asked total hence we replaced Max(..||..) with +
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    // If the current coin is larger than the amount j, carry forward the previous row's value
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The final result will be the number of ways to make change for amount N using all available coins
        return dp[coins.length][N];
    }

    public static void main(String[] args) {
        // Example input: N = 4, coins = {1, 2, 3}
        int N = 4;
        int[] coins = {1, 2, 3};

        // Output the number of ways to make change for N
        System.out.println("Number of ways to make change for " + N + ": " + countWays(coins, N));
    }
}
