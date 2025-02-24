package graphs.typesofgraphchapterone;

import java.util.*;

public class cycleDetectionInUndirectedGraphDFS {

    // DFS method to check if a cycle exists in the graph
    public static boolean dfs(int node, int parent, boolean[] visited, List<Integer>[] adj) {
        visited[node] = true;  // Mark the node as visited

        // Explore all neighbors of the current node
        for (int neighbor : adj[node]) {
            // If the neighbor is not visited, do DFS on the neighbor
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj)) {
                    return true;  // Cycle found
                }
            }
            // If the neighbor is visited and is not the parent, a cycle is found
            else if (neighbor != parent) {
                return true;  // Cycle found
            }
        }
        return false;  // No cycle found from this node
    }

    // Function to detect cycle in the graph
    public static boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];  // Array to track visited nodes

        // Try to detect a cycle in each connected component
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                // Start DFS from an unvisited node
                if (dfs(i, -1, visited, adj)) {
                    return true;  // Cycle detected
                }
            }
        }
        return false;  // No cycle found in the graph
    }

    public static void main(String[] args) {
        // Example graph represented as an adjacency list
        int V = 5;
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        // Add edges (undirected)
        adj[0].add(1);
        adj[1].add(0);
        adj[1].add(2);
        adj[2].add(1);
        adj[2].add(3);
        adj[3].add(2);
        adj[3].add(4);
        adj[4].add(3);

        // Check if there's a cycle in the graph
        if (isCycle(V, adj)) {
            System.out.println("Graph contains a cycle.");
        } else {
            System.out.println("Graph doesn't contain a cycle.");
        }
    }
}
