package graphs.typesofgraphchapterone;

import java.util.*;

public class reorderRoutes {

    // Helper function for DFS traversal
    public static void dfs(int node, List<List<Integer>> forwardNbrs, List<List<Integer>> backwardNbrs, int[] ans, boolean[] visited) {
        // Mark the current node as visited
        visited[node] = true;

        // Explore the forward neighbors, and add to the count if the edge direction is wrong
        for (int nbr : forwardNbrs.get(node)) {
            if (!visited[nbr]) {
                ans[0]++;  // This edge needs to be reordered
                dfs(nbr, forwardNbrs, backwardNbrs, ans, visited);
            }
        }

        // Explore the backward neighbors
        for (int nbr : backwardNbrs.get(node)) {
            if (!visited[nbr]) {
                dfs(nbr, forwardNbrs, backwardNbrs, ans, visited);
            }
        }
    }
    //  0 → 1 → 3 ← 2
    //  ↓
    //  4 → 5

    // Function to find the minimum reorder needed to make the graph connected
    public static int minReorder(int n, List<List<Integer>> connections) {
        // Initialize adjacency lists for forward and backward edges
        List<List<Integer>> forwardNbrs = new ArrayList<>();
        List<List<Integer>> backwardNbrs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            forwardNbrs.add(new ArrayList<>());
            backwardNbrs.add(new ArrayList<>());
        }

        // Build the adjacency lists
        for (List<Integer> connection : connections) {
            int a = connection.get(0);
            int b = connection.get(1);
            forwardNbrs.get(a).add(b);  // Add forward edge from a to b
            backwardNbrs.get(b).add(a); // Add backward edge from b to a
        }

        // Initialize visited array to track visited nodes
        boolean[] visited = new boolean[n];
        int[] ans = new int[1];  // To store the number of reorder operations

        // Start DFS traversal from node 0
        dfs(0, forwardNbrs, backwardNbrs, ans, visited);

        return ans[0];  // Return the result
    }

    // Main function to test the implementation
    public static void main(String[] args) {
        // Example usage
        int n = 6;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 3));
        connections.add(Arrays.asList(2, 3));
        connections.add(Arrays.asList(4, 0));
        connections.add(Arrays.asList(4, 5));

        // Call the function to find the minimum reorder
        int result = minReorder(n, connections);
        System.out.println("Minimum reorder operations required: " + result);
    }
}
//Summary of Your Questions:
//Yes, the DFS starts from node 0 and explores forward neighbors first.
//After exploring forward neighbors, it explores backward neighbors,
// but only if the node hasn't been visited yet. It doesn’t increment the reorder
// count for backward edges since they are already in the correct direction.