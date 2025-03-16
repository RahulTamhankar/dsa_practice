package graphs.typesofgraphchapterone;

import java.util.*;

public class cycleDetectionInDirectedGraphDFS {


    // Function to detect cycle in the directed graph
    public static boolean isCycle(int V, List<Integer> adj[]) {
        boolean[] visited = new boolean[V];
        boolean[] currentPath = new boolean[V];

        // Try to find a cycle in every connected component of the graph
        for (int i = 0; i < V; ++i) {
            if (!visited[i]) {
                boolean ans = dfs(i, adj, visited, currentPath);
                if (ans) {
                    return true;  // Exit once a cycle is found
                }
            }
        }

        return false;  // No cycle found
    }


    // Function to perform DFS traversal and detect cycle
    public static boolean dfs(int node, List<Integer> adj[], boolean[] visited, boolean[] currentPath) {
        // Mark the current node as visited and part of the current recursion path
        visited[node] = true;
        currentPath[node] = true;

        // Explore each neighbor of the current node
        for (int nbr : adj[node]) {
            // If the neighbor hasn't been visited, do DFS on it.   //node unvisted hai to vo current path pe hai hi nai ofc
            //just make a dfs call to nbr by passing adj List ,visited and currentPath
            //agar res bolta hai hai cycle detected hai to return True
            if (!visited[nbr]) {
                boolean res = dfs(nbr, adj, visited, currentPath);
                if (res) {
                    return true;  // A cycle is found
                }
            } else if (currentPath[nbr]) { //agar visited marked hai to bhi Gaurantee nai hai cycle hogi,
                    // islie check karo agar current path me vo node hai ki nai
                // If the neighbor is part of the current DFS path, a cycle is detected
                return true;
            }
        }

        // Backtrack by marking the node as not part of the current recursion path
        //unmark the current node from path
        currentPath[node] = false;
        return false; // cycle detect nai hui kahi bhi
    }


    // Example to use the class
    public static void main(String[] args) {
        // Example graph representation
        int V = 4;
        List<Integer> adj[] = new ArrayList[V];

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        // Example directed graph edges
        adj[0].add(1);
        adj[1].add(2);
        adj[2].add(0);  // Adding a cycle here (0 -> 1 -> 2 -> 0)

        // Check if the graph contains a cycle
        if (isCycle(V, adj)) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph does not contain a cycle");
        }
    }
}


//cycle detection using BFS is done by topological sort
