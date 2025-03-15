package graphs.typesofgraphchapterone;

import java.util.*;

public class cycleDetectionInUndirectedGraphBFS {

    // Function to perform BFS and detect a cycle in the graph
    public static boolean bfs(int node, List<Integer>[] adj, boolean[] visited, int[] parent) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);// push source node in queue
        visited[node] = true;

        // BFS traversal
        while (!q.isEmpty()) {
            int f = q.poll(); // take the front node out

            // Check all adjacent nodes (neighbors) of the f node
            //Eg- for f=1 adj[f] = [0,1]
            // f ke neighbors pe itirate karo
            for (int nbr : adj[f]) {
                // If the neighbor hasn't been visited, mark it and push it to the queue
                // Agar univisited neighbor hai to 3 Steps karo
                //DFS ME JUST 1) VISITED MARK KARDO 2) QUEUE ME PUSH KARO
                //But BFS ME 3 STEPS 1) + 2) + 3) MARK THE PARENT OF F
                if (!visited[nbr]) {
                    visited[nbr] = true;
                    parent[nbr] = f;
                    q.offer(nbr);
                } else if (parent[f] != nbr) { // Jo bhi nbr abhi aya...agar vo current node ka parent nai hai then for sure its a cycle
                    //Agar visited hai to 2 possibility hai parent hai to aage badho but agar visited hai but parent nai hai to vahi dabocho
                                                // aur return TRUE kardo
                    // If the neighbor is visited and it's not the parent of the current node, a cycle is detected
                    // f ke hum nbrs iterate kar rai the, so ab agar vo nbr current node
                    //ka parent nai hai
//                     1---3
//                     |  |
//                     2--4
                    //f = 4 , in 1st iteration nbr=2, check karoge 2 voisited hai ? haa,
                    //But iss 2 ka parent agar 2 hai to tum 2 se aai ho, but agar ye 2, 4 ka parent nai hai, to ye cycel hai

                    return true;
                }
            }
        }
        return false;
    }

    // Function to detect a cycle in an undirected graph
    public static boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];  // Array to track visited nodes
        int[] parent = new int[V];  // Array to store the parent of each node

        //parent array can be optimised keep a single array and initialize -1. If -1 then its unvisited, if some other value lets ssay 3, then its means its visited and parent = 3

        // Try to find a cycle in every connected component of the graph
        for (int i = 0; i < V; i++) {
            if (!visited[i]) { // for connected components do bfs from each node if unvisited
                // Use BFS to detect a cycle in the connected component
                //If its just a single graph then this will be called only once
                if (bfs(i, adj, visited, parent)) {
                    return true;  // Cycle found
                }
            }
        }
        return false;  // No cycle found
    }

    public static void main(String[] args) {
        // Example graph with 5 vertices
        int V = 5;
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        // Add edges to the graph (undirected)
        adj[0].add(1);
        adj[1].add(0);
        adj[1].add(2);
        adj[2].add(1);
        adj[2].add(3);
        adj[3].add(2);
        adj[3].add(4);
        adj[4].add(3);

        // Check if there is a cycle in the graph
        if (isCycle(V, adj)) {
            System.out.println("Graph contains a cycle.");
        } else {
            System.out.println("Graph doesn't contain a cycle.");
        }
    }
}

//TC O(V+E)
//sc o(2V)
