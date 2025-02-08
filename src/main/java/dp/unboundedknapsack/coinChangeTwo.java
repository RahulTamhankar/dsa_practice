package dp.unboundedknapsack;

public class coinChangeTwo {
//    public static int coinChange(int[] coins, int amount) {
//        int[][] t = new int[coins.length + 1][amount + 1];
//
//        // Initialize first row: no coins, hence amount can't be made.
//        for (int j = 1; j <= amount; j++) {
//            t[0][j] = Integer.MAX_VALUE;  // Can't form any amount > 0 with 0 coins. When we are counting num of coins required to get a sum, we are going through this way: num of coin required = sum / (value of a coin)
//
//            //if we need sum = 0, and we have no element in the array, and we go by 0 coin required approach then it will make the eq as: value of coin = sum/num of coins req = 0/0 = INFINTE
//            //Since we don't have a coin of value "INFINITE", we are saying it in reverse - That is, we need infinite coins to get a sum = 0, when we dont have any coins.
//            //Its about min number of coins required not number of ways. So making sum (x) from an empty array sounds illogical(or indefinite)
//
//        }
//
//        // Initialize first column: 0 amount can always be formed with 0 coins.
//        for (int i = 0; i <= coins.length; i++) {
//            t[i][0] = 0;
//        }
//
//        // Fill the table
//        for (int i = 1; i <= coins.length; i++) {
//            for (int j = 1; j <= amount; j++) {
//                if (coins[i - 1]<=j) {
//                    //exclude and include +1 as we have added that number(value[i-1] in knapsack)
//                    t[i][j] = Math.min(t[i - 1][j], 1 + t[i][j - coins[i - 1]]);
//                } else {
//                    t[i][j] = t[i - 1][j];
//                }
//            }
//        }
//
//        // If the value at the last cell is Integer.MAX_VALUE, no solution is possible
//        return t[coins.length][amount] == Integer.MAX_VALUE ? -1 : t[coins.length][amount];
//    }
//
//    public static void main(String[] args) {
//        // Example test case
//        int[] coins = {1, 2, 5};
//        int amount = 11;
//
//        int result = coinChange(coins, amount);
//
//        // Output the result
//        if (result == -1) {
//            System.out.println("It is not possible to make the amount with the given coins.");
//        } else {
//            System.out.println("The minimum number of coins required: " + result);
//        }
//    }

    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;

        // Initialize DP table: dp[i][j] will store the minimum number of coins needed to make change for amount j using first i coins
        int[][] dp = new int[n + 1][amount + 1];

        // Base case: dp[i][0] = 0 because no coins are needed to make amount 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        // Initialize the rest of the DP table: set to a large number (amount + 1), indicating that those amounts are not possible initially
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = amount + 1;  // Impossible to make a non-zero amount with 0 coins

        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    // If the coin can be included, take the minimum of:
                    // - 1 + dp[i][j - coins[i-1]] (using the coin)
                    // - dp[i-1][j] (not using the coin)
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else {
                    // If the coin cannot be used, just carry forward the previous result
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // If dp[n][amount] is still amount + 1, it means no solution was found
        return dp[n][amount] > amount ? -1 : dp[n][amount];
    }

    public static void main(String[] args) {
        int[] coins = {25, 10, 5};  // Coin denominations
        int amount = 30;  // Target amount to make change for

        // Output the minimum number of coins required
        System.out.println("Minimum number of coins required: " + coinChange(coins, amount));
    }
}
//One reason I think that is possible to initialize the matrix my +ve infinity and not by 0 is that we
// need to find the minimum number of coins. If we put 0 which Aditya Bhaiya pointed out in the video,
// then calculating bigger problems by using smaller sub-problems will always give 0 because 0 is going to be the minimum in the matrix. That is why we don't take 0 although it seems to be there.
//In 2nd row of dp table wherever sum need is fully divisible by coins available
//that time we fill eg 3 sum and 3 coins, 1 and wherever its not full Int_MAX-1 eg 4/3,

//-----------
//
//    What Happens if We Initialize to 1:
//        Here’s what could happen:
//
//        The DP table will incorrectly show that the minimum number of coins to form amounts like 1, 2, 3... is 1. So, for higher amounts, this would lead to invalid calculations because the algorithm would prematurely assume a valid combination exists, potentially ending up with a value like 1 for forming 30, which is incorrect.
//
//        Incorrect Result: In this case, when the table is filled, the algorithm might end up concluding that dp[3][30] (where dp[i][j] represents the minimum number of coins for amount j using the first i coins) is 1, even though it requires more than one coin.
//
//        Why We Use amount + 1:
//        amount + 1 ensures that we can't mistakenly treat any amount as achievable with just 1 coin. This is because amount + 1 is always larger than the maximum possible number of coins needed to form any amount.
//
//        When filling the table, the algorithm will either find a valid solution using one or more coins, or it will remain as amount + 1 if it’s not possible to make that amount with the available coins.
//
//        Example:
//        Suppose we want to make change for amount = 30 with coins {25, 10, 5}.
//
//        If we initialize the DP table with 1, the DP table might incorrectly say that dp[3][30] = 1 (1 coin), which is impossible, as we need at least 2 coins (25 + 5).
//
//        By initializing with amount + 1 (which is 31 here), the table will not make that mistake, and when we fill the table, we will correctly get the value 2 for dp[3][30], which indicates that the minimum number of coins required to make 30 is 2 (using the coins 25 and 5).
//
//        Conclusion:
//        Initialization to 1 would lead to false assumptions and incorrect results, because it would imply that you can make every amount with just 1 coin, even when that’s not true.
//        Initialization to amount + 1 ensures that we mark impossible states correctly and allow the DP algorithm to work properly, ensuring we only get valid solutions and can detect when it’s not possible to form a certain amount.
//        You're right in thinking that initializing to 1 would cause an issue with future calculations, and I hope this clears up why amount + 1 is the better choice for initialization!
// we do INT_MAX-1 so that while returning it gets subtracted from 1 otherwise int will overflow for INT_MAX+1

///////////////////VVVVVV IMP/////////////////////
//--------------------------------------------------/////////
//Why 31 Works as a High "Impossible" Value:
//        Avoids Incorrect Assumptions: If we initialized the DP table with 1 instead of 31, the algorithm would incorrectly treat amounts like 1, 2, 3, etc., as achievable with just 1 coin. This would create cascading errors in future calculations when trying to form higher amounts like 30, as the algorithm would prematurely assume a valid solution exists.
//
//        Identifies Impossible States: The value 31 is large enough that it cannot be mistaken for a valid solution. It clearly signals that it's impossible to form that amount with the coins considered so far. If dp[n][amount] remains 31 after filling the table, we know that the amount cannot be formed with the available coins.
//
//        Conclusion:
//        By initializing with amount + 1, we ensure that all "impossible" amounts are marked as impossible
//        FOR Example here impossible would be 19.. sum 19 can never be formed by any coins hence it will be marked as impossible (31)
//        (31 in our case). As we fill the DP table, the algorithm will correctly compute the minimum number of coins needed for each amount, and we can detect when it's not possible to form a particular amount. In the case of dp[3][30], this results in the correct answer of 2 coins (one 25 coin and one 5 coin).

// Comparison of Results:
//DP Initialization	dp[3][19] Value	Explanation
//Initialized with 1	1 (Incorrect)	This suggests that 19 can be made with 1 coin, which is wrong.
//Initialized with 31	31 (Correct)	This correctly indicates that 19 is impossible to form with the available coins.