package graphs.typesofgraphchapterone;

import java.util.*;

public class longestCycle {
    private int longestCycleLen = -1;

    // DFS to find the longest cycle
    private void dfsFindLongestCycle(int cycleLen, int node, int[] currentPath, int[] visitedNodeList, int[] edges) {
        cycleLen++;
        currentPath[node] = cycleLen;
        visitedNodeList[node] = 1;

        int nbr = edges[node];
        if (nbr != -1) {
            if (visitedNodeList[nbr] == 0) {  // If the neighbor is unvisited
                dfsFindLongestCycle(cycleLen, nbr, currentPath, visitedNodeList, edges);
            } else if (currentPath[nbr] != 0) {  // If the neighbor is already in the current path (cycle detected)
                int currCycleLen = currentPath[node] - currentPath[nbr] + 1;
                longestCycleLen = Math.max(longestCycleLen, currCycleLen);
            }
        }
        currentPath[node] = 0;  // Reset the node after visiting
    }

    // Function to find the longest cycle
    public int longestCycle(int[] edges) {
        int numOfNodes = edges.length;
        int[] visitedNodeList = new int[numOfNodes];  // Keeps track of visited nodes
        int[] currentPath = new int[numOfNodes];  // Keeps track of nodes in the current DFS path

        for (int i = 0; i < numOfNodes; i++) {
            if (visitedNodeList[i] == 0) {  // If node is not visited, start DFS
                dfsFindLongestCycle(0, i, currentPath, visitedNodeList, edges);
            }
        }
        return longestCycleLen;
    }

    // Main method for testing
    public static void main(String[] args) {
        longestCycle obj = new longestCycle();
        int[] edges = {3, 3, 4, 2, 3};  // Example graph with a cycle
        System.out.println("Longest Cycle Length: " + obj.longestCycle(edges));  // Output should be 3
    }
}
