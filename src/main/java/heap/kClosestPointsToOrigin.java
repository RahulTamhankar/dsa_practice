package heap;

import java.util.*;

public class kClosestPointsToOrigin {

    // Static method to find the K closest points
    public static List<int[]> kClosest(int[][] points, int k) {
        // Max-heap to store points based on distance
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) ->
                (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        );

        // Add all points to the max-heap
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove the farthest point if heap exceeds size k
            }
        }

        // Extract the k closest points from the max-heap
        List<int[]> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll());
        }

        // Reverse the result to return the closest points first
        Collections.reverse(result);

        return result;
    }

    // Main method to test the kClosest function
    public static void main(String[] args) {
        // Example input: points array and K value
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int K = 2;  // We want the 2 closest points

        // Call the method to get the K closest points
        List<int[]> closestPoints = kClosest(points, K);

        // Print the K closest points
        for (int[] point : closestPoints) {
            System.out.println(Arrays.toString(point)); // Print each point as an array [x, y]
        }
    }
}


//package heap;
//
//import java.util.*;
//
//public class kClosestPointsToOrigin {
//
//    // Static method to find the K closest points
//    public static List<int[]> kClosest(int[][] points, int k) {
//        // Max-heap to store points based on distance
//        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) ->
//            (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
//        );
//
//        // Add all points to the max-heap
//        for (int[] point : points) {
//            maxHeap.add(point);
//            if (maxHeap.size() > k) {
//                maxHeap.poll(); // Remove the farthest point if heap exceeds size k
//            }
//        }
//
//        // Extract the k closest points from the max-heap
//        List<int[]> result = new ArrayList<>();
//        while (!maxHeap.isEmpty()) {
//            result.add(maxHeap.poll());
//        }
//
//        // Reverse the result to return the closest points first
//        Collections.reverse(result);
//
//        return result;
//    }
//
//    // Main method to test the kClosest function
//    public static void main(String[] args) {
//        // Example input: points array and K value
//        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
//        int K = 2;  // We want the 2 closest points
//
//        // Call the method to get the K closest points
//        List<int[]> closestPoints = kClosest(points, K);
//
//        // Print the K closest points
//        for (int[] point : closestPoints) {
//            System.out.println(Arrays.toString(point)); // Print each point as an array [x, y]
//        }
//    }
//}