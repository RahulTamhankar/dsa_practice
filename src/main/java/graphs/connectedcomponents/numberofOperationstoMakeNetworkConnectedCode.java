package graphs.connectedcomponents;

import java.util.ArrayList;
import java.util.List;

public class numberofOperationstoMakeNetworkConnectedCode {

    // Depth-First Search to visit all connected nodes
    private static void dfs(List<List<Integer>> adj, boolean[] visited, int src) {
        visited[src] = true;
        for (int i : adj.get(src)) {
            if (!visited[i]) {
                dfs(adj, visited, i);
            }
        }
    }

    // Function to find the minimum number of operations to make the network connected
//    1-2     4-0
//    | |     |
//    3-|     5
    //connections=[[1,2][2,3][3,1][4,5][5,0]]
    // n=6
    // so as per our analysis to connect these we need minumum = n-1 = 5
    // 5 >=5 ?
    // yes
    // so calculate minimum componenets
    // total components in the example is 2 so 2-1 =1 cable, we need extra
    // so we can remove 1-3 and then connect 3 - 5
    public static int makeConnected(int n, int[][] connections) {// connections array - konsi node kisse connected hai
        // If there are not enough connections to form a connected network, return -1


        if (connections.length < n - 1) {  // ie X>=n-1 then only move forward else return -1
            return -1;
        }

        // Adjacency list to represent the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the adjacency list from the given connections
        for (int[] v : connections) {
            adj.get(v[0]).add(v[1]);// since its an undiracted edge, connection will be made between v(0)-v(1) and v[1]-v[0]//creataion of graph here
            adj.get(v[1]).add(v[0]);
        }

        // Array to track visited nodes
        boolean[] visited = new boolean[n];
        int components = 0;

        // Perform DFS to count the number of connected components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {   // agar koi node unvsited marked hai to us node ke lie firse dfs kardo
                dfs(adj, visited, i);
                components++;  //1st dfs started from 0 suppose, call [1,0,0,0,1,1]
            }                   // 2nd dfs starts from 1
        }                       // here dfs is initiated 2 times here componenets =2

        // To connect all components, we need at least (components - 1) operations
        return components - 1;
    }

    public static void main(String[] args) {

        // Test case 1:
        int n1 = 4;
        int[][] connections1 = {
                {0, 1},
                {0, 2},
                {1, 2}
        };

        // Output the result for the first test case
        System.out.println("Test case 1 result: " + makeConnected(n1, connections1));  // Expected output: 1

        // Explanation:
        // Remove the cable between computer 1 and 2, and place it between computers 1 and 3.
        // This will connect all computers with 1 operation.
    }
}
