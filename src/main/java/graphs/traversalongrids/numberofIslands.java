package graphs.traversalongrids;

public class numberofIslands {

    // Direction arrays for traversing up, down, left, and right
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    // DFS function to mark all connected '1's as '2' (visited)
    private static void dfs(char[][] grid, int i, int j) {
        // If out of bounds or not an island ('1'), return
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {  // IF CELL IS 2 THEN RETURN. ELSE MARK IT 2
            return;   // MAKE SURE grid[i][j] != '1' IS ALWAYS IN THE END. WHY? Coz if its in front and i= -1 then grid [-1][]  will give indexOutOfBound Exception
        }

        // Mark the current cell as visited
        grid[i][j] = '2';

        // Visit all 4 neighbors (up, down, left, right)
        for (int k = 0; k < 4; k++) {
            int ii = i + dx[k];
            int jj = j + dy[k];
            dfs(grid, ii, jj);  // Option 2 CALL then check. BASE CASE UP!
        }
    }

    // Function to count the number of islands
    public static int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int cnt = 0;

        // Iterate through each cell in the grid
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // If the cell is '1' (part of an island), perform DFS to mark the entire island
                if (grid[i][j] == '1') {  // if I have got a Land CoOrdinate, I will try to extend it using DFS... So after extending DFS will change 1->2
                    dfs(grid, i, j);        // Reason 1- so that i dont make a dfs call to it again , Reason 2- So that I can handle the visited concept on the go
                    cnt++; // Increment the island count. Jitne baar mera DFS initiate hua utne baar cnt++
                }
            }
        }

        return cnt;
    }

    // Main method for testing the function
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        int result  = numIslands(grid);
        System.out.println("Number of islands: " + result);
    }

}
