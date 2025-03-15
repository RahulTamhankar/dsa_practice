package graphs.typesofgraphchapterone;

import java.util.*;

public class cycleDetectionInUndirectedGraphDFS {

    // Function to detect cycle in the graph
    public static boolean isCycle(int V, List<List<Integer>> adj) {//array of list
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


    // DFS method to check if a cycle exists in the graph
    public static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;  // Mark the node as visited

        // Explore all neighbors of the current node
        for (int neighbor : adj.get(node)) {
            // If the neighbor is not visited, do DFS on the neighbor
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj)) {// agli node ke lie neighbor is g  oing to be
                                                        // the node and node is going to be the parent for next node
                    return true;  // Cycle found
                }
            }
            // If the neighbor is visited and is not the parent, a cycle is found
            else if (visited[neighbor] == true && neighbor != parent) {
                return true;  // Cycle found
            }
        }
        return false;  // No cycle found from this node
    }


    public static void main(String[] args) {
        // Example graph represented as an adjacency list
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());  // Create a new list for each vertex
        }

        // Add edges (undirected)
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);

        // Check if there's a cycle in the graph
        if (isCycle(V, adj)) {
            System.out.println("Graph contains a cycle.");
        } else {
            System.out.println("Graph doesn't contain a cycle.");
        }
    }
}