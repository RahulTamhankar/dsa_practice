package graphs.topologicalSort;

import java.util.*;

public class topologicalSortBFS {

    // Function to return list containing vertices in topological order
    public static List<Integer> topologicalSort(List<List<Integer>> adj) { // adjList--> at index 0 - [1] ,at index 1 - [2,3], at index 2 - [], at index 3 - [],at index 4 - [1]
        int n = adj.size();
        List<Integer> indegree = new ArrayList<>(Collections.nCopies(n, 0)); // Store indegree of each node and initialize to 0
        List<Integer> result = new ArrayList<>(); // To store the topological order

        // Step 1: Calculate the indegree of each node
        //Eg. 1 se connected vector ie [2,3] so 2 and 3 ki indegree badhao! ie jaha bhi incoming arrow hai
        for (int i = 0; i < n; i++) {
            for (int neighbor : adj.get(i)) {
                indegree.set(neighbor, indegree.get(neighbor) + 1);
            }
        } // Output indegree[0,2,1,1,0]  --> ie at index 0, means 0 has no nodes incoming or is independent

        // Step 2: Find the starting points (nodes with indegree 0)
        // get the start points for Topo Sort where indegree is 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree.get(i) == 0) {
                queue.add(i);
            }
        }

        // Step 3: Perform BFS
        while (!queue.isEmpty()) {
            int f = queue.poll();
            result.add(f);

            // Decrease the indegree of neighbors
            // traverse on nbr of f
            for (int neighbor : adj.get(f)) {
                indegree.set(neighbor, indegree.get(neighbor) - 1); // aur uss nbr ki indegree kum kardo
                if (indegree.get(neighbor) == 0) { //agar vo indegree becomes 0 then insert it in queue
                    queue.add(neighbor);
                }
            }
        }

        // Return the topological order
        return result;
    }

    public static void main(String[] args) {
        // Example adjacency list for the graph
        List<List<Integer>> adj = new ArrayList<>();

        // Node 0 -> 2, 3
        adj.add(Arrays.asList(2, 3));

        // Node 1 -> 3
        adj.add(Arrays.asList(3));

        // Node 2 -> 3
        adj.add(Arrays.asList(3));

        // Node 3 -> [] (no outgoing edges)
        adj.add(new ArrayList<>());

        // Perform the topological sort
        List<Integer> result = topologicalSort(adj);

        // Print the result
        System.out.println("Topological Sort: " + result);

        //Yaha question me already diya hai ki DAG HAI islie no need to check result

        // Otherwise 2 ways
        //1) if ans.size() == n , kyuki agar TOPO SORT laga hai to sari nodes result pe milengi , agar != hai to there is cycle present in the graph
        //2) Traverse indegree array again, check if each nodes indegree == 0, if != 0 then cycle hai aur TopoSort hume nai mila
    }
}
