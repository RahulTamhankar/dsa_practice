package backtracking;

import java.util.ArrayList;
import java.util.List;

public class nQueens {

    // This will store the final answer
    static List<List<Integer>> ans = new ArrayList<>();

    // This is the helper function that will perform backtracking
    public static void helper(int colIdx, int[][] board, int n, List<Integer> temp) {
        // Base case: If all columns are filled, add the solution
        if (colIdx == n) {
            ans.add(new ArrayList<>(temp)); // Make a copy of temp
            return;
        }

        // Column-wise traversal: Try all rows for the given column
        for (int rowIdx = 0; rowIdx < n; rowIdx++) {
            // Try placing the queen in (rowIdx, colIdx) if it's safe
            if (check(board, rowIdx, colIdx, n)) {
                // Place the queen and make changes
                temp.add(rowIdx + 1); // Store the 1-based index
                board[rowIdx][colIdx] = 1; // Mark the board

                // Recurse for the next column
                helper(colIdx + 1, board, n, temp);

                // Backtrack: Remove the queen and undo changes
                temp.remove(temp.size() - 1);
                board[rowIdx][colIdx] = 0;
            }
        }
    }

    // Function to check if placing a queen at (i, j) is safe
    public static boolean check(int[][] board, int i, int j, int n) {
        int r = i, c = j;

        // Check upper diagonal
        while (r >= 0 && c >= 0) {// since its doing upper left diagonally hence r and c can hit 0
            if (board[r][c] == 1) {
                return false;
            }
            r--;
            c--;
        }

        // Check same row (left side)
        r = i;
        c = j;
        while (c >= 0) {
            if (board[r][c] == 1) {
                return false;
            }
            c--;
        }

        // Check lower diagonal
        r = i;
        c = j;
        while (r < n && c >= 0) { //since its going down left diagonally hence r can hit n
            if (board[r][c] == 1) {
                return false;
            }
            r++;
            c--;
        }

        return true;
    }

    // Function to solve the N-Queens problem
    public static List<List<Integer>> nQueen(int n) {
        // Create an empty board initialized to 0
        int[][] board = new int[n][n];
        // List to store current temporary solution
        List<Integer> temp = new ArrayList<>();
        // Start the backtracking from the first column
        helper(0, board, n, temp);
        // Return the result (all valid solutions)
        return ans;
    }

    public static void main(String[] args) {
        // Example: Solving the 4-Queens problem
        int n = 4;
        List<List<Integer>> solutions = nQueen(n);
        System.out.println("Solutions for " + n + "-Queens:");
        for (List<Integer> solution : solutions) {
            System.out.println(solution);
        }
    }
}

