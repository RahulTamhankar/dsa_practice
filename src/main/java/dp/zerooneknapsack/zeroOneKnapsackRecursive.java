package dp.zerooneknapsack;

public class zeroOneKnapsackRecursive {

    public static int knapsack(int profit[],int weight[],int w,int n){
        if(n==0 || w==0){
            return 0;
        }

        if(weight[n-1]<=w){
            return Math.max(profit[n-1]+knapsack(profit,weight,w-weight[n-1],n-1),
                    knapsack(profit,weight,w,n-1));
        }
        else {
            return knapsack(profit,weight,w,n-1);
        }
    }


    public static void main(String[] args){
        int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int w=50;
        int n=profit.length;
        System.out.println(knapsack(profit,weight,w,n));
    }
}
