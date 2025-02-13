package dp.mcm;

import java.util.Arrays;

public class mcmMemoizeBottomUpDPaKaTopdownDPideally {

    // Memoization table to store the results of subproblems
    static int[][] dp = new int[10][10];

    // Function to compute the minimum number of scalar multiplications using memoization
    public static int mcmMemoize(int[] arr, int i, int j, int[][] dp) {
        // Base case: If there is only one matrix (i >= j), no multiplication is needed
        if (i >= j) {
            return 0;
        }

        // If the value has already been computed (cached result), return it
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Initialize the minimum number of multiplications as a very large number
        int min = Integer.MAX_VALUE;

        // Try every possible position 'k' to split the chain and calculate the cost
        for (int k = i; k < j; k++) {
            // Calculate the cost of splitting at 'k':
            // mcm(arr, i, k) + mcm(arr, k+1, j) + cost of multiplying the resulting matrices
            int temp = mcmMemoize(arr, i, k, dp) + mcmMemoize(arr, k + 1, j, dp) + (arr[i - 1] * arr[k] * arr[j]);

            // Track the minimum cost
            min = Math.min(min, temp);
        }

        // Store the result in the memoization table to avoid recomputing it
        dp[i][j] = min;

        // Return the minimum number of multiplications required for multiplying matrices from i to j
        return dp[i][j];
    }

    public static void main(String[] args) {
        // Example input: matrix dimensions
        int[] arr = {1, 2, 3, 4, 3};
        int n = arr.length;

        // Edge case check: If the input array contains less than 2 matrices, it's invalid
        if (n < 2) {
            System.out.println("Invalid input: Matrix chain must contain at least 2 matrices.");
            return;
        }

        // Initialize the memoization table with size n+1 x n+1
        // We use n+1 because the matrix chain indices start from 1 and go up to n-1
        int[][] dp = new int[n + 1][n + 1];

        // Initialize the dp table with -1 to indicate that no subproblem has been solved yet
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Call the mcmMemoize function and print the result
        int value = mcmMemoize(arr, 1, n - 1, dp);

        // Output the minimum number of scalar multiplications
        System.out.println("Minimum number of multiplications: " + value);
    }
}
