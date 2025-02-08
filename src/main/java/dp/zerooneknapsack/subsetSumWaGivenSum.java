package dp.zerooneknapsack;

public class subsetSumWaGivenSum {

    public static int countSubset(int[] arr,int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args){
        int[] arr=new int[]{1,2,3,3};
        int sum=6;
        System.out.println("Number of subsets:"+countSubset(arr,sum));
    }
}
