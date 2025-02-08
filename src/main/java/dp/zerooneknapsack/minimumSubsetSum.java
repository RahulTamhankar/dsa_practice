package dp.zerooneknapsack;

public class minimumSubsetSum {

    public static int minSubsetSum(int[] arr) {
        int n = arr.length;

        // Calculate the total sum of the array
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        // Call the calculate method to find the minimum difference
        return calculate(arr, n, sum);
    }

    public static int calculate(int[] arr, int n, int sum) {
        // DP table initialization
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Fill the DP table to track achievable subset sums
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0) {
                    dp[i][j] = true;  // A sum of 0 is always achievable
                } else if (i == 0) {
                    dp[i][j] = false;  // Sum is not achievable with 0 elements
                } else if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];  // Include or exclude current element
                } else {
                    dp[i][j] = dp[i - 1][j];  // Exclude current element
                }
            }
        }

        // Variable to store the minimum difference
        int min = Integer.MAX_VALUE;

        // Iterate over the last row (dp[n][j]) where the subset sums are stored
        for (int j = 0; j <= sum; j++) {
            if (dp[n][j]) {
                // Calculate the absolute difference and minimize it
                min = Math.min(min, Math.abs(sum - 2 * j));
            }
        }

        //Or like this
        //   // Variable to store the minimum difference
        //        int minDiff = Integer.MAX_VALUE;
        //
        //        // Find the closest sum to total/2
        //        for (int s1 = 0; s1 <= total / 2; s1++) {
        //            if (dp[n][s1]) {
        //                int s2 = total - s1;
        //                minDiff = Math.min(minDiff, Math.abs(s2 - s1));
        //            }
        //        }

//        Edit
//        dp[4][s1] (last row)  ->  [true, true, false, true, false, true, true, true, false, true, true, true, false, true, true, true, false, true, false, true, false, false, true]
//        dp[4][0] = true: Sum 0 is achievable (the empty set).
//        dp[4][1] = true: Sum 1 is achievable.
//        dp[4][6] = true: Sum 6 is achievable.
//        dp[4][7] = true: Sum 7 is achievable.
//        dp[4][10] = true: Sum 10 is achievable.
//        dp[4][11] = true: Sum 11 is achievable.
//        dp[4][15] = true: Sum 15 is achievable.
//        dp[4][16] = true: Sum 16 is achievable.
//        dp[4][17] = true: Sum 17 is achievable.
//        dp[4][20] = true: Sum 20 is achievable.
//        dp[4][21] = true: Sum 21 is achievable.
//        dp[4][23] = true: Sum 23 is achievable.
//        4. Finding the Closest Subset Sum
//        Now, the goal is to minimize the difference between the sums of two subsets. If one subset has sum s1, then the other subset has sum s2 = total - s1. The difference is |s1 - s2| = |2 * s1 - total|.
//
//        To find the closest s1 to total / 2 = 23 / 2 = 11.5, we iterate over all possible subset sums s1 from 0 to total / 2 (i.e., from 0 to 11), and for each sum s1 that is achievable (i.e., dp[4][s1] == true), we calculate the absolute difference |2 * s1 - 23|.
//
//        Calculate Differences:
//        For each achievable s1:
//
//        For s1 = 0:
//
//|2 * 0 - 23| = 23
//        For s1 = 1:
//
//|2 * 1 - 23| = 21
//        For s1 = 6:
//
//|2 * 6 - 23| = 11
//        For s1 = 7:
//
//|2 * 7 - 23| = 9
//        For s1 = 10:
//
//|2 * 10 - 23| = 3
//        For s1 = 11:
//
//|2 * 11 - 23| = 1
//        The smallest difference is 1, which occurs when s1 = 11.
//
//        5. Final Result
//        The minimum subset sum difference is 1.


        return min;
    }

    public static void main(String[] args) {
        int arr[] = {1, 6, 11, 5};
        System.out.println("Min subset sum difference: " + minSubsetSum(arr));
    }
}
