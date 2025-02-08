package dp.zerooneknapsack;

public class equalSumPartition {

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;

        // Calculate the sum of all elements in the array
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        // If the sum is odd, it's impossible to split it into two equal subsets
        if (sum % 2 != 0) {
            return false;
        } else {
            // Use the isSubsetSum function to check if it's possible to find a subset with sum = sum / 2
            return isSubsetSum(nums, n, sum / 2);
        }
    }

    public static boolean isSubsetSum(int[] arr, int n, int sum) {
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Initialize the base cases
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) {
                    dp[i][j] = false;  // No subset can form a positive sum with zero elements
                } else if (j == 0) {
                    dp[i][j] = true;   // A sum of 0 is always possible (with an empty subset)
                } else if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j]; // Include or exclude current element
                } else {
                    dp[i][j] = dp[i - 1][j]; // If the current element is greater than the sum, exclude it
                }
            }
        }
        return dp[n][sum]; // Return if we can form the target sum
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5}; // Example array
        if (canPartition(nums)) {
            System.out.println("Can partition the array into two subsets with equal sum.");
        } else {
            System.out.println("Cannot partition the array into two subsets with equal sum.");
        }
    }
}
