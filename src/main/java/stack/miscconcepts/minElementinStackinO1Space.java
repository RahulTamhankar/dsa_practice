package stack.miscconcepts;

import java.util.Stack;

public class minElementinStackinO1Space {
    private Stack<Integer> s;  // Stack to store elements
    private int minEle;  // Variable to track the current minimum element

    public minElementinStackinO1Space() {
        s = new Stack<>();
        minEle = Integer.MAX_VALUE;  // Initialize minEle to a large value
    }

    // Get the minimum element in the stack
    public int getMin() {
        if (s.isEmpty()) {
            return -1;  // Return -1 if the stack is empty
        }
        return minEle;
    }

    // Push an element to the stack
    public void push(int x) {
        if (s.isEmpty()) {
            s.push(x);
            minEle = x;  // When the stack is empty, set the minEle to the pushed element
        } else {
            if (x >= minEle) {
                s.push(x);  // Push the element directly if it's greater than or equal to minEle
            } else {
                s.push(2 * x - minEle);  // Store the difference when x < minEle
                minEle = x;  // Update minEle to the new minimum
            }
        }
    }

    // Pop the top element from the stack
    public int pop() {
        if (s.isEmpty()) {
            return -1;  // Return -1 if the stack is empty
        }

        int top = s.pop();

        // If the popped element is smaller than the current minEle, update the minEle
        if (top < minEle) {
            int originalValue = minEle;
            minEle = 2 * minEle - top;  // Restore the previous minimum
            return originalValue;
        }

        return top;  // If the popped element is greater than or equal to minEle, return it as is
    }

    // Get the top element of the stack
    public int top() {
        if (s.isEmpty()) {
            return -1;  // Return -1 if the stack is empty
        }

        int top = s.peek();

        // If the top element is smaller than minEle, return minEle (this means the original value was updated)
        if (top < minEle) {
            return minEle;
        }

        return top;  // Otherwise, return the top element as is
    }

    public static void main(String[] args) {
        minElementinStackinO1Space stack = new minElementinStackinO1Space();

        stack.push(5);
        System.out.println("Min: " + stack.getMin());  // Output: 5
        stack.push(3);
        System.out.println("Min: " + stack.getMin());  // Output: 3
        stack.push(7);
        System.out.println("Min: " + stack.getMin());  // Output: 3
        System.out.println("Top: " + stack.top());     // Output: 7

        stack.pop();
        System.out.println("Min: " + stack.getMin());  // Output: 3
        System.out.println("Top: " + stack.top());     // Output: 3

        stack.push(2);
        System.out.println("Min: " + stack.getMin());  // Output: 2
        System.out.println("Top: " + stack.top());     // Output: 2
    }
}
