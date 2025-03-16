package graphs.topologicalSort;
import java.util.*;

public class topologicalSortDFS {

    // Static Deque to store the topological order
    static Deque<Integer> dq = new LinkedList<>();


    // Function to return the topological order as a list
    public static List<Integer> topologicalSort(List<List<Integer>> adj) {
        int n = adj.size();
        boolean[] visited = new boolean[n];
        // Perform DFS for every unvisited node
        //iterate on all nodes and whenever we got a unvisted node ,
        // start dfs from that unvisted node, inside I am passing
        //the node, vsisited array and adjList
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, adj);
            }
        }

        // Convert deque to list for the final answer as we have to return a List
        List<Integer> ans = new ArrayList<>();
        while (!dq.isEmpty()) {
            ans.add(dq.pop());
        }
        return ans;
    }

    // DFS function to perform the depth-first search
    public static void dfs(int node, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true; // vsisted node to true mark kardiya
        for (int nbr : adj.get(node)) { //nbr pe traverse karo aur unvisted hai to dfs chalao recursively
            if (!visited[nbr]) {
                dfs(nbr, visited, adj);
            }
        }
        //### HERO OF THE QUESTION ###
        //Almost done of while push node in front of deque
        //node ke sare nbrs khatam hogai vo time pe parent call pe return karne ke pehle dq.push kardo
        dq.push(node); // Add node to the front of deque when done with its descendants

        //STEPS dfs(node)
        //1) US node ko visited mark kiya
        //2) Uske neighbors ko call kiya
        //3) deque ke front me push kiya
    }



    public static void main(String[] args) {
        // Example usage

        // Adjacency list for the graph (Example)
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(Arrays.asList(2, 3));  // Node 0 -> 2, 3
        adj.add(Arrays.asList(3));     // Node 1 -> 3
        adj.add(Arrays.asList(3));     // Node 2 -> 3
        adj.add(new ArrayList<>());    // Node 3 -> no neighbors

        // Get the topological sort order
        List<Integer> result = topologicalSort(adj);
        System.out.println(result);  // Output should be topological order, e.g. [0, 1, 2, 3]
    }
}
