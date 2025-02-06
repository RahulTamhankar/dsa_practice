package dp.unboundedknapsack;

public class coinChangeTwo {
    public static int coinChange(int[] coins, int amount) {
        int[][] t = new int[coins.length + 1][amount + 1];

        // Initialize first row: no coins, hence amount can't be made.
        for (int j = 1; j <= amount; j++) {
            t[0][j] = Integer.MAX_VALUE;  // Can't form any amount > 0 with 0 coins. When we are counting num of coins required to get a sum, we are going through this way: num of coin required = sum / (value of a coin)

            //if we need sum = 0, and we have no element in the array, and we go by 0 coin required approach then it will make the eq as: value of coin = sum/num of coins req = 0/0 = INFINTE
            //Since we don't have a coin of value "INFINITE", we are saying it in reverse - That is, we need infinite coins to get a sum = 0, when we dont have any coins.
            //Its about min number of coins required not number of ways. So making sum (x) from an empty array sounds illogical(or indefinite)

        }

        // Initialize first column: 0 amount can always be formed with 0 coins.
        for (int i = 0; i <= coins.length; i++) {
            t[i][0] = 0;
        }

        // Fill the table
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1]<=j) {
                    //exclude and include +1 as we have added that number(value[i-1] in knapsack)
                    t[i][j] = Math.min(t[i - 1][j], 1 + t[i][j - coins[i - 1]]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        // If the value at the last cell is Integer.MAX_VALUE, no solution is possible
        return t[coins.length][amount] == Integer.MAX_VALUE ? -1 : t[coins.length][amount];
    }

    public static void main(String[] args) {
        // Example test case
        int[] coins = {1, 2, 5};
        int amount = 11;

        int result = coinChange(coins, amount);

        // Output the result
        if (result == -1) {
            System.out.println("It is not possible to make the amount with the given coins.");
        } else {
            System.out.println("The minimum number of coins required: " + result);
        }
    }
}
