package dp.unboundedknapsack;

public class rodCutting {

    public static int rodCutting(int[] price, int length) {
        int n = length;  // length of the rod (based on input array)

        // Create a DP table to store the maximum value for each length
        int[][] dp = new int[n + 1][n + 1];

        // Iterate through the table to fill it based on the choices of cuts
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    dp[i][j] = 0;  // If no length to cut, value is 0
                } else if (i == 0) {
                    dp[i][j] = 0;  // No rod to cut
                } else if (i <= j) {
                    // Choose to cut the rod or skip
                    //Why Don't We Use coins[i-1] the Same Way as price[i-1]?
                    //In Rod Cutting, price[i-1] is a profit that you get when you cut the rod into pieces of size i. This is a profit-maximizing problem, where you are trying to maximize the total profit from cutting the rod. Hence, you need to add the value price[i-1] if you decide to cut the rod into pieces of length i.
                    //
                    //In Coin Change, you're not interested in maximizing anything. You're simply counting the ways to make change. The number of ways to make change for j using the first i coins is the sum of:
                    //
                    //The number of ways to make change for j - coins[i-1] (if you use the coin coins[i-1]).
                    //The number of ways to make change for j without using the coin coins[i-1].
                    //In summary:
                    //
                    //Rod Cutting: You maximize the profit by including the value of price[i-1] when you decide to cut the rod. You compare the profit from cutting versus not cutting.
                    //Coin Change: You count the ways to make change, so you add the number of ways you can make the remaining amount when including a coin.
                    //
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - i], dp[i - 1][j]);
                } else {
                    // If rod length is greater than the current j, don't cut
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Return the maximum value for the full rod length
        return dp[n][n];
    }

    //this is unbounded as we can choose one length multiple times to maximize profit
    public static void main(String[] args) {
        // Example rod length and price array
        int n = 8;
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};  // prices for rod lengths 1 to 8

        // Output the maximum obtainable value
        System.out.println("Maximum obtainable value: " + rodCutting(prices, n));
    }
}
