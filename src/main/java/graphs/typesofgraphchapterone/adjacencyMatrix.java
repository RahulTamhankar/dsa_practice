package graphs.typesofgraphchapterone;

public class adjacencyMatrix {
    // Function to print the adjacency matrix graph
    public static void printGraph(int[][] adjacencyMatrix) {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            System.out.print("Node " + (i + 1) + ", Neighbors: ");
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    System.out.print((j + 1) + " ");
                }
            }
            System.out.println();
        }
    }

    // Function to convert edge list to adjacency matrix
    public static int[][] createAdjacencyMatrix(int[][] edgeList, int numNodes) {
        int[][] adjacencyMatrix = new int[numNodes][numNodes];

        // Iterate through the edge list to fill the adjacency matrix
        for (int[] edge : edgeList) {
            int node1 = edge[0] - 1; // Adjust for 0-based index
            int node2 = edge[1] - 1; // Adjust for 0-based index
            adjacencyMatrix[node1][node2] = 1;
            adjacencyMatrix[node2][node1] = 1; // Assuming the graph is undirected
            //if directed then any 1 of above 2
        }

        return adjacencyMatrix;
    }

    public static void main(String[] args) {
        // Define the edge list (node pairs)
        int[][] edgeList = {
                {11, 5}, {6, 3}, {3, 4}, {4, 2}, {1, 3}
        };

        // Number of nodes in the graph
        int numNodes = 11;

        // Convert edge list to adjacency matrix
        int[][] adjacencyMatrix = createAdjacencyMatrix(edgeList, numNodes);

        // Print the adjacency matrix representation of the graph
        printGraph(adjacencyMatrix);
    }
}
