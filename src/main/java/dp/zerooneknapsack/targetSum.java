package dp.zerooneknapsack;

public class targetSum {

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;

        // Calculate the sum of all elements in the nums array
        for (int x : nums) {
            sum += x;
        }

        // If the difference between the sum and the target is odd or the target is larger than the sum, return 0
        if (((sum - target) % 2 == 1) || (target > sum)) {
            return 0;
        }

        int n = nums.length;
//        // Calculate the subset sum that we need to find
//        int s2 = (sum - target) / 2;
//
//        // DP table to store the number of ways to form a subset sum
//        int[][] t = new int[n + 1][s2 + 1];
//
//        // There's one way to make sum 0 (by choosing no elements)
//        t[0][0] = 1;
//
//        // Fill the DP table
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 0; j < s2 + 1; j++) {
//                if (nums[i - 1] <= j) {
//                    // Include or exclude the current element
//                    t[i][j] = t[i - 1][j] + t[i - 1][j - nums[i - 1]];
//                } else {
//                    // Exclude the current element
//                    t[i][j] = t[i - 1][j];
//                }
//            }
//        }

        int subset=(sum+target)/2;
        //Also I like the suggestion to use (sum_of_arr - diff)/2 instead of (sum_of_arr + diff)/2 this will reduce the size of array.
        int[][] dp= new int[n+1][subset+1];

        for(int i=0;i<=n;i++){
            for (int j=0;j<=subset;j++){
                if (j==0){
                    dp[i][j]=1;
                } else if (i==0) {
                    dp[i][j] = 0;
                } else if (nums[i-1]<=j) {
                    dp[i][j]=dp[i-1][j-nums[i-1]]+dp[i-1][j];
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][subset];
    }

        // The result is in t[n][s2], which is the number of ways to form the target sum

    public static void main(String[] args) {
        // Example array and target sum
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        // Find the number of ways to achieve the target sum
        int result = findTargetSumWays(nums, target);

        // Output the result
        System.out.println("Number of ways to achieve target " + target + ": " + result);
    }
}
