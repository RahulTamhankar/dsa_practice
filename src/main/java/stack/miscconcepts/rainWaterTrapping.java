//package stack.miscconcepts;

//public class rainWaterTrapping {
//
//    public static int trapRainWater(int[] arr) {
//        int size = arr.length;
//        if (size == 0) return 0;
//
//        int[] lmax = new int[size];  // Left max height array
//        int[] rmax = new int[size];  // Right max height array
//        int[] water_height = new int[size]; // Water trapped at each index
//
//        // Initialize the left max height array
//        lmax[0] = arr[0];
//        for (int i = 1; i < size; i++) {
//            lmax[i] = Math.max(lmax[i - 1], arr[i]);
//        }
//
//        // Initialize the right max height array
//        rmax[size - 1] = arr[size - 1];
//        for (int i = size - 2; i >= 0; i--) {
//            rmax[i] = Math.max(rmax[i + 1], arr[i]);
//        }
//
//        // Calculate the water trapped at each index
//        for (int i = 0; i < size; i++) {
//            water_height[i] = Math.min(lmax[i], rmax[i]) - arr[i];
//        }
//
//        // Sum up the water trapped
//        int totalWater = 0;
//        for (int i = 0; i < size; i++) {
//            totalWater += water_height[i];
//        }
//
//        return totalWater;
//    }
//
//    public static void main(String[] args) {
//        int[] arr1 = {2, 0, 2};
//        System.out.println("Water trapped for arr1: " + trapRainWater(arr1)); // Output: 2
//
//        int[] arr2 = {3, 0, 0, 2, 0, 4};
//        System.out.println("Water trapped for arr2: " + trapRainWater(arr2)); // Output: 10
//    }
//}


//using stack
package stack.miscconcepts;

import java.util.Stack;

public class rainWaterTrapping {

    public static int trapRainWater(int[] arr) {
        int size = arr.length;
        if (size == 0) return 0;

        // Stack to store indices of the bars
        Stack<Integer> stack = new Stack<>();
        int totalWater = 0;

        // Traverse the elevation map
        for (int i = 0; i < size; i++) {
            // While the stack is not empty and the current bar is higher than the top of the stack
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                // Pop the top element from the stack
                int top = stack.pop();

                if (stack.isEmpty()) break;

                // Calculate the distance between the current bar and the element at the new top of the stack
                int distance = i - stack.peek() - 1;

                // Calculate the bounded height by the two bars (left and right)
                int boundedHeight = Math.min(arr[i], arr[stack.peek()]) - arr[top];

                // Calculate the water trapped
                totalWater += distance * boundedHeight;
            }

            // Push the current index onto the stack
            stack.push(i);
        }

        return totalWater;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 0, 2};
        System.out.println("Water trapped for arr1: " + trapRainWater(arr1)); // Output: 2

        int[] arr2 = {3, 0, 0, 2, 0, 4};
        System.out.println("Water trapped for arr2: " + trapRainWater(arr2)); // Output: 10
    }
}