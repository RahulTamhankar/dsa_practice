package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class kthLargestElement {
    // Method to find K largest elements in the array using a min-heap
    private static void findKLargestElements(int[] arr, int k, int size) {
        // Create a min-heap to store the K largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Iterate through the array
        for (int i = 0; i < size; i++) {
            // Add the current element to the min-heap
            minHeap.add(arr[i]);

            // If the size of the heap exceeds K, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();  // Remove the smallest element (root of the heap)
            }
        }

        // Print the K largest elements (directly inside the while loop)
        System.out.print("The " + k + " largest elements are: ");
        while (minHeap.size() > 0) {
            System.out.print(minHeap.poll() + " "); // Print and remove each element
        }
        System.out.println(); // For a newline after printing the heap contents
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Input array and the value of k
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;  // We want to find the 3 largest elements

        // Find the K largest elements and print them directly inside the while loop
        findKLargestElements(arr, k, arr.length);
    }
}
// output will be from n-k
//Eg for 7,1,4,3,20,15 --> 3,4,7 are waste and extra computations so pop them