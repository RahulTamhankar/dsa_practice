package binarysearch.binarysearchonans;

public class searchinRowwiseAndColumnwiseSortedArray {

    // Function to search the element in the matrix
    public static String searchInMatrix(int[][] matrix, int key) {
        int n = matrix.length;
        int i = 0; // Start at the first row
        int j = n - 1; // Start at the last column

        // Loop until the indices are valid (i >= 0 and j >= 0)
        while (i < n && j >= 0) {
            // If the element at the current position is the target
            if (matrix[i][j] == key) {
                return "Found at (" + i + ", " + j + ")";
            }
            // If the element at current position is greater than the target, move left
            else if (matrix[i][j] > key) {
                j--;
            }
            // If the element at current position is less than the target, move down
            else {
                i++;
            }
        }

        // If the element is not found, return "Not Found"
        return "Not Found";
    }

    public static void main(String[] args) {
        // Example input matrix
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };

        // Search key
        int key = 29;

        // Function call
        String result = searchInMatrix(matrix, key);
        System.out.println(result); // Expected: "Found at (2, 1)"
    }
}
