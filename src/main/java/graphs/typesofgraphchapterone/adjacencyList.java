package graphs.typesofgraphchapterone;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class adjacencyList {
    // Function to print the graph using adjacency list representation
    public static void printGraph(Map<Integer, Set<Integer>> graph) {
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            int node = entry.getKey();
            Set<Integer> neighbors = entry.getValue();
            System.out.print("Node " + node + ", Neighbors: ");
            for (int neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Function to convert edge list to adjacency list
    public static Map<Integer, Set<Integer>> createAdjacencyList(int[][] edgeList) {
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();

        // Iterate through the edge list to fill the adjacency list
        for (int[] edge : edgeList) {
            int node1 = edge[0];
            int node2 = edge[1];

            // Add the edge in both directions for undirected graph
            adjacencyList.putIfAbsent(node1, new HashSet<>());
            adjacencyList.putIfAbsent(node2, new HashSet<>());

            adjacencyList.get(node1).add(node2);
            adjacencyList.get(node2).add(node1); // Undirected graph: add both directions
        }

        return adjacencyList;
    }

    public static void main(String[] args) {
        // Define the edge list (node pairs)
        int[][] edgeList = {
                {11, 5}, {6, 3}, {3, 4}, {4, 2}, {1, 3}
        };

        // Convert edge list to adjacency list
        Map<Integer, Set<Integer>> adjacencyList = createAdjacencyList(edgeList);

        // Print the adjacency list representation of the graph
        printGraph(adjacencyList);
    }
}
