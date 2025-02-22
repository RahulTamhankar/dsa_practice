package graphs.typesofgraphchapterone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class dfsImpl {

    // DFS function (recursive approach)
    public static void dfs(int node, HashMap<Integer, List<Integer>> graph, boolean[] visited) {
        // Print the current node and mark it as visited
        //-------- STEP 1-----//
        System.out.print(node + " ");
        //-------- STEP 2-----//
        visited[node] = true;  // har node print kardiya aur uski kahani khatam islie mark true, vahase dusre calls hosakte hai but usko firse print mat karna

        // Recur for all the unvisited neighbors of the current node
        //HashMap graph is the Adjaceny List
        // Key = 0 Value = [1,4]
        //-------- STEP 3-----//
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {  //means if its unvisited neighbor
                dfs(neighbor, graph, visited);  //make a dfs call to that neighbor
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

        // Perform DFS starting from node 0
        System.out.print("DFS order: ");
        boolean[] visited = new boolean[n];  // Initialize visited array with false
        dfs(0, graph, visited);
    }
}


//        0
//        |
//        1----4
//        |
//        2
//        |
//        3