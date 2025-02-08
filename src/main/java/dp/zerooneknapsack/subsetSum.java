package dp.zerooneknapsack;

public class subsetSum {

    public static boolean isSubsetSum(int[] arr, int n, int sum) {
        boolean[][] dp=new boolean[n+1][sum+1];

        for (int i=0;i<=n;i++) {
            for (int j = 0; j <= sum; j++) {
                if (i==0){
                    dp[i][j]=false;
                } else if (j==0) {
                    dp[i][j]=true;
                }else if (arr[i-1]<=j){
                    dp[i][j]= dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = arr.length;

        if (isSubsetSum(arr, n, sum)) {
            System.out.println("Found a subset with the given sum.");
        } else {
            System.out.println("No subset with the given sum.");
        }
    }
}
