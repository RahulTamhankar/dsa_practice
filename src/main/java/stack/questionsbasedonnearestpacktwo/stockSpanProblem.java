package stack.questionsbasedonnearestpacktwo;

import java.util.Stack;
import java.util.Vector;

public class stockSpanProblem {

    public static Vector<Integer> nearestGreaterLeft(int[] arr) {
        int size = arr.length;
        Vector<Integer> v = new Vector<>();
        Stack<int[]> s = new Stack<>();  // Stack to store [value, index] pairs

        // Traverse the array from left to right
        for (int i = 0; i < size; i++) {
            // If stack is empty, no greater element found on the left
            if (s.isEmpty()) {
                v.add(-1);
            }
            // If top of stack is greater than the current element
            else if (s.peek()[0] > arr[i]) {
                v.add(s.peek()[1]);
            }
            // If top of stack is smaller or equal to the current element
            else {
                // Pop elements from the stack while they are smaller or equal to the current element
                while (!s.isEmpty() && s.peek()[0] <= arr[i]) {
                    s.pop();
                }
                // If stack is empty after popping, no greater element
                if (s.isEmpty()) {
                    v.add(-1);
                } else {
                    v.add(s.peek()[1]);
                }
            }
            // Push the current element to stack for future comparisons
            s.push(new int[]{arr[i], i});
        }

        // Adjust the result to return the difference between indices
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i) != -1) {
                v.set(i, i - v.get(i));
            }
        }

        return v;
    }

    public static void main(String[] args) {
        // Sample array
        int[] arr = {100, 80, 60, 70, 60, 75, 85};

        // Call the method to find nearest greater elements to the left
        Vector<Integer> result = nearestGreaterLeft(arr);

        // Print the result
        System.out.println(result);  // Expected output: [-1, -1, 1, -1, 3]
    }

}
//Optimise just 1 for
//package stack.questionsbasedonnearestpacktwo;
//
//import java.util.Stack;
//import java.util.Vector;
//
//public class StockSpanProblem {
//
//    public static Vector<Integer> nearestGreaterLeft(int[] arr) {
//        int size = arr.length;
//        Vector<Integer> v = new Vector<>();
//        Stack<int[]> s = new Stack<>();  // Stack to store [value, index] pairs
//
//        // Traverse the array from left to right
//        for (int i = 0; i < size; i++) {
//            // If stack is empty, no greater element found on the left
//            if (s.isEmpty()) {
//                v.add(-1);
//            }
//            // If top of stack is greater than the current element
//            else if (s.peek()[0] > arr[i]) {
//                v.add(i - s.peek()[1]); // Directly store the difference between indices
//            }
//            // If top of stack is smaller or equal to the current element
//            else {
//                // Pop elements from the stack while they are smaller or equal to the current element
//                while (!s.isEmpty() && s.peek()[0] <= arr[i]) {
//                    s.pop();
//                }
//                // If stack is empty after popping, no greater element
//                if (s.isEmpty()) {
//                    v.add(-1);
//                } else {
//                    v.add(i - s.peek()[1]); // Store the difference
//                }
//            }
//            // Push the current element to stack for future comparisons
//            s.push(new int[]{arr[i], i});
//        }
//
//        return v;
//    }
//
//    public static void main(String[] args) {
//        // Sample array
//        int[] arr = {100, 80, 60, 70, 60, 75, 85};
//
//        // Call the method to find nearest greater elements to the left
//        Vector<Integer> result = nearestGreaterLeft(arr);
//
//        // Print the result
//        System.out.println(result);  // Expected output: [-1, -1, 1, -1, 3, 1, 1]
//    }
//}