package graphs.topologicalSort;

import java.util.*;

public class   largestColorValueInADirectedGraph {

    public static int largestPathValue(String colors, List<List<Integer>> edges) {// har node ka konsa color hoga vo iss string ke index pe mil jaega
        int n = colors.length(), ans = 0;

        // Create a 2D array to store the counts of colors for each node
        //for each node i it will be saving color count of each color type  ,
        // here n is a node and will save color count of each color at that node
        int[][] cnt = new int[n][26];

        // Create the graph and indegree array
        List<List<Integer>> graph = new ArrayList<>();  //2-D Matrix ko initialize kardiya n se aur empty list push karte raho
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n]; // Topological Sort hai islie indegree array banao  and bydefault initialized to 0
        // Create the graph and calculate indegrees
        for (List<Integer> edge : edges) {
            int u = edge.get(0), v = edge.get(1);
            graph.get(u).add(v);
            indegree[v]++;
        }



        // Initialize the queue for topological sorting (Kahn's algorithm)
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {   //indegree 0 wali nodes ko q me daldiya, all these will be initial BFS source points
                q.add(i);
            }
        }

        //Typical BFS While loop
        int processed = 0;// agar cycle nai hai to proceesed will be equal to n as its a topo sort
        while (!q.isEmpty()) {
            int f = q.poll();
            processed++; //each time a node is out we will do ++

            // Increment the color count for the current node
            //Question ka asli Hero
            cnt[f][colors.charAt(f) - 'a']++;// --> cnt will look like[node/index 0 [a(3),b(5).....]]

            // Update the answer to track the maximum color value
            //count of f , f is our node, usss node me jo color hai vo colors naam ki string se aajaega
            // and usme se agar 'a' subtract karenge to it will be mapped to an index
            //from 0 to 25, so jo bhi color nikal ke aaega +1 hojaega
            // agar ye nai karna to end me firse for loop chalega to get the max of all the count of colors
            // String array
            //This line of code is used to update the overall maximum color count found in the entire graph as we process each node.
            //ans = Math.max(ans, cnt[f][colors.charAt(f) - 'a']);: Updates the overall maximum color
            // count found at any node during the entire process.
            //
            //cnt[nbr][j] = Math.max(cnt[nbr][j], cnt[f][j]);: Ensures that each neighbor node gets the maximum
            // count of each color from its predecessor (i.e., it propagates the best color count to neighboring nodes).
            ans = Math.max(ans, cnt[f][colors.charAt(f) - 'a']);

            // Process neighbors of the current node
            //indgree of nbr 0 hui to usko q me push kardiya
            for (int nbr : graph.get(f)) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    q.add(nbr);
                }

                // passing color counts to the neighbors,updating with max
                //existing node se color count passon kar aur make sure jaha pass hora hai vaha pe max ho
                //iterate over colors 0 to 25 and Im saying uss nbr(cnt[nbr]) ka vo particular color(cnt[j])
                // should be max of jo usme already saved hua hai(Math.max(cnt[nbr][j],)  v/s jo mera vo particular node se aya
                for (int j = 0; j < 26; j++) {
                    cnt[nbr][j] = Math.max(cnt[nbr][j], cnt[f][j]); //cnt[nbr][j] is already saved, cnt[f][j] is the incoming one
                }
            }
        }

        // If all nodes are processed, return the maximum color value, else return -1
        // This is to check if there is no cycle if process==n then mene sari nodes ki processing karli return ans as there is no cycle else -1 as per  question requirement
        return processed == n ? ans : -1;
    }

    public static void main(String[] args) {

        // Test case example
        String colors = "abaca";
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(0, 2));
        edges.add(Arrays.asList(2, 3));
        edges.add(Arrays.asList(3, 4));

        int result = largestPathValue(colors, edges);
        System.out.println(result);  // Output will be based on the test case
    }
}

//TC - 26* O(E+V)
