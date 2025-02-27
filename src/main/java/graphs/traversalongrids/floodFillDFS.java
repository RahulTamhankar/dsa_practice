package graphs.traversalongrids;

import java.util.*;

public class floodFillDFS {

    // Direction arrays for traversing up, right, down, left
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    // Flood Fill using Depth-First Search (DFS)
    private static void dfs(int i, int j, int orgColor, int color, int r, int c, int[][] image) {
        // Base case: If out of bounds or the color is different, stop recursion
        if (i < 0 || j < 0 || i >= r || j >= c || image[i][j] != orgColor) {
            return;
        }

        // Change the color of the current cell
        image[i][j] = color;

        //nbrs pe 3 checks lagana hai
        //Check 1 - visited cells should not(same matrix)
        //Check 2 - adjacent coordinates should be val
        //check 3 - consider same color cells
        //##########
        //Dfs me har bar 3 options hote hai
        //Option 1) First Check then call
        //Options 2) WE DO First Call then check (check can be done using some base case)




        // Recursively visit all four neighboring cells
        for (int k = 0; k < 4; k++) {
            int ii = i + dx[k];
            int jj = j + dy[k];
            dfs(ii, jj, orgColor, color, r, c, image); ////Options 2) First CALL----->  BASE CASE IS UP //Varna agar option 1 karna hai to Upar wala base case if for ke andar likho agar valid hai to hi dfs call karo

        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        //dfs first
        //source is given
        //go to the connected calls of the same color
        //if it is a valid cell, change its color to the given color



        // Get the number of rows and columns
        int r = image.length;
        int c = image[0].length;

        // Get the original color at the starting point
        //since the source color is going to change down the line, save it
        int orgColor = image[sr][sc];

        // If the original color is the same as the new color, no need to change
        if (orgColor == color) {
            return image; // return the image matrix
        }

        // Start DFS from the source cell (sr, sc)
        dfs(sr, sc, orgColor, color, r, c, image);

        return image;
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int sr = 1, sc = 1, color = 2;

        int[][] result = floodFill(image, sr, sc, color);

        // Print the modified image
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}


//Worst Case TC- if I traverse entire matrix O(NxM)
//How- DFS O(V+E) Ignore E , O(V) , V are cells , Total cells = NxM
//SC -Doing changes in same given image O(1)