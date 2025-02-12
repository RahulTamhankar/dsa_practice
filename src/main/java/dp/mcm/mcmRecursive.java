package dp.mcm;

public class mcmRecursive {

    // Method to start matrix chain multiplication and return the minimum cost
    public static int matrixMultiplication(int N, int[] arr) {
        return helper(arr, 1, N - 1);
    }

    // Recursive helper method to calculate the minimum number of multiplications
    private static int helper(int[] arr, int i, int j) {
        // Base case: no multiplication needed for a single matrix
        if (i >= j) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        // Try every possible position 'k' to split the chain
        for (int k = i; k < j; k++) {
            // Cost of splitting the chain at k
            int temp = helper(arr, i, k) + helper(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];

            //40x20x30 + 30x10x30=//40x30x30

            //arr[i-1]xarr[k]xarr[j]=40x30x30

            // Take the minimum cost
            ans = Math.min(temp, ans);
        }

        return ans;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Sample input (matrix dimensions)
        int[] arr = {40, 20, 30, 10, 30};
        //                i   k       j
        int N = arr.length;

        // Call matrixMultiplication function and print the result
        System.out.println("Minimum number of multiplications: " + matrixMultiplication(N, arr));
    }
}
