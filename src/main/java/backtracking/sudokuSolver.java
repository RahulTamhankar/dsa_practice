package backtracking;

public class sudokuSolver {
    // The helper function uses backtracking to fill the board
    private static boolean helper(int rowIndex, int colIndex, char[][] board) {
        // Base case: if we've reached the end of the board
        if (rowIndex == 9) {
            return true; // we've found a valid solution
        }

        // If we've reached the end of a row, move to the next row
        if (colIndex == 9) {
            return helper(rowIndex + 1, 0, board);
        }

        // Skip cells that are already filled
        if (board[rowIndex][colIndex] != '.') {
            return helper(rowIndex, colIndex + 1, board);
        }

        // Try placing numbers 1-9
        for (char num = '1'; num <= '9'; num++) {
            if (canNumBePlaced(num, rowIndex, colIndex, board)) {
                board[rowIndex][colIndex] = num;
                if (helper(rowIndex, colIndex + 1, board)) {
                    return true; // If placing the number leads to a valid solution
                }
                board[rowIndex][colIndex] = '.'; // Backtrack if no solution is found
            }
        }

        return false; // No valid solution found for this cell
    }

    // Check if the number can be placed in the specified cell
    private static boolean canNumBePlaced(char num, int ri, int ci, char[][] board) {
        // Check the row
        for (int j = 0; j < 9; j++) {
            if (board[ri][j] == num) {
                return false;
            }
        }

        // Check the column
        for (int i = 0; i < 9; i++) {
            if (board[i][ci] == num) {
                return false;
            }
        }

        // Check the 3x3 subgrid
        int startRow = (ri / 3) * 3;
        int startCol = (ci / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true; // The number can be placed
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        // Start solving the Sudoku by calling the helper directly
        helper(0, 0, board);

        // Print the solved board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
