package recursion.ibh;

import java.util.Stack;

public class reverseStack {

    // Method to insert an element at the bottom of the stack
    static void insert_at_bottom(Stack<Integer> s, int x) {
        // if stack is empty, add the element at the bottom
        if (s.size() == 0) {
            s.push(x);
        } else {
            // store the top element of the stack
            int y = s.peek();
            // remove the top element
            s.pop();
            // recursively insert the element at the bottom
            insert_at_bottom(s, x);
            // add the stored element back to the stack
            s.push(y);
        }
    }

    // Method to reverse the stack
    static void reverse(Stack<Integer> s) {
        // if stack is not empty
        if (s.size() > 0) {
            // store the top element of the stack
            int x = s.peek();
            // remove the top element
            s.pop();
            // recursively reverse the remaining elements in the stack
            reverse(s);
            // insert the stored element at the bottom of the reversed stack
            insert_at_bottom(s, x);
        }
    }

    // Main method for testing the reverse functionality
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Adding elements to the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Original Stack: " + stack);

        // Reverse the stack
        reverse(stack);

        System.out.println("Reversed Stack: " + stack);
    }
}
