package graphs.typesofgraphchapterone;

import java.util.*;

public class adjacencyList {
    // Function to print the graph using adjacency list representation
    public static void printGraph(Map<Integer, List<Integer>> graph) {
        // Iterate through each node and its neighbors in the graph
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            int node = entry.getKey();  // Node
            List<Integer> neighbors = entry.getValue();  // Neighbors of the node
            System.out.print("Node " + node + ", Neighbors: ");
            for (int neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Define the edge list (pairs of connected nodes)
        int[][] edgeList = {
                {1, 2}, {2, 3}, {3, 4}, {4, 2}, {1, 3}
        };

        // Create an adjacency list using HashMap
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Fill the graph using the edge list
        for (int[] edge : edgeList) {
            int a = edge[0];
            int b = edge[1];

            // Ensure both nodes are in the graph
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            // Add the edge in both directions (undirected graph)
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // Print the graph
        printGraph(graph);
    }
}
