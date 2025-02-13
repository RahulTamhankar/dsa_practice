package dp.mcm;

public class palindromePartitioningRecursive {

    // Function to check if a substring is a palindrome
    public static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            // If we have a single character (start == end), it's inherently a palindrome
            if (start == end) return true;

            // If start > end, it means the string has been completely checked with no mismatches
            if (start > end) return true;

            // If characters at start and end don't match, it's not a palindrome
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }

            // Move towards the center of the string
            start++;
            end--;
        }

        // If no mismatches were found, it's a palindrome
        return true;
    }

    // Recursive function to solve the problem without memoization
    public static int solve(String str, int i, int j) {
        // Base case: If the indices cross (i.e., no characters to check) or it's a single character
        if (i >= j) {
            return 0;
        }

        // If the substring is already a palindrome, no split is needed
        if (isPalindrome(str, i, j)) {
            return 0;
        }

        // Initialize the minimum number of cuts to a large value
        int min = Integer.MAX_VALUE;

        // Try all possible positions to split the string and minimize cuts
        for (int k = i; k < j; k++) {
            // Recursively find the minimum number of splits required
            int temp = 1 + solve(str, i, k) + solve(str, k + 1, j); // +1 for the partition between i to k and k+1 to j
            min = Math.min(min, temp); // Track the minimum cuts
        }

        return min;
    }

    // Function to get the minimum cuts for the entire string
    public static int minPalindromicCuts(String str) {
        return solve(str, 0, str.length() - 1); // Start solving the problem for the whole string
    }

    public static void main(String[] args) {
        // Example input string
        String str = "nitinn"; // Example string to test

        // Uncomment below line to test with another string
        // String str = "nitin"; // In this case, min cuts will be 0 as the string is already a palindrome

        // Call the function to get the minimum cuts and print the result
        int result = minPalindromicCuts(str);
        System.out.println("Minimum cuts required to partition the string into palindromes: " + result);
    }
}
