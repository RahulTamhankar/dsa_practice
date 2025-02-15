package dp.eggdrop;

import java.util.Arrays;

public class eggDropMemoizeOptimize {

    // 2D dp array to store the results of subproblems
    static int[][] dp;

    // Method to solve the egg drop problem recursively with memoization
    public static int solve(int eggs, int floors) {
        // Base cases
        if (floors == 0 || floors == 1) {
            return floors;
        }
        if (eggs == 1) {
            return floors;
        }

        // If the result is already computed, return it from dp array
        if (dp[eggs][floors] != -1) {
            return dp[eggs][floors];
        }

        int minAttempts = Integer.MAX_VALUE;

        // Try dropping an egg from each floor and take the minimum of the maximum attempts
        for (int i = 1; i <= floors; i++) {
            // If the result of subproblems are already computed, reuse them
            int low, high;

            if (dp[eggs-1][i-1] != -1) {
                low = dp[eggs-1][i-1]; // Egg breaks, we need to check below the current floor
            } else {
                low = solve(eggs-1, i-1); // Egg breaks, solve recursively
                dp[eggs-1][i-1] = low; // Memoize the result
            }

            if (dp[eggs][floors-i] != -1) {
                high = dp[eggs][floors-i]; // Egg does not break, we need to check above the current floor
            } else {
                high = solve(eggs, floors-i); // Egg does not break, solve recursively
                dp[eggs][floors-i] = high; // Memoize the result
            }

            // Calculate the maximum of both results and take the minimum
            int temp = 1 + Math.max(low, high);
            minAttempts = Math.min(minAttempts, temp);
        }

        // Store the result in the dp array and return it
        dp[eggs][floors] = minAttempts;
        return minAttempts;
    }

    public static void main(String[] args) {
        int eggs = 3;
        int floors = 5;

        // Initialize the dp array with -1 using Arrays.fill()
        dp = new int[eggs + 1][floors + 1];

        // Using Arrays.fill to initialize each row of dp with -1
        for (int i = 0; i <= eggs; i++) {
            Arrays.fill(dp[i], -1);  // Fill each row with -1
        }

        // Call the solve method and display the result
        int attempts = solve(eggs, floors);
        System.out.println("# of attempts: " + attempts);
    }
}
