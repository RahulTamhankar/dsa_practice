package heap;

import java.util.*;

public class kClosestNumbers {

    // Function to find k closest numbers to x
    public static List<Integer> kClosest(int[] arr, int x, int k) {
        // Priority queue (max-heap) to store the pairs (absolute difference, value)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0], a[0]) // Custom comparator to make it a max heap based on absolute difference
        );

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - x); // Calculate absolute difference from x
            maxHeap.offer(new int[] { diff, arr[i] }); // Push the pair (diff, element) into the heap

            // If the size of the heap exceeds k, pop the largest element (furthest from x)
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // List to store the k closest elements
        List<Integer> result = new ArrayList<>();

        // Extract the elements from the heap and add them to the result list
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll()[1]); // Extract the value part of the pair
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9}; // Example array
        int x = 7; // Target number
        int k = 3; // Number of closest elements to find

        List<Integer> closest = kClosest(arr, x, k);

        // Print the k closest numbers
        System.out.println("The " + k + " closest numbers to " + x + " are: " + closest);
    }
}
