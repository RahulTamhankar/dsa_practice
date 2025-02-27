package graphs.traversalongrids;

import java.util.*;

public class floodFillBFS {

    // Direction arrays for traversing up, right, down, left
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    // BFS for flood fill
    private static void bfs(int sr, int sc, int orgColor, int color, int r, int c, int[][] image) {
        // Create a queue to perform BFS
        Queue<int[]> q = new LinkedList<>();  // Simple graph ke Q's me iske lie hum int data type dete the but abhi ke node me 2 CoOrdinates hai i,j->row,column
        q.add(new int[]{sr, sc});  //1st value is row 2nd value is column , source node

        // Change the color of the starting pixel
        // direct source node ko color assign kardiya
        image[sr][sc] = color;

        // Perform BFS
        while (!q.isEmpty()) {
            int[] f = q.poll(); // ye f ek pair hai ie. i,j
            int i = f[0];
            int j = f[1];

            // Check all four directions
            for (int k = 0; k < 4; k++) {
                int ii = i + dx[k];
                int jj = j + dy[k];

                // If the position is out of bounds or not the original color, skip it // DFS KI TARAHA ye hum BAHAR NAI KAR SAKTE Ie. OPTION 2
                //WHY?
                //Agar humne for me directly q.add(new int[]{ii, jj}); ye kar diya aur bahar jake ye if check kiya to issue aaega

                // Suppose A aur C dono queue me hai at the same time  <A,C> NOW  [A,B,C]  source node is A, hence insert all nbr of A into queue, A ko pop aur q= <C,B>
                // Now next time C pop hua, C ka nbr B hai, but since B ko humne visited mark kiya hi nai hai
                // B firse queue me insert hoga!!!  <B,B>
                //Manlo ek aur nbr hota D, D pop hoag firse B insert hua  queue<B,B,B>
                //DFS ME ek baar hum B pe aai usko insert karke uski kahahi khatam hogai , but bfs me level wise hota hai..
                // so A pe rehte time B queue me gaya but then again D pe se bhi B queue me insert hoga!
                //Islie its IMP to check this and insert only valid nbrs inside the QUEUE ie q.add(new int[]{ii, jj});
                if (ii < 0 || jj < 0 || ii >= r || jj >= c || image[ii][jj] != orgColor) {
                    continue;
                }

                // Change the color of the valid cell and add it to the queue
                // check + color marking
                // so jab ye NODE while ke bahar aaegi its already taken care of , no need to do anything
                image[ii][jj] = color;
                q.add(new int[]{ii, jj});
            }
        }
    }

    // Public method to initiate the flood fill using BFS
    public static int[][] floodFillBFS(int[][] image, int sr, int sc, int color) {
        // Get the number of rows and columns
        int r = image.length;
        int c = image[0].length;

        // Get the original color at the starting point
        int orgColor = image[sr][sc];

        // If the original color is the same as the new color, no need to change
        if (orgColor == color) {
            return image;
        }

        // Start BFS from the source cell (sr, sc)
        bfs(sr, sc, orgColor, color, r, c, image);

        return image;
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int sr = 1, sc = 1, color = 2;

        int[][] result = floodFillBFS(image, sr, sc, color);

        // Print the modified image
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
