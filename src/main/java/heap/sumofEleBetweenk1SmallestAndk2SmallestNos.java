package heap;

import java.util.PriorityQueue;

public class sumofEleBetweenk1SmallestAndk2SmallestNos {
    // Method to find the kth smallest element using a max-heap for the smallest k elements
    public static int kthSmallest(int[] arr, int k) {
        // Max-heap to store the first k smallest elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add elements to the heap
        for (int num : arr) {
            maxHeap.add(num);
            // Keep only the smallest k elements in the heap
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // The root of the max-heap will be the kth smallest element
        return maxHeap.peek();
    }

    // Method to find the sum of elements between k1-th and k2-th smallest elements
    public static int sumBetweenK1AndK2(int[] arr, int k1, int k2) {
        // Find the k1-th smallest and k2-th smallest elements
        int first = kthSmallest(arr, k1);
        int second = kthSmallest(arr, k2);

        // Initialize sum
        int sum = 0;

        // Add all elements between the kth smallest and kth2 smallest elements
        for (int num : arr) {
            if (num > first && num < second) {
                sum += num;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        // Test case
        int[] arr = {20, 8, 22, 4, 12, 10, 14};
        int k1 = 3, k2 = 6;

        // Find the sum of elements between k1-th and k2-th smallest
        int result = sumBetweenK1AndK2(arr, k1, k2);

        // Output the result
        System.out.println("Sum of elements between " + k1 + "th and " + k2 + "th smallest elements: " + result);
    }
}
