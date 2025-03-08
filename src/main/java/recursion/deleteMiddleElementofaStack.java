package recursion;

import java.util.Stack;

public class deleteMiddleElementofaStack {

    // Method to delete the middle element from the stack
    public static Stack<Integer> deleteMiddle(Stack<Integer> stack) {
        // Base case: If the stack is empty, return the stack as is
        if (stack.size() == 0) {
            return stack;
        }

        // Calculate the middle position (1-indexed)
        int mid = stack.size() / 2 + 1;

        // Call the helper method to delete the middle element
        delete(stack, mid);
        return stack;
    }

    // Helper method to recursively delete the middle element
    public static void delete(Stack<Integer> stack, int mid) {
        // Base case: If the current top element is the middle element, pop it
        if (stack.size() == mid) {
            stack.pop();
            return;
        }

        // Recursively pop elements and keep pushing them back after checking for the middle
        int temp = stack.pop();
        delete(stack, mid); // Continue solving with the smaller stack
        stack.push(temp); // Push the popped element back into the stack
    }

    // Main method to test the deletion of the middle element
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(1);
        stack.push(5);

        // Delete the middle element
        deleteMiddle(stack);

        // Print the modified stack
        while (!stack.isEmpty()) {
            int ele = stack.pop();
            System.out.println(ele);
        }
    }
}
