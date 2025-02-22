package graphs.typesofgraphchapterone;

import java.util.*;

public class ifPathExistsBfs {

    // BFS function to check if a path exists from source to destination
    public static boolean bfs(int source, HashMap<Integer, List<Integer>> graph, int destination, int n) {
        // Queue for BFS traversal
        //Queue is used to insert all neighbors of source node if its unvisited!!!
        Queue<Integer> queue = new LinkedList<>();
        // Array to track visited nodes
        boolean[] visited = new boolean[n];

        // Start by pushing the source node into the queue and mark it as visited
        queue.offer(source);
        visited[source] = true;

        // Process the queue
        while (!queue.isEmpty()) {
            int node = queue.poll();  // Get the node from the front of the queue  ---FIFO---
            // If we reach the destination IN BETWEEN itself w/o traversing entire graph, return true
            if (node == destination) {
                return true;
            }

            // Visit all the neighbors of the current node
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor])  {
                    visited[neighbor] = true;
                    queue.offer(neighbor);  // Push the unvisited neighbor into the queue
                }
            }
        }

        // If we exhaust the queue without finding the destination, return false
        return false;
    }

    public static void main(String[] args) {
        // Define edges as an edge list: {source, destination}
        List<int[]> edgeList = Arrays.asList(
                new int[]{0, 1}, new int[]{1, 4}, new int[]{1, 2}, new int[]{2, 3}
        );

        int n = 5;  // Number of nodes in the graph (0 to 4)

        // Create a HashMap to represent the graph as an adjacency list
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        // Add edges to the graph
        for (int[] edge : edgeList) {
            int a = edge[0], b = edge[1];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(b);  // Add destination to the adjacency list of source
            graph.get(b).add(a);  // Add source to the adjacency list of destination (for undirected graph)
        }

        // Define source and destination nodes
        int source = 0;
        int destination = 4;

        // Perform BFS to check if a valid path exists from source to destination
        System.out.print("Checking if a path exists from node " + source + " to node " + destination + ": ");
        boolean pathExists = bfs(source, graph, destination, n);

        // Output the result
        System.out.println(pathExists ? "Path exists!" : "No path exists.");
    }
}


//TC(V+E)
//SCO(NxN)