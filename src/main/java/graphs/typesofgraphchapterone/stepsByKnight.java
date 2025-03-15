package graphs.typesofgraphchapterone;

import java.util.LinkedList;
import java.util.Queue;

public class stepsByKnight {
    // Directions for the knight's move: 8 possible moves
    private static final int[][] coordinates = {
            {-1, -2}, {-1, 2}, {1, -2}, {1, 2},
            {-2, -1}, {-2, 1}, {2, -1}, {2, 1}
    };

    // Helper function for BFS to find minimum steps from (src_x, src_y) to (target_x, target_y)
    private static int helper(int src_x, int src_y, int target_x, int target_y, int n) {
        // 2D array to keep track of visited positions on the board
        boolean[][] visited = new boolean[n][n];

        // Queue for BFS traversal
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {src_x, src_y});  // Start with the source position
        visited[src_x][src_y] = true;

        int steps = 0;

        // Perform BFS
        while (!queue.isEmpty()) {
            int qSize = queue.size();  // Get the current size of the queue
            while (qSize > 0) {
                int[] current = queue.poll();
                int x = current[0], y = current[1];

                // Check if we've reached the target position
                if (x == target_x && y == target_y) {
                    return steps;
                }

                // Explore all possible knight moves
                for (int[] dir : coordinates) {
                    int new_x = x + dir[0];
                    int new_y = y + dir[1];

                    // Check if the new position is valid and hasn't been visited
                    if (new_x >= 0 && new_y >= 0 && new_x < n && new_y < n && !visited[new_x][new_y]) {
                        visited[new_x][new_y] = true;
                        queue.offer(new int[] {new_x, new_y});
                    }
                }
                qSize--;  // Decrease the number of nodes to be processed in the current level
            }
            steps++;  // Increment the steps after processing one level
        }

        return -1;  // Return -1 if there is no valid path (though there should always be one for a knight)
    }

    // Function to calculate the minimum steps for the knight to reach the target
    public static int minStepsToReachTarget(int[] knightPos, int[] targetPos, int n) {
        // Convert the 1-indexed position to 0-indexed (array indexing)
        int src_x = knightPos[1] - 1;
        int src_y = knightPos[0] - 1;
        int target_x = targetPos[1] - 1;
        int target_y = targetPos[0] - 1;
        //If the target is at position (4, 5) (1-indexed), after adding 310:
        //x = 4 + 310 = 314
        //y = 5 + 310 = 315
        //This places the target at (314, 315) in the larger offset grid.
        //Conclusion:
        //+310 is used in the second code to shift all coordinates (to avoid negative indices and work with larger grids).

        // Call the helper function to perform BFS and get the minimum steps
        return helper(src_x, src_y, target_x, target_y, n);
    }

    public static void main(String[] args) {
        // Example knight position and target position
        int[] knightPos = {1, 1};  // Knight starting at position (1, 1)
        int[] targetPos = {8, 8};  // Target at position (8, 8)
        int n = 8;  // Size of the chessboard (8x8)

        // Calculate the minimum steps required for the knight to reach the target
        int result = minStepsToReachTarget(knightPos, targetPos, n);

        // Print the result
        System.out.println("Minimum steps to reach the target: " + result);
    }
}
