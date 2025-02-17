package backtracking;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ratInMaze {

    // Function to find all possible paths
    public static void findAllPaths(int[][] grid, int[] currentPosition, String currentPath, List<String> allPaths) {
        int gridWidth = grid[0].length - 1;  // Grid width (columns)
        int gridHeight = grid.length - 1;    // Grid height (rows)

        int x = currentPosition[0];  // Current x position
        int y = currentPosition[1];  // Current y position

        // Base case: If we reach the destination (bottom-right corner)
        if (x == gridHeight && y == gridWidth) {
            allPaths.add(currentPath);
            return;
        }

        // Directions: Down, Left, Right, Up
        String[][] directions = {
                {"D", "1,0"},  // Down (move to the next row)
                {"L", "0,-1"}, // Left (move to the previous column)
                {"R", "0,1"},  // Right (move to the next column)
                {"U", "-1,0"}  // Up (move to the previous row)
        };

        // Try each direction
        for (String[] direction : directions) {
            String directionCode = direction[0];
            int dx = Integer.parseInt(direction[1].split(",")[0]);  // Row change (dx)
            int dy = Integer.parseInt(direction[1].split(",")[1]);  // Column change (dy)

            int newX = x + dx;  // New x position after move
            int newY = y + dy;  // New y position after move

            // Check if the new position is within bounds and not blocked
            if (newX < 0 || newX > gridHeight || newY < 0 || newY > gridWidth || grid[newX][newY] == 0) {
                continue;  // Skip invalid moves
            }

            // Mark the current cell as visited
            grid[x][y] = 0;

            // Recurse: move to the new valid position and append the current direction to the path
            findAllPaths(grid, new int[]{newX, newY}, currentPath + directionCode, allPaths);

            // Backtrack: unmark the current cell after exploring
            grid[x][y] = 1;
        }
    }

    // Function to find all possible paths from (0, 0) to (N-1, N-1)
    public static List<String> findPath(int[][] grid) {
        List<String> allPaths = new ArrayList<>();
        // Start backtracking from the top-left corner (0, 0) with an empty path
        if (grid[0][0] == 1) {  // If the start position is not blocked
            findAllPaths(grid, new int[]{0, 0}, "", allPaths);
        }
        Collections.sort(allPaths);  // Sort the paths lexicographically
        return allPaths;
    }

    // Main function to test the solution
    public static void main(String[] args) {
        // Example matrix: 1 indicates a valid cell, 0 indicates a blocked cell
        int[][] grid = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        // Find all possible paths from the top-left to the bottom-right corner
        List<String> paths = findPath(grid);

        // Print all the possible paths
        for (String path : paths) {
            System.out.println(path);  // Output paths in lexicographical order
        }
    }
}
