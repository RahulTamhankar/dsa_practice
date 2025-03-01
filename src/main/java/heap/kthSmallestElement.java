package heap;

import java.util.PriorityQueue;

public class kthSmallestElement {

    // Method to find the Kth smallest element in the array
    private static int findKthSmallestElement(int[] arr, int k, int size) {
        // Create a max-heap to store the k smallest elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Iterate through the array
        for (int i = 0; i < size; i++) {
            // Add the current element to the max-heap
            maxHeap.add(arr[i]);

            // If the size of the heap exceeds k, remove the largest element
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove the largest element (root of the heap)
            }
        }

        // The root of the max-heap is the Kth smallest element
        return maxHeap.peek(); // Return the element at the root of the heap
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Input array and the value of k
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;  // We want to find the 3rd smallest element

        // Find the Kth smallest element
        int result = findKthSmallestElement(arr, k, arr.length);

        // Output the result
        System.out.println("The " + k + "rd smallest element is: " + result);
    }

}
