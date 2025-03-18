package graphs.traversalongrids;

import java.util.*;

public class rottenOranges {

    // Direction arrays for traversing up, down, left, and right
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    // Function to find the minimum time for all oranges to rot
    public static int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int ans = 0;
        Queue<int[]> pq = new LinkedList<>();//[[],[],[]]

        // Add all rotten oranges (value 2) to the queue
        // traverse above grid and find all the rotten oranges and save all of them inside pq
        // 2 os the number for rotten oranges, so just save that i,j inside pq = [[i,j],[i,j]...]
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 2) {
                    pq.offer(new int[]{i, j});
                }
            }
        }

        // BFS to spread the rotting process
        while (!pq.isEmpty()) {
            int sz = pq.size(); // to solve Multi-Source concept
            int level = 0;  // this is like a flag to update level and avoid initalizing ans=-1 concept, check notebook
                            // inner loop chala matlab ek aur level add hua
            while (sz-- > 0) { // suppose initially level 1 pe 2 nodes thi ie Source = 2 then traverse 2 times and insert
                // their nbrs, Only after doing this we can say that, that particular level has been traversed!
                int[] p = pq.poll();
                int i = p[0];
                int j = p[1];

                // Check all four directions
                // p ke 4 nbr
                // Eg. i=3, j=4
                // i=3+(-1), j=4+(0) so isse 3,4 ke upar wala cordinate mil gaya
                for (int k = 0; k < 4; k++) {
                    int ii = i + dx[k];
                    int jj = j + dy[k];

                    // If within bounds and the orange is fresh, rot it
                    // so chaaro nbr mil gaya aur whatever oranges are fresh around it ie grid[ii][jj] == 1 take those
                    // then mark it visited(grid[ii][jj] = 2;) insert it inside the Queue
                    if (ii >= 0 && jj >= 0 && ii < r && jj < c && grid[ii][jj] == 1) {
                        grid[ii][jj] = 2; // Mark as rotten
                        level = 1; // At least one orange rotted for inital rotten oranges ie int[] p = pq.poll(); int i = p[0]; int j = p[1];
                        pq.offer(new int[]{ii, jj});
                    }
                }
            }

            // If any orange rotted in this step, increment the time
            ans+=level;
        }

        // Final check to see if there are any fresh oranges left
        for (int[] v : grid) {
            for (int x : v) {
                if (x == 1) {
                    return -1; // If any fresh orange remains, return -1
                }
            }
        }

        return ans; // Return the minimum time taken
    }

    // Main method for testing the function
    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int result = orangesRotting(grid);
        System.out.println("Minimum time for all oranges to rot: " + result);
    }
}
