package graphs.traversalongrids;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class geeksVillageandWellsCode {
    // Direction arrays for traversing up, down, left, and right
    private static final int[][] direction = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    // Function to compute distances from wells ('W') to humans ('H') in the grid
    public static int[][] chewells(int n, int m, char[][] c) {
        int[][] result = new int[n][m];

        // Initialize result grid with 0
        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], 0);
        }

        // Queue for BFS
        Queue<int[]> q = new LinkedList<>();

        // Enqueue all wells' positions and mark visited cells
        //insert all Well sources in Queue(Multi-Source)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (c[i][j] == 'W') {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int counter = 1; //To count number of levels

        // BFS to spread from all wells
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) { // Process Current Level
                int[] p = q.poll();
                int row = p[0], col = p[1];   //pair me se ek ek value leliya to row aur column mil gai


                // Ab upar ke row, column ke neighbors ki values dekhni hai
                // Explore all four directions
                for (int[] dir : direction) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // Check if the new position is within bounds and if it's a human ('H') or empty ('.')
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                            && (c[newRow][newCol] == 'H' || c[newRow][newCol] == '.')) { // naya CoOrdinate ya to 'H' ko denote karna chaiye ya fir . ko  , basically X matlab jo already marked hai , Well W and N ko nai lena chahte ! Bus H ya '.' ke case me hi andar jaenge

                        // 3 things were heppening when its a 'H' and 2 things happen when its a '.'

                        // If it's a human, mark it with the distance (2 * counter)
                        //1st thing - If its and 'H' to mujhe distance update karni hai , distance is 2*counter
                        if (c[newRow][newCol] == 'H') {
                            result[newRow][newCol] = 2 * counter;
                        }

                        //common kaam mark and insert those coordinates in queue
                        // Mark the cell as visited
                        c[newRow][newCol] = 'X';

                        // Enqueue the cell for future BFS
                        q.offer(new int[]{newRow, newCol});
                    }
                }
            }
            counter++; // increment the level
        }

        // For all remaining humans, set result to -1 if unreachable
        //jiske aas pass WELL nai tha aur H coordinates bach gai usko -1 mark kardo
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (c[i][j] == 'H') {
                    result[i][j] = -1;
                }
            }
        }

        return result;
    }

    // Main method for testing the function with the specific input
    public static void main(String[] args) {
        // Input: n = 3, m = 3
        int n = 3, m = 3;
        char[][] grid = {
                {'H', 'H', 'H'},
                {'H', 'W', 'H'},
                {'H', 'H', 'H'}
        };

        // Calling the chewells method to get the result
        int[][] result = chewells(n, m, grid);

        // Printing the result
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
