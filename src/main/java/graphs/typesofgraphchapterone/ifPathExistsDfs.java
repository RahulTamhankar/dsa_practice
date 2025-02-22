package graphs.typesofgraphchapterone;

import java.util.*;

public class ifPathExistsDfs {

    // DFS function to explore the graph
    public void dfs(int node, HashMap<Integer, List<Integer>> graph, boolean[] visited) {
        // Mark the current node as visited
        visited[node] = true;

        // Recur for all the unvisited neighbors of the current node
        for (int nbr : graph.get(node)) {
            if (!visited[nbr]) {
                dfs(nbr, graph, visited);
            }
        }
    }

    // Method to determine if a valid path exists between source and destination
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Create an adjacency list representation of the graph
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        // Initialize graph
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Add edges to the graph
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a); // Since it's a bi-directional graph
        }

        // Create a visited array to track visited nodes
        boolean[] visited = new boolean[n];

        // Perform DFS starting from the source node
        dfs(source, graph, visited);

        // Return true if destination is visited, else false
        return visited[destination];
    }

    public static void main(String[] args) {
        // Create an instance of the class
        ifPathExistsDfs solution = new ifPathExistsDfs();

        // Example 1
        int n = 3;
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 0}
        };
        int source = 0;
        int destination = 2;

        // Check if a valid path exists from source to destination
        boolean result = solution.validPath(n, edges, source, destination);

        // Output the result
        System.out.println("Path exists: " + result);  // Output: true
    }
}
