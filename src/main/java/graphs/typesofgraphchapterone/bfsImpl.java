package graphs.typesofgraphchapterone;

import java.util.*;

public class bfsImpl {
    // BFS function
    public static void bfs(int source, HashMap<Integer, List<Integer>> graph, int n) {
        // Queue for BFS traversal
        Queue<Integer> queue = new LinkedList<>();
        // Set to track visited nodes
        boolean[] visited = new boolean[n + 1];

        // Start by pushing the source node into the queue and mark it as visited
        queue.offer(source);
        visited[source] = true;

        // Process the queue
        while (!queue.isEmpty()) {
            int node = queue.poll();  // Get the node from the front of the queue6 //act as pop in c++
            System.out.print(node + " ");   // Print the current node

            // Visit all the neighbors of the current node
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);  // Push the unvisited neighbor into the queue // act as q.push in c++
                }
            }
        }
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

        // Perform BFS starting from node 0
        System.out.print("Breadth-First Search starting from node 0: ");
        bfs(0, graph, n);
    }
}


//        3
//        |
//0---1---2
//     |
//     4