//package dp.mcm;
//
//public class palindromePartitioningMemoizedOptimisation {
//
//    // Memoization table to store results of subproblems
//    private static Integer[][] dp;
//
//    // Function to check if the string is a palindrome
//    public static boolean isPalindrome(String str, int start, int end) {
//        while (start < end) {
//            if (str.charAt(start) != str.charAt(end)) {
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
//    }
//
//    // Recursive function to find the minimum cuts for a palindrome partitioning
//    public static int solve(String str, int i, int j) {
//        // Base case: if indices cross or if there's only one character (no cut needed)
//        if (i >= j) {
//            return 0;
//        }
//
//        // Check if the result for this subproblem is already computed
//        if (dp[i][j] != null) {
//            return dp[i][j];
//        }
//
//        // If the current substring is already a palindrome, no cut is needed
//        if (isPalindrome(str, i, j)) {
//            dp[i][j] = 0;
//            return 0;
//        }
//
//        int min = Integer.MAX_VALUE;
//
//        // Try different cuts between i and j
//        for (int k = i; k < j; k++) {
//            // Optimization: Only consider partitions where the left part is a palindrome
//            if (isPalindrome(str, i, k)) {
//                // Recursively solve for the right substring after the partition
//                int partitions = 1 + solve(str, k + 1, j);
//                min = Math.min(min, partitions);
//            }
//        }
//
//        // Store the result in the memoization table
//        dp[i][j] = min;
//        return dp[i][j];
//    }
//
//    // Function to initialize the memoization table and start the recursion
//    public static int minCut(String s) {
//        int n = s.length();
//        dp = new Integer[n][n]; // Initialize dp table
//
//        // Call the solve function starting from the entire string
//        return solve(s, 0, n - 1);
//    }
//
//    public static void main(String[] args) {
//        // Test with example input string
//        String s = "nitinn"; // Example string
//
//        // Call the function and print the result
//        int result = minCut(s);
//        System.out.println("Minimum cuts required to partition the string into palindromes: " + result);
//    }
//}

package dp.mcm;

public class palindromePartitioningMemoizedOptimisation {

    // Memoization table to store results of subproblems
    private static Integer[][] dp;

    // Function to check if the string is a palindrome
    public static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Recursive function to find the minimum cuts for a palindrome partitioning
    public static int solve(String str, int i, int j) {
        // Base case: if indices cross or if there's only one character (no cut needed)
        if (i >= j) {
            return 0;
        }

        // Check if the result for this subproblem is already computed
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        // If the current substring is already a palindrome, no cut is needed
        if (isPalindrome(str, i, j)) {
            dp[i][j] = 0;
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int left, right;

        // Try different cuts between i and j
        for (int k = i; k < j; k++) {
            // If dp[i][k] has already been computed, get the value from dp table
            if (dp[i][k] != null) {
                left = dp[i][k];
            } else {
                // Otherwise, solve the subproblem and store the result
                left = solve(str, i, k);
                dp[i][k] = left;
            }

            // If dp[k+1][j] has already been computed, get the value from dp table
            if (dp[k + 1][j] != null) {
                right = dp[k + 1][j];
            } else {
                // Otherwise, solve the subproblem and store the result
                right = solve(str, k + 1, j);
                dp[k + 1][j] = right;
            }

            // Calculate the total cuts for this partition
            int temp = 1 + left + right;  //eg dp[0][5] = 1 + dp[0][2] + dp[3][5] = 1 + 1 + 1 = 3


            // Track the minimum cuts
            min = Math.min(min, temp);
        }

        // Store the result in the memoization table
        dp[i][j] = min;
        return dp[i][j];
    }

    // Function to initialize the memoization table and start the recursion
    public static int minCut(String s) {
        int n = s.length();
        dp = new Integer[n][n]; // Initialize dp table

        // Call the solve function starting from the entire string
        return solve(s, 0, n - 1);
    }

    public static void main(String[] args) {
        // Test with example input string
        String s = "nitinn"; // Example string

        // Call the function and print the result
        int result = minCut(s);
        System.out.println("Minimum cuts required to partition the string into palindromes: " + result);
    }
}



