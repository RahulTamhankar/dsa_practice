package heap;

import java.util.*;

public class sortaKSortedArray {

    // Function to return the sorted array.
    public static ArrayList<Integer> nearlySorted(int arr[], int n, int k) {
        // Create a priority queue (min-heap)
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();// In java bydefault its minHeap, so smallest will be at TOP

        // Add first k+1 elements to the priority queue
        for (int i = 0; i < k + 1 && i < n; i++) {
            pq.offer(arr[i]);
        }

        //So sorting till k will give TC = O(nlogN), but later it will reduce to O(nlogK)
        //bcoz first we sort for all n but later we only do sorting from above k
        // Traverse through the rest of the array
        for (int i = k + 1; i < n; i++) {
            // Add the current element to the heap
            pq.offer(arr[i]);
            // Poll the smallest element from the heap and add it to the result list
            list.add(pq.poll());
        }

        // Add the remaining elements in the heap to the result list
        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }

        return list;
    }

    public static void main(String[] args) {
        // Example usage
        int arr[] = {6, 5, 3, 2, 8, 10, 9}; // Sample k-sorted array
        int k = 3; // The maximum distance an element is away from its sorted position

        // Call the nearlySorted function to get the sorted array
        ArrayList<Integer> result = nearlySorted(arr, arr.length, k);

        // Print the result
        System.out.println("Sorted Array: " + result);
    }
}
