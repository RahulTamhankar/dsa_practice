package graphs.shortestpath;

import java.util.*;

public class snakesAndLadders {

    //STEP 1 Make Connection info
    // Function to find the shortest path to reach the destination
    public static int snakesAndLadders(int[][] board) {
        int n = board.length;

        // Connection array to store the destinations for each square
        int[] connection = new int[n * n + 1];
        Arrays.fill(connection, -1);  //Eg. [-1-,1,15,...] Connection info is stored in connection vector

        // Build the connection map (snake or ladder info)
        boolean flag = true; // This flag is used to track the direction in which i want to iterate ie.Left to Right or Right to Left
        int node = 1;  // node counter is initialized to 1 so that we can do alternate traversal

        for (int i = n - 1; i >= 0; i--) {
            if (flag) {  // If flag is true do Left to Right
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != -1) {
                        connection[node] = board[i][j];
                    }
                    node++;
                }
            } else { //else Right to Left
                for (int j = n - 1; j >= 0; j--) {
                    if (board[i][j] != -1) {
                        connection[node] = board[i][j];
                    }
                    node++;
                }
            }
            flag = !flag;  //each time I am changing the flag value... so 1st its true->false->true....alternate
        }


        //Step 2
        // Building the graph (adjacency list)
        //key, neighbors
        Map<Integer, List<Integer>> graph = new HashMap<>();


        //I will traverse from 1 to n^2
        //For each node I can have at max 6 options Eg If i am at 10 then i can go from 11 to 16. Just make sure the max at each level is nbr <=n^2

        for (int i = 1; i <= n * n - 1; i++) {
            for (int count = 1; count <= 6; count++) {
                int nbr = i + count;
                if (nbr <= n * n) {
                    if (connection[nbr] != -1) {// check ki uss nbr se koi connection ban raha hai ki nai
                        //agar koi bhi nbr pe agar jo bhi snake ladder ka destination hai uss destination node ko hum as nbr save karenge
                        // Has ladder or snake
                        graph.computeIfAbsent(i, k -> new ArrayList<>()).add(connection[nbr]);
                    } else {
                        graph.computeIfAbsent(i, k -> new ArrayList<>()).add(nbr);
                    }
                }
            }
        }

        // BFS to find the shortest path
        // from source apply BFS in level by level method

        int level = 0;  //whenever this level reached n^2 well return level, agar puri loop khatam hogai to bhi agar me destination pe nai pauch paya to return -1
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1); // Starting from the first square
        visited[1] = true;

        while (!q.isEmpty()) {
            int sz = q.size();
            // iterate level wise bcoz all the nodes at that level will be at the same distance from the source
            while (sz-- > 0) {
                int f = q.poll();
                if (f == n * n) { // if the poped is only the destination then return that level directly
                    return level; // Reached the destination ## Will the SHORTEST NUMBER OF STEP AS PER BFS
                }
                //else go and check for the neighbors
                //if the nbr is unvisited ,mark it visited and push it in the queue
                // Visit neighbors
                for (int nbr : graph.getOrDefault(f, new ArrayList<>())) {
                    if (!visited[nbr]) {
                        visited[nbr] = true;
                        q.add(nbr);
                    }
                }
            }
            level++;
        }

        return -1; // If no path to reach destination
    }

    public static void main(String[] args) {
        // Test case 1
        int[][] board1 = {
                {1, 1, -1},
                {1, 1, 1},
                {-1, 1, 1}
        };

        // Output the result for the first test case
        System.out.println(snakesAndLadders(board1));  // Expected output: 4

        // You can add more test cases below
    }
}
