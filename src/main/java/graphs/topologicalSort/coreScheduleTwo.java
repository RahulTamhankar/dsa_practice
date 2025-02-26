package graphs.topologicalSort;

import java.util.*;

public class coreScheduleTwo {

    public static List<Integer> findOrder(int n, List<List<Integer>> prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph from prerequisites
        //Prerequisistes ko travel karte time hi hum graph bhi bana sakte hai, yaha seperately kiya hai
        for (List<Integer> edge : prerequisites) {//[ai , bi] , we are traversing a 2D vector , each vector me humko ek EDGE milega ie. [ai , bi]-> means "ai" karne se pehle tumko "bi" karna hai...  bi--->ai
            graph.get(edge.get(1)).add(edge.get(0));  //hence bi(edge 1).pushback(ai (edge 2))
        }

        // Initialize indegree array
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int x : graph.get(i)) {//graph(i) matlab uss particular nodes ke neighbors ko mai travel kar raha hu
                indegree[x]++;        //Eg. if 0-->1  ,then here [[][+1][+1]]-->[[0][1][1][2][1]]
            }                          //      |    |
        }                              //      2--> 3-->4

        // Initialize queue for nodes with 0 indegree
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);             // jiski bhi indegree 0 aai hai usko queue me save karo
            }                           // hum yaha indegree ki value 0 hai ki nai islie check kar rai hai kyuki agar upar wale for me kiya
        }                               // to incorrect ho sakta hai.. coz pura traverse karne ke baaad hi hum decide kar sakte hai ki konse indegree 0 hai and then jaha 0 hai vahase BFS shuru kardo


        // Perform Kahn's algorithm (topological sorting)
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int f = q.poll();
            ans.add(f);  // since i want to preserve the order and order is what we want to return i am saving in list

            // Decrease indegree of neighboring nodes
            for (int neighbor : graph.get(f)) { //traversing nbrs of node f
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);    //agar f ke nbr ki indegree bhi 0 aarai hai to save that nbr in queue
                }
            }
        }

        // If we managed to sort all courses, return the result
        // if cycle nai hai to n will be ans but if there is a cycle queue will be empty and return empty vector coz question saying so
        if (ans.size() == n) {
            return ans;
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        List<List<Integer>> prerequisites = new ArrayList<>();
        prerequisites.add(Arrays.asList(1, 0));
        prerequisites.add(Arrays.asList(2, 0));
        prerequisites.add(Arrays.asList(3, 1));

        List<Integer> order = findOrder(4, prerequisites);
        System.out.println(order);
    }
}
