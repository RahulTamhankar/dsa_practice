package dp.zerooneknapsack;

public class countNoOfSubsetWgivenDiff {

    public static int subset(int[] arr,int diff){
        int n= arr.length;
        int sum=0;
        for (int num:arr) {
            sum+=num;
        }
//        if(n%2!=0){
//            return 0;
//        }  The check for n % 2 is relevant only to determine if the array length is odd or even. However,
//        in the problem of finding subsets with a specific difference (diff), the condition for the sum of
//        the array is also very important. The check for (sum + diff) % 2 != 0 helps ensure that the sum of the array can be partitioned correctly.

        // If the sum is odd or the array length is odd, we cannot divide it into two subsets
        if ((sum + diff) % 2 != 0 || sum < diff) {
            return 0;
        }

        int subset=(sum+diff)/2;
        //Also I like the suggestion to use (sum_of_arr - diff)/2 instead of (sum_of_arr + diff)/2 this will reduce the size of array.
        int[][] dp= new int[n+1][subset+1];

        for(int i=0;i<=n;i++){
            for (int j=0;j<=subset;j++){
                if (j==0){
                    dp[i][j]=1;
                } else if (i==0) {
                    dp[i][j] = 0;
                } else if (arr[i-1]<=j) {
                    dp[i][j]=dp[i-1][j-arr[i-1]]+dp[i-1][j];
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][subset];
    }



    public static void main(String[] args){
        int arr[]=new int[]{1,1,2,3};
        int diff=1;
        System.out.println("No of subsets with diff 1:"+ subset(arr,diff));
    }
}
