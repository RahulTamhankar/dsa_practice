package heap;

import java.util.PriorityQueue;

public class connectRopesToMinimiseCost {

    public static int connectRopes(int[] ropes) {
        // Create a priority queue (min-heap)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all the rope lengths to the min-heap
        for (int rope : ropes) {
            minHeap.add(rope);
        }

        int totalCost = 0;

        // While there are more than one rope left
        while (minHeap.size() > 1) {
            // Get the two smallest ropes
            int first = minHeap.poll();
            int second = minHeap.poll();

            // Cost to connect the two ropes
            int cost = first + second;
            totalCost += cost;

            // Add the combined rope back into the min-heap
            minHeap.add(cost);
        }

        // Return the total cost to connect all ropes
        return totalCost;
    }

    public static void main(String[] args) {
        // Test case: ropes of lengths 4, 3, 2, 6
        int[] ropes = {1, 2, 3, 4,5};
        int result = connectRopes(ropes);
        System.out.println("Minimum cost to connect all ropes: " + result);
    }
}
