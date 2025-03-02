package stack.questionsbasedonnearestpacktwo;

import java.util.Stack;
import java.util.Vector;

public class maximumAreaOfHistogram {

    // Function to find nearest smaller to left
    public static Vector<Integer> nearestSmallerLeft(int[] arr) {
        int size = arr.length;
        int pseudoIndex = -1;
        Vector<Integer> left = new Vector<>();
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < size; i++) {
            // If stack is empty, no smaller element found on the left
            if (s.isEmpty()) {
                left.add(pseudoIndex);
            } else if (arr[s.peek()] < arr[i]) {
                left.add(s.peek());
            } else {
                // Pop elements from the stack while they are greater than or equal to the current element
                while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    left.add(pseudoIndex);
                } else {
                    left.add(s.peek());
                }
            }
            s.push(i); // Push the current index onto the stack
        }
        return left;
    }

    // Function to find nearest smaller to right
    public static Vector<Integer> nearestSmallerRight(int[] arr) {
        int size = arr.length;
        int pseudoIndex = arr.length; // set pseudoIndex as arr.length for right side
        Vector<Integer> right = new Vector<>();
        Stack<Integer> s = new Stack<>();

        for (int i = size - 1; i >= 0; i--) {
            // If stack is empty, no smaller element found on the right
            if (s.isEmpty()) {
                right.add(pseudoIndex);
            } else if (arr[s.peek()] < arr[i]) {
                right.add(s.peek());
            } else {
                // Pop elements from the stack while they are greater than or equal to the current element
                while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    right.add(pseudoIndex);
                } else {
                    right.add(s.peek());
                }
            }
            s.push(i); // Push the current index onto the stack
        }
        // Reverse the right vector to match the left side processing
        Vector<Integer> reversedRight = new Vector<>();
        for (int i = right.size() - 1; i >= 0; i--) {
            reversedRight.add(right.get(i));
        }
        return reversedRight;
    }

    // Function to find the largest rectangular area
    public static int largestRectangleArea(int[] heights) {
        int size = heights.length;

        // Find the nearest smaller to left and right for each bar
        Vector<Integer> left = nearestSmallerLeft(heights);
        Vector<Integer> right = nearestSmallerRight(heights);

        int maxArea = 0;

        // Calculate the area for each bar
        for (int i = 0; i < size; i++) {
            int width = right.get(i) - left.get(i) - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area); // Update maxArea
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {3, 5, 1, 7, 5, 9};
        System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights));
    }
}
