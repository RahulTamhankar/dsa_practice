package graphs.typesofgraphchapterone;

import java.util.ArrayList;
import java.util.List;

public class eventualSafeStatesCode {

    // Depth-First Search function to detect cycles
    public static boolean dfs(int node, List<Integer>[] adj, int[] visited, int[] currentPath) {
        // Mark the current node as visited and part of the recursion stack
        visited[node] = 1;
        currentPath[node] = 1;

        // Explore all neighbors of the current node
        for (int nbr : adj[node]) {
            // If the neighbor has not been visited, perform DFS
            if (visited[nbr] == 0) {
                boolean isCycleFound = dfs(nbr, adj, visited, currentPath);
                if (isCycleFound) {
                    return true; // If a cycle is found, return true
                }
            } else if (currentPath[nbr] == 1) {
                // If the neighbor is already part of the current recursion path, a cycle is found
                return true;
            }
        }

        // Unmark the current node from the recursion stack after processing
        currentPath[node] = 0;
        return false; // No cycle found for this node
    }

    // Function to find all safe nodes in the graph
    public static List<Integer> eventualSafeNodes(int V, List<Integer>[] adj) {
        int[] visited = new int[V];  // 0: unvisited, 1: visited, 2: processed
        int[] currentPath = new int[V]; // 0: not in recursion stack, 1: in recursion stack
        List<Integer> safeNodes = new ArrayList<>();

        // Try to find a cycle in every connected component of the graph
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {  // If the node is unvisited
                if (!dfs(i, adj, visited, currentPath)) {
                    safeNodes.add(i); // If no cycle is found, the node is safe
                }
            }
        }

        return safeNodes; // Return the list of safe nodes
    }

    public static void main(String[] args) {
        // Example Graph:
        // V = 6, Adjacency List representation of the graph
        int V = 6;
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].add(1);
        adj[1].add(2);
        adj[2].add(3);
        adj[3].add(4);
        adj[4].add(1); // Creates a cycle 1 → 2 → 3 → 4 → 1
        adj[5].add(4); // Node 5 leads to node 4, which is part of the cycle

        // Find and print safe nodes in this graph
        List<Integer> safeNodes = eventualSafeNodes(V, adj);
        System.out.println("Safe nodes in the graph: " + safeNodes);  // Expected: [0, 5]
    }
}
